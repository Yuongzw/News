package com.news.yuong.news.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Util {
    public static String getDateToString(String time, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        @SuppressWarnings("unused")
        long lcc = Long.valueOf(time);
        int i = Integer.parseInt(time);
        String times = format.format(new Date(i * 1000L));
        return times;
    }

    //获取视频第一帧
    public static Bitmap getNetVideoBitmap(String videoUrl) {
        Bitmap bitmap = null;
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        try {
            //根据url获取缩略图
            retriever.setDataSource(videoUrl, new HashMap());
            //获得第一帧图片
            bitmap = retriever.getFrameAtTime();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } finally {
            retriever.release();
        }
        return bitmap;
    }

    /**
     * 获取屏幕高度(px)
     */
    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }
    /**
     * 获取屏幕宽度(px)
     */
    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int dip2px(float dpValue, Context context) {
        return (int) (dpValue * getDensity(context) + 0.5f);
    }

    public static float getDensity(Context context) {
        float density = -1f;
        if (density < 0) {
            return context.getResources().getDisplayMetrics().density;
        }
        return 0;
    }

}
