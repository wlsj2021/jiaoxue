package com.wlsj2021.jiaoxue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;

@Route(path = "/app/activity")
public class WelActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wel);
        Toast.makeText(this, "在？？？？？？？？？？", Toast.LENGTH_SHORT).show();
    }
}
