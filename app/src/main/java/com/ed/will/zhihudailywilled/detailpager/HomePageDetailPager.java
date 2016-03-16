package com.ed.will.zhihudailywilled.detailpager;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.ed.will.zhihudailywilled.R;
import com.ed.will.zhihudailywilled.view.SuperViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Win10 on 2016/3/11.
 */
public class HomePageDetailPager extends BasePager {

    private List<String> titleList=new ArrayList<>();
    private View v1,v2,v3,v4;
    private List<View> viewList=new ArrayList<>();

    private TabLayout tabs;
    private SuperViewPager viewpager;



    public HomePageDetailPager(Context ctx) {
        super(ctx);
    }

    @Override
    public View initView() {
        View view=View.inflate(ctx, R.layout.view_home,null);
        tabs= (TabLayout) view.findViewById(R.id.tabs);
        viewpager= (SuperViewPager) view.findViewById(R.id.viewpager);

        v1=View.inflate(ctx,R.layout.view_home_newest,null);
        v2=View.inflate(ctx,R.layout.activity_main,null);
        v3=View.inflate(ctx,R.layout.activity_main,null);
        v4=View.inflate(ctx,R.layout.activity_main,null);

        viewList.add(v1);
        viewList.add(v2);
        viewList.add(v3);
        viewList.add(v4);

        titleList.add("最新");
        titleList.add("心理");
        titleList.add("科技");
        titleList.add("更多");

        tabs.setTabMode(TabLayout.MODE_FIXED);
        tabs.addTab(tabs.newTab().setText(titleList.get(0)));
        tabs.addTab(tabs.newTab().setText(titleList.get(1)));
        tabs.addTab(tabs.newTab().setText(titleList.get(2)));
        tabs.addTab(tabs.newTab().setText(titleList.get(3)));


        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(viewList);
        viewpager.setAdapter(viewPagerAdapter);
        viewpager.setScrollble(true);
        tabs.setupWithViewPager(viewpager);
        tabs.setTabsFromPagerAdapter(viewPagerAdapter);

        return view;
    }


    @Override
    public void initData() {
        super.initData();
    }

    class ViewPagerAdapter extends PagerAdapter {

        private List<View> viewList;

        public ViewPagerAdapter(List<View> viewList){
            this.viewList=viewList;
        }

        @Override
        public int getCount() {
            return viewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {

            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(viewList.get(position));
            return viewList.get(position);
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(viewList.get(position));
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titleList.get(position);

        }
    }



}
