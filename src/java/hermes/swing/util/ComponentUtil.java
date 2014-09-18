package hermes.swing.util;

import java.awt.Component;

public class ComponentUtil
{
	public static Component getParentComponentForType(Component component, Class<?> targetClass)
	{
		Component parentComponent = component.getParent();

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
}
