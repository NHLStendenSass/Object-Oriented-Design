# Object-Oriented-Design Report

Organization: NHL Stenden University of Applied Sciences

Subject: Object-Oriented Design

Student: Sander Siimann

Student name: 4767667

## Report Details

### 1. Miscellaneous Enhancements

Rearrange method signatures, rename variable

### 2. Presentation and Slide

Shared methods like `getTitle()`, `setTitle()`, and `getSize()` are prevalent.

**Resolution**: Extract the `PresentationSlidePrep` interface for streamlined functionality.

This maneuver minimizes redundancy and ensures a clear delineation between classes.

### 3. Slide Displaying Component

`SlideViewerComponent` graphically exhibits slides, configuring elements and rendering slides.

- Extensive methods.

**Resolution**: Refactor by segmenting methods.

This enhancement enhances maintainability by decomposing methods into more focused components.

### 4. TextItem, Slide, SlideViewerComponent, SlideViewerFrame

These entities utilize manual width and height assignments.

**Resolution**: Introduce the `Measurement` enum for streamlined access.

This tactic centralizes measurements, facilitating future modifications without duplicating fields.

### 5. Styling

Altering styles necessitates code modifications.

**Resolution**: Develop the `StyleHelper` class for adaptable styling.

This maneuver enables style adjustments without altering the base class.

### 6. Menu Management

The `MenuController` orchestrates the creation of menu items for File, View, and Help functionalities.

- High field count in `MenuController`.
- Cumbersome methods with extensive logic.
- A glitch permits users to input a page number exceeding the total count of slides.
- Absence of robust error handling.

**Resolution**: Employ a structured approach by segregating classes and methods, and introduce `MenuControllerException`.

This approach decomposes responsibilities into distinct classes like `FileMenu`, `HelpMenu`, and `ViewMenu`, aligning with the concept of each class having a singular purpose. Method extraction with precise naming reduces complexity. `MakeMenuItemHelper` is abstracted to avoid redundancy. `MenuControllerException` manages error messages.

### 7. XML Interaction, Demonstration Presentation

`XMLAccessor` manages XML file operations for presentations, including title and slide item management.

- Overloaded fields and prolonged methods in `XMLAccessor`.
- Inadequate error handling.

**Resolution**: Segregate `XMLTag` class, delineate interfaces for XML loading and saving, introduce an exception class, and discard `Accessor`.

This strategy adopts the factory pattern for interface implementation variability between `DemoPresentation` and `XMLAccessor`. Method extraction to `LoadXMLFile` and `SaveXMLFile` adheres to the Single Responsibility Principle. Comprehensive error handling is implemented.