package state;

import model.Plateau;
import model.Rover;

public interface RoverState
{
    Object changeRoverState(Plateau plateau, Rover rover, char command);

    Object moveRover(Plateau plateau, Rover rover);
}
