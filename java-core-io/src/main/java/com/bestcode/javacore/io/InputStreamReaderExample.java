package com.bestcode.javacore.io;

import java.io.UnsupportedEncodingException;

/**
 * 字符流demo
 *
 * @author xch
 * @create 2018-04-11 23:04
 **/
public class InputStreamReaderExample {

    public String encoding = "UTF-8";

    public byte[] encoding(String str) throws UnsupportedEncodingException {
        byte[] bytes = str.getBytes(encoding);
        System.out.println("length:" + bytes.length);
        return bytes;
    }

    public void decoding(byte[] bytes) throws UnsupportedEncodingException {
        String str = new String(bytes, encoding);
        System.out.println(str);
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }
}
