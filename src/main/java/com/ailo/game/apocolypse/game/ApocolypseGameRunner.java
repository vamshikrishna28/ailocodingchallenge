package com.ailo.game.apocolypse.game;

import com.ailo.game.apocolypse.model.GameParameters;
import com.ailo.game.apocolypse.model.GameResult;

public interface ApocolypseGameRunner {

    public GameResult runGame(GameParameters gameParameters);

    public void printResults(GameResult gameResult);

    public void writeToFile(GameResult gameResult, String path);

    public void writeJSONResponse(GameResult gameResult);
}
