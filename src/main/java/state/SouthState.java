package state;

import enums.Direction;
import enums.Command;
import exception.PlateauRoverPositionException;
import exception.PlateauSizeException;
import model.Plateau;
import model.Rover;

public class SouthState implements RoverState
{
    @Override
    public Object changeRoverState(Plateau plateau, Rover rover, char command)
    {
        if(String.valueOf(Command.L).equals(String.valueOf(command)))
        {
            rover.setRoverDirection(Direction.E);
            return new EastState();
        }
        return new WestState();
    }

    public Object moveRover(Plateau plateau, Rover rover)
    {
        rover.yCoordinate = rover.yCoordinate - 1;
        if (!plateau.coordinateIsOnPlateau(rover.xCoordinate, rover.yCoordinate))
        {
            throw new PlateauSizeException();
        }
        else if(plateau.coordinateIsTaken(rover))
        {
            throw new PlateauRoverPositionException();
        }
        return new SouthState();
    }
}
