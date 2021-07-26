package com.wlsj2021.jiaoxue;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;

/**
 * 需求：一个ViewGroup中有多个控件，类似于常见的底部Tab布局，这几个子布局之间既可以点击切换，也可以左右滑动切换
 *
 * 实现：自定义父控件，在onInterceptTouchEvent方法中判断是否点击还是滑动，如果判断是点击，则直接交给child来响应点击事件去；如果是滑动，则
 *
 * 拦截事件，并通过回调传递给调用者处理。
 *
 * 优点：该控件只对触摸事件的分发做了相应处理，适用于各种滑动与点击冲突的情况....
 *
 * 使用：直接将该控件作为父布局即可，通过setmSetOnSlideListener回调处理对应滑动事件
 */
public class MyRelativeLayout extends RelativeLayout {

    public MyRelativeLayout(Context context) {
        this(context, null);
    }

    public MyRelativeLayout(Context context, AttributeSet attrs,
                                 int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public MyRelativeLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    private void initView() {

    }

    private boolean mScrolling;
    private float touchDownX;



    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                touchDownX = event.getX();
                mScrolling = false;
                break;
            case MotionEvent.ACTION_MOVE:
                if (Math.abs(touchDownX - event.getX()) >= ViewConfiguration.get(
                        getContext()).getScaledTouchSlop()) {
                    mScrolling = true;
                } else {
                    mScrolling = false;
                }
                break;
            case MotionEvent.ACTION_UP:
                mScrolling = false;
                break;
        }
        return mScrolling;
    }

    float x1 = 0;
    float x2 = 0;


    @Override
    public boolean onTouchEvent(MotionEvent event) {

//dispatchTouchEvent(MotionEvent.)

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                return true;
            case MotionEvent.ACTION_MOVE:

                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                if (touchDownX - x2 > DensityUtil.dip2px(getContext(), 40)) {
                    if(mSetOnSlideListener!=null){
                        mSetOnSlideListener.onRightToLeftSlide();
                    }
                }
                if (touchDownX - x2 < -DensityUtil.dip2px(getContext(), 40)) {
                    if(mSetOnSlideListener!=null){
                        mSetOnSlideListener.onLeftToRightSlide();
                    }
                }
                break;
        }



        return super.onTouchEvent(event);
    }

    private setOnSlideListener mSetOnSlideListener;

    public setOnSlideListener getmSetOnSlideListener() {
        return mSetOnSlideListener;
    }

    public void setmSetOnSlideListener(setOnSlideListener mSetOnSlideListener) {
        this.mSetOnSlideListener = mSetOnSlideListener;
    }

    public interface setOnSlideListener{
        void onRightToLeftSlide();
        void onLeftToRightSlide();
    }

}
