import java.awt.Image;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * Write a description of class WarholFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WarholFilter extends Filter
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class WarholFilter
     */
    public WarholFilter(String name)
    {
        // initialise instance variables
        super(name);
    }

    /**
     * Apply this filter to an image.
     * 
     * @param  image  The image to be changed by this filter.
     */
    public void apply(OFImage image)
    {
        RedTintFilter redTintFilter = new RedTintFilter("Red Tint");
        BlueTintFilter blueTintFilter = new BlueTintFilter("Blue Tint");
        GreenTintFilter greenTintFilter = new GreenTintFilter("Green Tint");
        
        int height = image.getHeight();
        int width = image.getWidth();
        
        Image scaledImage1 = image.getScaledInstance(width/2, height/2, image.SCALE_DEFAULT);
        Image scaledImage2 = scaledImage1.getScaledInstance(width/2, -1, image.SCALE_DEFAULT);
        Image scaledImage3 = scaledImage1.getScaledInstance(width/2, -1, image.SCALE_DEFAULT);
        Image scaledImage4 = scaledImage1.getScaledInstance(width/2, -1, image.SCALE_DEFAULT); 
        
        Graphics2D graphic = image.createGraphics();
        
        graphic.drawImage(scaledImage1, 0, 0, null);
        BufferedImage temp = image.getSubimage(0,0, width/2, height/2);
        OFImage tempOF = new OFImage(temp);
        redTintFilter.apply(image);
        
        graphic.drawImage(scaledImage2, width/2, 0, null);
        graphic.drawImage(scaledImage3, 0, height/2, null);
        graphic.drawImage(scaledImage4, width/2, height/2, null);
    }
}
