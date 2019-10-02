package Java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Java8Stream {
    public static void main(String[] args) {
//        Stream<Integer>stream = Stream.of(1,2,3,4,5,6,7,8,9);
//        stream.forEach(p->System.out.print(p));

//        Stream<Integer>stream = Stream.of(new Integer[]{1,2,3,4,5,6,7,8,9});
//        stream.forEach(p->System.out.print(p));
//
//
//        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
//        list.stream().forEach(p->System.out.print(p));
//
//
////        Stream<Date>stream1 = Stream.generate(()->{return new Date();});
////        stream1.forEach(p->System.out.println(p));
//
//        String string="123456_abcdefg";
//        IntStream stream2 = string.chars();
//        stream2.forEach(p->System.out.println((char)p));
//
//        Stream stream3 = Stream.of(string.split("_"));
//        stream3.forEach(p->System.out.print(p));
        List<String> memberNames = new ArrayList<>();
        memberNames.add("Amitabh");
        memberNames.add("Shekhar");
        memberNames.add("Aman");
        memberNames.add("Rahul");
        memberNames.add("Shahrukh");
        memberNames.add("Salman");
        memberNames.add("Yana  ");
        memberNames.add("Lokesh");

//        boolean matchedResult = memberNames.stream()
//                .anyMatch((s) -> s.startsWith("A"));
//
//        System.out.println(matchedResult);
//
//        matchedResult = memberNames.stream()
//                .allMatch((s) -> s.startsWith("A"));
//
//        System.out.println(matchedResult);
//
//        matchedResult = memberNames.stream()
//                .noneMatch((s) -> s.startsWith("A"));
//
//        System.out.println(matchedResult);

        Optional<String> reduced = memberNames.stream()
                .reduce((s1,s2) -> s1 + "#" + s2);

        reduced.ifPresent(System.out::println);


    }
}
