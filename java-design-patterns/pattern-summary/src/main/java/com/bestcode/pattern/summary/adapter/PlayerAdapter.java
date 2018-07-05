package com.bestcode.pattern.summary.adapter;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.07.05
 */
public class PlayerAdapter implements MusicPlayer {

    private ExistsPlayer existsPlayer;

    public PlayerAdapter(ExistsPlayer existsPlayer) {
        this.existsPlayer = existsPlayer;
    }

    @Override
    public void play(String type, String filename) {
        if ("mp3".equals(type)) {
            existsPlayer.playMp3(filename);
        } else if("wma".equals(type)) {
            existsPlayer.playWma(filename);
        }
    }
}
