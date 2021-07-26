package com.wlsj2021.jiaoxue;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.style.TtsSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.github.chrisbanes.photoview.PhotoView;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Test3Activity extends AppCompatActivity {
//    @BindView(R.id.photo_view)
//  private  PhotoView mPhotoView;

    private ImageView mImageView;

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test3_actvity);
//        ButterKnife.bind(this);
//        mPhotoView=findViewById(R.id.photo_view);

//        mPhotoView.setImageResource(R.drawable.ic_baseline_bug_report_24);

        mImageView = findViewById(R.id.btn_show);




//timePickerView.isDialog();



//        mImageView = findViewById(R.id.image_svg);
//        mImageView.setImageDrawable(getDrawable(R.drawable.svg_anim));
//        mImageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final Drawable drawable = mImageView.getDrawable();
//                if (drawable instanceof Animatable){
//                    ((Animatable) drawable).start();
//                }
//            }
//        });

//        AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) mImageView.getDrawable();
//        animatedVectorDrawable.start();
    }

    public void btn_show(View view) {
        TimePickerView timePickerView = new TimePickerBuilder(this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {

                Toast.makeText(Test3Activity.this, "???"+date, Toast.LENGTH_SHORT).show();


            }


        })

                .setCancelColor(Color.RED)
                .build();

        timePickerView.show();

    }
}