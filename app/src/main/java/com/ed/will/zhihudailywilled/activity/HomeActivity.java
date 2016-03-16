package com.ed.will.zhihudailywilled.activity;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ed.will.zhihudailywilled.R;
import com.ed.will.zhihudailywilled.detailpager.BasePager;
import com.ed.will.zhihudailywilled.factory.DetailPagerFactory;
import com.ed.will.zhihudailywilled.view.SuperViewPager;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Win10 on 2016/3/11.
 */
public class HomeActivity extends BaseActivity {

    @Bind(R.id.home_container)
    SuperViewPager homeContainer;
    @Bind(R.id.rb_news)
    RadioButton rbNews;
    @Bind(R.id.rb_dis)
    RadioButton rbDis;
    @Bind(R.id.rb_me)
    RadioButton rbMe;
    @Bind(R.id.rg_foot)
    RadioGroup rgFoot;


    private HomeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        adapter = new HomeAdapter();
        homeContainer.setScrollble(true);
        homeContainer.setAdapter(adapter);
        homeContainer.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        rbNews.setChecked(true);
                        break;
                    case 1:
                        rbDis.setChecked(true);
                        break;
                    case 2:
                        rbMe.setChecked(true);
                        break;

                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        rgFoot.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int currentItem = 0;
                switch (checkedId) {
                    case R.id.rb_news:
                        currentItem = 0;
                        break;
                    case R.id.rb_dis:
                        currentItem = 1;
                        break;

                    case R.id.rb_me:
                        currentItem = 2;
                        break;
                }

                homeContainer.setCurrentItem(currentItem);
            }
        });


    }


    class HomeAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }


        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            BasePager pager = DetailPagerFactory.getInstance()
                    .createDetailPager(HomeActivity.this, position);
            View view = pager.initView();
            container.addView(view);

            return view;
        }
    }

}
