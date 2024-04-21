package exceptions;

public class MenuControllerException extends Exception
{
    public static String loadErrorException() {
        return "Load Error";
    }

    public static String saveErrorException() {
        return "Save Error";
    }

    public static String iOException() {
        return "IO Exception";
    }
}
