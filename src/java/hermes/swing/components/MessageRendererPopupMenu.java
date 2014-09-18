package hermes.swing.components;

import hermes.Hermes;
import hermes.browser.BrowserTreeDockableFrame;
import hermes.browser.HermesBrowser;
import hermes.browser.IconCache;
import hermes.browser.components.BrowserTree;
import hermes.browser.components.MessagePayloadPanel;
import hermes.browser.model.BrowserTreeModel;
import hermes.browser.model.tree.DestinationConfigTreeNode;
import hermes.browser.model.tree.HermesTreeNode;
import hermes.browser.tasks.CopyOrMoveMessagesTask;
import hermes.swing.util.ComponentUtil;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.LinkedList;

import javax.jms.Message;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.tree.DefaultMutableTreeNode;

public class MessageRendererPopupMenu extends JPopupMenu 
{
	private static final long serialVersionUID = 6097743884257136149L;
	
	public MessageRendererPopupMenu(final String destination)
	{
		ActionListener menuListener = new ActionListener() {
			private String destinationName = destination;
				
			@Override
			public void actionPerformed(ActionEvent e)
			{
 				Component component = getInvoker();
				HermesBrowser hermesBrowser = (HermesBrowser) ComponentUtil.getParentComponentForType(component, HermesBrowser.class);
				MessagePayloadPanel messagePayloadPanel = (MessagePayloadPanel) ComponentUtil.getParentComponentForType(component, MessagePayloadPanel.class);
				BrowserTreeDockableFrame browserTreeDockableFrame = hermesBrowser.getBrowserTreePane();
				BrowserTree browserTree = browserTreeDockableFrame.getBrowserTree();
				BrowserTreeModel browserTreeModel = (BrowserTreeModel) browserTree.getModel();
				DefaultMutableTreeNode defaultMutableTreeNode = browserTreeModel.getJmsRootNode();
				
				String[] jmsInfo = destinationName.split(": ");
				String jmsServerName = jmsInfo[0];
				String jmsDestinationName = jmsInfo[1];
				
				for (Enumeration<?> jmsNodes = defaultMutableTreeNode.children(); jmsNodes.hasMoreElements();)
				{
					Object nextElement = jmsNodes.nextElement();
					
					if (isHermesTreeNode(nextElement))
					{
						HermesTreeNode hermesTreeNode = (HermesTreeNode) nextElement;
						
						if (hermesTreeNode.getId().matches(jmsServerName))
						{
							for (Enumeration<?> jmsDestinations = hermesTreeNode.children(); jmsDestinations.hasMoreElements();)
							{
								DestinationConfigTreeNode destinationConfigTreeNode = (DestinationConfigTreeNode) jmsDestinations.nextElement();
								
								if (destinationConfigTreeNode.getId().matches(jmsDestinationName))
								{
									Hermes hermes = (Hermes) hermesTreeNode.getBean();
									
									CopyOrMoveMessagesTask task = hermesBrowser.getActionFactory().createMessageCopyAction(hermes, jmsDestinationName, destinationConfigTreeNode.getDomain(), new LinkedList<Message>(Arrays.asList(messagePayloadPanel.getMessage())), false, true);
									task.start();
								}
							}
						}
					}
				}
			}
		};

		JMenuItem jMenuItem = new JMenuItem("Resend message to " + destination, IconCache.getIcon("hermes.message.resend"));
		jMenuItem.addActionListener(menuListener);
		
		add(jMenuItem);
	}
	
	public Boolean isHermesTreeNode(Object node)
	{
		return node.getClass().isAssignableFrom(HermesTreeNode.class);
	}
}
