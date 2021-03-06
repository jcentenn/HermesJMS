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

package hermes.browser.components;

import hermes.Hermes;
import hermes.HermesException;
import hermes.browser.HermesBrowser;
import hermes.browser.IconCache;
import hermes.browser.model.BrowserTreeModel;
import hermes.browser.model.tree.DestinationConfigTreeNode;
import hermes.browser.model.tree.FolderTreeNode;
import hermes.browser.model.tree.HermesTreeNode;
import hermes.browser.model.tree.QueueTopicTreeNode;
import hermes.browser.model.tree.QueueTreeNode;
import hermes.browser.model.tree.TopicTreeNode;
import hermes.browser.tasks.RecordDestinationTask;
import hermes.browser.transferable.HermesConfigGroup;
import hermes.browser.transferable.JMSAdministeredObjectTransferable;
import hermes.config.WatchConfig;
import hermes.fix.FIXMessageTable;
import hermes.store.MessageStore;
import hermes.swing.actions.ActionRegistry;
import hermes.swing.actions.AddDurableTopicAction;
import hermes.swing.actions.AddQueueAction;
import hermes.swing.actions.AddToExistingWatchAction;
import hermes.swing.actions.AddToSessionFolderAction;
import hermes.swing.actions.AddTopicAction;
import hermes.swing.actions.BrowseDestinationOrContextAction;
import hermes.swing.actions.BrowseDestinationWithSelectorAction;
import hermes.swing.actions.CascadeBrowserTreeAction;
import hermes.swing.actions.ChainByClOrdIDAction;
import hermes.swing.actions.CollapseBrowserTreeAction;
import hermes.swing.actions.CopyBrowserNodeAction;
import hermes.swing.actions.CopyMessagesToClipboardAction;
import hermes.swing.actions.CorrelateMessagesAction;
import hermes.swing.actions.CreateNewContextAction;
import hermes.swing.actions.CreateNewJNDIContextAction;
import hermes.swing.actions.CreateNewMessageStoreAction;
import hermes.swing.actions.CreateNewSessionAction;
import hermes.swing.actions.CreateNewSessionFolderAction;
import hermes.swing.actions.CreateNewSessionFromJNDIAction;
import hermes.swing.actions.CreateNewWatchAction;
import hermes.swing.actions.CutMessagesToClipboardAction;
import hermes.swing.actions.DeleteBrowserTreeNodeAction;
import hermes.swing.actions.DeleteMessagesAction;
import hermes.swing.actions.DiscoverDestinationsAction;
import hermes.swing.actions.DurableUnsubscribeAction;
import hermes.swing.actions.EditObjectAction;
import hermes.swing.actions.ExpandBrowserTreeAction;
import hermes.swing.actions.GetDestinationStatisticsAction;
import hermes.swing.actions.JNDIUnbindAction;
import hermes.swing.actions.PasteMessagesFromClipboardAction;
import hermes.swing.actions.RenameJNDIBindingAction;
import hermes.swing.actions.ReplayAction;
import hermes.swing.actions.SaveAllMessagesAsXMLAction;
import hermes.swing.actions.SaveMessagesAsTextAction;
import hermes.swing.actions.SaveMessagesAsXMLAction;
import hermes.swing.actions.SaveMessagesIndividuallyAsXMLAction;
import hermes.swing.actions.SearchDestinationOrContextAction;
import hermes.swing.actions.SendNewMessageAction;
import hermes.swing.actions.TruncateAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.TransferHandler;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

import org.apache.log4j.Logger;

import com.jidesoft.swing.JideMenu;
import com.jidesoft.swing.JidePopupMenu;

/**
 * Factory for the creation of popups.
 * 
 * @author colincrist@hermesjms.com
 * @version $Id: PopupMenuFactory.java,v 1.25 2007/02/18 16:13:39 colincrist Exp $
 */

public class PopupMenuFactory
{
   private static final Logger log = Logger.getLogger(PopupMenuFactory.class);

