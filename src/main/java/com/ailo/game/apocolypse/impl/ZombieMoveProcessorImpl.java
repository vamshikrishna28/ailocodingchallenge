package com.ailo.game.apocolypse.impl;

import com.ailo.game.apocolypse.game.ZombieMoveProcessor;
import com.ailo.game.apocolypse.model.Creature;
import com.ailo.game.apocolypse.model.GameParameters;
import com.ailo.game.apocolypse.model.Position;

/*
This is the class where all the zombie moves happen left, right, up, down. The zombie position is moved
to the opposite side of the grid in case the move is through the edge of the grid.
 */
public class ZombieMoveProcessorImpl implements ZombieMoveProcessor {

    private GameParameters gameParameters;

    public Position moveZombie(Creature creature, char move){
       int gridSize = gameParameters.getGridSize();
        Position creaturePosition = null;
        if(creature.getCurrentPosition() == null){
            creature.setCurrentPosition(creature.getStartPosition());
        }
        if(creature.getCurrentPosition() != null){
            creaturePosition = creature.getCurrentPosition();
        }

            switch (move) {
                case 'U':
                    //Move Up : current y co-ordinate - 1
                    int afterMovePosition = determineEdgeMove(gridSize, creaturePosition.getY()-1);
                    creaturePosition.setY(afterMovePosition);
                    break;
                case 'D':
                    //Move Down : current y co-ordinate + 1
                    afterMovePosition = determineEdgeMove(gridSize,creaturePosition.getY() + 1);
                    creaturePosition.setY(afterMovePosition);
                    break;
                case 'L':
                    //Move Left : current x co-ordinate - 1
                    afterMovePosition = determineEdgeMove(gridSize,creaturePosition.getX() - 1);
                    creaturePosition.setX(afterMovePosition);
                    break;
                case 'R':
                    //Move Right : current x co-ordinate + 1
                    afterMovePosition = determineEdgeMove(gridSize,creaturePosition.getX() + 1);
                    creaturePosition.setX(afterMovePosition);
                    break;
            }

        return creaturePosition;
    }

    private int determineEdgeMove(int gridSize, int afterMovePosition) {
        //if the move is on the edge coordinate, move to the opposite side
        if(afterMovePosition < 0)
            return gridSize-1;
        else if(afterMovePosition >= gridSize)
            return 0;
        else
            return  afterMovePosition;
    }

    public ZombieMoveProcessorImpl(GameParameters gameParameters) {
        this.gameParameters = gameParameters;
    }

}
