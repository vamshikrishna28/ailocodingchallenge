package com.ailo.game.apocolypse.impl;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CreaturePropertyChangeListener implements PropertyChangeListener {

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println(evt.getSource());
        System.out.println("Property:"+evt.getPropertyName()+" "+evt.getOldValue() +"-->"+evt.getNewValue());

    }
}
