package com.wlsj2021.jiaoxue.presenter;
//555555
public interface RegisterPresenter {
    void register(String username,String password,String repassword);
    //回收一些view
    void destroy();
}
