package state;

import enums.Direction;
import enums.Command;
import exception.PlateauRoverPositionException;
import exception.PlateauSizeException;
import model.Plateau;
import model.Rover;

public class WestState implements RoverState
{
    @Override
    public Object changeRoverState(Plateau plateau, Rover rover, char command)
    {
        if(String.valueOf(Command.L).equals(String.valueOf(command)))
        {
            rover.setRoverDirection(Direction.S);
            return new SouthState();
        }
        return new NorthState();
    }

    public Object moveRover(Plateau plateau, Rover rover)
    {
        rover.xCoordinate = rover.xCoordinate - 1;
        if (!plateau.coordinateIsOnPlateau(rover.xCoordinate, rover.yCoordinate))
        {
            throw new PlateauSizeException();
        }
        else if(plateau.coordinateIsTaken(rover))
        {
            throw new PlateauRoverPositionException();
        }
        return new WestState();
    }

}
