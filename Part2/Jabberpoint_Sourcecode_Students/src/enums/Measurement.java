package enums;

public enum Measurement
{
    WIDTH(1200),
    HEIGHT(800);

    private final int size;

    Measurement(int size) {
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }
}
