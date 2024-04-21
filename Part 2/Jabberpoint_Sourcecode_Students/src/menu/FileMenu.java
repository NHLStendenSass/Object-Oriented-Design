package menu;

import exceptions.MenuControllerException;
import presentation.Presentation;
import presentation.PresentationFrame;
import presentation.StartPresentation;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class FileMenu
{
    public static final String TESTFILE = "testPresentation.xml";
    public static final String SAVEFILE = "savedPresentation.xml";
    protected static final String FILE = "File";
    protected static final String OPEN = "Open";
    protected static final String NEW = "New";
    protected static final String SAVE = "Save";
    protected static final String EXIT = "Exit";
    private final PresentationFrame presentationFrame;
    private MenuItem menuItem;

    public FileMenu(PresentationFrame presentationFrame)
    {
        this.presentationFrame = presentationFrame;
    }

    public Menu makeFileMenu()
    {
        Menu fileMenu = new Menu(FILE);

        openButton(fileMenu);
        newButton(fileMenu);
        saveButton(fileMenu);
        exitButton(fileMenu);

        return fileMenu;
    }

    private void exitButton(Menu fileMenu)
    {
        fileMenu.add(menuItem = MakeMenuItemHelper.makeMenuItem(EXIT));
        menuItem.addActionListener(actionEvent -> exitPresentation(presentationFrame.presentation));
    }

    private void saveButton(Menu fileMenu)
    {
        fileMenu.add(menuItem = MakeMenuItemHelper.makeMenuItem(SAVE));
        menuItem.addActionListener(e -> {
            try {
                StartPresentation.savePresentation(presentationFrame.presentation);
            } catch (IOException exc) {
                JOptionPane.showMessageDialog(presentationFrame.frame, MenuControllerException.iOException() + exc, MenuControllerException.saveErrorException(), JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private void newButton(Menu fileMenu)
    {
        fileMenu.add(menuItem = MakeMenuItemHelper.makeMenuItem(NEW));
        menuItem.addActionListener(actionEvent -> StartPresentation.newPresentation(presentationFrame));
    }

    private void openButton(Menu fileMenu)
    {
        fileMenu.add(menuItem = MakeMenuItemHelper.makeMenuItem(OPEN));
        menuItem.addActionListener(actionEvent -> {
            presentationFrame.presentation.clear();
            try {
                StartPresentation.openPresentation(presentationFrame.presentation);
                this.presentationFrame.presentation.setSlideNumber(0);
            } catch (IOException exc) {
                JOptionPane.showMessageDialog(presentationFrame.frame, MenuControllerException.iOException() + exc, MenuControllerException.loadErrorException(), JOptionPane.ERROR_MESSAGE);
            }
            presentationFrame.frame.repaint();
        });
    }

    private void exitPresentation(Presentation presentation)
    {
        presentation.exit(0);
    }
}
