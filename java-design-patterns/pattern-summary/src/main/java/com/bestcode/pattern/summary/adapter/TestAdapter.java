package com.bestcode.pattern.summary.adapter;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.07.05
 */
public class TestAdapter {

    public static void main(String[] args) {
        MusicPlayer musicPlayer = new PlayerAdapter(new ExistsPlayer());
        musicPlayer.play("mp3", "apple.mp3");
    }
}
