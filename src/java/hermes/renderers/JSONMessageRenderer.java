package hermes.renderers;

import hermes.renderers.kit.JsonEditorKit;
import hermes.swing.colors.Colors;
import hermes.swing.listeners.mouse.MessageRendererMouseAdapter;
import hermes.swing.listeners.mouse.MessageRendererMouseWheelListener;

import java.awt.Font;
import java.nio.charset.Charset;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class JSONMessageRenderer extends AbstractMessageRenderer {
	
	private static final String KEY = "key";
	private static final String KEY_INFO = "The list of available colors";
	
	private static final String INTEGER = "integerType";
	private static final String INTEGER_INFO = "JSON Integers";

	private static final String BACKGROUNDCOLOR = "backgroundColor";
	private static final String BACKGROUNDCOLOR_INFO = "The list of available colors";

	private static final String DOUBLE = "doubleType";
	private static final String DOUBLE_INFO = "JSON Doubles";

	private static final String VALUE = "value";
	private static final String VALUE_INFO = "JSON Values";

	private static final String TRUE = "trueType";
	private static final String TRUE_INFO = "JSON TRUE value";

	private static final String FALSE = "falseType";
	private static final String FALSE_INFO = "JSON FALSE value";

	private static final String COLON = "colon";
	private static final String COLON_INFO = "JSON color delimiter";

	private static final String CURLY_BRACE_OPEN = "curlyBraceOpen";
	private static final String CURLY_BRACE_OPEN_INFO = "JSON curlyBraceOpen";

	private static final String CURLY_BRACE_CLOSE = "curlyBraceClose";
	private static final String CURLY_BRACE_CLOSE_INFO = "JSON curlyBraceClose";

	private static final String COMMA = "comma";
	private static final String COMMA_INFO = "JSON comma delimiter";

	private static final String BRACE_OPEN = "braceOpen";
	private static final String BRACE_OPEN_INFO = "JSON braceOpen";

	private static final String BRACE_CLOSE = "braceClose";
	private static final String BRACE_CLOSE_INFO = "JSON braceClose";

	public class MyConfig extends AbstractMessageRenderer.BasicConfig {
		private String encoding = Charset.defaultCharset().name();
		
		private Colors key = Colors.LINEN;
		private Colors backgroundColor = Colors.BLACK;
    	private Colors integerType = Colors.LIGHTSKYBLUE;
    	private Colors doubleType = Colors.CADMIUMYELLOW;
        private Colors value = Colors.PALEGREEN;
        private Colors trueType = Colors.GOLD;
        private Colors falseType = Colors.GOLD;
        private Colors colon = Colors.SGI_BEET;
        private Colors curlyBraceOpen = Colors.CHOCOLATE;
        private Colors curlyBraceClose = Colors.CHOCOLATE;
        private Colors comma = Colors.CARROT;
        private Colors braceOpen = Colors.SGI_SLATEBLUE;
        private Colors braceClose = Colors.SGI_SLATEBLUE;
        
		public Colors getBraceClose() {
			return braceClose;
		}

		public void setBraceClose(Colors braceClose) {
			this.braceClose = braceClose;
		}

		public Colors getBraceOpen() {
			return braceOpen;
		}

		public void setBraceOpen(Colors braceOpen) {
			this.braceOpen = braceOpen;
		}

		public Colors getComma() {
			return comma;
		}

		public void setComma(Colors comma) {
			this.comma = comma;
		}

		public Colors getCurlyBraceClose() {
			return curlyBraceClose;
		}

		public void setCurlyBraceClose(Colors curlyBraceClose) {
			this.curlyBraceClose = curlyBraceClose;
		}

		public Colors getCurlyBraceOpen() {
			return curlyBraceOpen;
		}

		public void setCurlyBraceOpen(Colors curlyBraceOpen) {
			this.curlyBraceOpen = curlyBraceOpen;
		}

		public Colors getFalseType() {
			return falseType;
		}

		public void setFalseType(Colors falseType) {
			this.falseType = falseType;
		}

		public Colors getColon() {
			return colon;
		}

		public void setColon(Colors colon) {
			this.colon = colon;
		}

		public Colors getTrueType() {
			return trueType;
		}

		public void setTrueType(Colors trueType) {
			this.trueType = trueType;
		}

		public Colors getValue() {
			return value;
		}

		public void setValue(Colors value) {
			this.value = value;
		}

		public Colors getDoubleType() {
			return doubleType;
		}

		public void setDoubleType(Colors doubleType) {
			this.doubleType = doubleType;
		}

		public String getEncoding() {
			return encoding;
		}

		public void setEncoding(String encoding) {
			this.encoding = encoding;
		}

		public Colors getKey() {
			return key;
		}

		public void setKey(Colors key) {
			this.key = key;
		}

		public Colors getBackgroundColor() {
			return backgroundColor;
		}

		public void setBackgroundColor(Colors backgroundColor) {
			this.backgroundColor = backgroundColor;
		}

		public Colors getIntegerType() {
			return integerType;
		}

		public void setIntegerType(Colors integerType) {
			this.integerType = integerType;
		}
		
		@Override
		public String getPropertyDescription(String propertyName) 
		{
			if (propertyName.equals(CURLY_BRACE_OPEN))
			{
				return CURLY_BRACE_OPEN_INFO;
			}
			
			if (propertyName.equals(CURLY_BRACE_CLOSE))
			{
				return CURLY_BRACE_CLOSE_INFO;
			}
			
			if (propertyName.equals(COMMA))
			{
				return COMMA_INFO;
			}
			
			if (propertyName.equals(BRACE_OPEN))
			{
				return BRACE_OPEN_INFO;
			}
			
			if (propertyName.equals(BRACE_CLOSE))
			{
				return BRACE_CLOSE_INFO;
			}
			
			if (propertyName.equals(DOUBLE))
			{
				return DOUBLE_INFO;
			}
			
			if (propertyName.equals(VALUE))
			{
				return VALUE_INFO;
			}
			
			if (propertyName.equals(TRUE))
			{
				return TRUE_INFO;
			}
			
			if (propertyName.equals(FALSE))
			{
				return FALSE_INFO;
			}
			
			if (propertyName.equals(COLON))
			{
				return COLON_INFO;
			}
			
			if (propertyName.equals(INTEGER))
			{
				return INTEGER_INFO;
			}
			
			if (propertyName.equals(KEY))
			{
				return KEY_INFO;
			}
			
			if (propertyName.equals(BACKGROUNDCOLOR))
			{
				return BACKGROUNDCOLOR_INFO;
			}
			
			return propertyName;
		}
	}
	
	
	public JSONMessageRenderer() {
		super();
		setConfig(createConfig()); // force using instance of MyConfig
	}
	
	@Override
	public boolean canRender(Message message) {
		
		if (message instanceof TextMessage)
		{
			String text = null;
			
			try
			{
				text = ((TextMessage) message).getText();
				return text != null && text.trim().startsWith("{");
			}
			catch (JMSException e)
			{
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

	@Override
	public String getDisplayName() {
		return "JSON";
	}

	@Override
	public synchronized JComponent render(JScrollPane parent, Message m) {

		JEditorPane pane = new JEditorPane();
		//JTextPane pane = new JTextPane();
		
		JsonEditorKit kit = new JsonEditorKit(getConfig());
		
		pane.setEditorKit(kit);
		parent.setViewportView(pane);

		pane.setEditable(false);
		//pane.setContentType("text/plain");
		
		pane.setFont(Font.decode("Monospaced-PLAIN-14"));
		
		if (m instanceof TextMessage)
		{
			TextMessage textMessage = (TextMessage) m;
			
			try
			{
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				JsonParser jp = new JsonParser();
				JsonElement je = jp.parse(textMessage.getText());

//				JsonObject jo = je.getAsJsonObject();
//				
//				for (Entry<String, JsonElement> entry : jo.entrySet())
//				{
//				    System.err.println(entry.getKey() + ": " + entry.getValue());
//				}

				String prettyJsonString = gson.toJson(je);
				pane.setText(prettyJsonString);
			}
			catch (JMSException e)
			{
				e.printStackTrace();
			}
		}

		pane.setBackground(getConfig().getBackgroundColor().getColor());
		pane.setCaretPosition(0);
		pane.addMouseWheelListener(new MessageRendererMouseWheelListener());
		pane.addMouseListener(new MessageRendererMouseAdapter());
		
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
}
