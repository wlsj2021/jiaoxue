package com.wlsj2021.jiaoxue;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.wlsj2021.jiaoxue.net.RegisterEntity;
import com.wlsj2021.jiaoxue.net.RegisterService;
import com.wlsj2021.jiaoxue.presenter.MsgPresenter;
import com.wlsj2021.jiaoxue.presenter.MsgPresenterImL;
import com.wlsj2021.jiaoxue.view.MsgView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//注册
public class RegisterActivity extends AppCompatActivity implements MsgView {
private String username = "aaala11111151";
private String passWord  = "123465789";
private String repassWord="123456789";
private MsgPresenter mMsgPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_acitivity);

       mMsgPresenter = new MsgPresenterImL(this);
        msg();
    }

    @Override
    public void msg() {
        mMsgPresenter.login(username,passWord,repassWord);
    }
}