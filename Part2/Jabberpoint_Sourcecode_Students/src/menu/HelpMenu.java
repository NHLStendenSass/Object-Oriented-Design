package menu;

import about.AboutBox;
import presentation.PresentationFrame;

import java.awt.*;

public class HelpMenu extends MenuBar
{
    private static final String ABOUT = "about";
    private static final String HELP = "Help";
    private PresentationFrame presentationFrame;
    private MenuItem menuItem;

    public HelpMenu(PresentationFrame presentationFrame)
    {
        this.presentationFrame = presentationFrame;
    }

    public Menu makeAboutMenu()
    {
        Menu helpMenu = new Menu(HELP);
        helpButton(helpMenu);
        return helpMenu;
    }

    private void helpButton(Menu helpMenu)
    {
        helpMenu.add(menuItem = MakeMenuItemHelper.makeMenuItem(ABOUT));
        menuItem.addActionListener(actionEvent -> AboutBox.showAbout(presentationFrame.frame));
        setHelpMenu(helpMenu);
    }
}
