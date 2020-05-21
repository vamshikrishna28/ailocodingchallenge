package com.ailo.game.apocolypse.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameResult {
    List<Position> finalPositions = new ArrayList<Position>();
    int score = 0;

    public List<Position> getFinalPositions() {
        return finalPositions;
    }

    public void setFinalPositions(List<Position> finalPositions) {
        this.finalPositions = finalPositions;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "GameResult{" +
                "finalPositions=" + finalPositions +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResult that = (GameResult) o;
        return score == that.score &&
                Objects.equals(finalPositions, that.finalPositions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(finalPositions, score);
    }
}
