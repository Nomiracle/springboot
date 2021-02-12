package bestpractices.CompareArrayAndVector;

import java.util.Calendar;
import java.util.Vector;

public class CompareArrayAndVector {
    public static void method1(Vector<String> v) {
        int size = v.size();
        for (int i = size; i > 0; i--) {
            String str = v.elementAt(size - i);
        }
    }

    public static void method2(Vector<String> v) {
        int size = v.size();
        String[] vArr = new String[size];
        v.toArray(vArr);
        for (int i = 0; i < size; i++) {
            String str = vArr[i];
        }
    }

    public static void main(String[] args) {
        Vector<String> vector = new Vector<String>();
        for (int i = 0; i < 1000000; i++) {
            vector.add("" + i);
        }

        long startTime = Calendar.getInstance().getTimeInMillis();
        method1(vector);
        long endTime = Calendar.getInstance().getTimeInMillis();
        System.out.println("Using elementAt() :: " + (endTime - startTime) + " ms");

        startTime = Calendar.getInstance().getTimeInMillis();
        method2(vector);
        endTime = Calendar.getInstance().getTimeInMillis();
        System.out.println("Using array :: " + (endTime - startTime) + " ms");
    }
}
