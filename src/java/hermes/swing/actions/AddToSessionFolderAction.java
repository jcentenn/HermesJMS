package hermes.swing.actions;

import hermes.browser.HermesBrowser;
import hermes.browser.IconCache;
import hermes.browser.components.BrowserTree;
import hermes.browser.model.BrowserTreeModel;
import hermes.browser.model.tree.FolderTreeNode;
import hermes.browser.model.tree.HermesTreeNode;
import hermes.config.JMSGroupMemberConfig;
import hermes.config.JMSSessionGroupConfig;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.Action;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class AddToSessionFolderAction extends ActionSupport
{
	private static final long serialVersionUID = 139535445442209172L;
	private FolderTreeNode folderTreeNode;
	private HermesTreeNode hermesTreeNode;
	private DefaultMutableTreeNode jmsRootNode;
	
	public AddToSessionFolderAction(HermesTreeNode hermesTreeNode, FolderTreeNode folderTreeNode)
	{
		if (hermesTreeNode != null && folderTreeNode != null)
		{
			putValue(Action.NAME, "Add " + hermesTreeNode.getId() + " to session folder " + folderTreeNode.getId());
			putValue(Action.SHORT_DESCRIPTION, "Add item to session folder");
			putValue(Action.SMALL_ICON, IconCache.getIcon("jms.connectionMove"));
	
			setEnabled(true);
	
			this.folderTreeNode = folderTreeNode;
			this.hermesTreeNode = hermesTreeNode;
		}
	}

	public AddToSessionFolderAction(HermesTreeNode hermesTreeNode, DefaultMutableTreeNode jmsRootNode)
	{
		if (hermesTreeNode != null && jmsRootNode != null)
		{
			putValue(Action.NAME, "Add " + hermesTreeNode.getId() + " to session folder " + jmsRootNode);
			putValue(Action.SHORT_DESCRIPTION, "Add item to root folder");
			putValue(Action.SMALL_ICON, IconCache.getIcon("hermes.tree.folder.root"));
	
			setEnabled(true);
	
			this.jmsRootNode = jmsRootNode;
			this.hermesTreeNode = hermesTreeNode;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		try
	    {
			BrowserTree browserTree = getBrowserTree();
			BrowserTreeModel browserTreeModel = (BrowserTreeModel) browserTree.getModel();
			FolderTreeNode parentFolderTreeNode = null;
			
			Object parentNode = hermesTreeNode.getParent();
			
			DefaultMutableTreeNode rootNode = browserTreeModel.getJmsRootNode();

			if (folderTreeNode != null)
			{
				JMSSessionGroupConfig jmsSessionGroupConfig = folderTreeNode.getJmsSessionGroupConfig();
				
				List<JMSGroupMemberConfig> jmsGroupMemberConfigList = jmsSessionGroupConfig.getJmsGroupMember();
				
				JMSGroupMemberConfig jmsGroupMemberConfig = new JMSGroupMemberConfig();
				jmsGroupMemberConfig.setId(hermesTreeNode.getId());
				
				jmsGroupMemberConfigList.add(jmsGroupMemberConfig);
			
				if (parentNode != null)
				{
					if (parentNode.getClass().equals(FolderTreeNode.class))
					{
						parentFolderTreeNode = (FolderTreeNode) parentNode;
						parentFolderTreeNode.remove(hermesTreeNode);
						
						JMSSessionGroupConfig parentJmsSessionGroupConfig = parentFolderTreeNode.getJmsSessionGroupConfig();
						
						List<JMSGroupMemberConfig> parentJmsSessionGroupConfigList = parentJmsSessionGroupConfig.getJmsGroupMember();
						
						// Remove configs from parent
						List<JMSGroupMemberConfig> deleteList = findJMSGroupMemberConfigByID(parentJmsSessionGroupConfig.getJmsGroupMember(), hermesTreeNode.getId());
						parentJmsSessionGroupConfigList.removeAll(deleteList);
					}
				}
	
				folderTreeNode.add(hermesTreeNode);
			}
			
			if (jmsRootNode != null)
			{
				if (parentNode.getClass().isAssignableFrom(FolderTreeNode.class))
				{
					parentFolderTreeNode = (FolderTreeNode) parentNode;
					parentFolderTreeNode.remove(hermesTreeNode);
					
					JMSSessionGroupConfig parentJmsSessionGroupConfig = parentFolderTreeNode.getJmsSessionGroupConfig();
					
					List<JMSGroupMemberConfig> parentJmsSessionGroupConfigList = parentJmsSessionGroupConfig.getJmsGroupMember();
					
					// Remove configs from parent
					List<JMSGroupMemberConfig> deleteList = findJMSGroupMemberConfigByID(parentJmsSessionGroupConfig.getJmsGroupMember(), hermesTreeNode.getId());
					parentJmsSessionGroupConfigList.removeAll(deleteList);
					
					jmsRootNode.add(hermesTreeNode);
					
					System.err.println("ROOT: " + parentFolderTreeNode);
				}
			}
			
			HermesBrowser.getBrowser().saveConfig();
			
			//	Record expanded nodes to reinstate later; 
			Enumeration<TreePath> expandedPaths = BrowserTreeUtil.saveExpansionState(getBrowserTree());

			//	Refresh the model to reflect the movement of the BrowserTreeNode
			//	This will close all the nodes
			browserTree.getBrowserModel().nodeStructureChanged(rootNode);
			
			//	Use saved node state to restore expanded noded
			BrowserTreeUtil.restoreExpansionState(browserTree, expandedPaths);
	    }
		catch (Exception ex)
		{
			HermesBrowser.getBrowser().showErrorDialog("Adding to session folder: " + ex.getMessage(), ex);
		}
	}
	
	public static List<JMSGroupMemberConfig> findJMSGroupMemberConfigByID(List<JMSGroupMemberConfig> list, String id)
	{
		ArrayList<JMSGroupMemberConfig> returnList = new ArrayList<JMSGroupMemberConfig>();
		
		for (JMSGroupMemberConfig jmsGroupMemberConfig : list)
		{
			if (jmsGroupMemberConfig.getId().matches(id))
			{
				returnList.add(jmsGroupMemberConfig);
			}
		}
		
		return returnList;
	}
	
	public static boolean isPathValid(JTree tree, TreePath path)
	{
		TreeModel model = tree.getModel();
   
		if (path.getPathCount() == 0)
		{
			return model.getRoot().equals(path.getPathComponent(0));
		}
		
		for (int i = 1; i < path.getPathCount(); i++)
		{
			if (model.getIndexOfChild(path.getPathComponent(i-1), path.getPathComponent(i)) == -1)
			{
				return false;
			}
		}
   
		return true;
	}
}
