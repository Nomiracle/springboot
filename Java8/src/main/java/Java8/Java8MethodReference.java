package Java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8MethodReference {
    public static void main(String[] args) {
//        List<Integer>list = Arrays.asList(1,2,3,9,6,5);
//        Optional<Integer>max = list.stream().reduce(Math::max);
//        max.ifPresent(value->System.out.println(value));
//
//        max.ifPresent(System.out::println);
//        List<String> strings = Arrays.asList("how","to","do","in","java");
//        List<String> sorted  = strings.stream()
//                                       .sorted((s1,s2)->s1.compareTo(s2))
//                                         .collect(Collectors.toList());
//        System.out.println(sorted);
//
//        List<String>sortedAlt = strings.stream().sorted(String::compareTo)
//                .collect(Collectors.toList());
//        System.out.println(sortedAlt);
        List<Integer>integers = IntStream.range(1,100).boxed()
                             .collect(Collectors.toCollection(ArrayList::new));
        Optional<Integer>max = integers.stream().reduce(Math::max);
        max.ifPresent(System.out::println);

        List<Integer>integers1 = IntStream.range(1,100).boxed()
                .collect(Collectors.toList());
        Optional<Integer>max1 = integers1.stream().reduce(Math::max);
        max1.ifPresent(System.out::println);

    }
}
