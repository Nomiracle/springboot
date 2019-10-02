package Java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Java8ParseString2Date {
    public static void main(String[] args) {
        String armisticeDate = "2018-08-07";
        LocalDate ald = LocalDate.parse(armisticeDate);
        System.out.println(ald);

         armisticeDate = "2018-08-07T11:50";
        LocalDateTime ald1 = LocalDateTime.parse(armisticeDate);
        System.out.println(ald1);

        String anotherDate = "04 09 2016";

        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd MM yyyy");
        LocalDate random = LocalDate.parse(anotherDate, df);

        System.out.println(anotherDate + " parses as " + random);
    }
}
