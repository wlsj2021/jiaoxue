package com.wlsj2021.jiaoxue.presenter;

import com.wlsj2021.jiaoxue.MsgListener;
import com.wlsj2021.jiaoxue.moudle.MsgModeImL;
import com.wlsj2021.jiaoxue.moudle.MsgModel;
import com.wlsj2021.jiaoxue.view.MsgView;

public class MsgPresenterImL implements MsgPresenter, MsgListener {
    //6
    private MsgView msgView;
    private MsgModel msgModel;

    public MsgPresenterImL(MsgView msgView){
        this.msgView = msgView;
        this.msgModel = new MsgModeImL();

    }

    @Override
    public void sendMsg() {
        msgView.msg("dd");
        msgModel.sendMsg("ddd",this);
    }

    @Override
    public void success() {

    }

    @Override
    public void error() {

    }

    @Override
    public void sendMsg(String msg) {

    }

    @Override
    public void onDestroy() {

    }
}
