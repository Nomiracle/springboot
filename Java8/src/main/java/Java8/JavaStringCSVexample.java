package Java8;

import java.time.ZoneId;

public class JavaStringCSVexample {
    public static void main(String[] args) {
        String joined= String.join("/","user","local","bin");
        System.out.println(joined);
        String ids = String.join(",", ZoneId.getAvailableZoneIds());
        System.out.println(ids);
    }
}
