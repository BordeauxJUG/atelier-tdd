package org.bordeauxjug.guavademo.demo1collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author lforet
 */
public class DealWithMapBefore1 implements DealWithMap {

    private final static Map<String, String> STATIC_MAP = new HashMap<String, String>();

    @Override
    public String findByKey(String key) {
        return STATIC_MAP.get(key);
    }

    @Override
    public String findByValue(String value) {
        // Merde : STATIC_MAP.containsValue(value); pourrait retourner la clé quand même.
        // Obliger de ma fader l'itération :
        for (Entry<String, String> entry : STATIC_MAP.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Override
    public final void put(String key, String value) {
        // Etape 1 : de ma réflexion
        STATIC_MAP.put(key, value);

        // Etape 2 : Est ce suffisant ? La value doit être unique, comment gérer tout ça ?
//        if (STATIC_MAP.containsValue(value)) {
//            STATIC_MAP.remove(key); // Danger là !!! Faut vérifier que la clé corresponde bien à la valeur!
//        }
//        STATIC_MAP.put(key, value);

        // Etape 3 : Merde : on est obligé d'itérer encore une fois !
//         for (Entry<String, String> entry : STATIC_MAP.entrySet()) {
//            if (entry.getValue().equals(value)) {
//                STATIC_MAP.remove(entry.getKey()); // Cette fois on est sur que la clé correpond à la value que l'on veut supprimer
//                break;  // Comme la méthode est final on est sur qu'on est les seuls à savoir ce que nous faisons.
//             }
//        }
    }
}
