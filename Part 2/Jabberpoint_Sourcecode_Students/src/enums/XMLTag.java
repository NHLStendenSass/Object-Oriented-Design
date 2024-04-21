package enums;

public enum XMLTag
{
    SHOWTITLE("showtitle"),
    SLIDETITLE("title"),
    SLIDE("slide"),
    ITEM("item"),
    LEVEL("level"),
    KIND("kind"),
    TEXT("text"),
    IMAGE("image");

    private final String value;

    XMLTag(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
