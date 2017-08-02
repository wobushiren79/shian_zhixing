package com.shian.shianlifezx.adapter;

import android.content.Context;

import com.shian.shianlifezx.R;
import com.shian.shianlifezx.adapter.base.BaseRCAdapter;
import com.shian.shianlifezx.adapter.base.BaseViewHolder;
import com.shian.shianlifezx.mvp.dialog.bean.DataShowDialogResultBean;

/**
 * Created by zm.
 */

public class DataShowDialogListAdapter extends BaseRCAdapter<DataShowDialogResultBean> {
    /**
     * 单布局初始化
     *
     * @param context
     */
    public DataShowDialogListAdapter(Context context) {
        super(context, R.layout.dialog_show_data_layout_item);
    }

    @Override
    public void convert(BaseViewHolder holder, DataShowDialogResultBean content, int index) {

    }
}
