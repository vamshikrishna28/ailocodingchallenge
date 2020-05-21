package com.ailo.game.apocolypse.game;

import com.ailo.game.apocolypse.model.Creature;
import com.ailo.game.apocolypse.model.Position;

public interface ZombieMoveProcessor {

    public Position moveZombie(Creature creature, char move);

}
