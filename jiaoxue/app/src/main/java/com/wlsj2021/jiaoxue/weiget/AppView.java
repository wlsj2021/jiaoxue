package com.wlsj2021.jiaoxue.weiget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.wlsj2021.jiaoxue.R;
//2步定义view
public class AppView extends androidx.appcompat.widget.AppCompatImageView {
    private String AppText = "非空";
    private int AppSize;
    private int AppColor;

    private Paint mPaint;
    private Rect mRect = new Rect();

    public AppView(Context context) {
        super(context,null);
    }
//3在第二个构造写
    public AppView(Context context,  AttributeSet attrs) {
        super(context, attrs,0);
        //4拿到属性
        @SuppressLint("Recycle") TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.AppView);
        AppText = typedArray.getString(R.styleable.AppView_appText);
        AppSize = typedArray.getDimensionPixelSize(R.styleable.AppView_appSize,100);
        AppColor = typedArray.getColor(R.styleable.AppView_appColor, Color.BLUE);

        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "我被点击了", Toast.LENGTH_SHORT).show();
            }
        });


    }
//不能映射到布局当中
    public AppView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


//确定view的位置
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

//6测量view的大小
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int height;
        int width;
        if (heightMode == MeasureSpec.EXACTLY){
             height = heightSize;
        } else{
            mPaint.setTextSize(AppSize);
            mPaint.getTextBounds(AppText,0,AppText.length(),mRect);
             float textHeight = mRect.height();
             int h = (int) (getPaddingTop()+textHeight+getPaddingBottom());
             height = h;

        }

        if (widthMode == MeasureSpec.EXACTLY){
            width = widthSize;
        }else
            mPaint.setTextSize(AppSize);
//        mPaint.getTextBounds(AppText,0,AppText.length(),mRect);
        float textWidth = mRect.width();
        int w = (int) (getPaddingLeft()+textWidth+getPaddingRight());
        width = w;

        }




//5绘制这个view
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //Canvas 画布
        mPaint = new Paint();
        mPaint.setAlpha(50);
        mPaint.setColor(AppColor);
        mPaint.setTextSize(AppSize);

//        canvas.drawCircle(getWidth()/2,getHeight()/2,100,mPaint);
        canvas.drawRect(getWidth()/2-100,getHeight()/2-100,getWidth()/2,getHeight()/2,mPaint);
        mPaint.setColor(Color.RED);
        canvas.drawText(AppText,15,18,getWidth()/2,getHeight()/2,mPaint);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }


}
