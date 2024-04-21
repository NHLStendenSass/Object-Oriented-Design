package presentation;

import java.awt.*;

public class PresentationFrame
{
    public Presentation presentation;
    public Frame frame;

    public PresentationFrame(Frame frame, Presentation presentation)
    {
        this.presentation = presentation;
        this.frame = frame;
    }
}