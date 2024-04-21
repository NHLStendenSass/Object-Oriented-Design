package xml;

import presentation.Presentation;

import java.io.IOException;


/**
 * Xml.XMLAccessor, reads and writes XML files
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
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
