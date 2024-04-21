package xml;

import presentation.Presentation;

import java.io.IOException;


/**
 * Xml.XMLAccessor, reads and writes XML files
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class XMLAccessor implements LoadSaveXML
{
    private final LoadXMLFile loadXMLFile;
    private final SaveXMLFile saveXMLFile;

    public XMLAccessor() {
        loadXMLFile = new LoadXMLFile();
        saveXMLFile = new SaveXMLFile();
    }

    @Override
    public void loadFile(Presentation presentation, String filename) throws IOException {

        loadXMLFile.loadFile(presentation, filename);
    }

    @Override
    public void saveFile(Presentation presentation, String filename) throws IOException {

        saveXMLFile.saveFile(presentation, filename);
    }
}
