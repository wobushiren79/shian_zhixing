package com.shian.shianlifezx.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.loopj.android.http.RequestParams;
import com.shian.shianlifezx.R;
import com.shian.shianlifezx.base.BaseActivity;
import com.shian.shianlifezx.common.utils.ToastUtils;
import com.shian.shianlifezx.provide.MHttpManagerFactory;
import com.shian.shianlifezx.provide.base.HttpResponseHandler;

public class IdeaFeedbackActivity extends BaseActivity {
    EditText mEditText;
    Button mBTSubmit;
    TextView mTVTextNum;


    String[] UserInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idea_feedback);
        UserInfo = getIntent().getStringArrayExtra("UserInfo");
        setTitle("意见反馈");
        initView();
    }

    private void initView() {
        mEditText = (EditText) findViewById(R.id.edit);
        mBTSubmit = (Button) findViewById(R.id.bt_submit);
        mTVTextNum = (TextView) findViewById(R.id.tv_textnum);

        mBTSubmit.setOnClickListener(onClickListener);
        mEditText.addTextChangedListener(textWatcher);


        changeNum(0);
    }

    TextWatcher textWatcher = new TextWatcher() {


        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            changeNum(s.length());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private void changeNum(int num) {
        mTVTextNum.setText(num + "/" + 100);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == mBTSubmit) {
                submit();
            }
        }
    };


    private void submit() {
        if(mEditText.getText().toString().equals("")){
            ToastUtils.show(IdeaFeedbackActivity.this,"还没有填写反馈信息");
            return;
        }
        RequestParams params = new RequestParams();
        params.put("user", UserInfo[0]);
        params.put("tel", UserInfo[1]);
        params.put("content", mEditText.getText().toString());
        MHttpManagerFactory.getPHPManager().setOpinion(IdeaFeedbackActivity.this, params, new HttpResponseHandler<Object>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(Object result) {
                ToastUtils.show(IdeaFeedbackActivity.this,"提交成功");
                finish();
            }

            @Override
            public void onError(String message) {
              ToastUtils.show(IdeaFeedbackActivity.this,"提交失败");
            }
        },true);
    }
}