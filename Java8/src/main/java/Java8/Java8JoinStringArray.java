package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Java8JoinStringArray {
    public static void main(String[] args) {
        String joinedString = String.join(",","how","to","do","in","Java");
        System.out.println(joinedString);

        List<String>stringList= Arrays.asList("this","is","easy","but","need","coding");
        System.out.println(String.join(",",stringList));

        StringJoiner joiner = new StringJoiner(",","[","]");
        stringList.stream().forEach(joiner::add);
        System.out.println(joiner);

        String joinedStr = stringList.stream()
                .collect(Collectors.joining(",","{","}"));

        System.out.println(joinedStr);

    }
}
