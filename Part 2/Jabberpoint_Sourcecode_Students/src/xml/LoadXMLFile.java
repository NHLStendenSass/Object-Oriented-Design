package xml;

import enums.XMLTag;
import exceptions.XMLException;
import item.BitmapItem;
import item.TextItem;
import presentation.Presentation;
import slide.Slide;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class LoadXMLFile
{

    /**
     * Load a file
     *
     * @param presentation Presentation.Presentation to add the file element
     * @param fileName     Name of the file
     *                     NOTE: Extracted loadElement(), rename filename to fileName
     */
    public void loadFile(Presentation presentation, String fileName) throws IOException
    {
        try {
            // Parse the XML file
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = builder.parse(new File(fileName)); //Create a JDOM document
            Element doc = document.getDocumentElement();

            // Extract the title from the XML document
            presentation.setTitle(getTitle(doc, XMLTag.SHOWTITLE.getValue()));

            // Extract slides from the XML document
            NodeList slides = doc.getElementsByTagName(XMLTag.SLIDE.getValue());
            loadElement(slides, presentation);

        } catch (IOException | SAXException | ParserConfigurationException e) {
            throw new IOException("Error loading XML file: " + e.getMessage());
        }
    }

    /**
     *
     * @param element
     * @param tagName
     * @return
     */
    private String getTitle(Element element, String tagName)
    {
        NodeList titles = element.getElementsByTagName(tagName);
        return titles.item(0).getTextContent();
    }

    /**
     * Load slide element fromm NodeList slides
     *
     * @param slides       List of slides
     * @param presentation Presentation.Presentation
     */
    private void loadElement(NodeList slides, Presentation presentation)
    {
        for (int slideNumber = 0; slideNumber < slides.getLength(); slideNumber++)
        {
            Element xmlSlide = (Element) slides.item(slideNumber);
            Slide slide = new Slide();
            slide.setTitle(getTitle(xmlSlide, XMLTag.SLIDETITLE.getValue()));
            presentation.addSlide(slide);
            NodeList slideItems = xmlSlide.getElementsByTagName(XMLTag.ITEM.getValue());
            for (int itemNumber = 0; itemNumber < slideItems.getLength(); itemNumber++)
            {
                Element item = (Element) slideItems.item(itemNumber);
                loadSlideItem(slide, item);
            }
        }
    }

    /**
     * Load slide item
     *
     * @param slide Slide.Slide
     * @param item  Item
     *              NOTE: Extracted getTextLevel(), rename leveltext to levelText, change multi level if to another else if
     */
    protected void loadSlideItem(Slide slide, Element item)
    {
        String levelText = item.getAttribute(XMLTag.LEVEL.getValue());
        int level = getTextLevel(levelText);

        String type = item.getAttribute(XMLTag.KIND.getValue());

        if (XMLTag.TEXT.getValue().equals(type)) {
            slide.addSlideItem(new TextItem(level, item.getTextContent()));
        } else if (XMLTag.IMAGE.getValue().equals(type)) {
            slide.addSlideItem(new BitmapItem(level, item.getTextContent()));
        } else {
            System.err.println(XMLException.unknownTypeError());
        }
    }

    /**
     * Get text level
     *
     * @param levelText Level text
     * @return Level
     */
    private int getTextLevel(String levelText)
    {
        if (levelText != null)
        {
            try {
                return Integer.parseInt(levelText);
            } catch (NumberFormatException x) {
                System.err.println(XMLException.numberFormatError());
            }
        }
        return 1;
    }
}
