package com.ailo.game.apocolypse.model;

import com.ailo.game.apocolypse.impl.CreaturePropertyChangeListener;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Objects;

//@JavaBean
public class Position {
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    CreaturePropertyChangeListener creaturePropertyChangeListener = new CreaturePropertyChangeListener();

    int x;
    int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        support.firePropertyChange("x", this.x, x);
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    public void setY(int y) {
        support.firePropertyChange("y", this.y, y);
        this.y = y;
    }

    public Position(int x, int y) {
        support.addPropertyChangeListener(creaturePropertyChangeListener);
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x +
                "," + y +
                ')';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x &&
                y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
