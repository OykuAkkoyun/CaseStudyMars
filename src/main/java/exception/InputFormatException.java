package exception;

public class InputFormatException extends RuntimeException
{
    public InputFormatException()
    {
        super("Input value is wrong!");
    }
}
