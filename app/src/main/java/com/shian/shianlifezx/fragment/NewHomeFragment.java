package com.shian.shianlifezx.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

import com.shian.shianlifezx.R;
import com.shian.shianlifezx.base.BaseActivity;
import com.shian.shianlifezx.base.BaseFragment;
import com.shian.shianlifezx.view.customview.MainAPP;
import com.shian.shianlifezx.view.customview.MainAdvertisementLayout;
import com.shian.shianlifezx.view.customview.MainDynamic;
import com.shian.shianlifezx.view.customview.UserInfoLayout;


/**
 * Created by Administrator on 2017/3/5.
 */

public class NewHomeFragment extends BaseFragment {
    View view;

    UserInfoLayout mUserInfoLayout;
    MainAdvertisementLayout mMainAdvertisementLayout;
    MainDynamic mMainDynamicLayout;//重要通知
    MainAPP mMainAPP;//我的APP

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_newhome, null, false);
        initView();

        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    private void initView() {
        mUserInfoLayout = (UserInfoLayout) view.findViewById(R.id.userinfo_layout);
        mMainAdvertisementLayout = (MainAdvertisementLayout) view.findViewById(R.id.mainadvertisement_layout);
        mMainDynamicLayout = (MainDynamic) view.findViewById(R.id.maindynamic_layout);
        mMainAPP = (MainAPP) view.findViewById(R.id.mainapp_layout);

        mMainAdvertisementLayout.setCallBack(advertisermentlayout);
        mMainDynamicLayout.setCallBack(mainDynamicCallBack);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {


        }
    };

    /**
     * 广告加载完毕与取消动画
     */
    MainAdvertisementLayout.CallBack advertisermentlayout = new MainAdvertisementLayout.CallBack() {
        @Override
        public void loadingComplete() {
            mMainAdvertisementLayout.setVisibility(View.VISIBLE);
            TranslateAnimation animation = new TranslateAnimation(BaseActivity.metrics.widthPixels, Animation.RELATIVE_TO_SELF, Animation.RELATIVE_TO_SELF, Animation.RELATIVE_TO_SELF);
            animation.setDuration(500);
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    animation.cancel();
                    mMainAdvertisementLayout.clearAnimation();
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            mMainAdvertisementLayout.startAnimation(animation);
        }

        @Override
        public void cancelPic() {
            AlphaAnimation animation = new AlphaAnimation(1, 0);
            animation.setDuration(500);
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    animation.cancel();
                    mMainAdvertisementLayout.clearAnimation();
                    mMainAdvertisementLayout.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            mMainAdvertisementLayout.startAnimation(animation);
        }
    };
    MainDynamic.CallBack mainDynamicCallBack = new MainDynamic.CallBack() {
        @Override
        public void loadingComplete() {
            mMainDynamicLayout.setVisibility(View.VISIBLE);

        }
    };
}
