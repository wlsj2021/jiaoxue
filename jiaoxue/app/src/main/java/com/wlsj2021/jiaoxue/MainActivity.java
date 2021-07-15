package com.wlsj2021.jiaoxue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                .withString("key3", "888")
//                .withObject("key4", new Test("Jack", "Rose"))
                .navigation();
    }
}