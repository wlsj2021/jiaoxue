package com.wlsj2021.jiaoxue;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.wlsj2021.jiaoxue.presenter.MsgPresenter;
import com.wlsj2021.jiaoxue.presenter.MsgPresenterImL;
import com.wlsj2021.jiaoxue.view.MsgView;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
//7 8
public class MainActivity extends AppCompatActivity implements MsgView {
    //4等编译完添加注入
//    @Inject
//    Test test;

    @Inject
    Test2 test2;
//8
    private MsgPresenter msgPresenter;


@SuppressLint("NonConstantResourceId")
@BindView(R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //5等编译完使用自动生成的注入Component
        DaggerTest2Component.create().inject(this);
//        DaggerTest2Component.create().inject(this);
//        DaggerTestComponent.create().inject(this);

//        Toast.makeText(this, "----------------"+test, Toast.LENGTH_SHORT).show();
        Log.e("TAG", "onCreate: "+test2,null );

        msgPresenter = new MsgPresenterImL(this);
    }
    static WeakReference<Activity> weakReference ;

    public static WeakReference<Activity> getWeakReference() {
        return weakReference;
    }

    @OnClick(R.id.button2)
    public void btn2(){
        button.setText("第一个按钮");
    }




    public void btn(View view) {
        ARouter.getInstance().build("/app/activity").withDouble("dou",8).navigation();
    }


    public void btn2(View view) {
        ARouter.getInstance().build("/app/activity")
                .withLong("name", 666L)
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

    @Override
    public void msg() {

    }
}