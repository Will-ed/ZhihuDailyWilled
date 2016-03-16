package com.ed.will.zhihudailywilled.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ed.will.zhihudailywilled.R;
import com.ed.will.zhihudailywilled.view.SuperViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Win10 on 2016/3/11.
 */
public class HomeNewActivity extends BaseActivity {

    @Bind(R.id.tabs)
    TabLayout tabs;
    @Bind(R.id.viewpager)
    SuperViewPager viewpager;

    private LayoutInflater layoutInflater;
    private List<String> titleList=new ArrayList<>();
    private View v1,v2,v3,v4;
    private List<View> viewList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_home);
        ButterKnife.bind(this);

        layoutInflater=LayoutInflater.from(this);
        v1=layoutInflater.inflate(R.layout.activity_main, null);
        v2=layoutInflater.inflate(R.layout.activity_main, null);
        v3=layoutInflater.inflate(R.layout.activity_main, null);
        v4=layoutInflater.inflate(R.layout.activity_main,null);

        viewList.add(v1);
        viewList.add(v2);
        viewList.add(v3);
        viewList.add(v4);

        titleList.add("No:1");
        titleList.add("No:2");
        titleList.add("No:3");
        titleList.add("No:4");

        tabs.setTabMode(TabLayout.MODE_FIXED);
        tabs.addTab(tabs.newTab().setText(titleList.get(0)));
        tabs.addTab(tabs.newTab().setText(titleList.get(1)));
        tabs.addTab(tabs.newTab().setText(titleList.get(2)));
        tabs.addTab(tabs.newTab().setText(titleList.get(3)));

        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(viewList);
        viewpager.setAdapter(viewPagerAdapter);
        viewpager.setScrollble(false);
        tabs.setupWithViewPager(viewpager);
        tabs.setTabsFromPagerAdapter(viewPagerAdapter);


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
