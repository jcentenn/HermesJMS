package hermes.swing;

import java.awt.Component;
import java.text.DecimalFormat;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class IntegerTableCellRenderer extends DefaultTableCellRenderer
{
	private static final long serialVersionUID = -6067708250667263536L;

	private static final DecimalFormat formatter = new DecimalFormat("#");
	 
	public Component getTableCellRendererComponent(JTable table, Object formattedValue, boolean isSelected, boolean hasFocus, int row, int column)
	{
		formattedValue = formatter.format((Number) formattedValue);

		return super.getTableCellRendererComponent(table, formattedValue, isSelected, hasFocus, row, column);
	} 	
}
