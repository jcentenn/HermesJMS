package hermes.swing.actions;

import java.util.Enumeration;

import javax.swing.tree.TreePath;

import hermes.browser.components.BrowserTree;

public class BrowserTreeUtil
{
    public static Enumeration<TreePath> saveExpansionState(BrowserTree browserTree)
    {
		//	Record expanded nodes to reinstate later; 
		TreePath rootPath = new TreePath(browserTree.getModel().getRoot());
		
		return browserTree.getExpandedDescendants(rootPath);
    }
	
    public static void restoreExpansionState(BrowserTree browserTree, Enumeration<TreePath> expandedPaths)
    {
		if (expandedPaths != null)
		{
			while (expandedPaths.hasMoreElements())
			{
				TreePath treePath = (TreePath) expandedPaths.nextElement();

				browserTree.expandPath(treePath);
			}
		}
    }
}
