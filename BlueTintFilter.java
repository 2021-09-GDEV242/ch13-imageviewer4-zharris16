import java.awt.Color;

/**
 * Write a description of class BlueTintFIlter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BlueTintFilter extends Filter
{
    /**
     * Constructor for objects of class BlueChannelFilter.
     * @param name The name of the filter.
     */
    public BlueTintFilter(String name)
    {
        super(name);
    }

    /**
     * Apply this filter to an image.
     * 
     * @param  image  The image to be changed by this filter.
     */
    public void apply(OFImage image)
    {
        int height = image.getHeight();
        int width = image.getWidth();
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color pixelColor = image.getPixel(x, y);
        
                int red = pixelColor.getRed();
                int green = pixelColor.getGreen();
                int blue = pixelColor.getBlue();
                if(blue < 155){
                    blue += 100;
                    image.setPixel(x, y, new Color(red, green, blue));
                }
                
            }
        }
    }
}
