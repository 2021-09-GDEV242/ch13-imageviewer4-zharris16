
/**
 * Write a description of class RedChannelFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RedChannelFilter extends Filter
{
    /**
     * Constructor for objects of class RedChannelFilter.
     * @param name The name of the filter.
     */
    public RedChannelFilter(String name)
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
                image.setRGB(x, y, (pixel & 0xffff0000));
            }
        }
    }
}
