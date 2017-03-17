package com.shian.shianlifezx.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.shian.shianlifezx.R;
import com.shian.shianlifezx.activity.CustomerHelpActivity;
import com.shian.shianlifezx.activity.IdeaFeedbackActivity;
import com.shian.shianlifezx.activity.MyCollectionActivity;
import com.shian.shianlifezx.activity.SettingsActivity;
import com.shian.shianlifezx.activity.UserInfoActivity;
import com.shian.shianlifezx.base.BaseFragment;
import com.shian.shianlifezx.common.contanst.AppContansts;
import com.shian.shianlifezx.common.utils.JSONUtil;
import com.shian.shianlifezx.common.utils.PicassoUD;
import com.shian.shianlifezx.common.utils.ToastUtils;
import com.shian.shianlifezx.common.utils.Utils;
import com.shian.shianlifezx.provide.MHttpManagerFactory;
import com.shian.shianlifezx.provide.base.HttpResponseHandler;
import com.shian.shianlifezx.provide.result.HrUserInfo;
import com.shian.shianlifezx.thisenum.UserCenterEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/12.
 */

public class NewUserCenterFragment extends BaseFragment {
    View view;
    TextView mTVName;
    TextView mTVPhone;
    ImageView mIVInfoIn;
    ImageView mIVIcon;

    HrUserInfo mHrUserInfo;

    LinearLayout mLLEdit;
    LinearLayout mLLHelp;
    LinearLayout mLLCollection;
    LinearLayout mLLIdea;
    LinearLayout mLLSetting;
    LinearLayout mLLPlatform;
    LinearLayout mLLVersion;

    List<LinearLayout> listLayout = new ArrayList<>();

    UserCenterEnum[] layoutEnum = {
            UserCenterEnum.HELP,
            UserCenterEnum.COLLECTION,
            UserCenterEnum.IDEA,
            UserCenterEnum.SETTING,
            UserCenterEnum.PLATFORM,
            UserCenterEnum.VERSION
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_new_user_center, null, false);
        initView();
        return view;
    }

    private void initView() {
        listLayout.clear();

        mTVName = (TextView) view.findViewById(R.id.tv_name);
        mTVPhone = (TextView) view.findViewById(R.id.tv_phone);
        mIVInfoIn = (ImageView) view.findViewById(R.id.iv_infoin);
        mIVIcon = (ImageView) view.findViewById(R.id.iv_icon);

        mLLEdit = (LinearLayout) view.findViewById(R.id.ll_edit);
        mLLHelp = (LinearLayout) view.findViewById(R.id.layout_help);
        mLLCollection = (LinearLayout) view.findViewById(R.id.layout_collection);
        mLLIdea = (LinearLayout) view.findViewById(R.id.layout_idea);
        mLLSetting = (LinearLayout) view.findViewById(R.id.layout_setting);
        mLLPlatform = (LinearLayout) view.findViewById(R.id.layout_platform);
        mLLVersion = (LinearLayout) view.findViewById(R.id.layout_vsersion);

        listLayout.add(mLLHelp);
        listLayout.add(mLLCollection);
        listLayout.add(mLLIdea);
        listLayout.add(mLLSetting);
        listLayout.add(mLLPlatform);
        listLayout.add(mLLVersion);

        mLLHelp.setOnClickListener(onClickListener);
        mLLCollection.setOnClickListener(onClickListener);
        mLLIdea.setOnClickListener(onClickListener);
        mLLSetting.setOnClickListener(onClickListener);
        mLLPlatform.setOnClickListener(onClickListener);
        mLLVersion.setOnClickListener(onClickListener);

        for (int i = 0; i < layoutEnum.length; i++) {
            LinearLayout layout = listLayout.get(i);
            ImageView ivIcon = (ImageView) layout.findViewById(R.id.iv_icon);
            TextView tvTitle = (TextView) layout.findViewById(R.id.tv_name);
            ivIcon.setImageResource(layoutEnum[i].getPicId());
            tvTitle.setText(layoutEnum[i].getName());
            if (layoutEnum[i].getName().contains("版本号")) {
                tvTitle.append(Utils.getVersion(getContext()));
            }
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        getUserInfo();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    private void getUserInfo() {
        MHttpManagerFactory.getAccountManager().getUserInfo(getActivity(), new HttpResponseHandler<HrUserInfo>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(final HrUserInfo result) {
                mHrUserInfo = result;
                PicassoUD.loadImage(getActivity(), AppContansts.OSSURL + result.getHeadImg(), mIVIcon);
                mTVName.setText(result.getName());
                mTVPhone.setText(result.getMobile());
                mLLEdit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent in = new Intent(getActivity(), UserInfoActivity.class);
                        in.putExtra("data", JSONUtil.writeEntityToJSONString(result));
                        getActivity().startActivity(in);
                    }
                });
            }

            @Override
            public void onError(String message) {

            }
        });
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == mLLHelp) {
                help();
            } else if (v == mLLCollection) {
                collection();
            } else if (v == mLLIdea) {
                idea();
            } else if (v == mLLSetting) {
                setting();
            } else if (v == mLLPlatform) {

            } else if (v == mLLVersion) {

            }
        }
    };

    /**
     * 意见反馈
     */
    private void idea() {
        if(mHrUserInfo==null){
            ToastUtils.show(getContext(),"数据异常，请重新登陆");
        }else{
            Intent intent = new Intent(getContext(), IdeaFeedbackActivity.class);
            intent.putExtra("UserInfo",new String[]{mHrUserInfo.getName(),mHrUserInfo.getMobile()});
            startActivity(intent);
        }
    }

    /**
     * 帮助
     */
    private void help() {
        Intent intent = new Intent(getContext(), CustomerHelpActivity.class);
        startActivity(intent);
    }
    /**
     * 收藏
     */
    private void collection() {
        Intent intent = new Intent(getContext(), MyCollectionActivity.class);
        startActivity(intent);
    }

    /**
     * 设置
     */
    private void setting() {
        Intent in = new Intent(getContext(), SettingsActivity.class);
        in.putExtra("state", mHrUserInfo.getAppStatus());
        startActivityForResult(in, 101);
    }
}