package com.wlsj2021.jiaoxue;

public interface MsgListener {
//1
    void sendMsg();
    void success();
    void error();
}
