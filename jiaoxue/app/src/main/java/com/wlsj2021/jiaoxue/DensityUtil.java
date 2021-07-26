package com.wlsj2021.jiaoxue;

import android.app.Activity;
import android.content.Context;
import android.view.WindowManager;
import android.widget.Toast;

public class DensityUtil {

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 获取屏幕高度
     *
     * @param activity
     * @return
     */
    public static int getDeviceHeight(Activity activity) {
        WindowManager wm = activity.getWindowManager();

        int height = wm.getDefaultDisplay().getHeight();
        return height;
    }

    /**
     * 获取屏幕款度
     *
     * @param activity
     * @return
     */
    public static int getDeviceWidth(Activity activity) {
        WindowManager wm = activity.getWindowManager();

        int width = wm.getDefaultDisplay().getWidth();
        return width;
    }

    /**
     * 字号转换
     *
     * @param context
     * @param pxValue
     * @return
     */
    public static int px2sp(Context context, float pxValue) {

        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;

        Toast.makeText(context, fontScale + "", Toast.LENGTH_SHORT).show();

        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 字号转换
     *
     * @param context
     * @param pxValue
     * @return
     */
    public static int sp2px(Context context, float pxValue) {

        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;

        return (int) (pxValue * fontScale + 0.5f);
    }

}