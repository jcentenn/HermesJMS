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

import hermes.swing.colors.Colors;
import hermes.swing.listeners.mouse.MessageRendererMouseAdapter;
import hermes.swing.listeners.mouse.MessageRendererMouseWheelListener;
import hermes.util.MessageUtils;
import hermes.util.XmlUtils;

import java.awt.Font;
import java.nio.charset.Charset;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;

import org.apache.log4j.Logger;
import org.bounce.text.xml.XMLEditorKit;
import org.bounce.text.xml.XMLStyleConstants;

/**
 * A renderer that displays toString() on a JMS message in a text area.
 * 
 * @author colincrist@hermesjms.com
 * @version $Id: XMLMessageRenderer.java,v 1.3 2007/02/18 16:13:41 colincrist
 *          Exp $
 */

public class XMLMessageRenderer extends AbstractMessageRenderer {
	private static final Logger log = Logger.getLogger(XMLMessageRenderer.class);
	
	private static final String ELEMENT_NAME = "elementName";
	private static final String ELEMENT_NAME_INFO = "The list of available colors";

	private static final String ELEMENT_VALUE = "elementValue";
	private static final String ELEMENT_VALUE_INFO = "The list of available colors";

	private static final String BACKGROUNDCOLOR = "backgroundColor";
	private static final String BACKGROUNDCOLOR_INFO = "The list of available colors";

	private static final String XML_DECLARATION = "xmlDeclaration";
	private static final String XML_DECLARATION_INFO = "The list of available colors";
	
	private static final String CDATA = "cdata";
	private static final String CDATA_INFO = "The list of available colors";
	
	private static final String ATTRIBUTE_NAME = "attributeName";
	private static final String ATTRIBUTE_NAME_INFO = "The list of available colors";

	private static final String ATTRIBUTE_VALUE = "attributeValue";
	private static final String ATTRIBUTE_VALUE_INFO = "The list of available colors";

	private static final String SPECIAL = "special";
	private static final String SPECIAL_INFO = "The list of available colors";

	private static final String COMMENT = "comment";
	private static final String COMMENT_INFO = "The list of available colors";

	private static final String NAMESPACE_NAME = "namespaceName";
	private static final String NAMESPACE_NAME_INFO = "The list of available colors";
	
	private static final String NAMESPACE_PREFIX = "namespacePrefix";
	private static final String NAMESPACE_PREFIX_INFO = "The list of available colors";
	
	private static final String NAMESPACE_VALUE = "namespaceValue";
	private static final String NAMESPACE_VALUE_INFO = "The list of available colors";

	private static final String ENTITY = "entity";
	private static final String ENTITY_INFO = "The list of available colors";

	public class MyConfig extends AbstractMessageRenderer.BasicConfig {
		private String encoding = Charset.defaultCharset().name();
		private Colors backgroundColor = Colors.IVORYBLACK;
		private Colors special = Colors.GOLDENROD;
		private Colors xmlDeclaration = Colors.PALEGREEN;
		private Colors attributeName = Colors.CARROT;
		private Colors attributeValue = Colors.BISQUE;
		private Colors cdata = Colors.LAVENDERBLUSH;
		private Colors comment = Colors.LIGHTSTEELBLUE;
		private Colors namespaceName = Colors.CADMIUMYELLOW;
		private Colors namespacePrefix = Colors.GOLD;
		private Colors namespaceValue = Colors.BANANA;
		private Colors elementValue = Colors.WHITE;
		private Colors elementName = Colors.CHOCOLATE;
		private Colors entity = Colors.LIGHTSTEELBLUE;
		
		public Colors getEntity() 
		{
			return entity;
		}

		public void setEntity(Colors entity) 
		{
			this.entity = entity;
		}

		public Colors getElementName()
		{
			return elementName;
		}

		public void setElementName(Colors elementName) 
		{
			this.elementName = elementName;
		}

		public Colors getElementValue() {
			return elementValue;
		}