   public static JidePopupMenu createFIXMessageTablePopup(final FIXMessageTable table)
   {
      final JidePopupMenu popup = new JidePopupMenu() ;
      final JideMenu editMenu = new JideMenu("Edit...") ;
      final JideMenu chainMenu = new JideMenu("Chain...") ;
      final JCheckBoxMenuItem autoScroll = new JCheckBoxMenuItem("Autoscroll") ;
      
      chainMenu.add(new JMenuItem(new ChainByClOrdIDAction(chainMenu, table))) ;
      editMenu.add(new JMenuItem(ActionRegistry.getAction(CopyMessagesToClipboardAction.class)));
      
      popup.add(editMenu) ;
      popup.add(chainMenu) ;
      // popup.add(autoScroll) ;
      
      autoScroll.setSelected(table.isAutoScroll()) ;
      autoScroll.addActionListener(new ActionListener()
      {      
         public void actionPerformed(ActionEvent e)
         {
            table.setAutoscrolls(autoScroll.isSelected()) ;      
         }      
      }) ;
      
      return popup ;
   }
   public static JidePopupMenu createBrowseActionPopup()
   {
      final JidePopupMenu popup = new JidePopupMenu();
      final JideMenu editMenu = new JideMenu("Edit...");
      final JideMenu saveMenu = new JideMenu("Save...");

      editMenu.add(new JMenuItem(ActionRegistry.getAction(CutMessagesToClipboardAction.class)));
      editMenu.add(new JMenuItem(ActionRegistry.getAction(CopyMessagesToClipboardAction.class)));
      editMenu.add(new JMenuItem(ActionRegistry.getAction(PasteMessagesFromClipboardAction.class)));

      saveMenu.add(new JMenuItem(ActionRegistry.getAction(SaveMessagesAsTextAction.class)));
      saveMenu.add(new JMenuItem(ActionRegistry.getAction(SaveMessagesAsXMLAction.class)));
      saveMenu.add(new JMenuItem(ActionRegistry.getAction(SaveMessagesIndividuallyAsXMLAction.class)));

      popup.add(new JMenuItem(ActionRegistry.getAction(CorrelateMessagesAction.class))) ;
      popup.add(editMenu);
      popup.add(saveMenu);
      popup.add(new JPopupMenu.Separator());
      popup.add(new JMenuItem(ActionRegistry.getAction(DeleteMessagesAction.class)));

      return popup;
   }

   public static JidePopupMenu createContextTreePopup(final ContextTree contextTree)
   {
      final JidePopupMenu popupMenu = new JidePopupMenu();

      final JMenuItem newSessionItem = new JMenuItem(ActionRegistry.getAction(CreateNewSessionFromJNDIAction.class));
      final JideMenu addToSessionItem = new JideMenu("Add to");
      final JMenuItem createContextItem = new JMenuItem(ActionRegistry.getAction(CreateNewJNDIContextAction.class));
      final JMenuItem renameBindingItem = new JMenuItem(ActionRegistry.getAction(RenameJNDIBindingAction.class));
      final JMenuItem unbindItem = new JMenuItem(ActionRegistry.getAction(JNDIUnbindAction.class));

      contextTree.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener()
      {
         public void valueChanged(TreeSelectionEvent e)
         {
            if (e.getNewLeadSelectionPath() == null)
            {
               addToSessionItem.setEnabled(false);
            }
            else
            {
               final TreeNode node = (TreeNode) e.getNewLeadSelectionPath().getLastPathComponent();

               addToSessionItem.setEnabled(node instanceof QueueTreeNode || node instanceof TopicTreeNode || node instanceof QueueTopicTreeNode);
            }
         }
      });

