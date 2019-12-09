package Collections.HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Iterate {
    public static void main(String[] args) {
        HashMap<Integer,String> hashMap
                 = new HashMap<>();
        hashMap.put(1,"tom");
        hashMap.put(2,"hashMap");
        for(Integer key:hashMap.keySet()){
            System.out.println(hashMap.get(key));
        }
        System.out.println();

        Iterator<Map.Entry<Integer,String>>
                iterator = hashMap.entrySet().iterator();
        int i=0;
        while(iterator.hasNext()){
            System.out.print(i++ + ":");
            Map.Entry<Integer,String>entry = iterator.next();
            System.out.println(entry.getValue());
        }
    }
}
