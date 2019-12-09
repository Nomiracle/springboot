package Collections.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Iterate {
    public static void main(String[] args) {
        List<String>names = new ArrayList<>(
                Arrays.asList("hhh","ddd","ggg")
        );
        names.add("qqq");
        names.set(1,"fff");
        System.out.println(names);

        names.remove(2);
        Iterator<String>iterator
                = names.iterator();
        while(iterator.hasNext()){
            System.out.print(" "+iterator.next());
        }
    }
}
