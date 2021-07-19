package com.wlsj2021.jiaoxue.moudle;

import com.wlsj2021.jiaoxue.MsgListener;
//3
public interface MsgModel {
    void Login(String username,String password,String repassword, MsgListener msgListener);
}
