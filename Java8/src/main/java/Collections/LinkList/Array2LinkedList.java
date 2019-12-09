package Collections.LinkList;

import java.util.Arrays;
import java.util.LinkedList;

public class Array2LinkedList {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");
//1. LinkedList to Array
        String[] arrays = new String[linkedList.size()];
        linkedList.toArray(arrays);
        for (String s:
             arrays) {
            System.out.println(s);
        }
//2. Array to LinkedList
        LinkedList<String> linkedListTmp
                = new LinkedList<>(Arrays.asList(arrays));
        System.out.println(linkedListTmp);

    }
}
