/* 
 * Copyright 2003,2004 Colin Crist
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

package hermes.renderers.fix;

import hermes.fix.FIXMessage;
import hermes.fix.FIXUtils;
import hermes.fix.quickfix.QuickFIXMessage;
import hermes.fix.quickfix.QuickFIXMessageCache;
import hermes.renderers.AbstractMessageRenderer;
import hermes.swing.colors.Colors;
import hermes.swing.listeners.mouse.MessageRendererMouseAdapter;
import hermes.swing.listeners.mouse.MessageRendererMouseWheelListener;
import hermes.util.MessageUtils;

import java.io.IOException;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.StreamMessage;
import javax.jms.TextMessage;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.apache.commons.collections.map.LRUMap;
import org.apache.log4j.Logger;

/**
 * Renderer for FIX messages carried in BytesMessage or TextMessage.
 * 
 * @author colincrist@hermesjms.com last changed by: $Author: colincrist $
 * @version $Id: FIXMessageRenderer.java,v 1.6 2006/04/28 09:59:37 colincrist
 *          Exp $
 */
public class FIXMessageRenderer extends AbstractMessageRenderer {
	private static final Logger log = Logger.getLogger(FIXMessageRenderer.class);
	private static final String MESSAGE_CACHE = "messageCache";
	private static final String MESSAGE_CACHE_INFO = "The number of panels to cache - can speed up the user interface when switching between messages";
	private static final String VALUE_WITH_ENUM = "displayValueWithEnum";
	private static final String VALUE_WITH_ENUM_INDO = "If true displays any enumeration values along with the descriptive text";
	private static final String SHOW_HEADER_AND_TRAINER = "displayHeaderAndTrailer";
	private static final String SHOW_HEADER_AND_TRAINER_INFO = "Display header and trailer fields";
	
	private static final String APPLICATION_COLOR = "applicationColor";
	private static final String APPLICATION_COLOR_INFO = "Color for the message body";

	private static final String GROUP_COLOR = "groupColor";
	private static final String GROUP_COLOR_INFO = "Color for the group body";

	private static final String HEADER_COLOR = "headerColor";
	private static final String HEADER_COLOR_INFO = "Color for the header";

	private static final String TRAILER_COLOR = "trailerColor";
	private static final String TRAILER_COLOR_INFO = "Color for the trailer";

	private static final String TEXT_COLOR = "textColor";
	private static final String TEXT_COLOR_INFO = "Color for the text";
	
	private final QuickFIXMessageCache cache = new QuickFIXMessageCache(32);
	private LRUMap panelCache;

	public class MyConfig extends AbstractMessageRenderer.BasicConfig {
		private int messageCache = 100;
		private boolean displayValueWithEnum = true;
		private boolean displayHeaderAndTrailer = true;
		private String name;
		private Colors applicationColor = Colors.BISQUE;
		private Colors groupColor = Colors.WHEAT;
		private Colors headerColor = Colors.LINEN;
		private Colors trailerColor = Colors.LINEN;
		private Colors textColor = Colors.BURNTUMBER;

		public Colors getTrailerColor()
		{
			return trailerColor;
		}

		public void setTrailerColor(Colors trailerColor) 
		{
			this.trailerColor = trailerColor;
		}

		public Colors getHeaderColor() 
		{
			return headerColor;
		}

		public void setHeaderColor(Colors headerColor) 
		{
			this.headerColor = headerColor;
		}

		public Colors getGroupColor() 
		{
			return groupColor;
		}

		public void setGroupColor(Colors groupColor) 
		{
			this.groupColor = groupColor;
		}

		public Colors getApplicationColor() 
		{
			return applicationColor;
		}

		public void setApplicationColor(Colors applicationColor) 
		{
			this.applicationColor = applicationColor;
		}
		
		public Colors getTextColor() 
		{
			return textColor;
		}

		public void setTextColor(Colors textColor) 
		{
			this.textColor = textColor;
		}

		@Override
		public String getName() {
			return name;
		}

		@Override
		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String getPropertyDescription(String propertyName) {
			if (propertyName.equals(MESSAGE_CACHE)) {
				return MESSAGE_CACHE_INFO;
			}

			if (propertyName.equals(VALUE_WITH_ENUM)) {
				return VALUE_WITH_ENUM_INDO;
			}

			if (propertyName.equals(SHOW_HEADER_AND_TRAINER)) {
				return SHOW_HEADER_AND_TRAINER_INFO;
			}

			if (propertyName.equals(APPLICATION_COLOR)) {
				return APPLICATION_COLOR_INFO;
			}
			
			if (propertyName.equals(GROUP_COLOR)) {
				return GROUP_COLOR_INFO;
			}
			
			if (propertyName.equals(HEADER_COLOR)) {
				return HEADER_COLOR_INFO;
			}
			
			if (propertyName.equals(TRAILER_COLOR)) {
				return TRAILER_COLOR_INFO;
			}

			if (propertyName.equals(TEXT_COLOR)) {
				return TEXT_COLOR_INFO;
			}

			return propertyName;
		}

