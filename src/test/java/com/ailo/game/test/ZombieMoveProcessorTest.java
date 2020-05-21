package com.ailo.game.test;

import com.ailo.game.apocolypse.game.ZombieMoveProcessor;
import com.ailo.game.apocolypse.impl.ZombieMoveProcessorImpl;
import com.ailo.game.apocolypse.model.Creature;
import com.ailo.game.apocolypse.model.Position;
import org.junit.Assert;
import org.junit.Test;

public class ZombieMoveProcessorTest extends BaseTest{

    ZombieMoveProcessor zombieMoveProcessor = new ZombieMoveProcessorImpl(constructGameParameters());

    @Test
    public void moveZombieDownTest(){
        Creature creature = new Creature(new Position(2,1),true,false,new Position(2,1));
        Position positionAfterMove = zombieMoveProcessor.moveZombie(creature,'D');
        Assert.assertEquals(positionAfterMove.getX(),2);
        Assert.assertEquals(positionAfterMove.getY(),2);
    }

    @Test
    public void moveZombieUpTest(){
        Creature creature = new Creature(new Position(2,1),true,false,new Position(2,1));
        Position positionAfterMove = zombieMoveProcessor.moveZombie(creature,'U');
        Assert.assertEquals(positionAfterMove.getX(),2);
        Assert.assertEquals(positionAfterMove.getY(),0);
    }

    @Test
    public void moveZombieLeftTest(){
        Creature creature = new Creature(new Position(2,1),true,false,new Position(2,1));
        Position positionAfterMove = zombieMoveProcessor.moveZombie(creature,'L');
        Assert.assertEquals(positionAfterMove.getX(),1);
        Assert.assertEquals(positionAfterMove.getY(),1);
    }

    @Test
    public void moveZombieRightTest(){
        Creature creature = new Creature(new Position(2,1),true,false,new Position(2,1));
        Position positionAfterMove = zombieMoveProcessor.moveZombie(creature,'R');
        Assert.assertEquals(positionAfterMove.getX(),3);
        Assert.assertEquals(positionAfterMove.getY(),1);
    }

    @Test
    public void moveZombieLeftEdge(){
        Creature creature = new Creature(new Position(0,2),true,false,new Position(0,2));
        Position positionAfterMove = zombieMoveProcessor.moveZombie(creature,'L');
        Assert.assertEquals(positionAfterMove.getX(),3);
        Assert.assertEquals(positionAfterMove.getY(),2);
    }

    @Test
    public void moveZombieRightEdge(){
        Creature creature = new Creature(new Position(3,2),true,false,new Position(3,2));
        Position positionAfterMove = zombieMoveProcessor.moveZombie(creature,'R');
        Assert.assertEquals(positionAfterMove.getX(),0);
        Assert.assertEquals(positionAfterMove.getY(),2);

    }

    @Test
    public void moveZombieTopEdge(){
        Creature creature = new Creature(new Position(1,0),true,false,new Position(1,0));
        Position positionAfterMove = zombieMoveProcessor.moveZombie(creature,'U');
        Assert.assertEquals(positionAfterMove.getX(),1);
        Assert.assertEquals(positionAfterMove.getY(),3);

    }

    @Test
    public void moveZombieDownEdge(){
        Creature creature = new Creature(new Position(0,3),true,false,new Position(0,1));
        Position positionAfterMove = zombieMoveProcessor.moveZombie(creature,'D');
        Assert.assertEquals(positionAfterMove.getX(),0);
        Assert.assertEquals(positionAfterMove.getY(),0);

    }
}
