package exception;

public class PlateauRoverPositionException extends RuntimeException
{
    public PlateauRoverPositionException()
    {
        super("Rover's position is not valid! Another rover is already there!");
    }
}
