package item;

import style.Style;

import java.awt.*;
import java.awt.image.ImageObserver;

/**
 * <p>The abstract class for items on a slide.<p>
 * <p>All SlideItems have drawing capabilities.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public abstract class SlideItem
{
    private int level = 0; //The level of the Item.SlideItem

    public SlideItem(int level) {
        this.level = level;
    }

    //Returns the level
    public int getLevel() {
        return this.level;
    }

    //Returns the bounding box
    public abstract Rectangle getBoundingBox(Graphics graphics, ImageObserver observer, float scale, Style style);

    //Draws the item
    public abstract void drawItem(Graphics graphics, ImageObserver observer, float scale, Style style, int x, int y);
}
