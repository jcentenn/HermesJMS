package hermes.swing.listeners.mouse;

import hermes.swing.components.MessageRendererPopupMenu;
import hermes.swing.util.ComponentUtil;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.jidesoft.document.TdiGroup;

public final class MessageRendererMouseAdapter extends MouseAdapter  
{
	public void mousePressed(MouseEvent e)
	{
        if (e.isPopupTrigger() && shouldHandleHere(e))
        {
            doPop(e);
        }
    }

    public void mouseReleased(MouseEvent e)
    {
    	if (e.isPopupTrigger() && shouldHandleHere(e))
        {
           doPop(e);
        }
    }

    private void doPop(MouseEvent e)
    {
    	Component component = e.getComponent();
    	MessageRendererPopupMenu menu = new MessageRendererPopupMenu(getDestination(component));
        
        menu.show(component, e.getX(), e.getY());
    }
    
    private String getDestination(Component component)
    {
    	TdiGroup tdiGroup = (TdiGroup) ComponentUtil.getParentComponentForType(ComponentUtil.getParentComponentForType(component, TdiGroup.class), TdiGroup.class);
    	
    	String label = tdiGroup.getTitleAt(tdiGroup.getSelectedIndex());
    	
    	String[] labelArray = label.split(" ");
    	String destination = labelArray[0] + ": " + labelArray[1];
    	
    	return destination;
    }
	
    public boolean shouldHandleHere(MouseEvent e) 
    {
        return (e.getModifiersEx() & MouseEvent.CTRL_DOWN_MASK) != 0;
    }
}
