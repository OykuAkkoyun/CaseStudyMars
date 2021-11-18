package exception;

public class PlateauSizeException extends RuntimeException
{
    public PlateauSizeException()
    {
        super("Coordinate is not on the plateau!");
    }
}