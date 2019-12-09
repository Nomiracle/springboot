package Collections.LinkList;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListExample {
    public static void main(String[] args)
    {
        //Create linked list
        LinkedList<String> linkedList = new LinkedList<>();

        //Add elements
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");

        System.out.println(linkedList);

        //Add elements at specified position
        linkedList.add(4, "A");
        linkedList.add(5, "A");

        System.out.println(linkedList);

        //Remove element
        linkedList.remove("A");     //removes A
        linkedList.remove(0);       //removes B

        System.out.println(linkedList);

        //Iterate
        ListIterator<String> itrator = linkedList.listIterator();

        while (itrator.hasNext()) {
            System.out.print(itrator.next()+" ");
        }
        System.out.println();
    }
}
