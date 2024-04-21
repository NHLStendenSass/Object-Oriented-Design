package style;

import java.awt.*;

public class StyleHelper {
    //NOTE: Extracted from Style.Style.java
    private static Style[] styles;

    public StyleHelper() {

    }

    /**
     * Styles
     */
    public static void createStyles() {
        styles = new Style[5];
        styles[0] = new Style(0, Color.red, 48, 20);    // style voor item-level 0
        styles[1] = new Style(20, Color.blue, 40, 10);  // style voor item-level 1
        styles[2] = new Style(50, Color.black, 36, 10); // style voor item-level 2
        styles[3] = new Style(70, Color.black, 30, 10); // style voor item-level 3
        styles[4] = new Style(90, Color.black, 24, 10); // style voor item-level 4
    }

    /**
     * Get the style for a given item level.
     *
     * @param level The item level.
     * @return The Style.Style for that level.
     */
    public static Style getStyle(int level) {
        if (level >= styles.length)
        {
            level = styles.length - 1;
        }
        return styles[level];
    }

    public static int getLeadingStyle(Style myStyle, float scale) {
        return (int) (myStyle.getLeading() * scale);
    }
}
