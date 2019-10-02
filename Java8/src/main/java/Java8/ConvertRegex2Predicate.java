package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ConvertRegex2Predicate {
    public static void main(String[] args) {
        List<String>emails= Arrays.asList("alex@example.com","bob@yahoo.com","cata@example.com");
        Pattern pattern= Pattern.compile("^(.+)@example.com");
//---------------------new-------------------------------------------
        Predicate<String>emailFilter = pattern.asPredicate();
        List<String>desiredEmails=emails.stream().filter(emailFilter).collect(Collectors.<String>toList());
        StringJoiner stringJoiner = new StringJoiner(",","[new method :","]");
        desiredEmails.forEach(stringJoiner::add);
        System.out.println(stringJoiner);


//----------------------old------------------------------------------
        for(String email:emails){
            Matcher matcher = pattern.matcher(email);
            if(matcher.matches()){
                System.out.println(email);
            }
        }
    }
}
