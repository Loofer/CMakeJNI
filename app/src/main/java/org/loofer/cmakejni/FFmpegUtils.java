package org.loofer.cmakejni;

/**
 * ============================================================
 * 版权： Loofer 版权所有（c）2018
 * <p>
 * 作者：Loofer
 * 版本：1.0
 * 创建日期 ：2018/7/7 23:12.
 * 描述：
 * <p>
 * 注:如果您修改了本类请填写以下内容作为记录，如非本人操作劳烦通知，谢谢！！！
 * Modified Date Modify Content:
 * <p>
 * ==========================================================
 */
public class FFmpegUtils {


    static {
        System.loadLibrary("libavutil.so");
        System.loadLibrary("libavcodec.so");
        System.loadLibrary("libavdevice.so");
        System.loadLibrary("libavfilter.so");
        System.loadLibrary("libavformat.so");
        System.loadLibrary("libpostproc.so");
        System.loadLibrary("libswresample.so");
        System.loadLibrary("libswscale.so");
        System.loadLibrary("testffmpeg.so");
    }

    public native void playMyMedia(String url);



}
