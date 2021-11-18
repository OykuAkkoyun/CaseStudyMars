import enums.Command;
import enums.Direction;
import exception.PlateauSizeException;
import model.Plateau;
import model.Rover;
import org.junit.Test;
import state.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class MarsProgramTest
{
    private Plateau plateau = new Plateau(5, 5, new ArrayList<>());

    @Test
    public void succeedCase1_firstRover()
    {
        Rover rover = new Rover(1, 2, Direction.N);
        RoverState roverState = new NorthState();
        for (char c : ("LMLMLMLMM").toCharArray())
        {
            if(String.valueOf(Command.M).equals(String.valueOf(c)))
                roverState.moveRover(plateau, rover);
            else roverState = (RoverState) roverState.changeRoverState(plateau, rover, c);
        }
        String lastPosition =  rover.xCoordinate + " " + rover.yCoordinate + " " + rover.roverDirection;
        assertEquals("1 3 N", lastPosition);
    }

    @Test
    public void succeedCase_secondRover()
    {
        Rover rover = new Rover( 3, 3, Direction.E);
        RoverState roverState = new EastState();
        for (char c : ("MMRMMRMRRM").toCharArray())
        {
            if(String.valueOf(Command.M).equals(String.valueOf(c)))
                roverState.moveRover(plateau, rover);
            else roverState = (RoverState) roverState.changeRoverState(plateau, rover, c);
        }
        String lastPosition =  rover.xCoordinate + " " + rover.yCoordinate + " " + rover.roverDirection;
        assertEquals("5 1 E", lastPosition);
    }

    @Test
    public void faultedCase_commandLetter()
    {
        Rover rover = new Rover(3, 2, Direction.E);
        RoverState roverState = new WestState();
        for (char c : ("MMRXMAMRRM").toCharArray())
        {
            roverState = (RoverState) roverState.changeRoverState(plateau, rover, c);
        }
        assertTrue("Input format is wrong!", true);
    }

   @Test
    public void faultedCase_plateauSize()
    {
        Rover rover = new Rover(9, 7, Direction.E);
        RoverState roverState = new EastState();
        try {
            for (char c : ("MMRMMRMRRM").toCharArray())
            {
                roverState = (RoverState) roverState.changeRoverState(plateau, rover, c);
            }
        }
        catch (PlateauSizeException ex) {
            assertEquals("Coordinate is not on the plateau!", ex.getMessage());
        }
    }
}
