package Java8;

import org.apache.commons.lang3.StringUtils;

public class JoinStringArray {
    public static void main(String[] args) {
        String[] strArray = { "How", "To", "Do", "In", "Java" };

        String joinedString = StringUtils.join(strArray);
        System.out.println(joinedString);

        String joinedString2 = StringUtils.join(strArray, ", ");
        System.out.println(joinedString2);


    }
}
