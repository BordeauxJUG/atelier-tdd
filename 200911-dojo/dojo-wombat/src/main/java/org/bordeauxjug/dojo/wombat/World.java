package org.bordeauxjug.dojo.wombat;

import java.math.BigDecimal;
import java.util.Collection;

/**
 *
 * @author laurent.foret
 */
public interface World {

    public enum CardinalPoint {
        NORTH, NORTHEAST, EAST, SOUTHEAST, SOUTH, SOUTHWEST, WEST, NORTHWEST;
    }

    public interface Cell extends Identifiable {
        
        public long getX();
        public long getY();
        public Collection<ContentItem> getContent();
        
        public interface ContentItem {
            
            public Prey getPrey();
            public Quantity getQuantity();
        }

        public interface Quantity {

            public enum Unit {
                GRAMMES, KILOGRAMMES, CALORIE, CELLS_BY_TIME_UNIT;
            }

            public BigDecimal getValue();
            public Unit getUnit();
        }
    }

}
