package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class Java8ForEach {
//    Consumer<Object> action = new Consumer<Object>()
//    {
//        @Override
//        public void accept(Object t)
//        {
//            /* perform action */
//        }
//    };
    public static void main(String[] args) {

        ArrayList<Integer>numberList =
                new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
//        Consumer<Integer> action = System.out::println;
//        numberList.stream().filter(n->n%2==0).forEach(action);
        Consumer<Integer> action0=entry ->
            System.out.println("value is:"+entry);

        numberList.stream().filter(n->n%2==0).forEach(action0);

        HashMap<String,String>map=new HashMap<>();
        map.put("1","ad");
        map.put("2","ap");
        map.put("3","tank");
        Consumer<Map.Entry<String,String>> action = entry ->{
          System.out.print("key is:"+entry.getKey());
          System.out.println("  value is:"+entry.getValue());
        };
        map.entrySet().forEach(action);
    }

}
