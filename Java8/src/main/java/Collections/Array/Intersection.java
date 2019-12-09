package Collections.Array;

import java.util.Arrays;
import java.util.HashSet;

public class Intersection {
    public static void main(String[] args) {
        Integer[] C = {1,2,3,4,5,6,7};
        Integer[] D = {5,6,7,8,9,10,11};
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.addAll(Arrays.asList(C));
        hashSet.retainAll(Arrays.asList(D));
        System.out.println(hashSet);

        Integer[] intersection = {};
        intersection = hashSet.toArray(intersection);
        System.out.println(Arrays.toString(intersection));
    }
}
