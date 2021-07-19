package com.wlsj2021.jiaoxue.presenter;

import com.wlsj2021.jiaoxue.OnRegisterListener;
import com.wlsj2021.jiaoxue.moudle.RegisterModel;
import com.wlsj2021.jiaoxue.moudle.RegisterModelImL;
import com.wlsj2021.jiaoxue.view.RegisterView;
//666666
public class RegisterPresenterImL implements RegisterPresenter, OnRegisterListener {
    private RegisterModel mRegisterModel;
    private RegisterView mRegisterView;

    public RegisterPresenterImL(RegisterView registerView) {
        this.mRegisterModel = new RegisterModelImL();
        this.mRegisterView = registerView;
    }

    @Override
    public void register() {

    }

    @Override
    public void registerSuccess() {
mRegisterView.Register();
mRegisterModel.Register("1111121231","342342","23423423433",this);
    }

    @Override
    public void register(String username, String password, String repassword) {
        mRegisterModel.Register(username,password,repassword,this);

    }

    @Override
    public void destroy() {

    }
}
