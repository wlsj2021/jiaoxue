package com.wlsj2021.jiaoxue;


import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
//ARouter拦截器
@Interceptor(priority = 1, name = "TestInterceptor")
public class TestInterceptor implements IInterceptor {
    public static final String INTERCEPTOR = "/app/lj";
    Context mContext;

    private static final String TAG = "TestInterceptor";

    /**
     * The operation of this interceptor.
     *
     * @param postcard meta
     * @param callback cb
     */
    @Override
    public void process(final Postcard postcard, final InterceptorCallback callback) {
        String path = postcard.getPath();

        Toast.makeText(mContext, "!!!!!!!!", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "process: path=" + path);

        if (INTERCEPTOR.equals(postcard.getPath())) {
            Activity context = MainActivity.getWeakReference().get();
            if (context == null) {
                return;
            }

            Toast.makeText(context, "!!!!!!!!!!!!!", Toast.LENGTH_SHORT).show();
            final AlertDialog.Builder ab = new AlertDialog.Builder(context);
            ab.setCancelable(false);
            ab.setTitle("温馨提醒");
            ab.setMessage(String.format("想要跳转到ActivityOne么？(触发了%s拦截器，拦截了本次跳转)", INTERCEPTOR));
            ab.setNegativeButton("继续", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    callback.onContinue(postcard);
                }
            });
            ab.setNeutralButton("算了", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    callback.onInterrupt(null);
                }
            });
            ab.setPositiveButton("加点料", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    postcard.withString("extra", "我是在拦截器中附加的参数");
                    callback.onContinue(postcard);
                }
            });

            MainLooper.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    ab.create().show();
                }
            });
        } else {
            callback.onContinue(postcard);
        }
    }

    /**
     * Do your init work in this method, it well be call when processor has been load.
     *
     * @param context ctx
     */
    @Override
    public void init(Context context) {
        mContext = context;
        Log.e("testService", TestInterceptor.class.getName() + " has init.");
    }
}
