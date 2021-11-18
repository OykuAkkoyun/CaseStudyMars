import enums.Command;
import enums.Direction;
import helper.InputValidator;
import model.Plateau;
import model.Rover;
import state.*;

import java.util.Scanner;

public class MarsProgram
{
    public static void main(String[] args)
    {
        InputValidator inputValidator = new InputValidator();
        String continueToAddRover = "N";

        System.out.print("Enter the plateau's dimension size : x y :");
        Scanner input = new Scanner(System.in);
        String plateauDimension = input.nextLine();
        inputValidator.validatePlateau(plateauDimension);
        Plateau plateau = Plateau.createPlateau(plateauDimension);
        do {
            Rover rover = new Rover();
            System.out.print("Enter the rover's position:  x y d : ");
            String roverPosition = input.nextLine();
            inputValidator.validateRoverBasePosition(roverPosition, plateau);
            rover = rover.parseRoverCommands(roverPosition);
            RoverState roverState = initiliazeRoverState(rover);
            System.out.print("Enter nasa commands: L-M-R : ");
            String nasaCommands = input.nextLine();
            inputValidator.validateRoverCommand(nasaCommands);
            for (char c : nasaCommands.toCharArray())
            {
                if(String.valueOf(Command.M).equals(String.valueOf(c)))
                    roverState.moveRover(plateau, rover);
                else
                    roverState = (RoverState) roverState.changeRoverState(plateau, rover, c);
            }
            plateau.getRoverList().add(rover);
            System.out.print("Do you want to add an another  rover : Y - N :");
            continueToAddRover = input.next();
            input = new Scanner(System.in);
        }
        while ("Y".equals(continueToAddRover));
        input.close();
        plateau.printRovers(plateau);
    }

    private static RoverState initiliazeRoverState(Rover rover)
    {
        if (Direction.E.equals(rover.getRoverDirection()))
        {
            return new EastState();
        }
        else if (Direction.W.equals(rover.getRoverDirection()))
        {
             return new WestState();
        }
        else if (Direction.N.equals(rover.getRoverDirection()))
        {
            return new NorthState();
        }
        else if (Direction.S.equals(rover.getRoverDirection()))
        {
            return new SouthState();
        }
        return null;
    }

}
