package com.ailo.game.apocolypse;

import com.ailo.game.apocolypse.model.GameParameters;
import com.ailo.game.apocolypse.model.GameResult;
import com.ailo.game.apocolypse.util.UserInputParser;
import com.ailo.game.apocolypse.impl.ApocolypseGameRunnerImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AiloZombie {

    public static void main(String[] args) {
        int inputCount = 1;
 	    System.out.println("Dimensions of the area (N)\n" +
                "The initial position of the zombie\n" +
                "A list of positions of poor creatures\n" +
                "List of moves zombies will make");
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        List<String> inputLines = new ArrayList<String>(4);
        try {
            while ((line = br.readLine()) != null) {
                inputLines.add(line);
                if(inputCount == 4)
                    break;
                inputCount++;

            }
            br.close();
        } catch (IOException e) {
            //TODO: To define custom exception class
            System.out.println("Unable to read the user input from console: "+e.getMessage());
        }

        //Parse the user input and run the game
        GameParameters gameParameters = UserInputParser.parseUserInput(inputLines);
        ApocolypseGameRunnerImpl gameRunner = new ApocolypseGameRunnerImpl();
        GameResult gameResult = gameRunner.runGame(gameParameters);
        gameRunner.printResults(gameResult);
        gameRunner.writeJSONResponse(gameResult);
        gameRunner.writeToFile(gameResult,"./output.txt");
    }
}