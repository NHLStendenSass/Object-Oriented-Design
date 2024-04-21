package slide;

import enums.Measurement;
import item.SlideItem;
import item.TextItem;
import presentation.PresentationSlidePrep;
import style.Style;
import style.StyleHelper;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.Vector;

/**
 * <p>A slide. This class has drawing functionality.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class Slide implements PresentationSlidePrep
{

    protected String title;
    protected Vector<SlideItem> items;

    public Slide() {
        items = new Vector<SlideItem>();
    }

    //Add a Item.SlideItem

    /**
     * Rename method
     *
     * @param anItem the item to add
     */
    public void addSlideItem(SlideItem anItem) {
        items.addElement(anItem);
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    //Change the title of a slide
    @Override
    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public void createTextItem(int level, String message) {
        addSlideItem(new TextItem(level, message));
    }

    //Returns the Item.SlideItem
    public SlideItem getSlideItem(int number) {
        return (SlideItem) items.elementAt(number);
    }

    //Return all the SlideItems in a vector
    public Vector<SlideItem> getSlideItems() {
        return this.items;
    }

    //Returns the size of a slide
    @Override
    public int getSize() {
        return this.items.size();
    }

    /**
     * Draws the slide on the specified graphics context within the given area.
     *
     * @param graphics the graphics context to draw on.
     * @param area     the area within which to draw the slide.
     * @param observer the image observer to be notified as images are asynchronously loaded.
     */
    public void drawSlide(Graphics graphics, Rectangle area, ImageObserver observer)
    {
        float scale = getScale(area);
        int y = area.y;

        // Draw title separately
        y += drawSlideItem(graphics, observer, y, area, new TextItem(0, getTitle()));

        // Draw slide items
        for (SlideItem slideItem : getSlideItems())
        {
            y += drawSlideItem(graphics, observer, y, area, slideItem);
        }
    }

    /**
     * Draws a slide item on the specified graphics context within the given area.
     *
     * @param graphics  the graphics context to draw on.
     * @param observer  the image observer to be notified as images are asynchronously loaded.
     * @param y         the vertical position to draw the slide item.
     * @param area      the area within which to draw the slide item.
     * @param slideItem the slide item to draw.
     * @return the height of the drawn slide item.
     */
    private int drawSlideItem(Graphics graphics, ImageObserver observer, int y, Rectangle area, SlideItem slideItem)
    {
        slideItem.drawItem(graphics, observer, getScale(area), StyleHelper.getStyle(slideItem.getLevel()), area.x, y);
        return slideItem.getBoundingBox(graphics, observer, getScale(area), StyleHelper.getStyle(slideItem.getLevel())).height;
    }

    /**
     * Returns the scale to draw a slide
     * @param area
     * @return
     */
    private float getScale(Rectangle area)
    {
        return Math.min(((float) area.width) / ((float) Measurement.WIDTH.getSize()), ((float) area.height) / ((float) Measurement.HEIGHT.getSize()));
    }

    /**
     * Draws the elements of a slide item and returns the height occupied by the item.
     * @param graphics
     * @param observer
     * @param y
     * @param area
     * @param slideItem
     * @return
     */
    private int getElements(Graphics graphics, ImageObserver observer, int y, Rectangle area, SlideItem slideItem)
    {
        Style style = StyleHelper.getStyle(slideItem.getLevel());
        slideItem.drawItem(graphics, observer, getScale(area), style, area.x, y);

        return slideItem.getBoundingBox(graphics, observer, getScale(area), style).height;
    }
}
