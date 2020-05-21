package com.ailo.game.apocolypse.model;

import com.ailo.game.apocolypse.impl.CreaturePropertyChangeListener;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Objects;

public class Creature {
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    CreaturePropertyChangeListener creaturePropertyChangeListener = new CreaturePropertyChangeListener();

    @JsonSerialize
    Position currentPosition;
    private boolean zombie;
    private boolean active;
    private Position startPosition;

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
        support.firePropertyChange("Position", this.currentPosition, currentPosition);
    }

    public boolean isZombie() {
        return zombie;
    }

    public void setZombie(boolean zombie) {
        this.zombie = zombie;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Position getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(Position startPosition) {
        this.startPosition = startPosition;
    }
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    public Creature(Position currentPosition, boolean zombie, boolean active, Position startPosition) {
        support.addPropertyChangeListener(creaturePropertyChangeListener);
        this.currentPosition = currentPosition;
        this.zombie = zombie;
        this.active = active;
        this.startPosition = startPosition;
    }

    @Override
    public String toString() {
        return "Creature{" +
                "currentPosition=" + currentPosition +
                ", zombie=" + zombie +
                ", active=" + active +
                ", startPosition=" + startPosition +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Creature creature = (Creature) o;
        return zombie == creature.zombie &&
                active == creature.active &&
                Objects.equals(support, creature.support) &&
                Objects.equals(creaturePropertyChangeListener, creature.creaturePropertyChangeListener) &&
                Objects.equals(currentPosition, creature.currentPosition) &&
                Objects.equals(startPosition, creature.startPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(support, creaturePropertyChangeListener, currentPosition, zombie, active, startPosition);
    }
}
