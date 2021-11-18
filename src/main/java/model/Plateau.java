package model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Plateau
{
    @Getter @Setter
    public int xSize;
    @Getter @Setter
    public int ySize;
    @Getter @Setter
    public List<Rover> roverList;

    public Plateau(int xDimension, int yDimension, List<Rover> roverList)
    {
        this.xSize = xDimension;
        this.ySize = yDimension;
        this.roverList = roverList;
    }

    public static Plateau createPlateau(String plateauDimension)
    {
        String[] coordinateSizes = plateauDimension.split(" ");
        int xDimension = Integer.parseInt(coordinateSizes[0]);
        int yDimension = Integer.parseInt(coordinateSizes[1]);
        List<Rover> roverList = new ArrayList<>();
        return new Plateau(xDimension, yDimension, roverList);
    }

    public boolean coordinateIsTaken(Rover newRover)
    {
        for (Rover r : this.roverList)
        {
            if (r.xCoordinate == newRover.xCoordinate && r.yCoordinate == newRover.yCoordinate)
            {
                return true;
            }
        }
        return false;
    }

    public boolean coordinateIsOnPlateau(int xCoordinate, int yCoordinate)
    {
        if (xCoordinate < 0 || xCoordinate > this.xSize)
        {
            return false;
        }
        else if(yCoordinate < 0 || yCoordinate > this.ySize)
        {
            return false;
        }
        return true;
    }

    public void printRovers(Plateau plateau)
    {
        if(plateau.getRoverList() != null && plateau.getRoverList().size() > 0)
        {
            System.out.println("Rovers' locations are : ");
            for(Rover rover : plateau.getRoverList())
            {
                System.out.println(rover.xCoordinate +" "+  rover.yCoordinate + " " + rover.getRoverDirection());
            }
        }
    }
}