		public void setElementValue(Colors elementValue) {
			this.elementValue = elementValue;
		}

		public Colors getNamespaceValue()
		{
			return namespaceValue;
		}

		public void setNamespaceValue(Colors namespaceValue)
		{
			this.namespaceValue = namespaceValue;
		}

		public Colors getNamespacePrefix() 
		{
			return namespacePrefix;
		}

		public void setNamespacePrefix(Colors namespacePrefix) 
		{
			this.namespacePrefix = namespacePrefix;
		}

		public Colors getNamespaceName() 
		{
			return namespaceName;
		}

		public void setNamespaceName(Colors namespaceName) 
		{
			this.namespaceName = namespaceName;
		}

		public Colors getComment()
		{
			return comment;
		}

		public void setComment(Colors comment) 
		{
			this.comment = comment;
		}

		public Colors getCdata()
		{
			return cdata;
		}

		public void setCdata(Colors cdata)
		{
			this.cdata = cdata;
		}

		public Colors getSpecial() 
		{
			return special;
		}

		public void setSpecial(Colors special) 
		{
			this.special = special;
		}

		public Colors getAttributeValue()
		{
			return attributeValue;
		}

		public void setAttributeValue(Colors attributeValue)
		{
			this.attributeValue = attributeValue;
		}
		
		public Colors getAttributeName()
		{
			return attributeName;
		}

		public void setAttributeName(Colors attributeName)
		{
			this.attributeName = attributeName;
		}
		
		public Colors getXmlDeclaration() 
		{
			return xmlDeclaration;
		}

		public void setXmlDeclaration(Colors xmlDeclaration) 
		{
			this.xmlDeclaration = xmlDeclaration;
		}

		public String getEncoding() 
		{
			return encoding;
		}

		public void setEncoding(String encoding) 
		{
			this.encoding = encoding;
		}

		public Colors getBackgroundColor()
		{
			return backgroundColor;
		}

		public void setBackgroundColor(Colors backgroundColor) 
		{
			this.backgroundColor = backgroundColor;
		}
		
		@Override
		public String getPropertyDescription(String propertyName) 
		{
			if (propertyName.equals(ELEMENT_NAME))
			{
				return ELEMENT_NAME_INFO;
			}
			
			if (propertyName.equals(ELEMENT_VALUE))
			{
				return ELEMENT_VALUE_INFO;
			}
			
			if (propertyName.equals(NAMESPACE_NAME))
			{
				return NAMESPACE_NAME_INFO;
			}

			if (propertyName.equals(NAMESPACE_PREFIX))
			{
				return NAMESPACE_PREFIX_INFO;
			}

			if (propertyName.equals(NAMESPACE_VALUE))
			{
				return NAMESPACE_VALUE_INFO;
			}
			
			if (propertyName.equals(BACKGROUNDCOLOR))
			{
				return BACKGROUNDCOLOR_INFO;
			}

			if (propertyName.equals(SPECIAL))
			{
				return SPECIAL_INFO;
			}
			
			if (propertyName.equals(XML_DECLARATION))
			{
				return XML_DECLARATION_INFO;
			}

			if (propertyName.equals(ATTRIBUTE_NAME))
			{
				return ATTRIBUTE_NAME_INFO;
			}

			if (propertyName.equals(ATTRIBUTE_VALUE))
			{
				return ATTRIBUTE_VALUE_INFO;
			}
			
			if (propertyName.equals(CDATA))
			{
				return CDATA_INFO;
			}		
			
			if (propertyName.equals(COMMENT))
			{
				return COMMENT_INFO;
			}		

			if (propertyName.equals(ENTITY))
			{
				return ENTITY_INFO;
			}	
			
			return propertyName;
		}
	}

	public XMLMessageRenderer() {
		super();
		setConfig(createConfig()); // force using instance of MyConfig
		
	}

