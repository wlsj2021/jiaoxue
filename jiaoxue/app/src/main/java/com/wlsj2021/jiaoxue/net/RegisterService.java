package com.wlsj2021.jiaoxue.net;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RegisterService {

    @POST("/user/register")
    Call<RegisterEntity.DataDTO>register
            (@Query("username") String username,
             @Query("password") String password,
             @Query("repassword") String repassword);


}
