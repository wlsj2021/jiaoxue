package com.wlsj2021.common;

import android.app.Application;
import android.content.res.Configuration;

import androidx.annotation.NonNull;

import com.alibaba.android.arouter.launcher.ARouter;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
//        if (isDebug()) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
//            ARouter.openLog();     // 打印日志
//            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
//        }

        ARouter.openDebug();
        ARouter.openLog();
        //ARouter第三步
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
