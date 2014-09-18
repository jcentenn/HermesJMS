package hermes.swing.table;

import hermes.swing.colors.ColorUtils;
import hermes.swing.colors.Colors;

import java.awt.Color;
import java.awt.Component;

import javax.swing.table.TableCellRenderer;

import com.jidesoft.grid.Property;
import com.jidesoft.grid.PropertyTable;
import com.jidesoft.grid.PropertyTableModel;

public class CustomPropertyTable extends PropertyTable
{
	private static final long serialVersionUID = -7772049234223525L;
	private PropertyTableModel<Property> propertyTableModel;
	
	public CustomPropertyTable(PropertyTableModel<Property> model)
	{
		super(model);
		this.propertyTableModel = model;
	}

	public Component prepareRenderer(TableCellRenderer renderer, int row, int column)
	{
		Component component = super.prepareRenderer(renderer, row, column);
		Color defaultBackgroundColor = Color.WHITE;
		
		component.setForeground(ColorUtils.getContrastingColor(defaultBackgroundColor));
		component.setBackground(defaultBackgroundColor);
		
		if (propertyTableModel.getCellClassAt(row, column) != null)
		{
			if (propertyTableModel.getCellClassAt(row, column).isAssignableFrom(Colors.class))
			{
				Color backgroundColor = Colors.valueOf(propertyTableModel.getValueAt(row, column).toString()).getColor();
				component.setForeground(ColorUtils.getContrastingColor(backgroundColor));
				component.setBackground(backgroundColor);
			}
		}

		return component;
	}
}