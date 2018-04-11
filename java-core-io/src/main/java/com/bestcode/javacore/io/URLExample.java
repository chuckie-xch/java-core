package com.bestcode.javacore.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 从url中读取字节流数据
 *
 * @author xch
 * @create 2018-04-11 23:22
 **/
public class URLExample {

    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.baidu.com");
        try (InputStream is = url.openStream();
             InputStreamReader isr = new InputStreamReader(is, "UTF-8");
             BufferedReader br = new BufferedReader(isr)) {
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        }

    }
}
