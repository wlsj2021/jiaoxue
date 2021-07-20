package com.wlsj2021.jiaoxue.net;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import rx.Observable;

public interface CommonlyUsedWebService {
//观察者模式
//    @Headers({"Content-Type:application/json","charset=UTF-8"})
    @GET("/friend/{json}")
    //第二步
    Observable<CommonlyUsedEntity> getCommonlyUsedWeb(@Path("json")String json);

    //MVP+OKHttp3+Retrofit2+RXJAVA+RxPermissions+Rxlifecycle+Dagger2+ButterKnife+ARouter

}
