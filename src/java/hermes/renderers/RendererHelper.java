/* 
 * Copyright 2003,2004 Colin Crist
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package hermes.renderers;

import hermes.browser.ConfigDialogProxy;
import hermes.browser.MessageRenderer.Config;
import hermes.swing.colors.ColorUtils;
import hermes.swing.colors.Colors;
import hermes.swing.renderer.ComboBoxRenderer;
import hermes.swing.table.CustomPropertyTable;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.CellEditor;
import javax.swing.JComponent;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;

import com.jidesoft.combobox.AbstractComboBox;
import com.jidesoft.combobox.ListComboBox;
import com.jidesoft.converter.EnumConverter;
import com.jidesoft.converter.ObjectConverterManager;
import com.jidesoft.grid.CellEditorFactory;
import com.jidesoft.grid.CellEditorManager;
import com.jidesoft.grid.CellRendererManager;
import com.jidesoft.grid.EnumCellEditor;
import com.jidesoft.grid.EnumCellRenderer;
import com.jidesoft.grid.Property;
import com.jidesoft.grid.PropertyPane;
import com.jidesoft.grid.PropertyTable;
import com.jidesoft.grid.PropertyTableModel;

/**
 * Some helper functions for creating MessageRenderers.
 * 
 * @author colincrist@hermesjms.com
 * @version $Id: RendererHelper.java,v 1.5 2005/05/16 16:41:37 colincrist Exp $
 */
public class RendererHelper
{
	private static final Logger cat = Logger.getLogger(RendererHelper.class);
	private static Color xmlRendererBackgroundColor;
	
