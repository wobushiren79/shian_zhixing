package com.shian.shianlifezx.fragment;

import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.InjectViews;
import butterknife.OnClick;

import com.kf5sdk.init.KF5SDKConfig;
import com.shian.shianlifezx.R;
import com.shian.shianlifezx.activity.SettingsActivity;
import com.shian.shianlifezx.activity.UserInfoActivity;
import com.shian.shianlifezx.activity.WebActivity;
import com.shian.shianlifezx.base.BaseFragment;
import com.shian.shianlifezx.common.contanst.AppContansts;
import com.shian.shianlifezx.common.utils.JSONUtil;
import com.shian.shianlifezx.common.utils.PicassoUD;
import com.shian.shianlifezx.common.utils.Utils;
import com.shian.shianlifezx.provide.MHttpManagerFactory;
import com.shian.shianlifezx.provide.base.HttpResponseHandler;
import com.shian.shianlifezx.provide.result.HrUserInfo;

public class UserCenterFragment extends BaseFragment {
	private View v;
	@InjectView(R.id.iv_user_pic)
	ImageView ivPic;
	@InjectViews({R.id.tv_user_name,R.id.tv_user_zw,R.id.tv_user_jb1,R.id.tv_user_jb2,R.id.tv_user_fwgs1,R.id.tv_user_fwmy1})
	List<TextView> tvList;
	@InjectViews({R.id.tv_user_fwgs2,R.id.tv_user_fwmy2})
	List<RatingBar> rbList;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		v = inflater.inflate(R.layout.fragment_usercenter_2, null, false);
		ButterKnife.inject(this, v);
		return v;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);

	}

	@Override
	public void onResume() {
		super.onResume();getUserInfo();
	}

	@OnClick(R.id.tv_settings)
	void onSettingsClisk(View v) {
		Intent in = new Intent(getActivity(), SettingsActivity.class);
		in.putExtra("state",mHrUserInfo.getAppStatus());
		startActivityForResult(in,101);
	}

	  @OnClick(R.id.phone)
	    void Phone(View v) {
	        Utils.call(v, "4009679678");
	    }

	    @OnClick({R.id.grzy,R.id.help,R.id.ly})
	    void urlClick(View v){
	        Intent in = new Intent(getActivity(), WebActivity.class);
	        String url = "";
	        switch (v.getId()){
	            case R.id.grzy:
	                url = "http://m.e-funeral.cn/html/company.html";
	                break;
	            case R.id.help:
	                url = "http://m.e-funeral.cn/html/help.html";
	                break;
	            case R.id.ly:
	                url = "http://h5.e-soumu.cn/s/KHb8GxTK";
	                break;
	        }
	        in.putExtra("url", url);
	        getActivity().startActivity(in);
	    }

	@OnClick(R.id.tv_zx)
	void onZXClick(View v){
		KF5SDKConfig.INSTANCE.startKF5ChatActivity(getActivity());
	}
	private HrUserInfo mHrUserInfo;
	private void getUserInfo(){
		MHttpManagerFactory.getAccountManager().getUserInfo(getActivity(), new HttpResponseHandler<HrUserInfo>() {
			@Override
			public void onStart() {


			}

			@Override
			public void onSuccess(final HrUserInfo result) {
				mHrUserInfo=result;
				PicassoUD.loadImage(getActivity(),AppContansts.OSSURL+result.getHeadImg(),ivPic);
				tvList.get(0).setText(result.getName());

				for(int i=0;i<result.getRoles().size();i++){
					if(i!=0){
////						tvList.get(2).append("\n");
//					}else{
						tvList.get(2).append("/");
					}
					tvList.get(2).setText("角色"+result.getRoles().get(i).getName());
					tvList.get(4).setText(result.getServiceSuccessSum()+"");
					tvList.get(5).setText(result.getAvgSatis()+"");
					v.findViewById(R.id.editor).setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View v) {
							Intent in=new Intent(getActivity(),UserInfoActivity.class);
							in.putExtra("data", JSONUtil.writeEntityToJSONString(result));
							getActivity().startActivity(in);
						}
					});
				}
			}

			@Override
			public void onError(String message) {

			}
		});
	}
}
