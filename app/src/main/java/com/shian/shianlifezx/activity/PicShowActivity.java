package com.shian.shianlifezx.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.shian.shianlifezx.R;
import com.shian.shianlifezx.base.BaseActivity;
import com.shian.shianlifezx.common.utils.IntentName;
import com.shian.shianlifezx.view.carousel.CarouselView;

import java.util.ArrayList;

import butterknife.InjectView;

public class PicShowActivity extends BaseActivity {

    @InjectView(R.id.layout_carouse)
    CarouselView layoutCarouse;

    private ArrayList<String> listData = new ArrayList<>();
    private String titleName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic_show);
        initView();
        initData();
    }

    private void initView() {

    }

    private void initData() {
        listData = (ArrayList<String>) getIntent().getSerializableExtra(IntentName.INTENT_LIST_DATA);
        titleName = getIntent().getStringExtra(IntentName.INTENT_DATA);
        if (!titleName.isEmpty())
            setTitle(titleName);
        else
            setTitle("图片");
        layoutCarouse.setData(listData);
    }

}
