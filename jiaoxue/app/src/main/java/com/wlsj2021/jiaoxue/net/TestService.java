package com.wlsj2021.jiaoxue.net;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;
//password,repassword
public interface TestService {
    @POST("/user/register")
    Call<TestEntity.DataDTO>register(
            @Query("username")String username
            ,@Query("password")String password
            ,@Query("repassword")String repassword
    );
}
