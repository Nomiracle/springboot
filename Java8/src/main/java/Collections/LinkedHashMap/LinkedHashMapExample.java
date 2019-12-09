package Collections.LinkedHashMap;

import java.util.LinkedHashMap;

public class LinkedHashMapExample {
    public static void main(String[] args) {
//3rd parameter set access order
        LinkedHashMap<Integer,String> pairs = new LinkedHashMap<>(2, .75f, true);

        pairs.put(1,  "A");
        pairs.put(2,  "B");
        pairs.put(3,  "C");
        pairs.put(4,  "D");

//Access 3rd pair
        pairs.get(3);

//Access 1st pair
        pairs.getOrDefault(2, "oops");

        pairs.getOrDefault(2, "B");

        pairs.forEach((key, value) -> {
            System.out.println("Key:"+ key + ", Value:" + value);
        });
    }
}
