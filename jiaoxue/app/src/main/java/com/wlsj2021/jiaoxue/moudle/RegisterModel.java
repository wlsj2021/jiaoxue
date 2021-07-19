package com.wlsj2021.jiaoxue.moudle;

import com.wlsj2021.jiaoxue.OnRegisterListener;
//33333
public interface RegisterModel {
    void Register(String username, String password, String repassword, OnRegisterListener onRegisterListener);
}
