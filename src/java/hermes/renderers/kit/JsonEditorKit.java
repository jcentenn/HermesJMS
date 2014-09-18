package hermes.renderers.kit;

import hermes.renderers.JSONMessageRenderer;

import javax.swing.text.StyledEditorKit;
import javax.swing.text.ViewFactory;

public class JsonEditorKit extends StyledEditorKit
{
	private static final long serialVersionUID = 1569232907546426457L;
	private final JSONViewFactory jsonViewFactory;

    public JsonEditorKit(JSONMessageRenderer.MyConfig myConfig)
    {
    	jsonViewFactory = new JSONViewFactory();
    	
    	jsonViewFactory.setBraceCloseColor(myConfig.getBraceClose().getColor()); 
    	jsonViewFactory.setBraceOpenColor(myConfig.getBraceOpen().getColor()); 
    	jsonViewFactory.setColonColor(myConfig.getColon().getColor()); 
    	jsonViewFactory.setCommaColor(myConfig.getComma().getColor()); 
    	jsonViewFactory.setCurlyBraceCloseColor(myConfig.getCurlyBraceClose().getColor()); 
    	jsonViewFactory.setCurlyBraceOpenColor(myConfig.getCurlyBraceOpen().getColor()); 
    	jsonViewFactory.setDoubleColor(myConfig.getDoubleType().getColor()); 
    	jsonViewFactory.setFalseColor(myConfig.getFalseType().getColor()); 
    	jsonViewFactory.setIntegerTypeColor(myConfig.getIntegerType().getColor());
    	jsonViewFactory.setKeyColor(myConfig.getKey().getColor());
    	jsonViewFactory.setTrueColor(myConfig.getTrueType().getColor());
    	jsonViewFactory.setValueColor(myConfig.getValue().getColor());
    }

    @Override
    public ViewFactory getViewFactory() 
    {
        return jsonViewFactory;
    }

    @Override
    public String getContentType() 
    {
        return "application/json";
    }
}