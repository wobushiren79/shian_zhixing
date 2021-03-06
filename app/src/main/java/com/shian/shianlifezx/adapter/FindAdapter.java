package com.shian.shianlifezx.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.loopj.android.http.RequestParams;
import com.shian.shianlifezx.R;
import com.shian.shianlifezx.activity.WebActivity;
import com.shian.shianlifezx.common.contanst.AppContansts;
import com.shian.shianlifezx.common.utils.PicassoUD;
import com.shian.shianlifezx.provide.MHttpManagerFactory;
import com.shian.shianlifezx.provide.base.HttpResponseHandler;
import com.shian.shianlifezx.provide.phpmodel.SiftListData;
import com.shian.shianlifezx.provide.phpparams.PHPHpSiftDataParams;
import com.shian.shianlifezx.thisenum.SystemTypeEnum;

import java.util.List;

import okhttp3.Request;


/**
 * Created by Administrator on 2017/3/11.
 */

public class FindAdapter extends BaseAdapter {
    Context context;
    List<SiftListData> listDatas;

    public FindAdapter(Context context, List<SiftListData> listDatas) {
        this.context = context;
        this.listDatas = listDatas;
    }

    public void setData(List<SiftListData> listDatas) {
        this.listDatas = listDatas;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return listDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(context, R.layout.layout_find_items, null);
            holder.ivPic = (ImageView) convertView.findViewById(R.id.iv_pic);
            holder.tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
            holder.tvTime = (TextView) convertView.findViewById(R.id.tv_time);
            holder.tvCollection = (TextView) convertView.findViewById(R.id.tv_collection);
            holder.tvPraise = (TextView) convertView.findViewById(R.id.tv_praise);
            holder.ivCollection = (ImageView) convertView.findViewById(R.id.iv_collection);
            holder.ivPraise = (ImageView) convertView.findViewById(R.id.iv_praise);
            holder.llCollection = (LinearLayout) convertView.findViewById(R.id.ll_collection);
            holder.llPraise = (LinearLayout) convertView.findViewById(R.id.ll_praise);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final SiftListData data = listDatas.get(position);
        PicassoUD.loadImage(context, AppContansts.PHP_BaseUrl + data.getImg(), holder.ivPic);
        holder.tvTitle.setText(data.getTitle());
        holder.tvTime.setText(data.getTime());
        holder.tvCollection.setText(data.getCollectionNum() + "");
        holder.tvPraise.setText(data.getPraiseNum() + "");

        holder.ivPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WebActivity.class);
                intent.putExtra("url", AppContansts.siftsPHPURL + "?id=" + data.getId());
                intent.putExtra("isCollection", true);
                intent.putExtra("shareData", data);
                context.startActivity(intent);
            }
        });

        if (data.getIsCollection() == 0) {
            holder.ivCollection.setImageResource(R.drawable.zhy_find_collection_1);
            holder.llCollection.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    data.setIsCollection(1);
                    int collectionNum = data.getCollectionNum();
                    data.setCollectionNum(++collectionNum);
                    holder.ivCollection.setOnClickListener(null);
                    setData(2, data.getId());
                    notifyDataSetChanged();
                }
            });
        } else {
            holder.ivCollection.setImageResource(R.drawable.zhy_find_collection_2);
            holder.llCollection.setOnClickListener(null);
        }

        if (data.getIsPraise() == 0) {
            holder.ivPraise.setImageResource(R.drawable.zhy_find_praise_1);
            holder.llPraise.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    data.setIsPraise(1);
                    holder.ivPraise.setImageResource(R.drawable.zhy_find_praise_2);
                    int praiseNum = data.getPraiseNum();
                    data.setPraiseNum(++praiseNum);
                    holder.ivPraise.setOnClickListener(null);
                    setData(1, data.getId());
                    notifyDataSetChanged();
                }
            });
        } else {
            holder.ivPraise.setImageResource(R.drawable.zhy_find_praise_2);
            holder.llPraise.setOnClickListener(null);
        }
        return convertView;
    }


    /**
     * @param type （1.为点赞   2.为收藏）
     */
    private void setData(int type, int siftID) {
        PHPHpSiftDataParams params = new PHPHpSiftDataParams();
        params.setType(type);
        params.setUserid(AppContansts.systemLoginInfo.getUserId());
        params.setUserType(siftID);
        params.setUserType(SystemTypeEnum.funeral.getCode());
        MHttpManagerFactory.getPHPManager().setSiftData(context, params, new HttpResponseHandler<Object>() {

            @Override
            public void onStart(Request request, int id) {

            }

            @Override
            public void onSuccess(Object result) {

            }

            @Override
            public void onError(String message) {

            }
        });
    }

    class ViewHolder {
        ImageView ivPic;
        TextView tvTitle;
        TextView tvTime;

        TextView tvCollection;
        TextView tvPraise;
        ImageView ivCollection;
        ImageView ivPraise;

        LinearLayout llCollection;
        LinearLayout llPraise;
    }
}
