package com.ailo.game.apocolypse.util;

import com.ailo.game.apocolypse.model.Position;
import com.ailo.game.apocolypse.model.GameParameters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserInputParser {

    public static GameParameters parseUserInput(List<String> userInputs){
        //TODO: To validate the user inputs and define Exception class
        GameParameters gameParameters = new GameParameters();

        //Grid Dimensions
        int gridSize = Integer.parseInt(userInputs.get(0));
        gameParameters.setGridSize(gridSize);

        //Zombie initial position
        List<Position> zombiePositions = processCoordinatePairs(userInputs.get(1));
        if(!zombiePositions.isEmpty()){
            gameParameters.setZombiePosition(zombiePositions.get(0));
        }

        //Creature positions
        List<Position> creaturePositions = processCoordinatePairs(userInputs.get(2));
        if(!creaturePositions.isEmpty()){
            gameParameters.setCreaturePosition(creaturePositions);
        }

        //Move sequence
        gameParameters.setMoveSequence(userInputs.get(3));
        return gameParameters;
    }

    private static List<Position> processCoordinatePairs(String coordinates){
        //TODO : To improve the user input parsing technique
        String[] coordinatesArray = coordinates.split("\\)");
        List<Position> gridPositions = new ArrayList<Position>();
        Arrays.stream(coordinatesArray).forEach(coordinate -> {
            String[] xyCoordinates = coordinate.replace("(","").trim().split(",");
            gridPositions.add(new Position(Integer.parseInt(xyCoordinates[0]), Integer.parseInt(xyCoordinates[1])));
        });
        return gridPositions;
    }
}
