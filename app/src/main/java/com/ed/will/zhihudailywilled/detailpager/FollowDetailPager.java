package com.ed.will.zhihudailywilled.detailpager;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Win10 on 2016/3/11.
 */
public class FollowDetailPager extends BasePager {
    public FollowDetailPager(Context ctx) {
        super(ctx);
    }

    @Override
    public View initView() {
        TextView view=new TextView(ctx);
        view.setText("Dis");
        return view;
    }
}
