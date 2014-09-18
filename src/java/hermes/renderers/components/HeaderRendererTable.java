package hermes.renderers.components;

import hermes.swing.colors.ColorUtils;
import hermes.swing.colors.Colors;

import java.awt.Component;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.jidesoft.grid.SortableTable;

public class HeaderRendererTable extends SortableTable
{
	private static final long serialVersionUID = 4940836313380713311L;
	private DefaultTableModel model;
	
	public HeaderRendererTable(DefaultTableModel model)
	{
		super(model);
		
		setSortable(true);
		this.model = model;
	}

	public Component prepareRenderer(TableCellRenderer renderer, int row, int column)
	{
		final Component component = super.prepareRenderer(renderer, row, column);
		
		String propertyName = (String) model.getValueAt(getActualRowAt(row), 0);
		
		if (propertyName.startsWith("JMS"))
		{
			component.setBackground(Colors.PEACHPUFF.getColor());
		}
		else if (propertyName.startsWith("MULE"))
		{
			component.setBackground(Colors.LIGHTSTEELBLUE.getColor());
		}
		else if (propertyName.startsWith("FIX"))
		{
			component.setBackground(Colors.PALEGREEN.getColor());
		}
		else
		{
			component.setBackground(Colors.LIGHTSKYBLUE.getColor());
		}
		
		// Make sure the text is easy to see
		component.setForeground(ColorUtils.getContrastingColor(component.getBackground()));
		
		return component;
	}
}
