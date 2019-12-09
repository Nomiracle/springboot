package Collections.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintArray
{
    public static void main(String[] args)
    {

        // A normal java list having four String objects
        List<String> list = new ArrayList<>();
        list.add("First");
        list.add("Second");
        list.add("Third");
        list.add("Fourth");

        // Print the list in console
        System.out.println("1: "+list);

        // An array of String objects
        String[] array = new String[] { "First", "Second", "Third", "Fourth" };

        // Print the array using default toString method - Do not Use it
        System.out.println("2: "+array.toString());

        // Print the array using Arrays.toString() - "RECOMMENDED for simple arrays"
        System.out.println("3: "+Arrays.toString(array));

        String[] arr1 = new String[] { "Fifth", "Sixth" };
        String[] arr2 = new String[] { "Seventh", "Eigth" };

        // An array of array containing String objects
        String[][] arrayOfArray = new String[][] { arr1, arr2 };

        // Compare the different outputs

        // Print the array using default toString method
        System.out.println("4: "+arrayOfArray);

        // Print the array using Arrays.toString()
        System.out.println("5: "+Arrays.toString(arrayOfArray));

        // Print the array using Arrays.deepToString() -  "RECOMMENDED for multi-dimensional array"
        System.out.println("6: "+Arrays.deepToString(arrayOfArray));
    }
}
