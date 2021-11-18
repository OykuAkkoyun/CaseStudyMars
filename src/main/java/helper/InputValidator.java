package helper;

import exception.PlateauRoverPositionException;
import exception.InputFormatException;
import model.Plateau;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator
{
    private static final String plateauRegex = "\\d\\s\\d";
    private static final String roverBasePositionRegex = "\\d\\s\\d\\s[N|S|W|E]";
    private static final String roverCommandRegex = "[L|R|M]+";

    public void validatePlateau(String plateauInput)
    {
        regexControl(plateauRegex, plateauInput);
    }

    public void validateRoverBasePosition(String basePositionInput, Plateau plateau)
    {
        regexControl(roverBasePositionRegex, basePositionInput);
        if(plateau.xSize <  Integer.valueOf(basePositionInput.substring(0,1))
                || plateau.ySize < Integer.valueOf(basePositionInput.substring(2,3)))
        {
            throw new InputFormatException();
        }
    }

    public void validateRoverCommand(String commandInput)
    {
        regexControl(roverCommandRegex, commandInput);
    }

    public void regexControl(String regex, String input)
    {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        boolean matchFound = matcher.find();
        if(!matchFound)
        {
            throw new InputFormatException();
        }
    }
}
