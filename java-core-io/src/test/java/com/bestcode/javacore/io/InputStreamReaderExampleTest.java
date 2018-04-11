package com.bestcode.javacore.io;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.junit.Before;
import org.junit.Test;

public class InputStreamReaderExampleTest {

    private InputStreamReaderExample example ;

    @Before
    public void init() {
        example = new InputStreamReaderExample();
    }

    @Test
    public void encoding() throws UnsupportedEncodingException {
        example.encoding("夏");

        example.setEncoding("GBK");
        example.encoding("夏");
    }

    @Test
    public void decoding() {
    }
}