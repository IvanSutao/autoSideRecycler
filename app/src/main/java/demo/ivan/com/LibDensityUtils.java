package demo.ivan.com;

/**
 * Copyright (C), 2018-2018, 912租房网
 * Author: 张一帆
 * Date: 2018/4/19 0019 下午 12:38
 * Description: 屏幕、尺寸、view相关工具类
 */

public class LibDensityUtils {

    public static int dp2px(float dpValue) {
        final float scale = LibFrame.getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int px2dp(float pxValue) {
        final float scale = LibFrame.getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * sp转px
     *
     * @param spValue sp值
     * @return px值
     */
    public static int sp2px(float spValue) {
        final float fontScale = LibFrame.getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * px转sp
     *
     * @param pxValue px值
     * @return sp值
     */
    public static int px2sp( float pxValue) {
        final float fontScale = LibFrame.getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 获取屏幕的宽度
     * @return
     */
    public static int getScreenWidth() {
        return LibFrame.getDisplayMetrics().widthPixels;
    }

    /**
     * 获取屏幕的高度
     * @return
     */
    public static int getScreenHeight() {
        return LibFrame.getDisplayMetrics().heightPixels;
    }
}
