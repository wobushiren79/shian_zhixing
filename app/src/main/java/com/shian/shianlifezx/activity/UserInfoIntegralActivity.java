package com.shian.shianlifezx.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shian.shianlifezx.R;
import com.shian.shianlifezx.activity.userinfo.DetailsActivity;
import com.shian.shianlifezx.base.BaseActivity;
import com.shian.shianlifezx.view.customview.UserInfoIntegralSignView;

public class UserInfoIntegralActivity extends BaseActivity {
    UserInfoIntegralSignView signView;

    ImageView mIVBack;
    TextView mTVMyPoint;
    TextView mTVPointTitle;

    LinearLayout mLLDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info_integral);
        setTitle("积分");

        initView();
        startAnim();
    }

    /**
     * 动画效果
     */
    private void startAnim() {
        AnimationSet animationSet = new AnimationSet(true);
        RotateAnimation rotateAnimation = new RotateAnimation(0, 100, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(6000);
        rotateAnimation.setInterpolator(new LinearInterpolator());

        ScaleAnimation scaleAnimation = new ScaleAnimation(0, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(2000);
        scaleAnimation.setInterpolator(new OvershootInterpolator());

        animationSet.addAnimation(rotateAnimation);
        animationSet.addAnimation(scaleAnimation);
        mIVBack.startAnimation(animationSet);

        ScaleAnimation textScaleAnimation = new ScaleAnimation(0, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        textScaleAnimation.setDuration(2000);
        textScaleAnimation.setInterpolator(new OvershootInterpolator());

        textScaleAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                signView.setVisibility(View.VISIBLE);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
                alphaAnimation.setDuration(1000);
                alphaAnimation.setInterpolator(new OvershootInterpolator());
                signView.startAnimation(alphaAnimation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mTVMyPoint.startAnimation(textScaleAnimation);
        mTVPointTitle.startAnimation(textScaleAnimation);
    }

    private void initView() {
        signView = (UserInfoIntegralSignView) findViewById(R.id.signview);
        mIVBack = (ImageView) findViewById(R.id.iv_integral_back);
        mLLDetails = (LinearLayout) findViewById(R.id.ll_details);

        mTVMyPoint = (TextView) findViewById(R.id.tv_mypoint);
        mTVPointTitle = (TextView) findViewById(R.id.tv_pointtitle);
        mLLDetails.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == mLLDetails) {
                Intent intent = new Intent(UserInfoIntegralActivity.this, DetailsActivity.class);
                startActivity(intent);
            }
        }
    };
}