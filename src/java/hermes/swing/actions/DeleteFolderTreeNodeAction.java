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

import hermes.Hermes;
import hermes.HermesException;
import hermes.browser.HermesBrowser;
import hermes.browser.IconCache;
import hermes.browser.model.tree.AbstractTreeNode;
import hermes.browser.model.tree.DestinationConfigTreeNode;
import hermes.browser.model.tree.DestinationFragmentTreeNode;
import hermes.browser.model.tree.FolderTreeNode;
import hermes.browser.model.tree.HermesTreeNode;
import hermes.browser.model.tree.MessageStoreQueueTreeNode;
import hermes.browser.model.tree.MessageStoreTopicTreeNode;
import hermes.browser.model.tree.MessageStoreTreeNode;
import hermes.browser.model.tree.MessageStoreURLTreeNode;
import hermes.browser.model.tree.NamingConfigTreeNode;
import hermes.config.HermesConfig;
import hermes.store.MessageStore;
import hermes.util.JMSUtils;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;

import org.apache.log4j.Logger;

/**
 * Delete a destination, session or context from the browser tree,
 * 
 * @author colincrist@hermesjms.com
 * @version $Id: DeleteBrowserTreeNodeAction,v 1.1 2005/05/14 22:53:48
 *          colincrist Exp $
 */

public class DeleteFolderTreeNodeAction extends ActionSupport
{
   /**
	 * 
	 */
	private static final long serialVersionUID = -6731870847606117144L;
private static final Logger log = Logger.getLogger(DeleteFolderTreeNodeAction.class);

   public DeleteFolderTreeNodeAction()
   {
      putValue(Action.NAME, "Delete");
      putValue(Action.SHORT_DESCRIPTION, "Delete the folder.");
      putValue(Action.SMALL_ICON, IconCache.getIcon("hermes.objects.delete"));

      setEnabled(false);

      if (!HermesBrowser.getBrowser().isRestricted())
      {
         enableOnBrowserTreeSelection(new Class[] { FolderTreeNode.class }, this, false);
      }

   }

   private void doDelete(FolderTreeNode hermesNode) throws HermesException
   {
      final HermesConfig config = HermesBrowser.getBrowser().getConfig();
      final MutableTreeNode parentNode = (MutableTreeNode) hermesNode.getParent();

      HermesBrowser.getConfigDAO().removeHermes(config, hermesNode.getHermes().getId());

      HermesBrowser.getBrowser().saveConfig();
      Hermes.ui.getDefaultMessageSink().add(hermesNode.getHermes().getId() + " removed");

      final int[] index = { parentNode.getIndex(hermesNode) };
      final Object[] objects = { hermesNode };

      parentNode.remove(hermesNode);
      HermesBrowser.getBrowser().getBrowserTree().getBrowserModel().nodesWereRemoved(parentNode, index, objects);

   }

   public void actionPerformed(ActionEvent event)
   {
      try
      {
         final TreePath[] paths = HermesBrowser.getBrowser().getBrowserTree().getSelectionPaths();

         if (paths != null && paths.length > 0)
         {
            String msg = paths.length == 1 ? "Are you sure you want to delete this object?" : "Are you sure you want to delete these objects?";

            if (JOptionPane.showConfirmDialog(HermesBrowser.getBrowser(), msg, "Please confirm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            {
               for (final TreePath path : paths)
               {
                  final Object object = path.getLastPathComponent();

                  if (object instanceof HermesTreeNode)
                  {
                     doDelete((FolderTreeNode) object);
                  }
               }
            }

            HermesBrowser.getBrowser().saveConfig();
         }
      }
      catch (Exception ex)
      {
         log.error(ex.getMessage(), ex);
         HermesBrowser.getBrowser().showErrorDialog("Cannot delete: ", ex);
      }
   }
}
