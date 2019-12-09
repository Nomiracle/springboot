package Collections.LinkList;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class SortLinkedList {
    public static void main(String[] args) {
        Integer[] arrays = {45,3,16,56};
        LinkedList<Integer> linkedList
                 = new LinkedList<>(Arrays.asList(arrays));
        System.out.println(linkedList);
        LinkedList<Integer> linkedList1
                = new LinkedList<>(linkedList);
       // 1.default sort
        Collections.sort(linkedList1);
        System.out.println(linkedList1);

        // 2.default sort
        linkedList1.sort(Collections.reverseOrder());
        System.out.println(linkedList1);

    }
}
