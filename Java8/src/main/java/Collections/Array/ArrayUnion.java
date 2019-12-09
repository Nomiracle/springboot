package Collections.Array;

import java.util.Arrays;
import java.util.HashSet;

public class ArrayUnion {
    public static void main(String[] args) {
        Integer[] A = {0,1,2,3,4,5,6};
        Integer[] B = {4,5,6,7,8,9,10};
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.addAll(Arrays.asList(A));
        hashSet.addAll(Arrays.asList(B));
        System.out.println(hashSet);

        Integer[] union = {};
        union = hashSet.toArray(union);
        System.out.println(Arrays.toString(union));
    }
}
