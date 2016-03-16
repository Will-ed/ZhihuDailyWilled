package com.ed.will.zhihudailywilled.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Win10 on 2016/3/11.
 */
public class SuperViewPager extends ViewPager{
    private boolean scrollble=true;

    public SuperViewPager(Context context) {
        super(context);
    }

    public SuperViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if(!scrollble){
            return true;
        }
        return super.onTouchEvent(ev);
    }

    public boolean isScrollble(){
        return scrollble;
    }

    public void setScrollble(boolean scrollble){
        this.scrollble=scrollble;
    }
}
