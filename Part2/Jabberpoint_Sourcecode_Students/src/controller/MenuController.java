package controller;

import menu.FileMenu;
import menu.HelpMenu;
import menu.ViewMenu;
import presentation.Presentation;
import presentation.PresentationFrame;

import java.awt.*;

/**
 * <p>The controller for the menu</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
public class MenuController extends MenuBar
{
    private PresentationFrame presentationFrame;
    private FileMenu fileMenu;
    private ViewMenu viewMenu;
    private HelpMenu helpMenu;

    public MenuController(Frame frame, Presentation presentation)
    {
        this.presentationFrame = new PresentationFrame(frame, presentation);

        fileMenu = new FileMenu(this.presentationFrame);
        viewMenu = new ViewMenu(this.presentationFrame);
        helpMenu = new HelpMenu(this.presentationFrame);
        add(fileMenu.makeFileMenu());
        add(viewMenu.makeViewMenu());
        add(helpMenu.makeAboutMenu());
    }
}