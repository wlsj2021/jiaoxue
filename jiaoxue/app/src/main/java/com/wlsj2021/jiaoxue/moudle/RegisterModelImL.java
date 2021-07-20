package com.wlsj2021.jiaoxue.moudle;

import android.util.Log;

import com.wlsj2021.jiaoxue.OnRegisterListener;
import com.wlsj2021.jiaoxue.net.TestEntity;
import com.wlsj2021.jiaoxue.net.TestService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

//4444444
public class RegisterModelImL implements RegisterModel {
    @Override
    public void Register(String username, String password, String repassword, OnRegisterListener onRegisterListener) {

        Retrofit retrofit
                =new Retrofit.Builder()
                .baseUrl("https://www.wanandroid.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        TestService testService = retrofit.create(TestService.class);



























//        testService.register(username,password,repassword)
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(Schedulers.io())
//                .doOnNext(new Action1<TestEntity.DataDTO>() {
//                    @Override
//                    public void call(TestEntity.DataDTO dataDTO) {
//                        //
//                    }
//                }).observeOn(AndroidSchedulers.mainThread()).subscribeOn(new Subscriber<TestEntity>())
//
//
//
//
//
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
