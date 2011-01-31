package bordeauxjug.guava1collections;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author lforet
 */
public class DealWithImmutables {




    public static List<String> populateAListAndMakeItImmutableBefore() {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        return Collections.unmodifiableList(list);
    }







    public static List<String> populateAListAndMakeItImmutableBeforeWithoutCheat() {
        return Collections.unmodifiableList(Arrays.asList("a", "b", "c", "d"));
    }






    public static List<String> populateAListAndMakeItImmutableGuava() {
        return ImmutableList.of("a", "b", "c", "d");
    }


////////////////////////////////////////////////////////////////////////////////





    public static Map<Integer, String> populateAMapAndMakeItImmutableBefore() {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1,"a");
        map.put(2,"b");
        map.put(3,"c");
        map.put(4,"d");
        return Collections.unmodifiableMap(map);
    }








    public static Map<Integer, String> populateAMapAndMakeItImmutableGuava() {
        return ImmutableMap.of(1 ,"a", 2, "b", 3, "c", 4, "d");
    }


    

}
