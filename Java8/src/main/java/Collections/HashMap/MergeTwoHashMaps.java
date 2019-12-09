package Collections.HashMap;

import java.util.HashMap;
import java.util.Map;

public class MergeTwoHashMaps {
    public static void main(String[] args) {
        Map<Integer,String>map1 = new HashMap<>();
        map1.put(1,"A");
        map1.put(2,"B");
        Map<Integer,String>map2 = new HashMap<>();
        map2.put(3,"C");
        map2.put(2,"D");
        //putAll()
        map1.putAll(map2);
        System.out.println(map1);
        //init map1
        map1.put(1,"A");
        map1.put(2,"d");
        map1.put(3,"D");
        //merge
        map2.forEach(
                (key,value)->map1.merge(key,value,(v1,v2)->
                        v1.compareToIgnoreCase(v2)==0 ?v1:v1+","+v2)
        );
        System.out.println(map1);

    }
}
