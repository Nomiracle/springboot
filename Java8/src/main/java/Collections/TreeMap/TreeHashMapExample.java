package Collections.TreeMap;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

public class TreeHashMapExample {
    public static void main(String[] args) {
        TreeMap<Integer,String>pairs = new TreeMap<>();
        pairs.put(2,  "B");
        pairs.put(1,  "A");
        pairs.put(3,  "C");
        int i=0;

        System.out.println(++i+" :"+pairs.get(3));
        System.out.println(++i+" :"+pairs.getOrDefault(5,"oops"));
        //Iteration example
        Iterator<Integer> iterator =  pairs.keySet().iterator();

        while(iterator.hasNext()) {
            Integer key = iterator.next();
            System.out.println("Key: " + key + ", Value: " + pairs.get(key));
        }


        System.out.println(pairs);

        System.out.println(pairs.containsKey(1));    //containsKey method

        System.out.println(pairs.containsValue("B"));    //containsValue method

        System.out.println(pairs.ceilingKey(2));

        System.out.println(pairs.higherKey(2));
        System.out.println(pairs.higherKey(3));

        //Remove example
        pairs.remove(3);

        //Sort keys in reverse order
        TreeMap<Integer, String> pairs1 = new TreeMap<>(Collections.reverseOrder());

        pairs1.put(2,  "B" );
        pairs1.put(1,  "A");
        pairs1.put(3,  "C");

        System.out.println(pairs1);

        System.out.println(++i+" :"+pairs1.getOrDefault(3,"oops"));
        System.out.println(++i+" :"+pairs1.getOrDefault(5,"oops"));


    }
}
