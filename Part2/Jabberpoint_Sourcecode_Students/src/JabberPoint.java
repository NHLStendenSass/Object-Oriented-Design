import presentation.DemoPresentation;
import presentation.Presentation;
import slide.SlideViewerFrame;
import style.StyleHelper;
import xml.LoadXMLFile;

import javax.swing.*;
import java.io.IOException;

/**
 * JabberPoint Main Program
 * <p>This program is distributed under the terms of the accompanying
 * COPYRIGHT.txt file (which is NOT the GNU General Public License).
 * Please read it. Your use of the software constitutes acceptance
 * of the terms in the COPYRIGHT.txt file.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class JabberPoint {
    protected static final String IOERR = "IO Error: ";
    protected static final String JABERR = "Jabberpoint Error ";
    protected static final String JABVERSION = "Jabberpoint 1.6 - OU version";

    /**
     * The main program
     */
    public static void main(String[] argv) {

        StyleHelper.createStyles();
        Presentation presentation = new Presentation();
        new SlideViewerFrame(JABVERSION, presentation);
        try {
            if (argv.length == 0) { //a demo presentation
                DemoPresentation demoPresentation = new DemoPresentation();
                demoPresentation.loadFile(presentation, "");
            } else {
                new LoadXMLFile().loadFile(presentation, argv[0]);
            }
            presentation.setSlideNumber(0);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,
                    IOERR + ex, JABERR,
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
