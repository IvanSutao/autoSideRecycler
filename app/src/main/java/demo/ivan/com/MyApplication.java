package demo.ivan.com;

import android.app.Application;

/**
 * Copyright (C), 2018-2018, 912租房网
 * Author: 张一帆
 * Date: 2018/8/22 0022 下午 2:40
 * Description:
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LibFrame.init(getApplicationContext());
    }
}
