package Collections.Array;

import java.util.Arrays;
import java.util.List;

public class subarray {
    public static void main(String[] args) {
        String[] names = {"Alex", "Brian", "Charles", "David"};

//Subarray from index '0' (inclusive) to index '2' (exclusive)
        String[] partialNames = Arrays.copyOfRange(names, 0, 2);
        System.out.println(Arrays.toString(partialNames));
// [Alex, Brian]

//Subarray to list
        List<String> namesList = Arrays.asList( Arrays.copyOfRange(names, 2, names.length) );
        namesList.stream().forEach(a ->System.out.print(" "+a));
        System.out.println();
// [Charles, David]
        String[] moreNames = Arrays.copyOfRange(names, 2, 10);
        System.out.println(Arrays.toString(moreNames));
    }
}
