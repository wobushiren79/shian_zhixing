package com.shian.shianlifezx.mvp.shared.model;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by zm.
 */

public class BaseSharedModel {
    protected static final String Tag_Goods_Perform = "Tag_Goods_Perform";  //单项执行数据

    protected SharedPreferences.Editor getEditShared(Context context, String Tag) {
        SharedPreferences.Editor editor = context.getSharedPreferences(Tag, MODE_PRIVATE).edit();
        return editor;
    }

    protected SharedPreferences getDataShared(Context context, String Tag) {
        SharedPreferences share = context.getSharedPreferences(Tag, MODE_PRIVATE);
        return share;
    }
}
