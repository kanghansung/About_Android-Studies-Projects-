package org.techtown.doing;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;

import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

//swipe막으려고 custompager를 정의했는데 MainActivity에서 쓸때, cast익셉션이 발생해서 사용불가능.

public class CustomViewPager extends ViewPager {

    boolean enable;

    public CustomViewPager(@NonNull Context context) {
        super(context);
    }

    public CustomViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if(enable)
            return super.onInterceptTouchEvent(ev);
        else{
            if(ev.getAction() == MotionEvent.ACTION_MOVE);
            else if(super.onInterceptTouchEvent(ev))
                super.onTouchEvent(ev);
        }

        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if(enable)
            return super.onTouchEvent(ev);
        else
            return ev.getAction() != MotionEvent.ACTION_MOVE && super.onTouchEvent(ev);
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
