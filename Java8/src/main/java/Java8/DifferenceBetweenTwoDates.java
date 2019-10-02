package Java8;

import org.joda.time.*;
import org.joda.time.chrono.GregorianChronology;

import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.StringJoiner;

public class DifferenceBetweenTwoDates {
    public static void main(String[] args) {
       //---------------old------------------------------
        DateTime dateOfBirth = new DateTime(1998,7,4,0,0,
                GregorianChronology.getInstance());
        DateTime currentDate = new DateTime();
        Days diffInDays = Days.daysBetween(dateOfBirth,currentDate);
        Hours diffInHours = Hours.hoursBetween(dateOfBirth,currentDate);
        Minutes diffInMinus = Minutes.minutesBetween(dateOfBirth,currentDate);
        Seconds diffInSecond= Seconds.secondsBetween(dateOfBirth,currentDate);
        StringJoiner stringJoiner = new StringJoiner(",","[","]");
        stringJoiner.add(diffInDays.getDays()+"")
                .add(diffInHours.getHours()+"")
                .add(diffInMinus.getMinutes()+"")
                .add(diffInSecond.getSeconds()+"");
        System.out.println(stringJoiner);
        //----------------new----------------------------
        java.time.LocalDate endOfCentury
                = java.time.LocalDate
                .of(1998, Month.JULY,4);
        java.time.LocalDate now =java.time.LocalDate.now();
        java.time.Period diff
                = java.time.Period.between(endOfCentury,now);
        StringJoiner stringJoiner1
                = new StringJoiner(",","[","]");
        stringJoiner1.add(diff.toTotalMonths()+"")
                .add(diff.getMonths()+"")
                .add(diff.getYears()+"");
        System.out.println(stringJoiner1);



        java.time.LocalDateTime dateTime2
                =java.time.LocalDateTime
                .of(1998, Month.JULY,4,0,0,0);
        java.time.LocalDateTime now2
                = java.time.LocalDateTime.now();

        StringJoiner stringJoiner2 = new StringJoiner(",","[","]");
        stringJoiner2
                .add(ChronoUnit.DAYS.between(dateTime2,now2)+"")
                .add(ChronoUnit.MONTHS.between(dateTime2,now2)+"")
                .add(ChronoUnit.YEARS.between(dateTime2,now2)+"")
                .add(ChronoUnit.MINUTES.between(dateTime2,now2)+"")
                .add(ChronoUnit.NANOS.between(dateTime2,now2)+"");
        System.out.println(stringJoiner2);


        StringJoiner stringJoiner3 = new StringJoiner(",","[","]");
        stringJoiner3
                .add(java.time.Duration.between(dateTime2,now2).toDays()+"")
                .add(java.time.Duration.between(dateTime2,now2).toHours()+"")
                .add(java.time.Duration.between(dateTime2,now2).toMinutes()+"")
                .add(java.time.Duration.between(dateTime2,now2).toNanos()+"")
                .add(java.time.Duration.between(dateTime2,now2).toMillis()+"");
        System.out.println(stringJoiner3);


    }
}
