package com.ailo.game.test;

import com.ailo.game.apocolypse.model.GameParameters;
import com.ailo.game.apocolypse.model.Position;
import com.ailo.game.apocolypse.util.UserInputParser;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UserInputParserTest {

    @Test
    public void testUserInputParser(){
        List<String> userInputs = constructUserInput();
        GameParameters gameParameters =  UserInputParser.parseUserInput(userInputs);
        GameParameters expectedOutput = constructExpectedGameParameters();

        Assert.assertEquals(gameParameters,expectedOutput);
    }

    private GameParameters constructExpectedGameParameters() {
        GameParameters expectedOutput = new GameParameters();
        expectedOutput.setZombiePosition(new Position(2,1));
        List<Position> creaturePosition = new ArrayList<Position>();
        creaturePosition.add(new Position(2,2));
        creaturePosition.add(new Position(2,4));
        creaturePosition.add(new Position(1,1));
        expectedOutput.setCreaturePosition(creaturePosition);
        expectedOutput.setMoveSequence("UURL");
        expectedOutput.setGridSize(4);
        return expectedOutput;
    }

    private List<String> constructUserInput() {
        List<String> userInputs = new ArrayList<String>();
        userInputs.add("4");
        userInputs.add("(2,1)");
        userInputs.add("(2,2)(2,4)(1,1)");
        userInputs.add("UURL");
        return userInputs;
    }
}
