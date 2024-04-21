package presentation;

import menu.FileMenu;
import xml.XMLAccessor;

import java.io.IOException;

public class StartPresentation
{
    public static void openPresentation(Presentation presentation) throws IOException
    {
        XMLAccessor loadXmlFile = new XMLAccessor();
        loadXmlFile.loadFile(presentation, FileMenu.TESTFILE);
    }

    public static void newPresentation(PresentationFrame presentationFrame)
    {
        presentationFrame.presentation.clear();
        presentationFrame.frame.repaint();
    }

    public static void savePresentation(Presentation presentation) throws IOException
    {
        XMLAccessor saveXmlFile = new XMLAccessor();
        saveXmlFile.saveFile(presentation, FileMenu.SAVEFILE);
    }
}
