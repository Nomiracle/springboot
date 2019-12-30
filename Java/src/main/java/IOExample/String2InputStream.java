package IOExample;

import org.apache.commons.io.IOUtils;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class String2InputStream {
    //1) Using ByteArrayInputStream to convert String to InputStream
    static InputStream usingByteArrayInputStream(String str) {
        System.out.print("IOExample.String2InputStream.usingByteArrayInputStream:");
        return new ByteArrayInputStream(
                str.getBytes()
        );
    }

    //2)IOUtils from Apache Commons
    static InputStream usingIOUtils(String str) {
        System.out.print("IOExample.String2InputStream.usingIOUtils:");
        return IOUtils.toInputStream(str);
    }

}
