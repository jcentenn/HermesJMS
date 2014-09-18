package hermes.swing.renderer;

import hermes.swing.colors.ColorUtils;
import hermes.swing.colors.Colors;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import com.jidesoft.combobox.AbstractComboBox;

public class ComboBoxRenderer extends JPanel implements ListCellRenderer<Object>
{
	private static final long serialVersionUID = 8045723784305929776L;

    private JPanel textPanel;
    private JLabel text;
    private ArrayList<Colors> colors = new ArrayList<Colors>();
    
	public ComboBoxRenderer(AbstractComboBox comboBox)
    {
        textPanel = new JPanel();
        textPanel.add(this);
        
        text = new JLabel();
        text.setOpaque(true);
        text.setFont(comboBox.getFont());
        
        for (int i=0; i < comboBox.getModel().getSize(); i++)
        {
            Object element = comboBox.getModel().getElementAt(i);
            colors.add(Colors.valueOf(element.toString()));
        }
        
        textPanel.add(text);
    }

    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus)
    {
        text.setText(value.toString());
        
        Object[] colorsArray = colors.toArray();
        
        if (index > -1)
        {
        	Color color = ((Colors) colorsArray[index]).getColor();
            
        	text.setForeground(ColorUtils.getContrastingColor(color));
            text.setBackground(color);
        }
        
        if (isSelected)
        {
        	Color bgColor = text.getBackground();
        	Color fgColor = text.getForeground();
            text.setBackground(fgColor);
            text.setForeground(bgColor);
        }
        
        return text;
    }
}