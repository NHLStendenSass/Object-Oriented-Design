package item;

import enums.Measurement;
import style.Style;
import style.StyleHelper;

import java.awt.*;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>A text item.</p>
 * <p>A text item has drawing capabilities.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class TextItem extends SlideItem
{
    private static final String EMPTY_TEXT = "No Text Given";
    private final String text;

    public TextItem(int level, String string)
    {
        super(level);
        this.text = string;
    }

    public TextItem()
    {
        this(0, EMPTY_TEXT);
    }

    public String getText()
    {
        return text == null ? "" : text;
    }

    public AttributedString getAttributedString(Style style, float scale)
    {
        AttributedString attrStr = new AttributedString(getText());
        attrStr.addAttribute(TextAttribute.FONT, style.getFont(scale), 0, text.length());
        return attrStr;
    }

    public Rectangle getBoundingBox(Graphics graphics, ImageObserver observer, float scale, Style style)
    {
        int xSize = 0;
        int ySize = StyleHelper.getLeadingStyle(style, scale);

        List<TextLayout> layouts = getLayouts(graphics, scale, style);
        for (TextLayout layout : layouts)
        {
            Rectangle2D bounds = layout.getBounds();
            xSize = Math.max(xSize, (int) bounds.getWidth());
            ySize += bounds.getHeight() + layout.getLeading() + layout.getDescent();
        }
        return new Rectangle((int) (style.getIndent() * scale), 0, xSize, ySize);
    }

    public void drawItem(Graphics graphics, ImageObserver observer, float scale, Style style, int x, int y)
    {
        if (!text.isEmpty())
        {
            List<TextLayout> layouts = getLayouts(graphics, scale, style);
            Point pen = new Point(x + (int) (style.getIndent() * scale), y + (int) (style.getLeading() * scale));
            Graphics2D g2d = (Graphics2D) graphics;
            g2d.setColor(style.getColor());

            for (TextLayout layout : layouts)
            {
                pen.y += layout.getAscent();
                layout.draw(g2d, pen.x, pen.y);
                pen.y += layout.getDescent();
            }
        }
    }

    private List<TextLayout> getLayouts(Graphics graphics, float scale, Style style)
    {
        List<TextLayout> layouts = new ArrayList<>();
        AttributedString attrStr = getAttributedString(style, scale);
        LineBreakMeasurer measurer = new LineBreakMeasurer(attrStr.getIterator(), ((Graphics2D) graphics).getFontRenderContext());
        float wrappingWidth = (Measurement.WIDTH.getSize() - style.getIndent()) * scale;

        while (measurer.getPosition() < getText().length())
        {
            TextLayout layout = measurer.nextLayout(wrappingWidth);
            layouts.add(layout);
        }
        return layouts;
    }

    public String toString()
    {
        return new TextItem(getLevel(), getText()).toString();
    }
}
