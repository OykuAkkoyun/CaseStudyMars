package model;

import enums.Direction;
import lombok.Getter;
import lombok.Setter;

public class Rover
{
    @Getter
    @Setter
    public int xCoordinate;
    @Getter
    @Setter
    public int yCoordinate;
    @Getter
    @Setter
    public Direction roverDirection;

    public Rover(int xCoordinate, int yCoordinate, Direction direction)
    {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.roverDirection = direction;
    }

    public Rover()
    {
    }

    public Rover parseRoverCommands(String commands)
    {
        String[] commandArray = commands.split(" ");
        int xDimension = Integer.parseInt(commandArray[0]);
        int yDimension = Integer.parseInt(commandArray[1]);
        Direction direction = Direction.valueOf(commandArray[2]);
        return new Rover(xDimension, yDimension, direction);
    }
}
