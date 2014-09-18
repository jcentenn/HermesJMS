package hermes.swing.colors;

import java.awt.Color;

public class ColorUtils 
{
	public static Color getContrastingColor(Color colorIn)
	{
		int red = colorIn.getRed();
		int green = colorIn.getGreen();
		int blue = colorIn.getBlue();

		int yiq = ((red * 299) + (green * 587) + (blue *114)) / 1000;
		
		return (yiq >= 128) ? Color.BLACK : Color.WHITE;
	}

	public static Color lighten(Color color, double fraction)
	{
		double fractionComplement = 1 - fraction;
		double fractionScale = 255 * fraction;
		
	    int red = (int) Math.round(Math.max(color.getRed() * fractionComplement + fractionScale, 0));
	    int green = (int) Math.round(Math.max(color.getGreen() * fractionComplement + fractionScale, 0));
	    int blue = (int) Math.round(Math.max(color.getBlue() * fractionComplement + fractionScale, 0));
	    
	    int alpha = color.getAlpha();
	
	    return new Color(red, green, blue, alpha);
	}
	
    public static Color darken(Color color, double fraction)
    {
        int red = (int) Math.round(Math.max(0, color.getRed() - 255 * fraction));
        int green = (int) Math.round(Math.max(0, color.getGreen() - 255 * fraction));
        int blue = (int) Math.round(Math.max(0, color.getBlue() - 255 * fraction));

        int alpha = color.getAlpha();

        return new Color(red, green, blue, alpha);
    }	
}
