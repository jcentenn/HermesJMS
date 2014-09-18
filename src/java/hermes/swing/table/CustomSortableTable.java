package hermes.swing.table;

import hermes.swing.colors.ColorUtils;

import java.awt.Color;
import java.awt.Component;

import javax.swing.table.TableCellRenderer;

import com.jidesoft.grid.SortableTable;

public class CustomSortableTable extends SortableTable
{
	private static final long serialVersionUID = -7772049234223525L;
	
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column)
	{
		Component component = super.prepareRenderer(renderer, row, column);
		Color defaultBackgroundColor = Color.WHITE;
		
		component.setForeground(ColorUtils.getContrastingColor(defaultBackgroundColor));
		component.setBackground(defaultBackgroundColor);

		return component;
	}
}