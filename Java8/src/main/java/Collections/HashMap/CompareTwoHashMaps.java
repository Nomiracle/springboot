package Collections.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CompareTwoHashMaps {
    private static HashMap<Integer,String>map1,map2,map3;
    static void  init(){
         map1 = new HashMap<>();

        map1.put(1, "A");
        map1.put(2, "B");
        map1.put(3, "C");

        //Same as map1
         map2 = new HashMap<>();

        map2.put(3, "C");
        map2.put(1, "A");
        map2.put(2, "B");

        //Different from map1
        map3 = new HashMap<>();

        map3.put(1, "A");
        map3.put(2, "B");
        map3.put(3, "C");
        map3.put(3, "D");
        show();

    }
    static void show(){
        System.out.println("map1:"+map1);
        System.out.println("map2:"+map2);
        System.out.println("map3:"+map3);
    }
    public static void main(String[] args) {
        init();
        int i = 0;
        System.out.println(++i+""+map1.equals(map2));  //true
        //false
        System.out.println(++i+""+map1.equals(map3));

        System.out.println(++i+""+map1.keySet().equals(map2.keySet()));
        System.out.println(++i+""+map1.keySet().equals(map3.keySet()));
        //Find out extra keys
        //Union of keys from both maps
        map2.put(4,"D");
        show();
        HashSet<Integer> unionKeys = new HashSet<>(map1.keySet());
        unionKeys.addAll(map2.keySet());
        unionKeys.removeAll(map1.keySet());
        System.out.println(unionKeys);
        //Compare hashmaps for values – HashMap.values()
        //1.Duplicates are NOT allowed
        map2.put(4,"C");
        map3.put(3,"C");
        show();
        System.out.println(++i+":"+
            new ArrayList<>(map1.values()).equals(
                    new ArrayList<>(map2.values())
            )
        );
        System.out.println(++i+":"+
                new ArrayList<>(map1.values()).equals(
                        new ArrayList<>(map3.values())
                )
        );
        //2.Duplicates are allowed
        System.out.println(++i+":"+
                new HashSet<>(map1.values()).equals(
                        new HashSet<>(map2.values())
                )
        );

    }
}