	@Override
	public JComponent render(JScrollPane parent, Message m) {
		//
		// Raw Panel.
		JEditorPane pane = new JEditorPane();
        
		XMLEditorKit kit = new XMLEditorKit();

		// Enable auto indentation.
        kit.setAutoIndentation(true);
        
        // Set a style
        kit.setStyle(XMLStyleConstants.ATTRIBUTE_NAME, getConfig().getAttributeName().getColor(), Font.PLAIN);
        kit.setStyle(XMLStyleConstants.ATTRIBUTE_VALUE, getConfig().getAttributeValue().getColor(), Font.PLAIN);
        
        kit.setStyle(XMLStyleConstants.DECLARATION, getConfig().getXmlDeclaration().getColor(), Font.PLAIN);

        kit.setStyle(XMLStyleConstants.ELEMENT_NAME, getConfig().getElementName().getColor(), Font.PLAIN);
        kit.setStyle(XMLStyleConstants.ELEMENT_VALUE, getConfig().getElementValue().getColor(), Font.PLAIN);

        kit.setStyle(XMLStyleConstants.NAMESPACE_NAME,  getConfig().getNamespaceName().getColor(), Font.PLAIN);
        kit.setStyle(XMLStyleConstants.NAMESPACE_PREFIX, getConfig().getNamespacePrefix().getColor(), Font.PLAIN);
        kit.setStyle(XMLStyleConstants.NAMESPACE_VALUE, getConfig().getNamespaceValue().getColor(), Font.PLAIN);
        
        //	'<', '>', '='
        kit.setStyle(XMLStyleConstants.SPECIAL, getConfig().getSpecial().getColor(), Font.PLAIN);
        
        kit.setStyle(XMLStyleConstants.CDATA, getConfig().getCdata().getColor(), Font.PLAIN);
        kit.setStyle(XMLStyleConstants.COMMENT, getConfig().getComment().getColor(), Font.PLAIN);

        kit.setStyle(XMLStyleConstants.ENTITY, getConfig().getEntity().getColor(), Font.PLAIN);
        
        pane.setEditorKit(kit);
        
		parent.setViewportView(pane);
		pane.setEditable(false);
        
		try {
			String string;
			if (m instanceof BytesMessage) {
				string = new String(MessageUtils.asBytes(m), getConfig().getEncoding());
			} else {
				string = new String(MessageUtils.asString(m).getBytes(Charset.defaultCharset()), getConfig().getEncoding());
			}
			pane.setBackground(getConfig().getBackgroundColor().getColor());
			
			pane.setCaretPosition(0);
			pane.setFont(Font.decode("Monospaced-PLAIN-12"));
			
			pane.setText(XmlUtils.prettyPrintXml(string));

			pane.addMouseWheelListener(new MessageRendererMouseWheelListener());
			pane.addMouseListener(new MessageRendererMouseAdapter());
			
		} 
		catch (Throwable e) 
		{
			pane.setText(e.getMessage());
			log.error("exception converting message to byte[]: ", e);
		}

		pane.setCaretPosition(0);
		
		return pane;
	}

	@Override
	public MyConfig createConfig() {
		return new MyConfig();
	}

	@Override
	public MyConfig getConfig() {
		return (MyConfig) super.getConfig();
	}

	/**
	 * Any JMS message is rederable.
	 */
	@Override
	public boolean canRender(Message message) {
		try {
			if (message instanceof TextMessage) {
				final String text = ((TextMessage) message).getText();

				return XmlUtils.isXML(text);
			}

			if (message instanceof BytesMessage) {
				BytesMessage bytesMsg = (BytesMessage) message;
				bytesMsg.reset();

				final byte[] decl = new byte["<?xml".length()];
				bytesMsg.readBytes(decl);

				return XmlUtils.isXML(new String(decl));
			}
		} catch (JMSException e) {
			log.error("error getting text: " + e.getMessage(), e);
		}

		return false;
	}

	@Override
	public String getDisplayName() {
		return "XML";
	}
}

