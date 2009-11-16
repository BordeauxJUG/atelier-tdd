package org.bordeauxjug.dojo.wombat;

import org.bordeauxjug.dojo.wombat.World.Cell.Quantity;

public interface Prey extends Identifiable {

    public enum Kingdom {
        VEGETABLE, ANIMAL, MINERAL;
    }

    public Kingdom getKingdom();
    public Quantity getCalorieValueFor100g();
    public Quantity getSpeed();


}