		public int getMessageCache() {
			return messageCache;
		}

		public void setMessageCache(int messageCache) {
			this.messageCache = messageCache;
		}

		public boolean getDisplayValueWithEnum() {
			return displayValueWithEnum;
		}

		public void setDisplayValueWithEnum(boolean displayValueWithEnum) {
			this.displayValueWithEnum = displayValueWithEnum;
		}

		public boolean getDisplayHeaderAndTrailer() {
			return displayHeaderAndTrailer;
		}

		public void setDisplayHeaderAndTrailer(boolean displayHeaderAndTrailer) {
			this.displayHeaderAndTrailer = displayHeaderAndTrailer;
		}
	}

	protected JComponent handleObjectMessage(final ObjectMessage objectMessage) throws JMSException {
		return null;
	}

	protected JComponent handleMapMessage(MapMessage mapMessage) throws JMSException {
		return null;
	}

	protected JComponent handleBytesMessage(BytesMessage bytesMessage) throws JMSException, IOException, ClassNotFoundException {
		try {
			bytesMessage.reset();

			final byte[] bytes = MessageUtils.asBytes(bytesMessage);

			return createComponent(new QuickFIXMessage(cache, bytes));
		} finally {
			bytesMessage.reset();
		}
	}

	protected JComponent handleStreamMessage(StreamMessage streamMessage) throws JMSException {
		return null;
	}

	protected JComponent handleTextMessage(final TextMessage textMessage) throws JMSException {
		String text = textMessage.getText();

		return createComponent(new QuickFIXMessage(cache, text.getBytes()));
	}

	protected JComponent createComponent(FIXMessage message) {
		try {
			final MyConfig currentConfig = (MyConfig) getConfig();
			//return FIXUtils.createView(message, currentConfig.getDisplayHeaderAndTrailer(), currentConfig.getDisplayValueWithEnum());
			return FIXUtils.createView(message, currentConfig);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		log.debug("message is not a valid FIX message, ignoring");

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hermes.browser.MessageRenderer#render(javax.jms.Message)
	 */
	@Override
	public JComponent render(JScrollPane parent, Message m) {
		try {
			JComponent rval = null;

			if (getPanelMap().containsKey(m)) {
				rval = (JComponent) getPanelMap().get(m);
			} else {
				if (m instanceof TextMessage) {
					rval = handleTextMessage((TextMessage) m);
				} else if (m instanceof javax.jms.ObjectMessage) {
					rval = handleObjectMessage((ObjectMessage) m);
				} else if (m instanceof javax.jms.MapMessage) {
					rval = handleMapMessage((MapMessage) m);
				} else if (m instanceof BytesMessage) {
					rval = handleBytesMessage((BytesMessage) m);
				} else if (m instanceof StreamMessage) {
					rval = handleStreamMessage((StreamMessage) m);
				}

				if (rval != null) {
					getPanelMap().put(m, rval);
				}
			}

			rval.addMouseWheelListener(new MessageRendererMouseWheelListener());
			rval.addMouseListener(new MessageRendererMouseAdapter());
			
			return rval;

		} catch (Throwable ex) {
			final JTextArea textArea = new JTextArea();

			textArea.setEditable(false);
			textArea.setText("Unable to display message: " + ex.getMessage());

			log.error(ex.getMessage(), ex);
			return textArea;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hermes.browser.MessageRenderer#createConfig()
	 */
	@Override
	public Config createConfig() {
		return new MyConfig();
	}

	public synchronized LRUMap getPanelMap() {
		if (panelCache == null) {
			final MyConfig currentConfig = (MyConfig) getConfig();
			panelCache = new LRUMap(currentConfig.getMessageCache());
		}

		return panelCache;
	}

	@Override
	public boolean canRender(Message message) {
		try {
			return FIXUtils.isFIX(message);
		} catch (JMSException ex) {
			log.error("during FIXMessage.isValid(): " + ex.getMessage(), ex);
			return false;
		}
	}

	@Override
	public String getDisplayName() {
		return "FIX";
	}
}