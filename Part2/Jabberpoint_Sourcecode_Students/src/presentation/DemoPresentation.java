package presentation;

import item.BitmapItem;
import slide.Slide;
import xml.LoadSaveXML;

/**
 * A built-in demo presentation
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class DemoPresentation implements LoadSaveXML
{

    public DemoPresentation() {}

    public void loadFile(Presentation presentation, String unusedFilename)
    {
        presentation.setTitle("Demo Presentation.Presentation");
        Slide slide;
        slide = new Slide();
        slide.setTitle("JabberPoint");
        slide.createTextItem(1, "The Java prestentation tool");
        slide.createTextItem(2, "Copyright (c) 1996-2000: Ian Darwin");
        slide.createTextItem(2, "Copyright (c) 2000-now:");
        slide.createTextItem(2, "Gert Florijn and Sylvia Stuurman");
        slide.createTextItem(4, "Calling Jabberpoint without a filename");
        slide.createTextItem(4, "will show this presentation");
        slide.createTextItem(1, "Navigate:");
        slide.createTextItem(3, "Next slide: PgDn or Enter");
        slide.createTextItem(3, "Previous slide: PgUp or up-arrow");
        slide.createTextItem(3, "Quit: q or Q");
        presentation.addSlide(slide);

        slide = new Slide();
        slide.setTitle("Demonstration of levels and styles");
        slide.createTextItem(1, "Level 1");
        slide.createTextItem(2, "Level 2");
        slide.createTextItem(1, "Again level 1");
        slide.createTextItem(1, "Level 1 has style number 1");
        slide.createTextItem(2, "Level 2 has style number 2");
        slide.createTextItem(3, "This is how level 3 looks like");
        slide.createTextItem(4, "And this is level 4");
        presentation.addSlide(slide);

        slide = new Slide();
        slide.setTitle("The third slide");
        slide.createTextItem(1, "To open a new presentation,");
        slide.createTextItem(2, "use File->Open from the menu.");
        slide.createTextItem(1, " ");
        slide.createTextItem(1, "This is the end of the presentation.");
        slide.addSlideItem(new BitmapItem(1, "JabberPoint.jpg"));
        presentation.addSlide(slide);
    }

    public void saveFile(Presentation presentation, String unusedFilename)
    {
        throw new IllegalStateException("Save As->Demo! called");
    }
}
