package com.wlsj2021.jiaoxue.moudle;

import android.util.Log;

import com.wlsj2021.jiaoxue.MsgListener;
import com.wlsj2021.jiaoxue.net.RegisterEntity;
import com.wlsj2021.jiaoxue.net.RegisterService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//4
public class MsgModeImL implements MsgModel {



    @Override
    public void Login(String username, String password, String repassword, MsgListener msgListener) {
        //网络
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.wanandroid.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RegisterService registerService = retrofit.create(RegisterService.class);
        Call<RegisterEntity.DataDTO> dddddd65465 = registerService.register(username, password, repassword);
        dddddd65465.enqueue(new Callback<RegisterEntity.DataDTO>() {
            @Override
            public void onResponse(Call<RegisterEntity.DataDTO> call, Response<RegisterEntity.DataDTO> response) {


                assert response.body() != null;
                String id = response.body().getUsername();
                Log.e("TAG", "onResponse: "+id, null);

                Log.e("TAG", "onResponse: "+response.body().toString(), null);

                Log.e("TAG", "onResponse:"+"注册成功", null);
            }

            @Override
            public void onFailure(Call<RegisterEntity.DataDTO> call, Throwable t) {
t.printStackTrace();
            }
        });

    }
}
