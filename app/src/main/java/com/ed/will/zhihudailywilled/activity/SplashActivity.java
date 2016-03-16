package com.ed.will.zhihudailywilled.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.ed.will.zhihudailywilled.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 闪屏页面
 * Created by Win10 on 2016/3/11.
 */
public class SplashActivity extends BaseActivity {

    @Bind(R.id.splash_img)
    ImageView splashImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ButterKnife.bind(this);

        Animation anim=getAnima();
        splashImg.startAnimation(anim);
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startHomeActivity();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void startHomeActivity() {
        Intent intent=new Intent(this,HomeActivity.class);
        startActivity(intent);
        finish();
    }

    private Animation getAnima() {
        AlphaAnimation anim=new AlphaAnimation(0.8f,1);
        anim.setDuration(2000);
        anim.setFillAfter(true);
        return anim;
    }
}