      addToSessionItem.addMouseListener(new MouseAdapter()
      {
         public void mouseEntered(MouseEvent e)
         {
            addToSessionItem.removeAll();

            for (final String sessionId : HermesBrowser.getBrowser().getBrowserTree().getAllHermesIds())
            {
               final JMenuItem menuItem = new JMenuItem(sessionId);

               // Cascade the enabled state down to the menu items from the
               // addToSessionItem...

               addToSessionItem.addPropertyChangeListener("enabled", new PropertyChangeListener()
               {
                  public void propertyChange(PropertyChangeEvent evt)
                  {
                     menuItem.setEnabled((Boolean) evt.getNewValue());
                  }
               });

               addToSessionItem.add(menuItem);

               menuItem.addActionListener(new ActionListener()
               {
                  public void actionPerformed(ActionEvent e)
                  {
                     HermesBrowser.getBrowser().getBrowserTree().doTransfer(
                           new JMSAdministeredObjectTransferable(new HermesConfigGroup(sessionId, contextTree.getSelectedDestinations(), contextTree
                                 .getSelectedConnectionFactories())), TransferHandler.COPY);
                  }
               });

               contextTree.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener()
               {
                  public void valueChanged(TreeSelectionEvent e)
                  {
                     if (e.getNewLeadSelectionPath() != null)
                     {
                        final TreeNode node = (TreeNode) e.getNewLeadSelectionPath().getLastPathComponent();

                        menuItem.setEnabled(node instanceof QueueTreeNode || node instanceof TopicTreeNode || node instanceof QueueTopicTreeNode);
                     }
                  }
               });
            }
         }
      });

      popupMenu.add(newSessionItem);
      popupMenu.add(addToSessionItem);

      popupMenu.add(createContextItem);
      popupMenu.add(renameBindingItem);
      popupMenu.add(unbindItem);

      return popupMenu;

   }

   public static JidePopupMenu createBrowserTreePopup(final BrowserTree tree)
   {
      final JidePopupMenu popupMenu = new JidePopupMenu();
      final JideMenu watchMenu = new JideMenu("Watch");
      final JideMenu newMenu = new JideMenu("New");
      final JideMenu recordMenu = new JideMenu("Record to");
      final JideMenu addToSessionFolderMenu = new JideMenu("Add To Session Folder");
      
      final JMenuItem browseItem = new JMenuItem(ActionRegistry.getAction(BrowseDestinationOrContextAction.class));
      final JMenuItem browseWithSelectorItem = new JMenuItem(ActionRegistry.getAction(BrowseDestinationWithSelectorAction.class)) ;
      final JMenuItem searchItem = new JMenuItem(ActionRegistry.getAction(SearchDestinationOrContextAction.class));
      final JMenuItem truncateItem = new JMenuItem(ActionRegistry.getAction(TruncateAction.class));
//      final JMenuItem addToSessionFolder = new JMenuItem(ActionRegistry.getAction(AddToSessionFolderAction.class));
      final JMenuItem editItem = new JMenuItem(ActionRegistry.getAction(EditObjectAction.class));
      final JMenuItem unsubscribe = new JMenuItem(ActionRegistry.getAction(DurableUnsubscribeAction.class));
      final JMenuItem addSession = new JMenuItem(ActionRegistry.getAction(CreateNewSessionAction.class));
      final JMenuItem addSessionFolder = new JMenuItem(ActionRegistry.getAction(CreateNewSessionFolderAction.class));
      final JMenuItem addContext = new JMenuItem(ActionRegistry.getAction(CreateNewContextAction.class));
      final JMenuItem addStore = new JMenuItem(ActionRegistry.getAction(CreateNewMessageStoreAction.class));
      final JMenuItem copySession = new JMenuItem(ActionRegistry.getAction(CopyBrowserNodeAction.class));
      final JMenuItem addQueue = new JMenuItem(ActionRegistry.getAction(AddQueueAction.class));
      final JMenuItem addTopic = new JMenuItem(ActionRegistry.getAction(AddTopicAction.class));
      final JMenuItem addDurableTopic = new JMenuItem(ActionRegistry.getAction(AddDurableTopicAction.class));      
      final JMenuItem delete = new JMenuItem(ActionRegistry.getAction(DeleteBrowserTreeNodeAction.class));
      final JMenuItem discover = new JMenuItem(ActionRegistry.getAction(DiscoverDestinationsAction.class));
      final JMenuItem statistics = new JMenuItem(ActionRegistry.getAction(GetDestinationStatisticsAction.class));
      final JMenuItem newWatch = new JMenuItem(ActionRegistry.getAction(CreateNewWatchAction.class));

      watchMenu.setIcon(IconCache.getIcon("hermes.watch"));
      watchMenu.setEnabled(false);

      newMenu.add(new JMenuItem(ActionRegistry.getAction(SendNewMessageAction.class))) ;
      newMenu.add(addSession);
      newMenu.add(addSessionFolder);
      newMenu.add(addContext);
      newMenu.add(addQueue);
      newMenu.add(addTopic);
      newMenu.add(addDurableTopic) ;
      // newMenu.add(new JMenuItem(ActionRegistry.getAction(CreateNewJDBCAction.class))) ;
      newMenu.add(addStore);

      newWatch.addPropertyChangeListener("enabled", new PropertyChangeListener()
      {
         public void propertyChange(PropertyChangeEvent evt)
         {
            watchMenu.setEnabled((Boolean) evt.getNewValue());
         }
      });

//      System.err.println("CHECK: " + tree.isCurrentSelectionASession());
      //addToSessionFolderMenu.setEnabled(false);
      addToSessionFolderMenu.setEnabled(tree.isCurrentSelectionASession());
      
//      addToSessionFolder.addPropertyChangeListener("enabled", new PropertyChangeListener()
//      {
//          public void propertyChange(PropertyChangeEvent evt)
//          {
//        	  addToSessionFolderMenu.setEnabled((Boolean) evt.getNewValue());
//          }
//       });
      
      popupMenu.add(newMenu);
      popupMenu.add(editItem);
      popupMenu.add(statistics);
      popupMenu.add(copySession);
      popupMenu.add(addToSessionFolderMenu);
      popupMenu.add(discover);
      popupMenu.add(delete);
      popupMenu.addSeparator() ;
      popupMenu.add(browseItem);
      popupMenu.add(browseWithSelectorItem) ;
      popupMenu.add(searchItem);
      popupMenu.add(truncateItem);
      popupMenu.add(watchMenu);
      popupMenu.add(recordMenu);
      popupMenu.add(new JMenuItem(ActionRegistry.getAction(SaveAllMessagesAsXMLAction.class))) ;
      popupMenu.add(ActionRegistry.getAction(ReplayAction.class));
     
      popupMenu.add(unsubscribe);
      popupMenu.addSeparator() ;
      popupMenu.add(new CascadeBrowserTreeAction(tree)) ;
      popupMenu.add(new ExpandBrowserTreeAction(tree)) ;
      popupMenu.add(new CollapseBrowserTreeAction(tree)) ;   
      

      
     

      recordMenu.addMouseListener(new MouseAdapter()
      {
         @Override
         public void mouseEntered(MouseEvent e)
         {
            recordMenu.removeAll();

            final Collection<MessageStore> stores = HermesBrowser.getBrowser().getBrowserTree().getMessageStores();
            final boolean isEnabled = tree.getSelectionPath() != null && tree.getSelectionPath().getLastPathComponent() instanceof DestinationConfigTreeNode ;
                    
            if (stores.size() > 0)
            {
               for (final MessageStore store : stores)
               {
                  final JMenuItem item = new JMenuItem(store.getId());

                  item.setEnabled(isEnabled);
                  item.addActionListener(new ActionListener()
                  {
                     public void actionPerformed(ActionEvent e)
                     {
                        final Hermes hermes = HermesBrowser.getBrowser().getBrowserTree().getSelectedHermesNode().getHermes();
                        final DestinationConfigTreeNode node = HermesBrowser.getBrowser().getBrowserTree().getFirstSelectedDestinationNode();

                        if (node != null)
                        {
                           HermesBrowser.getBrowser().getThreadPool().invokeLater(new RecordDestinationTask(hermes, node, store));
                        }
                     }
                  });

                  recordMenu.add(item);
               }
            }
            else
            {
               recordMenu.add(new JMenuItem("<no stores>"));
            }
         }

      });

      watchMenu.addMouseListener(new MouseAdapter()
      {
         public void mouseEntered(MouseEvent e)
         {
            watchMenu.removeAll();

            try
            {
               for (Iterator iter = HermesBrowser.getBrowser().getConfig().getWatch().iterator(); iter.hasNext();)
               {
                  final WatchConfig config = (WatchConfig) iter.next();
                  final AddToExistingWatchAction action = new AddToExistingWatchAction(config);

                  watchMenu.add(new JMenuItem(action));
                  watchMenu.addPropertyChangeListener("enabled", new PropertyChangeListener()
                  {

                     public void propertyChange(PropertyChangeEvent evt)
                     {
                        action.setEnabled((Boolean) evt.getNewValue());
                     }
                  });

                  action.setEnabled(watchMenu.isEnabled());
               }

               watchMenu.add(newWatch);
            }
            catch (HermesException ex)
            {
               log.error(ex.getMessage(), ex);
            }
         }
      });

      popupMenu.addMouseListener(new MouseAdapter()
      {
    	  public void mouseEntered(MouseEvent e)
          {
    		  addToSessionFolderMenu.removeAll();
    		  boolean enabled = false;

    		  BrowserTreeModel browserTreeModel = (BrowserTreeModel) tree.getModel();
    		  DefaultMutableTreeNode rootNode = browserTreeModel.getJmsRootNode();
    		  HermesTreeNode selectedNode = tree.getSelectedHermesNode();
    		  Object parentNode = null;
    		  
    		  if (selectedNode != null)
    		  {
        		  if (selectedNode.getParent() != null)
        		  {
        			  parentNode = selectedNode.getParent();
        		  }
    		  }
    		  
        	  if (rootNode.getChildCount() > 0)
        	  {
        		  Enumeration<?> rootNodeEnumeration = rootNode.children();
				
        		  while (rootNodeEnumeration.hasMoreElements())
        		  {
        			  Object node = rootNodeEnumeration.nextElement();
        			  
        			  if (node.getClass().isAssignableFrom(FolderTreeNode.class))
        			  {
        				  FolderTreeNode folderTreeNode = (FolderTreeNode) node;
        				  
        				  if (!folderTreeNode.equals(parentNode))
        				  {
        					  addToSessionFolderMenu.add(new AddToSessionFolderAction(selectedNode, folderTreeNode));	  
        				  }
        			  }
        		  }
        	  }
        	  
        	  if (!rootNode.equals(parentNode))
        	  {
        		  addToSessionFolderMenu.add(new AddToSessionFolderAction(selectedNode, rootNode));  
        	  }
        	  
        	  enabled = tree.isCurrentSelectionASession();
        	  
//        	  //	Check to see if selected node is the sessions node
//        	  if (selectedNode != null)
//        	  {
//        		  //	If the parent of the selected node is the sessions node and
//        		  //	the selected node is a session node enable menu
//            	  if (rootNode.equals(parentNode))
//            	  {
//            		  if (tree.isCurrentSelectionASession())
//            		  {
//            			  enabled = true;
//            		  }
//            	  }
//        	  }
        	
        	  addToSessionFolderMenu.setEnabled(enabled);
          }
       });
      
      return popupMenu;
   }
}
