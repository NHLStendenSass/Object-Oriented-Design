package menu;

import presentation.PresentationFrame;

import javax.swing.*;
import java.awt.*;

public class ViewMenu
{
    protected static final String VIEW = "View";
    protected static final String NEXT = "Next";
    protected static final String PREV = "Prev";
    protected static final String GOTO = "Goto";
    protected static final String PAGENR = "Page number?";
    private PresentationFrame presentationFrame;
    private MenuItem menuItem;

    public ViewMenu(PresentationFrame presentationFrame)
    {
        this.presentationFrame = presentationFrame;

    }

    public Menu makeViewMenu()
    {
        Menu viewMenu = new Menu(VIEW);

        next(viewMenu);
        previous(viewMenu);
        goTo(viewMenu);

        return viewMenu;
    }

    private void next(Menu viewMenu)
    {
        viewMenu.add(menuItem = MakeMenuItemHelper.makeMenuItem(NEXT));
        menuItem.addActionListener(actionEvent -> presentationFrame.presentation.nextSlide());
    }

    private void previous(Menu viewMenu)
    {
        viewMenu.add(menuItem = MakeMenuItemHelper.makeMenuItem(PREV));
        menuItem.addActionListener(actionEvent -> presentationFrame.presentation.prevSlide());
    }

    private void goTo(Menu viewMenu)
    {
        viewMenu.add(menuItem = MakeMenuItemHelper.makeMenuItem(GOTO));
        menuItem.addActionListener(actionEvent -> {
            String pageNumberStr = JOptionPane.showInputDialog(PAGENR);
            int pageNumber = Integer.parseInt(pageNumberStr);

            if (pageNumber > 0 && pageNumber <= presentationFrame.presentation.getSize())
            {
                presentationFrame.presentation.setSlideNumber(pageNumber - 1);
            } else {
                presentationFrame.presentation.setSlideNumber(presentationFrame.presentation.getSlideNumber());
            }
        });
    }

}
