package com.bestcode.pattern.summary.adapter;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.07.05
 */
public interface MusicPlayer {

    /**
     * 播放音乐
     * @param type 音乐格式
     * @param filename  文件
     */
    void play(String type, String filename);
}
