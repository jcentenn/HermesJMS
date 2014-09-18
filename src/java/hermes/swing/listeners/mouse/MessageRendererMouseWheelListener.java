package hermes.swing.listeners.mouse;

import hermes.browser.MainDocumentPane;
import hermes.browser.components.MessagePayloadPanel;
import hermes.fix.FIXMessageViewTable;
import hermes.renderers.components.HeaderRendererTable;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JSplitPane;

import com.jidesoft.document.TdiGroup;

public final class MessageRendererMouseWheelListener implements MouseWheelListener 
{
	private Component getParentComponentForType(Component component, Class<?> targetClass)
	{
		Component parentComponent = component.getParent();

		//System.err.println("Parent: " + parentComponent);
		
		if (parentComponent.getClass().isAssignableFrom(targetClass))
		{
			return parentComponent;	
		}
		else
		{
			parentComponent = getParentComponentForType(parentComponent, targetClass);
		}
		
		return parentComponent;
	}

//	private Component getParentComponent(Component component)
//	{
//		return component.getParent();
//	}
	
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) 
    {
    	Component component = e.getComponent();
    	
    	//TdiGroup tdiGroup = (TdiGroup) getParentComponentForType(getParentComponentForType(component, TdiGroup.class), TdiGroup.class);
//    	Component tdiGroup = getParentComponentForType(component, JRootPane.class);
//    	
//    	System.err.println(tdiGroup.getParent());
//    	Component x = tdiGroup.getParent();
    	
    	
        if (shouldHandleHere(e)) 
        {
        	float offset = 0;
            Font font = component.getFont();
            int fontSize = font.getSize();
            
            int notches = e.getWheelRotation();
            float newSize;
            
            //	Decrease font size
            if (notches > 0) 
            {
            	offset = -1f;
            	
                if ((fontSize + offset) < 1)
            	{
                	offset = 0f;
            	}
            }
            //	Increase font size
            else 
            {
            	offset = 1f;
            }

            newSize = font.getSize() + offset;
            
            Class<?> componentClass = component.getClass();

            //	Adjust rowsize of table for FIX renderer if applicable
        	if (componentClass.isAssignableFrom(FIXMessageViewTable.class))
        	{
        		FIXMessageViewTable fixMessageViewTable = (FIXMessageViewTable) component;
        		fixMessageViewTable.setRowHeight((int) (fixMessageViewTable.getRowHeight() + offset));
        	}

        	//	Adjust rowsize of table for Header renderer if applicable
        	if (componentClass.isAssignableFrom(HeaderRendererTable.class))
        	{
        		HeaderRendererTable headerRendererTable = (HeaderRendererTable) component;
        		headerRendererTable.setRowHeight((int) (headerRendererTable.getRowHeight() + offset));
        	}
        	
            Font newFont = font.deriveFont(newSize);
            
            component.setFont(newFont);
        }
        else
        {
        	component.getParent().dispatchEvent(e);
        }       
    }

    public boolean shouldHandleHere(MouseWheelEvent e) 
    {
        return (e.getModifiersEx() & MouseWheelEvent.CTRL_DOWN_MASK) != 0;
    }
}
