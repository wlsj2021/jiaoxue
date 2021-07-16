package com.wlsj2021.jiaoxue;

import dagger.Component;

@Component(modules = Test3.class)
public interface Test2Component {
    void inject(MainActivity mainActivity);
}
