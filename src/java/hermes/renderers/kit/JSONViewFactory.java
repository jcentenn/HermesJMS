package hermes.renderers.kit;

import java.awt.Color;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

import javax.swing.text.Element;
import javax.swing.text.View;
import javax.swing.text.ViewFactory;

public class JSONViewFactory implements ViewFactory
{
    private String KEY_PATTERN = "\\s+(\"[^\"]*\"): ";
    private String VALUE_PATTERN = ": (\"[^\"]*[\\\\]*\"*.*\")";
    private String TRUE_PATTERN = ": (true)";
    private String FALSE_PATTERN = ": (false)";
    private String INTEGER_PATTERN = ": (\\d+)(?![\\.\\d*])";
    private String DOUBLE_PATTERN = ": (\\d+\\.{1}\\d*)";
    private String COLON_PATTERN = "\"(:) {1}";
    private String CURLY_BRACE_OPEN_PATTERN = "(\\{){1}";
    private String CURLY_BRACE_CLOSE_PATTERN = "(\\}){1}";
    private String COMMA_PATTERN = "(,$)";
    private String BRACE_OPEN_PATTERN = "(\\[)";
    private String BRACE_CLOSE_PATTERN = "(\\])";
    
    private Pattern KEY = Pattern.compile(KEY_PATTERN);
    private Pattern VALUE = Pattern.compile(VALUE_PATTERN);
    private Pattern TRUE = Pattern.compile(TRUE_PATTERN);
    private Pattern FALSE = Pattern.compile(FALSE_PATTERN);
    private Pattern INTEGER = Pattern.compile(INTEGER_PATTERN);
    private Pattern DOUBLE = Pattern.compile(DOUBLE_PATTERN);
    private Pattern COLON = Pattern.compile(COLON_PATTERN);
    private Pattern CURLY_BRACE_OPEN = Pattern.compile(CURLY_BRACE_OPEN_PATTERN);
    private Pattern CURLY_BRACE_CLOSE = Pattern.compile(CURLY_BRACE_CLOSE_PATTERN);
    private Pattern COMMA = Pattern.compile(COMMA_PATTERN);
    private Pattern BRACE_OPEN = Pattern.compile(BRACE_OPEN_PATTERN);
    private Pattern BRACE_CLOSE = Pattern.compile(BRACE_CLOSE_PATTERN);
    
    private Color keyColor;
    private Color doubleColor;
    private Color integerTypeColor;
    private Color valueColor;
    private Color trueColor;
    private Color falseColor;
    private Color colonColor;
    private Color curlyBraceOpenColor;
    private Color curlyBraceCloseColor;
    private Color commaColor;
    private Color braceOpenColor;
    private Color braceCloseColor;

    
    private ConcurrentHashMap<Pattern, Color> patternToColor = new ConcurrentHashMap<Pattern, Color>();
    
    @Override
    public View create(Element element)
    {
    	patternToColor.put(INTEGER, getIntegerTypeColor());
    	patternToColor.put(DOUBLE, getDoubleColor());
        patternToColor.put(KEY, getKeyColor());
        patternToColor.put(VALUE, getValueColor());
        patternToColor.put(TRUE, getTrueColor());
        patternToColor.put(FALSE, getFalseColor());
        patternToColor.put(COLON, getColonColor());
        patternToColor.put(CURLY_BRACE_OPEN, getCurlyBraceOpenColor());
        patternToColor.put(CURLY_BRACE_CLOSE, getCurlyBraceCloseColor());
        patternToColor.put(COMMA, getCommaColor());
        patternToColor.put(BRACE_OPEN, getBraceOpenColor());
        patternToColor.put(BRACE_CLOSE, getBraceCloseColor());
       
        return new HighlightView(element, patternToColor);
    }

	public Color getKeyColor() {
		return keyColor;
	}

	public void setKeyColor(Color keyColor) {
		this.keyColor = keyColor;
	}

	public Color getDoubleColor() {
		return doubleColor;
	}

	public void setDoubleColor(Color doubleColor) {
		this.doubleColor = doubleColor;
	}

	public Color getValueColor() {
		return valueColor;
	}

	public void setValueColor(Color valueColor) {
		this.valueColor = valueColor;
	}

	public Color getTrueColor() {
		return trueColor;
	}

	public void setTrueColor(Color trueColor) {
		this.trueColor = trueColor;
	}

	public Color getFalseColor() {
		return falseColor;
	}

	public void setFalseColor(Color falseColor) {
		this.falseColor = falseColor;
	}

	public Color getColonColor() {
		return colonColor;
	}

	public void setColonColor(Color colonColor) {
		this.colonColor = colonColor;
	}

	public Color getCurlyBraceOpenColor() {
		return curlyBraceOpenColor;
	}

	public void setCurlyBraceOpenColor(Color curlyBraceOpenColor) {
		this.curlyBraceOpenColor = curlyBraceOpenColor;
	}

	public Color getCurlyBraceCloseColor() {
		return curlyBraceCloseColor;
	}

	public void setCurlyBraceCloseColor(Color curlyBraceCloseColor) {
		this.curlyBraceCloseColor = curlyBraceCloseColor;
	}

	public Color getCommaColor() {
		return commaColor;
	}

	public void setCommaColor(Color commaColor) {
		this.commaColor = commaColor;
	}

	public Color getBraceOpenColor() {
		return braceOpenColor;
	}

	public void setBraceOpenColor(Color braceOpenColor) {
		this.braceOpenColor = braceOpenColor;
	}

	public Color getBraceCloseColor() {
		return braceCloseColor;
	}

	public void setBraceCloseColor(Color braceCloseColor) {
		this.braceCloseColor = braceCloseColor;
	}

	public Color getIntegerTypeColor() {
		return integerTypeColor;
	}

	public void setIntegerTypeColor(Color integerTypeColor) {
		this.integerTypeColor = integerTypeColor;
	}

}
