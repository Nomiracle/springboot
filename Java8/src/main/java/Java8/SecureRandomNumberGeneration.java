package Java8;

import org.apache.commons.lang3.ArrayUtils;

import java.io.ByteArrayInputStream;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.StringJoiner;
import java.util.stream.Stream;

public class SecureRandomNumberGeneration {
    public static void main(String[] args) throws
            NoSuchAlgorithmException, NoSuchProviderException {
        SecureRandom secureRandom
                =SecureRandom.getInstance("SHA1PRNG","SUN");
        byte[] randomBytes=new byte[128];
        secureRandom.nextBytes(randomBytes);
        int r = secureRandom.nextInt();
        int randInRange=secureRandom.nextInt(999);
        StringJoiner sj = new StringJoiner(",","[","]");


        Byte[] bts = ArrayUtils.toObject(randomBytes);
        StringBuilder str=new StringBuilder();
        Stream<Byte>bs = Stream.of(bts);
        bs.forEach(b->str.append(b));

        sj.add(str.toString())
                .add(r+"")
                .add(randInRange+"");
        System.out.println(sj);

    }
}
