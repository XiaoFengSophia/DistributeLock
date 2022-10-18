package com.zxf.util;

import ws.schild.jave.*;
import ws.schild.jave.encode.AudioAttributes;
import ws.schild.jave.encode.EncodingAttributes;
import ws.schild.jave.encode.VideoAttributes;
import java.io.File;

/**
 * @ClassName: VideoUtil
 * @Description: 视频工具
 * @author: 赵晓峰
 * @date: 2022/10/18 11:53 上午
 * @Blog: https://blog.csdn.net/Websphere_zxf
 */

public class VideoUtil {

    public static void main(String[] args) {
        VideoUtil.videoToVideo("/Users/zhaoxiaofeng/Downloads/test/1.mp4", "result.avi");
    }

    /**
     * 视频转码
     * @param videoSource
     * @param videoTarget
     * @return true or false
     */
    public static boolean videoToVideo(String videoSource, String videoTarget) {

        long start = System.currentTimeMillis();
        File source = new File(videoSource);
        File target = new File(videoTarget);

        AudioAttributes audio = new AudioAttributes();
        audio.setCodec("aac");
        audio.setBitRate(236000 / 2);
        audio.setChannels(2);
        audio.setSamplingRate(8000);

        VideoAttributes video = new VideoAttributes();
        video.setCodec("h264");
        video.setBitRate(1000000);
        video.setFrameRate(25);
        video.setQuality(4);
//        video.setSize(new VideoSize(720, 480));

        EncodingAttributes attrs = new EncodingAttributes();
        attrs.setOutputFormat("mp4");
        attrs.setAudioAttributes(audio);
        attrs.setVideoAttributes(video);

        MultimediaObject multimediaObject = new MultimediaObject(source);
        Encoder encoder = new Encoder();
        try {
            encoder.encode(multimediaObject, target, attrs);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(encoder.getUnhandledMessages());
            return false;
        } finally {
            long end = System.currentTimeMillis();
            System.out.println("总耗时：" + (end - start) + "ms");
        }
    }

}
