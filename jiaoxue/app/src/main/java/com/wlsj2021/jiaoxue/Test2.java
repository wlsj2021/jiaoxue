package com.wlsj2021.jiaoxue;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides   ;

//被注入的对象带参
public class Test2 {
    private String agm1;
    private String agm2;
    public Test2(String agm1, String agm2) {
        this.agm1 = agm1;
        this.agm2 = agm2;
    }
}

