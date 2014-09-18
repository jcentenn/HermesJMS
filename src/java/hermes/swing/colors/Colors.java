package hermes.swing.colors;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public enum Colors 
{
	IVORYBLACK (new Color(41, 36, 33)),
	TEAL (new Color(0, 128, 128)),
    BURNTUMBER (new Color(138, 51, 36)),
    BURNTSIENNA (new Color(138,	54,	15)),
    BLACK (Color.BLACK),
    GRAY (Color.GRAY),
    GREEN (Color.GREEN),
    BLUE (Color.BLUE),
    YELLOW (Color.YELLOW),
    RED (Color.RED),
    PLUM (new Color(255, 187, 255)),
    GOLDENROD (new Color(218, 165, 32)),
    CORNSILK (new Color(255, 248, 220)),
    CARROT (new Color(237, 145, 33)),
    SGI_BEET (new Color(142, 56, 142)),
    BANANA (new Color(227, 207, 87)),
    PALEGREEN (new Color(152, 251, 152)),
    LAVENDERBLUSH (new Color(255, 240, 245)),
    LIGHTSTEELBLUE (new Color(176, 196, 222)),	
    WHITE (Color.WHITE),
    CHOCOLATE (new Color(210, 105, 30)),
    BISQUE (new Color(255, 228, 196)), 
    CADMIUMYELLOW (new Color(255, 153, 18)),
    SGI_SLATEBLUE (new Color(113, 113, 198)),
    LIGHTSKYBLUE (new Color(135, 206, 250)),
    LINEN (new Color(250, 240, 230)),
    WHITESMOKE (new Color(Integer.decode("#F5F5F5"))),
    POWDERBLUE (new Color(Integer.decode("#B0E0E6"))),
    WHEAT (new Color(Integer.decode("#F5DEB3"))),
    LIGHTSEAGREEN (new Color(Integer.decode("#20B2AA"))),
    PEACHPUFF (new Color(Integer.decode("#FFDAB9"))),
    GOLD (new Color(255, 215, 0));
	
	
	private final Color color;
	 
	Colors(Color color)
	{
        this.color = color;
    }
	
	public Color getColor()
    {
        return color;
    }
	
	public static ArrayList<Colors> sort()
	{
		Colors[] colorArray = Colors.values();
		ArrayList<Colors> colorList = new ArrayList<Colors>();
		HashMap<Colors, Double> colorMap = new HashMap<Colors, Double>();
		
		for (int i=0; i < colorArray.length; i++)
		{
			Color color = colorArray[i].getColor();
			colorMap.put(colorArray[i], Double.valueOf(colorDistance(color, Color.WHITE)));
		}
		
		Map<Colors, Double> sortedColorMap = sortByComparator(colorMap);
		
		for (Colors colors: sortedColorMap.keySet())
		{
			colorList.add(colors);
		}
		
		return colorList; 
	}
	
	private static Map<Colors, Double> sortByComparator(Map<Colors, Double> unsortedMap)
	{
		// Convert Map to List
		List<Map.Entry<Colors, Double>> list = new LinkedList<Map.Entry<Colors, Double>>(unsortedMap.entrySet());
	
		// Sort list with comparator, to compare the Map values
		Collections.sort(list, new Comparator<Map.Entry<Colors, Double>>() {
			public int compare(Map.Entry<Colors, Double> o1, Map.Entry<Colors, Double> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});
 		
		// Convert sorted map back to a Map
		Map<Colors, Double> sortedMap = new LinkedHashMap<Colors, Double>();
		
		for (Iterator<Map.Entry<Colors, Double>> it = list.iterator(); it.hasNext();)
		{
			Map.Entry<Colors, Double> entry = it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		
		return sortedMap;
	}
	
	private static double colorDistance(Color color1, Color color2) 
	{
	    double rmean = (color1.getRed() + color2.getRed()) / 2;
	    
	    int red = color1.getRed() - color2.getRed();
	    int green = color1.getGreen() - color2.getGreen();
	    int blue = color1.getBlue() - color2.getBlue();
	    
	    double weightR = 2 + rmean / 256;
	    double weightG = 4.0;
	    double weightB = 2 + (255 - rmean) / 256;
	    
	    return Math.sqrt(weightR * red * red + weightG * green * green + weightB * blue * blue);
	}
	
	
}
