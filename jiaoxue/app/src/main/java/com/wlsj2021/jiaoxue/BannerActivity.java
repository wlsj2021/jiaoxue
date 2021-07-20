package com.wlsj2021.jiaoxue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.wlsj2021.jiaoxue.net.BannerEntity;
import com.wlsj2021.jiaoxue.net.BannerService;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class BannerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);
        getBanner();
    }

    private void getBanner() {
        //配置网络相关
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .callTimeout(100,TimeUnit.SECONDS)
                .build();
//                .addInterceptor(new Interceptor() {
//                    @Override
//                    public Response intercept(Chain chain) throws IOException {
//                        //添加头信息
//                        return null;
//                    }
//                }).build();
//
//        OkHttpClient okHttpClient =
//                new OkHttpClient.Builder()
//                        //连接超时啥的就是OKHTTP那些设置
//                        .connectTimeout(100, TimeUnit.SECONDS)
//                        .writeTimeout(100, TimeUnit.SECONDS)
//                        .readTimeout(100, TimeUnit.SECONDS)
//                        //添加拦截器 完成添加获取   @Headers 信息 这里是获取
//                        // @Headers({"Content_Type:application/json", "charset:UTF-8"})
//                        //LogInterceptor 得到header 这里是得到的输出信息
//                        //json在 body
//                        //编码格式 登录状态 header
//                        .addInterceptor(new Interceptor() {
//                            @Override
//                            public Response intercept(Chain chain) throws IOException {
//                                Request originalRequest = chain.request();
//                                //第二种添加deader的方式 在okhttp的客户端里添加拦截器 在拦截器里添加头信息
//                                Request.Builder requestBuilder = originalRequest.newBuilder();
//                                originalRequest = requestBuilder.addHeader("Content-Type", "application/json;charset=UTF-8")
//                                        .post(RequestBody.create(MediaType.parse("application/json;charset=UTF-8"),
//                                                bodyToString(originalRequest.body())))//关键部分，设置requestBody的编码格式为json
//                                        .build();
//                                return chain.proceed(originalRequest);
//
//                            }
//                        }).build();
//实例化retrofit
        Retrofit retrofit =
                new Retrofit.Builder()
                        .baseUrl("https://www.wanandroid.com")
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .client(okHttpClient)
                        .build();
        //把接口的类的定义传递进retrofit
        BannerService bannerService = retrofit.create(BannerService.class);


        bannerService.getBanner().subscribeOn(Schedulers.newThread()).subscribe(new Subscriber<BannerEntity>() {
            @Override
            public void onCompleted() {
                Log.e("TAG", "onNext:请求 ", null);

            }

            @Override
            public void onError(Throwable e) {
e.printStackTrace();
                Log.e("TAG", "onError:请求失败 "+e, null);

            }

            @Override
            public void onNext(BannerEntity bannerEntity) {
                Log.e("TAG", "onNext:请求成功 "+bannerEntity, null);
            //请求成功
            }
        });

//
//        Observable.interval(1, TimeUnit.SECONDS)
//
//                .compose(this.bindToLifecycle())
//
//                .subscribe(new Action1<Long>() {
//
//                    @Override
//
//                    public void call(Long num) {
//
//                    }
//
//                });


//        Observable<BannerEntity> callBanner = bannerService.getBanner();
//
//        callBanner.enqueue(new Callback<BannerEntity>() {
//            @Override
//            public void onResponse(Call<BannerEntity> call, retrofit2.Response<BannerEntity> response) {
//                Log.e("TAG", "onResponse: 成功"+response.body().getData(), null);
////                Gson gson = new Gson();
//            }
//
//            @Override
//            public void onFailure(Call<BannerEntity> call, Throwable t) {
//
//            }
//        });


    }
    private static String bodyToString(final RequestBody request) {
        try {
            final RequestBody copy = request;
            final Buffer buffer = new Buffer();
            if (copy != null)
                copy.writeTo(buffer);
            else
                return "";
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "did not work";
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();


//
//        //解绑Observable
//        Observable.interval(1,TimeUnit.SECONDS)
//
//                .compose(this.bindUntilEvent(ActivityEvent.PAUSE))
//
//                .subscribe();
//
    }
}