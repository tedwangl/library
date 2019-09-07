package com.wl.library.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.viewpager.widget.ViewPager;

//禁止滑动
public class MyViewPager extends ViewPager {
    public MyViewPager(Context context) {
        super(context);
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        return super.onInterceptTouchEvent(ev);
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
//        return super.onTouchEvent(ev);
        return false;
    }
}
