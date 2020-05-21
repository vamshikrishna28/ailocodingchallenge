package com.ailo.game.apocolypse.model;

import java.util.List;
import java.util.Objects;

public class GameParameters {
    private int gridSize;
    private Position zombiePosition;
    private List<Position> creaturePosition;
    private String moveSequence;

    public GameParameters(int gridSize, Position zombiePosition, List<Position> creaturePosition, String moveSequence) {
        this.gridSize = gridSize;
        this.zombiePosition = zombiePosition;
        this.creaturePosition = creaturePosition;
        this.moveSequence = moveSequence;
    }

    public GameParameters() {

    }

    public int getGridSize() {
        return gridSize;
    }

    public void setGridSize(int gridSize) {
        this.gridSize = gridSize;
    }

    public Position getZombiePosition() {
        return zombiePosition;
    }

    public void setZombiePosition(Position zombiePosition) {
        this.zombiePosition = zombiePosition;
    }

    public List<Position> getCreaturePosition() {
        return creaturePosition;
    }

    public void setCreaturePosition(List<Position> creaturePosition) {
        this.creaturePosition = creaturePosition;
    }

    public String getMoveSequence() {
        return moveSequence;
    }

    public void setMoveSequence(String moveSequence) {
        this.moveSequence = moveSequence;
    }

    @Override
    public String toString() {
        return "GameParameters{" +
                "gridSize=" + gridSize +
                ", zombiePosition=" + zombiePosition +
                ", creaturePosition=" + creaturePosition +
                ", moveSequence='" + moveSequence + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameParameters that = (GameParameters) o;
        return gridSize == that.gridSize &&
                Objects.equals(zombiePosition, that.zombiePosition) &&
                Objects.equals(creaturePosition, that.creaturePosition) &&
                Objects.equals(moveSequence, that.moveSequence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gridSize, zombiePosition, creaturePosition, moveSequence);
    }
}
