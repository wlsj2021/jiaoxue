package com.wlsj2021.jiaoxue.moudle;

import com.wlsj2021.jiaoxue.MsgListener;
//3
public interface MsgModel {
    void sendMsg(String msg, MsgListener msgListener);
}
