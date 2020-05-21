package com.ailo.game.test;

import com.ailo.game.apocolypse.game.ApocolypseGameRunner;
import com.ailo.game.apocolypse.impl.ApocolypseGameRunnerImpl;
import com.ailo.game.apocolypse.model.GameParameters;
import com.ailo.game.apocolypse.model.GameResult;
import org.junit.Assert;
import org.junit.Test;

public class ApocolypseGameRunnerTest extends BaseTest{

    @Test
    public void testRunGame(){
        ApocolypseGameRunner gameRunner = new ApocolypseGameRunnerImpl();
        GameParameters gameParameters = constructGameParameters();
        GameResult gameRunResult = gameRunner.runGame(gameParameters);
        GameResult expectedResult = constructGameResults();
        Assert.assertEquals(gameRunResult,expectedResult);
      }
}
