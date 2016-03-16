package com.ed.will.zhihudailywilled.detailpager;

import android.content.Context;
import android.view.View;

/**
 * Created by Win10 on 2016/3/11.
 */
public abstract class BasePager {

    public Context ctx;
    public BasePager(Context ctx) {
        this.ctx=ctx;
    }
    /**
     * 初始化详情页视图
     * @return
     */
    public abstract View initView();
    /**
     * 初始化详情页数据
     */
    public void initData(){}
}
