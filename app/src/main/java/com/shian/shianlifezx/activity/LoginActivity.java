package com.shian.shianlifezx.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;

import butterknife.InjectView;
import butterknife.OnClick;

import com.shian.shianlifezx.R;
import com.shian.shianlifezx.base.BaseActivity;
import com.shian.shianlifezx.common.utils.SharePerfrenceUtils;
import com.shian.shianlifezx.common.utils.SharePerfrenceUtils.ShareLogin;
import com.shian.shianlifezx.common.utils.ToastUtils;
import com.shian.shianlifezx.provide.MHttpManagerFactory;
import com.shian.shianlifezx.provide.base.HttpRequestExecutor;
import com.shian.shianlifezx.provide.base.HttpResponseHandler;
import com.shian.shianlifezx.provide.params.HpLoginParams;
import com.shian.shianlifezx.provide.result.HrLoginResult;
import com.shian.shianlifezx.view.customview.LoadingButton;

public class LoginActivity extends BaseActivity {
	@InjectView(R.id.et_login_username)
	EditText etUserName;
	@InjectView(R.id.et_login_password)
	EditText etUserPassword;
	@InjectView(R.id.cb_login_re)
	CheckBox cbRe;
	@InjectView(R.id.cb_login_auto)
	CheckBox cbAuto;
	@InjectView(R.id.btn_login)
	LoadingButton lbLogin;
	@InjectView(R.id.rl_content)
	RelativeLayout rlContent;
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_login);
		initView();
		startAnim();
	}
	/**
	 * 动画
	 */
	private void startAnim() {
		TranslateAnimation translateAnimation=new TranslateAnimation(Animation.RELATIVE_TO_SELF,Animation.RELATIVE_TO_SELF,1000,Animation.RELATIVE_TO_SELF);
		translateAnimation.setDuration(1000);
		rlContent.setAnimation(translateAnimation);
		translateAnimation.start();
	}
	private void initView() {
		ShareLogin loginS = SharePerfrenceUtils.getLoginShare(this);
		etUserName.setText(loginS.getUsername());
		if (loginS.isRemeberPassword()) {
			cbRe.setChecked(true);
			etUserPassword.setText(loginS.getPassword());
		}

		if (loginS.isAutoLogin()) {
			cbAuto.setChecked(true);
			login(loginS.getUsername(), loginS.getPassword());
		}
	}

	@OnClick(R.id.btn_login)
	void loginClick(View v) {
		String username = etUserName.getText().toString();
		String password = etUserPassword.getText().toString();

		login(username, password);
	}
	public static String cookie;
	private void login(final String username, final String password) {

		if (!isCanLogin(username, password)) {
			return;
		}
		if(TextUtils.isEmpty(SharePerfrenceUtils.getShareChannelId(this))){
			ToastUtils.show(this, "消息推送正在初始化，请稍后。。。");
			return;
		}
		lbLogin.setLoading();
		HpLoginParams params = new HpLoginParams();
		params.setPassword(etUserPassword.getText().toString());
		params.setUsername(etUserName.getText().toString());
		params.setSystemType("3");
		params.setChannelId(SharePerfrenceUtils.getShareChannelId(this));
		MHttpManagerFactory.getAccountManager().login(this, params, new HttpResponseHandler<HrLoginResult>() {

			@Override
			public void onSuccess(HrLoginResult result) {
				lbLogin.setComplete();
				cookie=result.getSessionId();
				HttpRequestExecutor.setSession(cookie, LoginActivity.this);
				SharePerfrenceUtils.setLoginShare(LoginActivity.this, username, password, cbRe.isChecked(),
						cbAuto.isChecked());
				ToastUtils.show(getBaseContext(), "登陆成功");
				Intent in = new Intent(LoginActivity.this, MainActivity.class);
				startActivity(in);
				finish();
			}

			@Override
			public void onStart() {

			}

			@Override
			public void onError(String message) {
				lbLogin.setNormal();
			}
		});

	}

	private boolean isCanLogin(String username, String password) {

		if (username == null || username.equals("") || password == null || password.equals("")) {
			ToastUtils.show(getBaseContext(), "用户名或密码不能为空");
		} else {
			return true;
		}
		return false;
	}
	@OnClick(R.id.btn_login_web)
	void loginWeb(View v){
//		Intent in=new Intent(this,WebActivity.class);
//		in.putExtra("url","http://m.e-funeral.cn");
//		startActivity(in);
		Intent in=new Intent(this,LoginPhoneActivity.class);
		startActivity(in);
	}
}
