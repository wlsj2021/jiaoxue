package com.wlsj2021.jiaoxue;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;

import com.tbruyelle.rxpermissions.RxPermissions;
import com.trello.rxlifecycle.ActivityEvent;
import com.trello.rxlifecycle.components.RxActivity;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.wlsj2021.jiaoxue.net.CommonlyUsedEntity;
import com.wlsj2021.jiaoxue.net.CommonlyUsedWebService;

import java.io.IOException;
import java.security.acl.Permission;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

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
import rx.Observer;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class CommonlyUsedWebActivity extends RxAppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commonly_used_web);


        RxPermissions rxPermissions = new RxPermissions(this);
//      开启多个权限
//        rxPermissions.requestEach(Manifest.permission.ACCESS_NETWORK_STATE,
//                Manifest.permission.ACCESS_FINE_LOCATION,
//                Manifest.permission.ACCOUNT_MANAGER)
//                .subscribe(permission->{
//                    if (permission.granted){
//                     //要开启权限
//                }else if(permission.shouldShowRequestPermissionRationale){
//                        //不再提示
//                    }else {
//                         //去设置
//                    }
//        });

        //开启一个权限
        rxPermissions.request(Manifest.permission.ACCESS_NETWORK_STATE)
                .subscribe(granted -> {
                    if (granted) {

                    } else {

                    }
                });

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .callTimeout(100, TimeUnit.SECONDS)
                .connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100, TimeUnit.SECONDS)
                .writeTimeout(100, TimeUnit.SECONDS)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {

                        Request request = chain.request();
                        Request.Builder builder = request.newBuilder();
                        request = builder.addHeader("Content-Type", "application/json,charset=UTF-8")
                                .post(RequestBody.create(MediaType.parse("application/json;charset=UTF-8"),
                                        bodyToString(request.body())
                                )).build();


                        return chain.proceed(request);
                    }
                })
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.wanandroid.com")
                .addConverterFactory(GsonConverterFactory.create())
                //第一步 添加到工厂
                //观察者模式
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        CommonlyUsedWebService commonlyUsedWebService = retrofit.create(CommonlyUsedWebService.class);


        //第三步
        commonlyUsedWebService
                .getCommonlyUsedWeb("json")
//                .compose(this.bindToLifecycle())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Subscriber<CommonlyUsedEntity>() {
                    @Override
                    public void onCompleted() {
                        Log.e("TAG", "onCompleted:连接 ", null);

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        Log.e("TAG", "onError:请求失败 " + e, null);
                    }

                    @Override
                    public void onNext(CommonlyUsedEntity commonlyUsedEntity) {
                        Log.e("TAG", "onNext:请求成功 " + commonlyUsedEntity, null);

                    }
                });

//
//        Call<CommonlyUsedEntity>commonlyUsedEntityCall = commonlyUsedWebService.getCommonlyUsedWeb();
//
//        commonlyUsedEntityCall.enqueue(new Callback<CommonlyUsedEntity>() {
//            @Override
//            public void onResponse(Call<CommonlyUsedEntity> call, Response<CommonlyUsedEntity> response) {
//
//                Log.e("TAG", "onResponse: "+response, null);
//            }
//
//            @Override
//            public void onFailure(Call<CommonlyUsedEntity> call, Throwable t) {
//                t.printStackTrace();
//
//            }
//        });

        Observable.interval(1, TimeUnit.SECONDS)
                .compose(this.bindToLifecycle())
                .subscribe(new Action1
                        <Object>() {
                    @Override
                    public void call(Object o) {

                    }
                });


    }


    @Override
    protected void onPause() {
        super.onPause();
        Observable.interval(1, TimeUnit.SECONDS)
                .compose(this.bindUntilEvent(ActivityEvent.PAUSE))
                .subscribe();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Observable.interval(1, TimeUnit.SECONDS)
                .compose(this.bindUntilEvent(ActivityEvent.STOP))
                .subscribe();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Observable.interval(1, TimeUnit.SECONDS)
                .compose(this.bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe();


    }

    private static String bodyToString(final RequestBody requestBody) {

        try {
            final RequestBody copy = requestBody;
            final Buffer buffer = new Buffer();
            if (copy != null)
                copy.writeTo(buffer);
            else
                return "";
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "xxx";
        }
    }

}