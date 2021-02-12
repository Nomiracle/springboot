package test;

import org.springframework.util.DigestUtils;

public class test4 {
    public static void main(String[] args) {
        byte[] origin = {(byte)0x75,(byte)0xF4,(byte)0x94,(byte)0xAD};


        byte[] output =  DigestUtils.md5Digest(origin);

        for (byte b : output){
            int res = b & 0xFF;
            System.out.print(Integer.toHexString(res)+" ");
        }

    }
}
