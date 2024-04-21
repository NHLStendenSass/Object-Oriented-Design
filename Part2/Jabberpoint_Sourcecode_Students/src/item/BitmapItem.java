package item;

import style.Style;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;


/**
 * <p>The class for a Bitmap item</p>
 * <p>Bitmap items are responsible for drawing themselves.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
public class BitmapItem extends SlideItem
{
    private static final String FILE_NOT_FOUND_MESSAGE = "File not found: ";
    private final String imageName;
    private BufferedImage image;

    /**
     * Constructs a BitmapItem with the specified level and image file name.
     *
     * @param level  The level of the item.
     * @param name   The name of the image file.
     */
    public BitmapItem(int level, String name)
    {
        super(level);
        this.imageName = name;
        loadImage();
    }

    /**
     * Loads the image from the specified file.
     */
    private void loadImage()
    {
        try {
            image = ImageIO.read(new File(imageName));
        } catch (IOException e) {
            System.err.println(FILE_NOT_FOUND_MESSAGE + imageName);
        }
    }

    /**
     * Gets the name of the image file.
     *
     * @return The name of the image file.
     */
    public String getName()
    {
        return imageName;
    }

    /**
     * Gets the bounding box of the image.
     *
     * @param graphics The Graphics object.
     * @param observer The ImageObserver object.
     * @param scale    The scale factor.
     * @param style    The style of the item.
     * @return The bounding box of the image.
     */
    public Rectangle getBoundingBox(Graphics graphics, ImageObserver observer, float scale, Style style)
    {
        int width = (int) (style.getIndent() * scale);
        int height = (int) (style.getLeading() * scale);
        return new Rectangle(width, 0,
                (int) (image.getWidth(observer) * scale),
                height + (int) (image.getHeight(observer) * scale));
    }

    /**
     * Draws the image on the graphics context.
     *
     * @param graphics The Graphics object.
     * @param observer The ImageObserver object.
     * @param scale    The scale factor.
     * @param style    The style of the item.
     * @param x        The x-coordinate.
     * @param y        The y-coordinate.
     */
    public void drawItem(Graphics graphics, ImageObserver observer, float scale, Style style, int x, int y)
    {
        int width = x + (int) (style.getIndent() * scale);
        int height = y + (int) (style.getLeading() * scale);
        graphics.drawImage(image, width, height,
                (int) (image.getWidth(observer) * scale),
                (int) (image.getHeight(observer) * scale), observer);
    }

    @Override
    public String toString()
    {
        return "Item.BitmapItem[" + getLevel() + "," + imageName + "]";
    }
}
