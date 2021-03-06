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

package hermes.renderers;

import hermes.Domain;
import hermes.browser.ConfigDialogProxy;
import hermes.renderers.components.HeaderRendererTable;
import hermes.swing.SwingUtils;
import hermes.swing.listeners.mouse.MessageRendererMouseWheelListener;
import hermes.util.JMSUtils;

import java.util.Date;
import java.util.Enumeration;

import javax.jms.Message;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

/**
 * A renderer that displays the JMS and user header properties in a sortable
 * table.
 * 
 * @author colincrist@hermesjms.com
 * @version $Id: DefaultMessageHeaderRenderer.java,v 1.3 2006/07/13 07:35:31
 *          colincrist Exp $
 */

public class DefaultMessageHeaderRenderer extends AbstractMessageRenderer {
	private static final Logger log = Logger.getLogger(DefaultMessageHeaderRenderer.class);

	public DefaultMessageHeaderRenderer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public JComponent render(JScrollPane parent, Message m) {
		//final SortableTable table = new SortableTable();
		final DefaultTableModel tableModel = new DefaultTableModel() {

			/**
		 * 
		 */
			private static final long serialVersionUID = 5702541447000695825L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		tableModel.addColumn("Property");
		tableModel.addColumn("Value");

		//
		// Header properties...

		try {
			tableModel.addRow(new Object[] { "JMSMessageID", m.getJMSMessageID() });
		} catch (Exception ex) {
			log.error("no JMSMessageID in message: " + ex.getMessage());
		}

		try {
			tableModel.addRow(new Object[] { "JMSDestination", JMSUtils.getDestinationName(m.getJMSDestination()) });
		} catch (Exception ex) {
			log.error("no JMSDestination in message: " + ex.getMessage());
		}

		try {
			tableModel.addRow(new Object[] { "JMSTimestamp", new Date(m.getJMSTimestamp()) });
		} catch (Exception ex) {
			tableModel.addRow(new Object[] { "JMSTimestamp", new Date() });
			log.error("no JMSTimestamp in message: " + ex.getMessage());
		}

		try {
			tableModel.addRow(new Object[] { "JMSType", m.getJMSType() });
		} catch (Exception ex) {
			log.error("no JMSType in message: " + ex.getMessage());
		}

		try {
			tableModel.addRow(new Object[] { "JMSReplyTo", JMSUtils.getDestinationName(m.getJMSReplyTo()) + (m.getJMSReplyTo() != null ? " (" + Domain.getDomain(m.getJMSReplyTo()) + ")" : "") });
		} catch (Exception ex) {
			log.error("no JMSReplyTo in message: " + ex.getMessage());
		}

		try {
			tableModel.addRow(new Object[] { "JMSCorrelationID", m.getJMSCorrelationID() });
		} catch (Exception ex) {
			log.error("no JMSCorrelationID in message: " + ex.getMessage());
		}

		try {
			tableModel.addRow(new Object[] { "JMSExpiration", new Long(m.getJMSExpiration()) });
		} catch (Exception ex) {
			log.error("no JMSExpiration in message: " + ex.getMessage());
		}

		try {
			tableModel.addRow(new Object[] { "JMSPriority", new Long(m.getJMSPriority()) });
		} catch (Exception ex) {
			log.error("no JMSPriority in message: " + ex.getMessage());
		}

		try {
			if (m.getPropertyNames() != null) {
				for (final Enumeration<?> iter = m.getPropertyNames(); iter.hasMoreElements();) {
					try {
						final String propertyName = (String) iter.nextElement();
						final Object propertyValue = m.getObjectProperty(propertyName);

						final Object[] row = { propertyName, propertyValue };

						tableModel.addRow(row);
					} catch (RuntimeException ex) {
						ex.printStackTrace();
					}
				}
			}
		} catch (Throwable e) {
			final Object[] row = { "Error", e.getClass().getName() + ": " + e.getMessage() };
			tableModel.addRow(row);

			log.error(e.getMessage(), e);
		}

		HeaderRendererTable table = new HeaderRendererTable(tableModel);
		
		table.setModel(tableModel);
		
		table.addMouseWheelListener(new MessageRendererMouseWheelListener());
		return SwingUtils.createJScrollPane(table);
	}

	/**
	 * There are no configurable options on this renderer
	 */
	@Override
	public JComponent getConfigPanel(ConfigDialogProxy dialogProxy) throws Exception {
		return null;
	}

	/**
	 * Any JMS message is rederable.
	 */
	@Override
	public boolean canRender(Message message) {
		return true;
	}

	@Override
	public String getDisplayName() {
		return "Header";
	}
}
