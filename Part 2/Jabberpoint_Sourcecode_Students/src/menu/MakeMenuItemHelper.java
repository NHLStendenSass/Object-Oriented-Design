package menu;

import java.awt.*;

public final class MakeMenuItemHelper
{
    public static MenuItem makeMenuItem(String name)
    {
        return new MenuItem(name, new MenuShortcut(name.charAt(0)));
    }
}
