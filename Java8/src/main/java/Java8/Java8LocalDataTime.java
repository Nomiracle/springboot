package Java8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.TemporalAdjusters;

public class Java8LocalDataTime {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        LocalDate lastDate = localDate.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDate);

        Duration duration = Duration.between(instant,Instant.now());
        System.out.println(duration);
        System.out.println(Period.between(localDate,lastDate));

        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        System.out.println(offsetDateTime.toString());              //2013-05-15T10:10:37.257+05:30

        offsetDateTime = OffsetDateTime.now(ZoneId.of("+05:30"));
        System.out.println(offsetDateTime.toString());              //2013-05-15T10:10:37.258+05:30

        offsetDateTime = OffsetDateTime.now(ZoneId.of("+06:30"));
        System.out.println(offsetDateTime.toString());              //2013-05-14T22:10:37.258-06:30

        ZonedDateTime zonedDateTime =
                ZonedDateTime.now(ZoneId.of("Europe/Paris"));
        System.out.println(zonedDateTime.toString());

        System.out.println(ZoneId.systemDefault());
        ZonedDateTime zonedDateTime1 =
                ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(zonedDateTime1.toString());

        DateTimeFormatterBuilder formatterBuilder = new DateTimeFormatterBuilder();
        formatterBuilder.append(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
                .appendLiteral("-")
                .appendZoneOrOffsetId();
        DateTimeFormatter formatter = formatterBuilder.toFormatter();
        System.out.println(formatter.format(ZonedDateTime.now()));

    }
}
