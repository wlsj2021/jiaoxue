package com.wlsj2021.jiaoxue;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    static WeakReference<Activity> weakReference ;

    public static WeakReference<Activity> getWeakReference() {
        return weakReference;
    }

    public void btn(View view) {
        ARouter.getInstance().build("/app/activity").navigation(this, new NavigationCallback() {
            @Override
            public void onFound(Postcard postcard) {
                Log.e("111111", "onFound: "+postcard+"成功",null );
            }

            @Override
            public void onLost(Postcard postcard) {
                Log.e("22222", "onFound: "+postcard+"失败",null );

            }

            @Override
            public void onArrival(Postcard postcard) {
                Log.e("33333", "onFound: "+postcard,null );

            }

            @Override
            public void onInterrupt(Postcard postcard) {
                Log.e("44444", "onFound: "+postcard,null );

            }
        });
    }

    public void btn2(View view) {
        ARouter.getInstance().build("/app/activity")
                .withLong("key1", 666L)
                .withString("key3", "88888888888888888888")
//                .withObject("key4", new Test("Jack", "Rose"))
                .navigation(this, new NavigationCallback() {
                    @Override
                    public void onFound(Postcard postcard) {
                        Log.e("55555", "onFound: "+postcard,null );

                    }

                    @Override
                    public void onLost(Postcard postcard) {

                    }

                    @Override
                    public void onArrival(Postcard postcard) {

                    }

                    @Override
                    public void onInterrupt(Postcard postcard) {

                    }
                });
    }
//greenChannel().
    public void btn3(View view) {
    ARouter.getInstance().build("/app/lj").navigation(this, new NavigationCallback() {
        @Override
        public void onFound(Postcard postcard) {
        }

        @Override
        public void onLost(Postcard postcard) {
            Log.e("TAG", "onFound: "+postcard,null );

        }

        @Override
        public void onArrival(Postcard postcard) {

        }

        @Override
        public void onInterrupt(Postcard postcard) {

        }
    });
    }
}