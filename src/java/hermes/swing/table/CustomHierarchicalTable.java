package hermes.swing.table;

import hermes.browser.model.ClasspathGroupTableModel;
import hermes.swing.colors.ColorUtils;
import hermes.swing.colors.Colors;

import java.awt.Color;
import java.awt.Component;

import javax.swing.table.TableCellRenderer;

import com.jidesoft.grid.HierarchicalTable;
import com.jidesoft.grid.MarginExpandablePanel;

public class CustomHierarchicalTable extends HierarchicalTable
{
	private static final long serialVersionUID = 7175847296029427862L;

	public CustomHierarchicalTable(ClasspathGroupTableModel model)
	{
		super(model);
	}

	public Component prepareRenderer(TableCellRenderer renderer, int row, int column)
	{
		Component component = super.prepareRenderer(renderer, row, column);
		Color defaultBackgroundColor = Colors.WHITE.getColor();
		
		MarginExpandablePanel marginExpandablePanel = (MarginExpandablePanel) component;
		
		if (marginExpandablePanel.getComponentCount() > 0)
		{
			Component nestedComponent = marginExpandablePanel.getComponent(0);
			nestedComponent.setForeground(ColorUtils.getContrastingColor(defaultBackgroundColor));
			nestedComponent.setBackground(defaultBackgroundColor);
		}
		
		component.setForeground(ColorUtils.getContrastingColor(defaultBackgroundColor));
		component.setBackground(defaultBackgroundColor);

		return component;
	}
}
