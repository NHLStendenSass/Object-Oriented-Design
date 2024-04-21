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