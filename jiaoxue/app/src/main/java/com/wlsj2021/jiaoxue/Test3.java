package com.wlsj2021.jiaoxue;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

////被注入的对象带参
@Module
public class Test3 {
@Provides
public Test2 test2(){
        return new Test2("1","2");
    }
}



