package com.shian.shianlifezx.view.customview;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shian.shianlifezx.R;
import com.shian.shianlifezx.activity.UserInfoIntegralActivity;
import com.shian.shianlifezx.activity.UserInfoMoneyActivity;
import com.shian.shianlifezx.common.contanst.AppContansts;
import com.shian.shianlifezx.common.utils.PicassoUD;
import com.shian.shianlifezx.common.utils.ToastUtils;
import com.shian.shianlifezx.mvp.login.bean.SystemLoginResultBean;
import com.shian.shianlifezx.provide.MHttpManagerFactory;
import com.shian.shianlifezx.provide.base.HttpResponseHandler;
import com.shian.shianlifezx.provide.result.HrUserInfo;
import com.shian.shianlifezx.thisenum.RoleEnum;

import java.util.List;

import okhttp3.Request;


/**
 * Created by Administrator
 */

public class UserInfoLayout extends LinearLayout {
    View view;
    TextView mTVName;
    TextView mTVStatus;
    TextView mTVScore;
    TextView mTVSignName;

    ImageView mIVUserPic;
    ImageView mIVSignIcon;

    LinearLayout mLLSign;

    UserInfoPointLayout mUserInfoPointLayoutIntegral;
    UserInfoPointLayout mUserInfoPointLayoutMoney;
    UserInfoPointLayout mUserInfoPointLayoutOrder;


    public UserInfoLayout(Context context) {
        this(context, null);
    }

    public UserInfoLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        view = View.inflate(context, R.layout.view_userinfo_layout, this);
        initView();
        getUserInfo();
    }

    private void initView() {
        mTVName = (TextView) view.findViewById(R.id.tv_name);
        mTVStatus = (TextView) view.findViewById(R.id.tv_status);
        mTVScore = (TextView) view.findViewById(R.id.tv_score);
        mTVSignName = (TextView) view.findViewById(R.id.tv_sign_name);
        mIVUserPic = (ImageView) view.findViewById(R.id.iv_user_pic);
        mIVSignIcon = (ImageView) view.findViewById(R.id.iv_sign_icon);
        mLLSign = (LinearLayout) view.findViewById(R.id.ll_sign);

        mUserInfoPointLayoutIntegral = (UserInfoPointLayout) view.findViewById(R.id.pointlayout_integral);
        mUserInfoPointLayoutMoney = (UserInfoPointLayout) view.findViewById(R.id.pointlayout_money);
        mUserInfoPointLayoutOrder = (UserInfoPointLayout) view.findViewById(R.id.pointlayout_order);

        mUserInfoPointLayoutIntegral.initLayout(R.drawable.zhy_userinfo_integral, "积分", "0");
        mUserInfoPointLayoutMoney.initLayout(R.drawable.zhy_userinfo_money, "钱包", "0");
        mUserInfoPointLayoutOrder.initLayout(R.drawable.zhy_userinfo_order, "优惠劵", "0");

        mUserInfoPointLayoutIntegral.setOnClickListener(onClickListener);
        mUserInfoPointLayoutMoney.setOnClickListener(onClickListener);
        mUserInfoPointLayoutOrder.setOnClickListener(onClickListener);
    }

    OnClickListener onClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == mLLSign) {
                sign();
            } else if (v == mUserInfoPointLayoutIntegral) {
                integralActivity();
            } else if (v == mUserInfoPointLayoutMoney) {
                moneyActivity();
            } else if (v == mUserInfoPointLayoutOrder) {
                ToastUtils.show(getContext(), "敬请期待！");
            }

        }
    };

    /**
     * 进入积分界面
     */
    private void integralActivity() {
        Intent intent = new Intent(getContext(), UserInfoIntegralActivity.class);
        getContext().startActivity(intent);
    }

    /**
     * 进入钱包界面
     */
    private void moneyActivity() {
        Intent intent = new Intent(getContext(), UserInfoMoneyActivity.class);
        getContext().startActivity(intent);
    }

    /**
     * 签名
     */
    private void sign() {
        mIVSignIcon.setImageResource(R.drawable.zhy_main_sign_check);
        mTVSignName.setTextColor(getResources().getColor(R.color.zhy_text_color_5));
    }


    /**
     * 获取用户信息
     */
    private void getUserInfo() {
//        PicassoUD.loadImage(getContext(), AppContansts.OSSURL + AppContansts.systemLoginInfo.getHeadImg(), mIVUserPic);
        if (AppContansts.systemLoginInfo == null)
            return;
        SystemLoginResultBean.UserObject userObject = AppContansts.systemLoginInfo.getUserObj();
        List<String> roleCodeList = AppContansts.systemLoginInfo.getResourceCodes();
        List<String> roleNameList = RoleEnum.getRoleNameList(roleCodeList);
        String name = userObject.getName();
        mTVName.setText(name);
        mTVStatus.setText("");
        for (String roleName : roleNameList) {
            mTVStatus.append(roleName + "\n");
        }
        mTVScore.setText("");
//                mUserInfoPointLayoutOrder.setPoint(result.getServiceSuccessSum() + "");
        mUserInfoPointLayoutOrder.setPoint("0");
        mLLSign.setOnClickListener(onClickListener);
    }


}
