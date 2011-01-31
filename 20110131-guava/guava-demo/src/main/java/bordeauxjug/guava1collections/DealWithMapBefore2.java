package bordeauxjug.guava1collections;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author lforet
 */
public class DealWithMapBefore2 implements DealWithMap {

    private final static Map<String, String> STATIC_MAP = new HashMap<String, String>();
    private final static Map<String, String> INVERSE_STATIC_MAP = new HashMap<String, String>();
  
    @Override
    public String findByKey(String key) {
        return STATIC_MAP.get(key);
    }

    @Override
    public String findByValue(String key) {
        return INVERSE_STATIC_MAP.get(key);
    }

    @Override
    public synchronized void put(String key, String value) {
        // Etape 1 :
        STATIC_MAP.put(key, value);
        INVERSE_STATIC_MAP.put(value, key);
        
        // Etape 2 : Est ce suffisant ? La value doit être unique, comment le gérer ?
//        STATIC_MAP.remove(key);
//        INVERSE_STATIC_MAP.remove(value);
//        STATIC_MAP.put(key, value);
//        INVERSE_STATIC_MAP.put(value, key);

        // le synchronized nous protège t'il d'une éventuelle désynchro des deux maps !!?!!
    }
}
