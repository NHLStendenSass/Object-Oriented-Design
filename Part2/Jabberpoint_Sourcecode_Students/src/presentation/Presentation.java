package presentation;

import slide.Slide;
import slide.SlideViewerComponent;

import java.util.ArrayList;


/**
 * <p>Presentations keeps track of the slides in a presentation.</p>
 * <p>Only one instance of this class is available.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class Presentation implements PresentationSlidePrep
{
    private String showTitle;
    private ArrayList<Slide> showList;
    private int currentSlideNumber = 0;
    private SlideViewerComponent slideViewComponent = null;

    public Presentation()
    {
        this.showList = new ArrayList<>();
        slideViewComponent = null;
        clear();
    }

    public Presentation(SlideViewerComponent slideViewerComponent)
    {
        this.slideViewComponent = slideViewerComponent;
        clear();
    }

    @Override
    public int getSize()
    {
        return this.showList.size();
    }

    @Override
    public String getTitle()
    {
        return this.showTitle;
    }

    @Override
    public void setTitle(String newTitle)
    {
        this.showTitle = newTitle;
    }

    /**
     * Sets the SlideViewerComponent associated with this presentation.
     *
     * @param slideViewerComponent the SlideViewerComponent to set
     */
    public void setShowView(SlideViewerComponent slideViewerComponent)
    {
        this.slideViewComponent = slideViewerComponent;
    }

    /**
     * Gets the number of the current slide.
     *
     * @return the number of the current slide
     */
    public int getSlideNumber()
    {
        return this.currentSlideNumber;
    }

    /**
     * Sets the current slide number and updates the SlideViewerComponent to display the new slide.
     *
     * @param number the number of the slide to set as current
     */
    public void setSlideNumber(int number)
    {
        this.currentSlideNumber = number;
        if (this.slideViewComponent != null)
        {
            this.slideViewComponent.updateContent(this, getCurrentSlide());
        }
    }

    /**
     * Navigates to the previous slide, if not on the first slide.
     */
    public void prevSlide()
    {
        if (this.currentSlideNumber > 0)
        {
            setSlideNumber(this.currentSlideNumber - 1);
        }
    }

    /**
     * Navigates to the next slide, if not on the last slide.
     */
    public void nextSlide()
    {
        if (this.currentSlideNumber < (this.showList.size() - 1)) {
            setSlideNumber(this.currentSlideNumber + 1);
        }
    }

    /**
     * Removes all slides from the presentation.
     */
    public void clear()
    {
        this.showList = new ArrayList<>();
        setSlideNumber(-1);
    }

    /**
     * Adds a slide to the presentation.
     *
     * @param slide the slide to add
     */
    public void addSlide(Slide slide)
    {
        showList.add(slide);
    }

    /**
     * Retrieves the slide with the specified number.
     *
     * @param number the number of the slide to retrieve
     * @return the slide with the specified number, or null if not found
     */
    public Slide getSlide(int number)
    {
        if (number < 0 || number >= getSize())
        {
            return null;
        }
        return showList.get(number);
    }

    /**
     * Retrieves the current slide.
     *
     * @return the current slide
     */
    public Slide getCurrentSlide()
    {
        return getSlide(currentSlideNumber);
    }

    /**
     * Exits the presentation.
     *
     * @param n the exit status code
     */
    public void exit(int n)
    {
        System.exit(n);
    }
}
