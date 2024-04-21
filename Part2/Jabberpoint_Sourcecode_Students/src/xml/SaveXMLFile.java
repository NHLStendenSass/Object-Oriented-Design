package xml;

import item.BitmapItem;
import item.SlideItem;
import item.TextItem;
import presentation.Presentation;
import slide.Slide;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

public class SaveXMLFile
{
    /**
     * Save a file
     *
     * @param presentation Presentation.Presentation to save
     * @param fileName     Name of the file
     * @throws IOException IO Exception
     *                     NOTE: Extracted saveXMLPresentation(),saveXMLSlide(),saveXMLItem(), rename filename to fileName
     */
    public void saveFile(Presentation presentation, String fileName) throws IOException
    {
        PrintWriter out = new PrintWriter(new FileWriter(fileName));

        out.println("<?xml version=\"1.0\"?>");
        out.println("<!DOCTYPE presentation SYSTEM \"jabberpoint.dtd\">");

        saveXMLPresentation(out, presentation);

        out.close();
    }

    /**
     * Saves the presentation to XML format.
     *
     * @param out           The PrintWriter to which the XML content will be written.
     * @param presentation  The Presentation object containing the slides to be saved.
     */
    private void saveXMLPresentation(PrintWriter out, Presentation presentation)
    {
        out.println("<presentation>");
        out.print("<showtitle>");
        out.print(presentation.getTitle());
        out.println("</showtitle>");

        for (int slideNumber = 0; slideNumber < presentation.getSize(); slideNumber++)
        {
            Slide slide = presentation.getSlide(slideNumber);
            saveXMLSlide(out, slide);
        }

        out.println("</presentation>");
    }

    /**
     * Saves a slide to XML format.
     *
     * @param out   The PrintWriter to which the XML content will be written.
     * @param slide The Slide object to be saved.
     */
    private void saveXMLSlide(PrintWriter out, Slide slide)
    {
        StringBuilder xmlSlide = new StringBuilder();
        xmlSlide.append("<slide>").append(System.lineSeparator());
        xmlSlide.append("<title>").append(slide.getTitle()).append("</title>").append(System.lineSeparator());

        Vector<SlideItem> slideItems = slide.getSlideItems();
        for (SlideItem slideItem : slideItems)
        {
            saveXMLItem(xmlSlide, slideItem);
        }

        xmlSlide.append("</slide>").append(System.lineSeparator());

        out.print(xmlSlide);
    }


    /**
     * Saves a slide item to XML format.
     *
     * @param out       The StringBuilder to which the XML content will be appended.
     * @param slideItem The SlideItem object to be saved.
     */
    private void saveXMLItem(StringBuilder out, SlideItem slideItem)
    {
        out.append("<item kind=\"")
                .append(slideItem instanceof TextItem ? "text" : "image")
                .append("\" level=\"")
                .append(slideItem.getLevel())
                .append("\">");

        if (slideItem instanceof TextItem) {
            out.append(((TextItem) slideItem).getText());
        } else if (slideItem instanceof BitmapItem) {
            out.append(((BitmapItem) slideItem).getName());
        } else {
            System.out.println("Ignoring " + slideItem);
        }

        out.append("</item>").append(System.lineSeparator());
    }
}
