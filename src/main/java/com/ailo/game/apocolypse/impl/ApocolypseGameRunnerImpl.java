package com.ailo.game.apocolypse.impl;

import com.ailo.game.apocolypse.game.ApocolypseGameRunner;
import com.ailo.game.apocolypse.model.Creature;
import com.ailo.game.apocolypse.model.GameParameters;
import com.ailo.game.apocolypse.model.GameResult;
import com.ailo.game.apocolypse.model.Position;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
This is the class that has the logic to run the rules. It uses a Linked list data structure to keep track of
the list of creatures infected with the virus and is processed in the order of infection. At the same time
the score is incremented to keep track of the number of infections so far.
 */
public class ApocolypseGameRunnerImpl implements ApocolypseGameRunner {

    @Override
    public GameResult runGame(GameParameters gameParameters){
        List<Position> inActiveZombiePositions = new ArrayList<Position>();
        int score = 0;
        LinkedList<Creature> zombieList = new LinkedList<Creature>();
        //Construct the creature list based on the game parameters
        List<Creature> creatureList = constructCreatures(gameParameters);
        //Add the initial zombie to the zombie list
        zombieList.add(new Creature(gameParameters.getZombiePosition(),true,true,gameParameters.getZombiePosition()));

        GameResult gameResult = new GameResult();
        ZombieMoveProcessorImpl zombieMoveProcessorimpl = new ZombieMoveProcessorImpl(gameParameters);

        while(!zombieList.isEmpty()){
            Creature zombie = zombieList.poll();
            for(char move : gameParameters.getMoveSequence().toCharArray()) {
                Position newPosition = zombieMoveProcessorimpl.moveZombie(zombie,move);
                zombie.setCurrentPosition(newPosition);
                Creature passByCreature = checkCreatureAtPosition(newPosition, creatureList);
                //infect creature and add it to the dead zombie list and remove infected creature from creaturelist
                if(passByCreature != null) {
                    passByCreature.setZombie(true);
                    zombieList.push(passByCreature);
                    creatureList.remove(passByCreature);
                    score++;
                }
            }
            inActiveZombiePositions.add(zombie.getCurrentPosition());
        }
        gameResult.setFinalPositions(inActiveZombiePositions);
        gameResult.setScore(score);
        return gameResult;
    }

    private List<Creature> constructCreatures(GameParameters gameParameters) {
        List<Creature> creatures = new ArrayList<Creature>();
        gameParameters.getCreaturePosition().stream().forEach(position -> {
            creatures.add(new Creature(position,false,false,position));
        });
        return creatures;
    }

    private Creature checkCreatureAtPosition(Position position, List<Creature> creatureList){
        for(Creature creature : creatureList){
            if(creature.getCurrentPosition().equals(position))
                return creature;
        }
        return null;
    }

    public void printResults(GameResult gameResult){
        System.out.println(gameResult);
        System.out.println("Zombies positions:");
       gameResult.getFinalPositions().stream().forEach(position -> System.out.print(position));
       System.out.println("\nZombies score: "+gameResult.getScore());
    }

    //Write output to text file
    public void writeToFile(GameResult gameResult, String path) {
        File outputFile = new File(path);
        try {
            outputFile.createNewFile();
            FileWriter outputWriter = new FileWriter(path);
            outputWriter.write(gameResult.toString());
            outputWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Write a json output to the console
    public void writeJSONResponse(GameResult gameResult) {
        ObjectMapper mapper = new ObjectMapper();
        //Converting the Object to JSONString
        try {
            String jsonString = mapper.writeValueAsString(gameResult);
            System.out.println("JSON:"+jsonString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
