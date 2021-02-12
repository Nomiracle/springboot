package test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class test2 {
    public static void main(String[] args) {
        Set<String>strings = new HashSet<>(Arrays.asList("1","2","3"));
        strings.addAll(Arrays.asList("11","22","33"));
        System.out.println(strings);
    }
}
