package org.bordeauxjug.dojo.wombat;

import org.bordeauxjug.dojo.wombat.World.Cell.Quantity;

public interface Wombat extends Identifiable {

    public String getName();
    public World.Cell getPosition();
    public Quantity getCalorieNeeds();
    public Quantity getCurrentCalorieIntakes();


}
