package com.wlsj2021.jiaoxue;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.tbruyelle.rxpermissions.RxPermissions;
import com.trello.rxlifecycle.ActivityEvent;
import com.trello.rxlifecycle.components.RxActivity;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.wlsj2021.jiaoxue.net.CommonlyUsedEntity;
import com.wlsj2021.jiaoxue.net.CommonlyUsedWebService;
import com.wlsj2021.jiaoxue.weiget.AppView;

import java.io.IOException;
import java.security.acl.Permission;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import butterknife.BindView;
import butterknife.ButterKnife;
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

    @BindView(R.id.app_view)
    AppView mAppView;

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commonly_used_web);
        ButterKnife.bind(this);

//帧动画
        AnimationDrawable animationDrawable = new AnimationDrawable();
//        animationDrawable.addFrame(getResources().getDrawable(R.drawable.ic_launcher_background),100);
//        animationDrawable.addFrame(getResources().getDrawable(R.drawable.ic_launcher_foreground),100);
//        animationDrawable.addFrame(getResources().getDrawable(R.drawable.ic_launcher_background),100);
//        animationDrawable.addFrame(getResources().getDrawable(R.drawable.ic_launcher_background),100);
//        animationDrawable.addFrame(getResources().getDrawable(R.drawable.ic_launcher_background),100);
//        animationDrawable.addFrame(getResources().getDrawable(R.drawable.ic_launcher_background),100);
//        animationDrawable.addFrame(getResources().getDrawable(R.drawable.ic_launcher_background),100);
        animationDrawable.setOneShot(false);
        mAppView.setImageDrawable(animationDrawable);
//        animationDrawable.start();

//补间动画 透明 位移 旋转 缩放
        //补间动画透明度
        AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
        alphaAnimation.setRepeatCount(10);
        alphaAnimation.setDuration(1000);
//        mImageView.setAnimation(alphaAnimation);
        //差值器 改变动画的运动状态
        //估值器 改变动画的运动值
        alphaAnimation.setInterpolator(new BounceInterpolator());
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.e("TAG", "onAnimationStart: ",null );
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.e("TAG", "onAnimationEnd: ", null);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Log.e("TAG", "onAnimationRepeat: ", null);

            }
        });
//        alphaAnimation.start();
        //补间动画平移

        TranslateAnimation translateAnimation = new TranslateAnimation(1,100,3,100);
        translateAnimation.setDuration(2000);
        translateAnimation.setRepeatCount(5);
        translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
//        mImageView.setAnimation(translateAnimation);
//        translateAnimation.start();
//        mImageView.setVisibility(View.INVISIBLE);
        //补间动画旋转

        RotateAnimation rotateAnimation = new RotateAnimation(0,180,Animation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setDuration(2000);
        rotateAnimation.setRepeatCount(5);
        rotateAnimation.setInterpolator(new BounceInterpolator());
//        mImageView.setAnimation(rotateAnimation);
//        rotateAnimation.start();

        //补间动画缩放

        ScaleAnimation scaleAnimation = new ScaleAnimation(1,10,3,10,Animation.ABSOLUTE,0.5f,Animation.ABSOLUTE,0.5f);
        scaleAnimation.setDuration(2000);
        scaleAnimation.setRepeatCount(5);
        scaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
//        mImageView.setAnimation(scaleAnimation);
//        scaleAnimation.start();


        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setDuration(5000);
        //补间动画透明度
        animationSet.addAnimation(alphaAnimation);
        //补间动画缩放
        animationSet.addAnimation(scaleAnimation);
        //补间动画平移
        animationSet.addAnimation(translateAnimation);
        //补间动画旋转
        animationSet.addAnimation(rotateAnimation);
        animationSet.setInterpolator(new BounceInterpolator());
//        mImageView.setAnimation(animationSet);
//        animationSet.start();
//ARGB
        //Alpha Red Green Blue  ARGB8888 ARGB4444  RGB565
//属性动画 valueAnimator
        //透明
        ObjectAnimator alphaObjectAnimator = ObjectAnimator.ofFloat(mAppView,"alpha",1f,0f,1f,0f,0.5f,1f,0.7f,0.3f);
        alphaObjectAnimator.setInterpolator(new BounceInterpolator());
        alphaObjectAnimator.setDuration(10000);
//        alphaObjectAnimator.start();
        //缩放
        ObjectAnimator scaleObjectAnimator = ObjectAnimator.ofFloat(mAppView,"scaleY",1f,3f,6f,2f,1f,6f);
        scaleObjectAnimator.setDuration(10000);
//        scaleObjectAnimator.start();
        //平移
        ObjectAnimator translationObjectAnimator = ObjectAnimator.ofFloat(mAppView,"translationY",0,100,0,-100,50.0f,-100);
        translationObjectAnimator.setInterpolator(new BounceInterpolator());
        translationObjectAnimator.setDuration(10000);
//        translationObjectAnimator.start();
        //旋转
        ObjectAnimator rotationObjectAnimator = ObjectAnimator.ofFloat(mAppView,"rotation",0,150,-90,360,180,-360);
        rotationObjectAnimator.setDuration(10000);
//        rotationObjectAnimator.start();

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(10000);
        animatorSet.setInterpolator(new BounceInterpolator());
//        animatorSet.playTogether(
//                alphaObjectAnimator,
//                scaleObjectAnimator,
//                translationObjectAnimator,
//                rotationObjectAnimator
//        );
        animatorSet.play(alphaObjectAnimator).before(scaleObjectAnimator).after(rotationObjectAnimator).with(translationObjectAnimator);
        animatorSet.start();




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