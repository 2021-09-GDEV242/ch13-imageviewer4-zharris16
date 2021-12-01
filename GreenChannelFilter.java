
/**
 * Write a description of class GreenChannelFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GreenChannelFilter extends Filter
{
    /**
     * Constructor for objects of class GreenChannelFilter.
     * @param name The name of the filter.
     */
    public GreenChannelFilter(String name)
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
                int pixel = image.getPixel(x, y).getRGB();
                image.setRGB(x, y, (pixel & 0xff00ff00));
            }
        }
    }
}
