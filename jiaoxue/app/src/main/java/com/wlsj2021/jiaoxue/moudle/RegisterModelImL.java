package com.wlsj2021.jiaoxue.moudle;

import android.util.Log;

import com.wlsj2021.jiaoxue.OnRegisterListener;
import com.wlsj2021.jiaoxue.net.TestEntity;
import com.wlsj2021.jiaoxue.net.TestService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
//4444444
public class RegisterModelImL implements RegisterModel {
    @Override
    public void Register(String username, String password, String repassword, OnRegisterListener onRegisterListener) {

        Retrofit retrofit
                =new Retrofit.Builder()
                .baseUrl("https://www.wanandroid.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TestService testService = retrofit.create(TestService.class);

        Call<TestEntity.DataDTO> call =testService.register(username,password,repassword);

        call.enqueue(new Callback<TestEntity.DataDTO>() {
            @Override
            public void onResponse(Call<TestEntity.DataDTO> call, Response<TestEntity.DataDTO> response) {
                response.body().getNickname();
                Log.e("TAG", "onResponse:注册成功，请登录 "+response, null);

            }

            @Override
            public void onFailure(Call<TestEntity.DataDTO> call, Throwable t) {
                Log.e("TAG", "onResponse:注册失败 ", null);

                t.printStackTrace();
            }
        });
    }
}
