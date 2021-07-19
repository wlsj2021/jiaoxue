package com.wlsj2021.jiaoxue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.wlsj2021.jiaoxue.net.TestEntity;
import com.wlsj2021.jiaoxue.net.TestService;
import com.wlsj2021.jiaoxue.presenter.RegisterPresenter;
import com.wlsj2021.jiaoxue.presenter.RegisterPresenterImL;
import com.wlsj2021.jiaoxue.view.RegisterView;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TestActivity extends AppCompatActivity implements RegisterView {

    //77777
    private RegisterPresenter mRegisterPresenter;

    @BindView(R.id.username)
    EditText mUsername;

    @BindView(R.id.password)
    EditText mPassword;

    @BindView(R.id.repassword)
    EditText mRepassWord;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
        mRegisterPresenter = new RegisterPresenterImL(this);
        Register();

    }
//8888
    @Override
    public void Register() {
        String username = mUsername.getText().toString();
        String password = mPassword.getText().toString();
        String repassword = mRepassWord.getText().toString();
        mRegisterPresenter.register(username,password,repassword);

    }
}