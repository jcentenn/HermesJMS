/*
 * Copyright 2003,2004,2005 Colin Crist
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package hermes.swing.actions;

import hermes.HermesException;
import hermes.browser.HermesBrowser;
import hermes.browser.IconCache;
import hermes.browser.model.BrowserTreeModel;
import hermes.browser.model.tree.FolderTreeNode;
import hermes.config.HermesConfig;
import hermes.config.JMSSessionGroupConfig;

import java.awt.event.ActionEvent;

import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

import org.apache.log4j.Logger;

/**
 * Create a new JMS session.
 *
 * @author colincrist@hermesjms.com
 * @version $Id: CreateNewContextAction.java,v 1.1 2005/05/14 22:53:48
 *          colincrist Exp $
 */

public class CreateNewSessionFolderAction extends ActionSupport
{
	private static final long serialVersionUID = 2530938007369978175L;
	private static final Logger log = Logger.getLogger(CreateNewSessionFolderAction.class);

   public CreateNewSessionFolderAction()
   {
      putValue(Action.NAME, "New session folder");
      putValue(Action.SHORT_DESCRIPTION, "Create new JMS session folder.");
      putValue(Action.SMALL_ICON, IconCache.getIcon("hermes.tree.folder.new"));

      setEnabled(!HermesBrowser.getBrowser().isRestricted()) ;
   }

   public void actionPerformed(ActionEvent arg0)
   {
	   try
	   {
		   HermesBrowser hermesBrowser = HermesBrowser.getBrowser();
		   BrowserTreeModel browserTreeModel = (BrowserTreeModel) hermesBrowser.getBrowserTree().getModel();
		   HermesConfig hermesConfig = hermesBrowser.getConfig();
		   
		   final String folderName = JOptionPane.showInputDialog(HermesBrowser.getBrowser(), "Enter folder name", "");

		   if (folderName != null && !folderName.equals(""))
		   {
			   JMSSessionGroupConfig jmsSessionGroupConfig = new JMSSessionGroupConfig();
			   jmsSessionGroupConfig.setName(folderName);
			   DefaultMutableTreeNode defaultMutableTreeNode = browserTreeModel.getJmsRootNode();
			   
			   //	No dulicate folder names
			   for (int i = 0; i < defaultMutableTreeNode.getChildCount(); i++)
			   {
				   TreeNode treeNode = defaultMutableTreeNode.getChildAt(i);
				   
				   if (treeNode.getClass().isAssignableFrom(FolderTreeNode.class))
				   {
					   FolderTreeNode folderTreeNode = (FolderTreeNode) treeNode;
					   
					   if (folderTreeNode.getId().matches(folderName))
					   {
						   throw new Exception("Duplicate folder name");
					   }
				   }
			   }
			   
			   FolderTreeNode folderTreeNode = new FolderTreeNode(folderName, hermesBrowser.getHermes(), jmsSessionGroupConfig);
			   
			   //	Add folder to config and model
			   hermesConfig.getJmsSessionGroup().add(jmsSessionGroupConfig);
			   //browserTreeModel.onFolderAdded(folderTreeNode);
			   
			   defaultMutableTreeNode.add(folderTreeNode);
			   final int[] index = { defaultMutableTreeNode.getIndex(folderTreeNode) };
			   
			   hermesBrowser.getBrowserTree().getBrowserModel().nodesWereInserted(defaultMutableTreeNode, index);
			   
			   hermesBrowser.saveConfig();
		   }
		   else
		   {
			   HermesBrowser.getBrowser().showErrorDialog("Invalid folder name.");
		   }	  
      
	   }
	   catch (Throwable ex)
	   {
		   HermesBrowser.getBrowser().showErrorDialog("Cannot create folder:", ex);
	   }
   }
}
