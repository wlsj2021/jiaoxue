package com.wlsj2021.jiaoxue.net;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import rx.Observable;
//password,repassword

//80%
//post
//1 json?
//2 k,v
//a-Z 对称 MD5


//get




public interface TestService {
    @POST("/user/register")
    Call<TestEntity.DataDTO> register(
            @Query("username") String username
            ,@Query("password") String password
            ,@Query("repassword") String repassword
    );
}
