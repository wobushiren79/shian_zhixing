package com.shian.shianlifezx.activity.userinfo;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shian.shianlifezx.R;
import com.shian.shianlifezx.activity.MainActivity;
import com.shian.shianlifezx.activity.WebActivity;
import com.shian.shianlifezx.base.BaseActivity;
import com.shian.shianlifezx.common.utils.AnimUtils;
import com.shian.shianlifezx.common.utils.ToastUtils;
import com.shian.shianlifezx.common.view.TipsDialog;
import com.shian.shianlifezx.mvp.login.bean.DuiBaLoginResultBean;
import com.shian.shianlifezx.mvp.login.presenter.IDuiBaLoginPresenter;
import com.shian.shianlifezx.mvp.login.presenter.impl.DuiBaLoginPresenterImpl;
import com.shian.shianlifezx.mvp.login.view.IDuiBaLoginView;
import com.shian.shianlifezx.mvp.userinfo.bean.UserInfoIntegralResultBean;
import com.shian.shianlifezx.mvp.userinfo.presenter.IUserInfoIntegralPresenter;
import com.shian.shianlifezx.mvp.userinfo.presenter.impl.UserInfoIntegralPresenterImpl;
import com.shian.shianlifezx.mvp.userinfo.view.IUserInfoIntegralView;
import com.shian.shianlifezx.view.customview.UserInfoIntegralSignView;
import com.shian.shianlifezx.view.ptr.CustomPtrFramelayout;

import butterknife.ButterKnife;
import butterknife.InjectView;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;

public class UserInfoIntegralActivity extends BaseActivity implements IUserInfoIntegralView, UserInfoIntegralSignView.CallBack, View.OnClickListener, IDuiBaLoginView {
    @InjectView(R.id.iv_integral_back)
    ImageView ivIntegralBack;
    @InjectView(R.id.tv_mypoint)
    TextView tvMypoint;
    @InjectView(R.id.tv_pointtitle)
    TextView tvPointtitle;
    @InjectView(R.id.signview)
    UserInfoIntegralSignView signView;
    @InjectView(R.id.rl_point)
    RelativeLayout rlPoint;
    @InjectView(R.id.ptr_layout)
    CustomPtrFramelayout ptrLayout;

    @InjectView(R.id.ll_details)
    LinearLayout llDetails;
    @InjectView(R.id.ll_rule)
    LinearLayout llRule;
    @InjectView(R.id.ll_point)
    LinearLayout llPoint;
    @InjectView(R.id.ll_continuous_sign)
    LinearLayout llContinuousSign;
    @InjectView(R.id.tv_continuous_day)
    TextView tvContinuousDay;

    private Integer myIntegral;

    private IUserInfoIntegralPresenter userInfoIntegralPresenter;
    private IDuiBaLoginPresenter duiBaLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info_integral);
        ButterKnife.inject(this);

        initView();
        initData();

    }

    private void initView() {
        setTitle("积分");
        ptrLayout.setPtrHandler(ptrDefaultHandler2);
        signView.setCallBack(this);
        llRule.setOnClickListener(this);
        llPoint.setOnClickListener(this);
        llDetails.setOnClickListener(this);
    }

    private void initData() {
        userInfoIntegralPresenter = new UserInfoIntegralPresenterImpl(this);
        duiBaLoginPresenter = new DuiBaLoginPresenterImpl(this);
        userInfoIntegralPresenter.getUserInfoIntegral();
    }

    /**
     * 动画效果
     */
    private void startAnim(int startPoint, int endPoint) {
        AnimUtils.integralBackAnim(ivIntegralBack);
        AnimUtils.intagralTextAnim(tvPointtitle, null);
        AnimUtils.intagralTextAnim(llContinuousSign, null);
        AnimUtils.intagralTextAnim(tvMypoint, new Animation.AnimationListener() {
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
        AnimUtils.intagralPointAnim(tvMypoint, startPoint, endPoint);

    }

    PtrDefaultHandler2 ptrDefaultHandler2 = new PtrDefaultHandler2() {
        @Override
        public void onLoadMoreBegin(PtrFrameLayout frame) {
            ptrLayout.refreshComplete();
        }

        @Override
        public void onRefreshBegin(PtrFrameLayout frame) {
            setViewStatus(View.GONE);
            signView.setVisibility(View.GONE);
            userInfoIntegralPresenter.getUserInfoIntegral();
        }
    };

    /**
     * 设置控件状态
     *
     * @param gone
     */
    private void setViewStatus(int gone) {
        ivIntegralBack.setVisibility(gone);
        tvMypoint.setVisibility(gone);
        tvPointtitle.setVisibility(gone);
        llContinuousSign.setVisibility(gone);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showToast(String msg) {
        ToastUtils.show(this, msg);
    }

    @Override
    public void getUserInfoIntegralSuccess(UserInfoIntegralResultBean resultBean) {
        setViewStatus(View.VISIBLE);
        ptrLayout.refreshComplete();
    }

    @Override
    public void getUserInfoIntegralFail(String msg) {
        ptrLayout.refreshComplete();
        ToastUtils.show(this, msg);
    }

    @Override
    public void setUserInfoIntegral(Integer integral) {
        myIntegral = integral;
        startAnim(0, integral);
    }

    @Override
    public void setUserInfoContinuousDay(Integer day) {
        tvContinuousDay.setText(day + "天");
    }

    @Override
    public void setUserInfoCanSign(boolean isSign) {
        if (isSign)
            signView.setSignStatus(false);
        else
            signView.setSignStatus(true);
    }

    @Override
    public void signSuccess(View view) {
        ptrLayout.autoRefresh();
        MainActivity.isRefreshUserInfo = true;
    }

    @Override
    public void onClick(View v) {
        if (v == llRule) {
            showRule();
        } else if (v == llDetails) {
            Intent intent = new Intent(UserInfoIntegralActivity.this, UserInfoIntegralDetailsActivity.class);
            startActivity(intent);
        } else if (v == llPoint) {
            showInegralStore();
        }
    }

    /**
     * 登录对吧
     */
    private void showInegralStore() {
        duiBaLoginPresenter.loginDuiBa();
    }


    /**
     * 展示积分规则
     */
    private void showRule() {
        TipsDialog dialog = new TipsDialog(this);
        dialog.setTop("积分规则");
        dialog.setTitle("1.第一天签到：3分/天。\n" +
                "2.连续三天签到：5分/天。\n" +
                "3.连续七天及七天以上签到：7分/天。");
        dialog.setBottomButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        dialog.show();
    }

    @Override
    public void loginDuiBaSuccess(DuiBaLoginResultBean resultBean) {
        Intent intent = new Intent(this, WebActivity.class);
        intent.putExtra("url", resultBean.getUrl());
        startActivity(intent);
    }

    @Override
    public void loginDuiBaFail(String msg) {
        ToastUtils.show(this, msg);
    }

    @Override
    public Integer getIntegral() {
        return myIntegral;
    }
}
