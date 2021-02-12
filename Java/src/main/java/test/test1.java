package test;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class test1 {
    public static void main(String[] args) {
        String i = ""+null;
        byte[] tmp = i.getBytes();
        System.out.println(ToStringBuilder.reflectionToString(tmp));
        String b = null;
        byte[] tmp2 = b.getBytes();
        System.out.println(ToStringBuilder.reflectionToString(tmp2));
    }
}
