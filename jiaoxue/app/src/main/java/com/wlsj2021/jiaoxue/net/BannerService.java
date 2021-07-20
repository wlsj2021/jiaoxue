package com.wlsj2021.jiaoxue.net;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import rx.Observable;

//1建实体类 2创建Service
//body data
//headers 需要长期持有的
public interface BannerService {
//    @Headers("???")
//    @GET("/{lll}/json")
//    Call<BannerEntity>getBanner(@Path("lll")String banner );


    @GET("/banner/json")
    Observable<BannerEntity> getBanner();
}
