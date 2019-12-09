package Collections.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class addAll {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>(
                Arrays.asList(1,2,3,4)
        );
        List<Integer> integers1 = new ArrayList<>(
                Arrays.asList(5,6,7,8)
        );
        integers.addAll(integers1);
        System.out.print(integers);
        integers.addAll(2,integers1);
        System.out.print(integers);
    }
}
