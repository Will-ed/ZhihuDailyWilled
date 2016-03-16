package com.ed.will.zhihudailywilled.factory;

import android.content.Context;

import com.ed.will.zhihudailywilled.detailpager.BasePager;
import com.ed.will.zhihudailywilled.detailpager.FollowDetailPager;
import com.ed.will.zhihudailywilled.detailpager.MineDetailPager;
import com.ed.will.zhihudailywilled.detailpager.HomePageDetailPager;

/**
 * Created by Win10 on 2016/3/11.
 */
public class DetailPagerFactory {
    private static DetailPagerFactory factory;
    private DetailPagerFactory(){}
    public static DetailPagerFactory getInstance(){
        if(factory==null){
            factory=new DetailPagerFactory();
        }
        return factory;
    }
    public BasePager createDetailPager(Context ctx,int position){
        BasePager pager = null;
        switch (position) {
            case 0:
                pager=new HomePageDetailPager(ctx);
                break;
            case 1:
                pager=new FollowDetailPager(ctx);
                break;
            case 2:
                pager=new MineDetailPager(ctx);
                break;


        }
        return pager;

    }
}
