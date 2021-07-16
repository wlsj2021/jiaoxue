package com.wlsj2021.jiaoxue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = "/app/activity")
public class WelActivity extends AppCompatActivity {
    //接收第一步
    @Autowired
    String key3;

    @Autowired
    Double dou;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wel);
        //接收第二步
        ARouter.getInstance().inject(this);

        Toast.makeText(this, "在？？？？？？？？？？------------- "+key3+dou, Toast.LENGTH_SHORT).show();
    }
}