    /**
     * Create a default renderer for a Config that just contains simple
     * properties (i.e. not 1:m relationships), the dialog will be a normal
     * property pane.
     * 
     * @param dialogProxy
     * @return @throws
     *         IllegalAccessException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     */
    public static JComponent createDefaultConfigPanel(final ConfigDialogProxy dialogProxy) throws IllegalAccessException, InvocationTargetException,
            NoSuchMethodException
    {
        final Config theConfig = dialogProxy.getConfig();
        final List<Property> list = new ArrayList<Property>();
        final Map<?, ?> properties = PropertyUtils.describe(theConfig);
        
        class CustomItemChangeListener implements ItemListener
        {
			@Override
            public void itemStateChanged(ItemEvent event)
            {
        		if (event.getStateChange() == ItemEvent.SELECTED)
        		{
        			Object item = event.getItem();
        			Color newColor = Colors.valueOf(item.toString()).getColor();
                  
					setXmlRendererBackgroundColor(newColor);
					  
					ListComboBox listComboBox = (ListComboBox) event.getSource();
					 
					listComboBox.setBackground(getXmlRendererBackgroundColor());
					listComboBox.setForeground(ColorUtils.getContrastingColor(getXmlRendererBackgroundColor()));
        		}
            }       
        }

        ArrayList<Colors> colors = Colors.sort();
        String[] colorNames = new String[colors.size()];
        
        for (int i=0; i < colors.size(); i++)
        {
        	colorNames[i] = colors.get(i).name();
        }
        
        final EnumConverter colorsConverter = new EnumConverter("ColorsConverter", colors.toArray(), colorNames);
        
        ObjectConverterManager.registerConverter(colorsConverter.getType(), colorsConverter, colorsConverter.getContext());
        
        EnumCellRenderer enumCellRenderer = new EnumCellRenderer(colorsConverter);
        
        CellRendererManager.registerRenderer(colorsConverter.getType(), enumCellRenderer, enumCellRenderer.getContext());
        
        CellEditorFactory editorFactory = new CellEditorFactory() {
        	private AbstractComboBox comboBox;
        	
            public CellEditor create()
            {
            	EnumCellEditor enumCellEditor = new EnumCellEditor(colorsConverter);

            	setComboBox(enumCellEditor.getComboBox());
            	
            	getComboBox().setRenderer(new ComboBoxRenderer(comboBox));

            	for (int i = 0; i < comboBox.getComponentCount(); i++)
            	{
            		Component c = comboBox.getComponent(i);
	            	c.addMouseListener(new CustomMouseAdapter());
	            }
            	
            	getComboBox().addItemListener(new CustomItemChangeListener());
            	
                return enumCellEditor;
            }

            class CustomMouseAdapter extends MouseAdapter
            {
	            public void mouseReleased(MouseEvent me)
	            {
    				Component sourceComponent = (Component) me.getSource();
    				ListComboBox listComboBox = (ListComboBox) sourceComponent.getParent();
    				
    				PropertyTable propertyTable = (PropertyTable) listComboBox.getParent();
    				int editingRow = propertyTable.getEditingRow();
                	
               	 	PropertyTableModel<?> propertyTableModel = (PropertyTableModel<?>) propertyTable.getModel();
            	 
               	 	Property property = (Property) propertyTableModel.getRowAt(editingRow);
               	 	String propertyName = property.getName();
            	 
               	 	if (propertyName.matches("backgroundColor"))
               	 	{
               	 		Color backgroundColor = Colors.valueOf(listComboBox.getSelectedItem().toString()).getColor();
               	 		
               	 		getComboBox().setForeground(ColorUtils.getContrastingColor(backgroundColor));
               	 		getComboBox().setBackground(backgroundColor);
               	 	}
	            }
            }

			public AbstractComboBox getComboBox() 
			{
				return comboBox;
			}

			public void setComboBox(AbstractComboBox comboBox)
			{
				this.comboBox = comboBox;
			}
        };

        CellEditorManager.registerEditor(colorsConverter.getType(), editorFactory);
        
        for (Iterator<?> iter = properties.entrySet().iterator(); iter.hasNext();)
        {
            final Map.Entry<?, ?> entry = (Entry<?, ?>) iter.next();
            final String propertyName = (String) entry.getKey();
            final Object propertyValue = entry.getValue();
            
            
            if (!propertyName.equals("class") && !propertyName.equals("name"))
            {
                Property displayProperty = new Property(propertyName, theConfig.getPropertyDescription(propertyName), propertyValue.getClass())
                {
                    /**
					 * 
					 */
					private static final long serialVersionUID = -4650355524853942976L;

					public void setValue(Object value)
                    {
                        try
                        {
                            dialogProxy.setDirty() ;
                            
                            PropertyUtils.setProperty(theConfig, propertyName, value);
                        }
                        catch (Exception e)
                        {
                            cat.error(e.getMessage(), e);
                        }
                    }

                    public Object getValue()
                    {
                        try
                        {
                            return PropertyUtils.getProperty(theConfig, propertyName);
                        }
                        catch (Exception e)
                        {
                            cat.error(e.getMessage(), e);
                        }

                        return null;
                    }

                    public boolean hasValue()
                    {
                        return true;
                    }
                };

                list.add(displayProperty);
            }
        }

        Collections.sort(list);
        
        PropertyTableModel<Property> model = new PropertyTableModel<>(list);

//        class CustomPropertyTable extends PropertyTable
//        {
//			private static final long serialVersionUID = -7772049234223525L;
//			private PropertyTableModel<Property> propertyTableModel;
//        	
//			public CustomPropertyTable(PropertyTableModel<Property> model)
//			{
//				super(model);
//				this.propertyTableModel = model;
//			}
//
//			public Component prepareRenderer(TableCellRenderer renderer, int row, int column)
//			{
//				Component component = super.prepareRenderer(renderer, row, column);
//				Color defaultBackgroundColor = Color.WHITE;
//				
//				component.setForeground(ColorUtils.getContrastingColor(defaultBackgroundColor));
//				component.setBackground(defaultBackgroundColor);
//				
//				if (propertyTableModel.getCellClassAt(row, column) != null)
//				{
//					if (propertyTableModel.getCellClassAt(row, column).isAssignableFrom(Colors.class))
//					{
//						Color backgroundColor = Colors.valueOf(propertyTableModel.getValueAt(row, column).toString()).getColor();
//						component.setForeground(ColorUtils.getContrastingColor(backgroundColor));
//						component.setBackground(backgroundColor);
//					}
//				}
//
//				return component;
//			}
//        }
        
        PropertyTable table;
        
//        if (!theConfig.getName().matches("hermes.renderers.XMLMessageRenderer"))
//        {
//        	table = new PropertyTable(model);
//        }
//        else
//        {
        	table = new CustomPropertyTable(model);
//        }
        
        Property propRow = (Property) table.getRowAt(0);
       	propRow.setDisplayName("Properties");
       	
        table.setAutoResizeMode(PropertyTable.AUTO_RESIZE_ALL_COLUMNS);

        PropertyPane pane = new PropertyPane(table);
        
        pane.addPropertyChangeListener(new PropertyChangeListener()
        {
            public void propertyChange(PropertyChangeEvent evt)
            {
                dialogProxy.setDirty() ;
            }
        }) ;
        
        model.expandAll();
        
        return pane;
    }

	public static Color getXmlRendererBackgroundColor()
	{
		return xmlRendererBackgroundColor;
	}

	public static void setXmlRendererBackgroundColor(Color xmlRendererBackgroundColor)
	{
		RendererHelper.xmlRendererBackgroundColor = xmlRendererBackgroundColor;
	}
}