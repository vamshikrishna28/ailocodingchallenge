package com.ailo.game.test;

import com.ailo.game.apocolypse.model.GameParameters;
import com.ailo.game.apocolypse.model.GameResult;
import com.ailo.game.apocolypse.model.Position;

import java.util.ArrayList;

public class BaseTest {

    public GameParameters constructGameParameters() {
        GameParameters gameParameters = new GameParameters();
        Position zombiePosition = new Position(2,1);
        ArrayList<Position> creaturePositions = new ArrayList<Position>();

        creaturePositions.add(new Position(0,1));
        creaturePositions.add(new Position(1,2));
        creaturePositions.add(new Position(3,1));
        gameParameters.setGridSize(4);
        gameParameters.setCreaturePosition(creaturePositions);
        gameParameters.setMoveSequence("DLUURR");
        gameParameters.setZombiePosition(zombiePosition);
        return gameParameters;
    }

    public GameResult constructGameResults() {
        GameResult gameResult = new GameResult();
        ArrayList<Position> finalPositions = new ArrayList<Position>();

        finalPositions.add(new Position(3,0));
        finalPositions.add(new Position(2,1));
        finalPositions.add(new Position(1,0));
        finalPositions.add(new Position(0,0));

        gameResult.setScore(3);
        gameResult.setFinalPositions(finalPositions);
        return  gameResult;
    }
}
