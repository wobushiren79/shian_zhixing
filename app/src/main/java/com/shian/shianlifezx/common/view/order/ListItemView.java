package com.shian.shianlifezx.common.view.order;

import com.chanven.lib.cptr.loadmore.OnLoadMoreListener;
import com.chanven.lib.cptr.loadmore.SwipeRefreshHelper;
import com.chanven.lib.cptr.loadmore.SwipeRefreshHelper.OnSwipeRefreshListener;
import com.shian.shianlifezx.R;
import com.shian.shianlifezx.activity.ImagePreviewActivity;
import com.shian.shianlifezx.activity.map.NewRoutePlanActivity;
import com.shian.shianlifezx.activity.map.RoutePlanActivity;
import com.shian.shianlifezx.activity.Shenhe1Activity;
import com.shian.shianlifezx.common.contanst.AppContansts;
import com.shian.shianlifezx.common.utils.JSONUtil;
import com.shian.shianlifezx.common.utils.PicassoUD;
import com.shian.shianlifezx.common.utils.TArrayListAdapter;
import com.shian.shianlifezx.common.utils.TArrayListAdapter.IOnDrawViewEx;
import com.shian.shianlifezx.common.utils.ToastUtils;
import com.shian.shianlifezx.common.utils.Utils;
import com.shian.shianlifezx.common.utils.ViewGropMap;
import com.shian.shianlifezx.common.view.TipsDialog;
import com.shian.shianlifezx.provide.MHttpManagerFactory;
import com.shian.shianlifezx.provide.base.HttpResponseHandler;
import com.shian.shianlifezx.provide.params.HpAcceptParams;
import com.shian.shianlifezx.provide.params.HpPageParams;
import com.shian.shianlifezx.provide.params.HpRejectParams;
import com.shian.shianlifezx.provide.params.HpSkuIdParams;
import com.shian.shianlifezx.provide.params.HpStartServiceParams;
import com.shian.shianlifezx.provide.result.HrGetSKUDetails;
import com.shian.shianlifezx.provide.result.HrWaitExecuteList;
import com.shian.shianlifezx.provide.result.WaitItem;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ListItemView extends BaseOrderView {
    private TArrayListAdapter<WaitItem> adapter;
    private Handler mHandler = new Handler();
    private ListView mListView;
    private SwipeRefreshLayout mSryt;
    private SwipeRefreshHelper mSwipeRefreshHelper;
    private int mType;
    private int page = 0;
    private HpPageParams params = new HpPageParams();
    private View v;

    public ListItemView(Context paramContext) {
        this(paramContext, null);
    }

    public ListItemView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        this.v = LayoutInflater.from(paramContext).inflate(R.layout.view_order_qt, null, false);
        addView(this.v);
        initView();
        initDate();
    }

    private void initDate() {
        initAdapter();
        this.mListView.setAdapter(this.adapter);
        this.mSwipeRefreshHelper = new SwipeRefreshHelper(this.mSryt);
        this.mSwipeRefreshHelper.setOnSwipeRefreshListener(new OnSwipeRefreshListener() {

            @Override
            public void onfresh() {
                // TODO Auto-generated method stub
                refreshDate(true);
            }
        });
        this.mSwipeRefreshHelper.setOnLoadMoreListener(new OnLoadMoreListener() {

            @Override
            public void loadMore() {
                // TODO Auto-generated method stub
                refreshDate(false);
            }
        });
    }

    private void initView() {
        this.mSryt = ((SwipeRefreshLayout) this.v.findViewById(R.id.sryt_swipe_listview));
        this.mListView = ((ListView) this.v.findViewById(R.id.lv_swipe_listview));
        SwipeRefreshLayout localSwipeRefreshLayout = this.mSryt;
        localSwipeRefreshLayout.setColorSchemeColors(Color.BLUE);
    }

    private void initAdapter() {
        adapter = new TArrayListAdapter<WaitItem>(getContext());
        this.adapter.setLayout(R.layout.view_item_list);
        this.adapter.setDrawViewEx(new IOnDrawViewEx<WaitItem>() {

            @Override
            public void OnDrawViewEx(Context aContext, final WaitItem paramWaitItem, ViewGropMap paramViewGropMap,
                                     int aIndex) {
                // TODO Auto-generated method stub
                View tlt3 = paramViewGropMap.getView(R.id.rl_qt3);
                View tlt4 = paramViewGropMap.getView(R.id.rl_qt4);
                View rlPic = paramViewGropMap.getView(R.id.rl_pic);
                ImageView ivPic1 = (ImageView) paramViewGropMap.getView(R.id.btn_ht_pic_0);
                ImageView ivPic2 = (ImageView) paramViewGropMap.getView(R.id.btn_ht_pic_1);
                ImageView moreInfo= (ImageView) paramViewGropMap.getView(R.id.iv_data);
                ((TextView) paramViewGropMap.getView(R.id.tv_item_0))
                        .setText("派单时间:" + Utils.getDateUtils(paramWaitItem.getItemApplyTime()));
                TextView localTextView00 = (TextView) paramViewGropMap.getView(R.id.tv_item_00);
                TextView localTextView1 = (TextView) paramViewGropMap.getView(R.id.tv_item_1);
                TextView localTextView2 = (TextView) paramViewGropMap.getView(R.id.tv_item_2);
                TextView localTextView3 = (TextView) paramViewGropMap.getView(R.id.tv_item_3);
                TextView localTextView44 = (TextView) paramViewGropMap.getView(R.id.tv_item_4);
                TextView localTextView4 = (TextView) paramViewGropMap.getView(R.id.tv_item_6);
                TextView localTextView5 = (TextView) paramViewGropMap.getView(R.id.tv_item_5);
                TextView localTextView6 = (TextView) paramViewGropMap.getView(R.id.tv_item_7);
                TextView localTextView7 = (TextView) paramViewGropMap.getView(R.id.tv_item_8);
                TextView localTextView8 = (TextView) paramViewGropMap.getView(R.id.tv_item_88);
                TextView localTextView9 = (TextView) paramViewGropMap.getView(R.id.tv_item_9);
                TextView localTextView10 = (TextView) paramViewGropMap.getView(R.id.tv_item_99);
                TextView orderIDTextView = (TextView) paramViewGropMap.getView(R.id.order_id);
                localTextView1.setText(paramWaitItem.getCtgName());
                localTextView2.setText(paramWaitItem.getSkuName());
                localTextView3.setText(paramWaitItem.getNumber() + paramWaitItem.getSkuUnit());
                localTextView4.setText(paramWaitItem.getAdviserName());
                localTextView5.setText(paramWaitItem.getZsLocation());
                localTextView6.setText(paramWaitItem.getNote());
                localTextView7.setText(Utils.getDateUtils(paramWaitItem.getStartTime()));
                localTextView9.setText(Utils.getDateUtils(paramWaitItem.getAcceptTime()));
                localTextView44.setText(paramWaitItem.getSpecification());
                TextView localTextView11 = (TextView) paramViewGropMap.getView(R.id.tv_item_send);
                TextView localTextView12 = (TextView) paramViewGropMap.getView(R.id.accept);
                TextView localTextView13 = (TextView) paramViewGropMap.getView(R.id.reject);
                ImageView iv_call = (ImageView) paramViewGropMap.getView(R.id.iv_call);
                Button btnMap = (Button) paramViewGropMap.getView(R.id.button_map);


                moreInfo.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //获取商品详情
                        HpSkuIdParams params = new HpSkuIdParams();
                        params.setSkuId(paramWaitItem.getSkuId());
                        MHttpManagerFactory.getAccountManager().getSKUDetails(getContext(), params, new HttpResponseHandler<HrGetSKUDetails>() {
                            @Override
                            public void onStart() {

                            }

                            @Override
                            public void onSuccess(HrGetSKUDetails result) {

                                if (result.getDetails() != null && !result.getDetails().equals("")) {
                                    AlertDialog dialog = new AlertDialog.Builder(getContext())
                                            .setTitle("商品详情")
                                            .setMessage(result.getDetails())
                                            .setPositiveButton("确认", null)
                                            .create();
                                    dialog.show();
                                } else {
                                    ToastUtils.show(getContext(), "没有商品详情数据");
                                }
                            }

                            @Override
                            public void onError(String message) {

                            }
                        });

                    }
                });

                if (paramWaitItem.getZsLocation() == null) {
                    btnMap.setVisibility(GONE);
                }else if(paramWaitItem.getZsLocation().equals("")) {
                    btnMap.setVisibility(GONE);
                } else {
                    btnMap.setVisibility(VISIBLE);
                    btnMap.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getContext(), NewRoutePlanActivity.class);
                            intent.putExtra("LocationType",2);
                            intent.putExtra("ConsultId",-1);
                            intent.putExtra("OrderItemId",paramWaitItem.getOrderItemId());
                            intent.putExtra("RoutePlanLocation", paramWaitItem.getZsLocation());
                            getContext().startActivity(intent);

                        }
                    });
                }

                iv_call.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_CALL,
                                Uri.parse("tel:" + paramWaitItem.getAdviserMobile()));
                        v.getContext().startActivity(intent);

                    }
                });
                if (paramWaitItem.isShowAcceptOrRejectFlag()) {
                    localTextView12.setVisibility(View.VISIBLE);
                    localTextView13.setVisibility(View.VISIBLE);
                    localTextView11.setVisibility(View.GONE);
                } else {
                    localTextView12.setVisibility(View.GONE);
                    localTextView13.setVisibility(View.GONE);
                    localTextView11.setVisibility(View.VISIBLE);
                }

                if ((mType == 0 || mType == 1) && paramWaitItem.getItemAdditions().size() > 0) {
                    rlPic.setVisibility(View.VISIBLE);
                    PicassoUD.loadImage(getContext(),
                            AppContansts.OSSURL + paramWaitItem.getItemAdditions().get(0).getFileUrl(), ivPic1);
                    ivPic1.setOnClickListener(new OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            Intent mIntent = new Intent(getContext(), ImagePreviewActivity.class);
                            mIntent.putExtra("url",
                                    AppContansts.OSSURL + paramWaitItem.getItemAdditions().get(0).getFileUrl());
                            ((Activity) (getContext())).startActivity(mIntent);

                        }
                    });
                    if (paramWaitItem.getItemAdditions().size() > 1) {
                        PicassoUD.loadImage(getContext(),
                                AppContansts.OSSURL + paramWaitItem.getItemAdditions().get(1).getFileUrl(), ivPic2);
                        ivPic2.setOnClickListener(new OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                Intent mIntent = new Intent(getContext(), ImagePreviewActivity.class);
                                mIntent.putExtra("url",
                                        AppContansts.OSSURL + paramWaitItem.getItemAdditions().get(1).getFileUrl());
                                ((Activity) (getContext())).startActivity(mIntent);

                            }
                        });
                    } else {

                    }
                } else {
                    rlPic.setVisibility(View.GONE);
                }
                if (paramWaitItem.getOrderNum() != null) {
                    orderIDTextView.setText(paramWaitItem.getOrderNum() + "");//改（订单编号）
                }

                switch (mType) {
                    case 0:
                        tlt3.setVisibility(View.GONE);
                        tlt4.setVisibility(View.GONE);
                        localTextView7.setVisibility(View.GONE);
                        localTextView9.setVisibility(View.GONE);
                        localTextView12.setOnClickListener(new OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                // TODO Auto-generated method stub
                                reciver(paramWaitItem.getAssignId(), paramWaitItem.getOrderItemId());
                            }
                        });
                        localTextView13.setOnClickListener(new OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                // TODO Auto-generated method stub
                                reject(paramWaitItem.getAssignId(), paramWaitItem.getOrderItemId());
                            }
                        });
                        localTextView11.setOnClickListener(new OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                // TODO Auto-generated method stub
                                startService(paramWaitItem.getOrderItemId());
                            }
                        });
                        break;
                    case 1:
                        tlt4.setVisibility(View.GONE);
                        localTextView8.setText("开始时间:");
                        localTextView7.setText(Utils.getDateUtils(paramWaitItem.getStartTime()));
                        localTextView12.setVisibility(View.GONE);
                        localTextView13.setVisibility(View.GONE);
                        localTextView9.setVisibility(View.GONE);
                        localTextView11.setText("提交审核");
                        localTextView11.setOnClickListener(new OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                // TODO Auto-generated method stub
                                subimtSH(paramWaitItem);
                            }
                        });
                        break;
                    case 2:
                        localTextView12.setVisibility(View.GONE);
                        localTextView13.setVisibility(View.GONE);
                        localTextView11.setVisibility(View.GONE);
                        break;
                    case 3:
                        localTextView8.setText("申请审核时间:");
                        localTextView10.setText("审核通过时间:");
                        localTextView10.setVisibility(View.GONE);
                        localTextView7.setText(Utils.getDateUtils(paramWaitItem.getApplyTime()));
                        localTextView9.setText(Utils.getDateUtils(paramWaitItem.getPassTime()));
                        localTextView12.setVisibility(View.GONE);
                        localTextView13.setVisibility(View.GONE);
                        localTextView9.setVisibility(View.GONE);
                        localTextView11.setVisibility(GONE);//改
                        localTextView11.setText("审核已通过");
                        localTextView11.setEnabled(false);
                        localTextView11.setBackgroundColor(getResources().getColor(R.color.gray));
                        localTextView00.setVisibility(View.VISIBLE);
                        localTextView00.setText("完成时间:" + Utils.getDateUtils(paramWaitItem.getPassTime()));
                        break;
                    case 4:
                        localTextView8.setText("申请审核时间:");
                        localTextView10.setText("审核未通过时间:");
                        localTextView7.setText(Utils.getDateUtils(paramWaitItem.getApplyTime()));
                        localTextView9.setText(Utils.getDateUtils(paramWaitItem.getPassUnTime()));
                        localTextView12.setVisibility(View.GONE);
                        localTextView13.setVisibility(View.GONE);
                        localTextView9.setVisibility(View.GONE);
                        localTextView11.setText("再次提交审核");
                        localTextView00.setVisibility(View.VISIBLE);
                        localTextView11.setOnClickListener(new OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                // TODO Auto-generated method stub
                                subimtSH(paramWaitItem);
                            }
                        });
                        break;

                    default:
                        break;
                }
            }
        });
    }

    private void reciver(long paramLong1, long paramLong2) {
        HpAcceptParams localHpAcceptParams = new HpAcceptParams();
        localHpAcceptParams.setId(paramLong1);
        localHpAcceptParams.setOrderItemId(paramLong2);
        MHttpManagerFactory.getAccountManager().accept(getContext(), localHpAcceptParams,
                new HttpResponseHandler<String>() {

                    @Override
                    public void onSuccess(String result) {
                        // TODO Auto-generated method stub
                        ToastUtils.show(getContext(), "操作成功");
                        refresh(mType);
                    }

                    @Override
                    public void onStart() {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void onError(String message) {
                        // TODO Auto-generated method stub

                    }
                });
    }

    private void reject(long paramLong1, long paramLong2) {
        HpRejectParams localHpAcceptParams = new HpRejectParams();
        localHpAcceptParams.setId(paramLong1);
        localHpAcceptParams.setOrderItemId(paramLong2);
        MHttpManagerFactory.getAccountManager().reject(getContext(), localHpAcceptParams,
                new HttpResponseHandler<String>() {

                    @Override
                    public void onSuccess(String result) {
                        // TODO Auto-generated method stub
                        ToastUtils.show(getContext(), "操作成功");
                        refresh(mType);
                    }

                    @Override
                    public void onStart() {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void onError(String message) {
                        // TODO Auto-generated method stub

                    }
                });
    }

    private void refreshDate(final boolean paramBoolean) {
        if (paramBoolean)
            this.params.setPageNum(0);
        else
            this.params.setPageNum(20 + this.params.getPageNum());
        this.params.setPageSize(20);
        MHttpManagerFactory.getAccountManager().getWaitExecuteList((Activity) getContext(), this.mType, this.params,
                new HttpResponseHandler<HrWaitExecuteList>() {

                    @Override
                    public void onSuccess(HrWaitExecuteList result) {
                        // TODO Auto-generated method stub
                        if (paramBoolean) {
                            adapter.clear();
                            params.setPageNum(0);
                        }
                        adapter.addListData(result.getItems());
                        adapter.notifyDataSetChanged();
                        mSwipeRefreshHelper.refreshComplete();
                        mSwipeRefreshHelper.loadMoreComplete(true);
                        mSwipeRefreshHelper.setLoadMoreEnable(true);
                    }

                    @Override
                    public void onStart() {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void onError(String message) {
                        // TODO Auto-generated method stub

                    }
                });

    }

    private void startService(final long paramLong) {
        TipsDialog dialog = new TipsDialog(getContext());
        dialog.setTitle("请确认您现在开始为客户服务。");
        dialog.setTopButton("稍后开始", null);
        dialog.setBottomButton("现在开始", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                HpStartServiceParams localHpStartServiceParams = new HpStartServiceParams();
                localHpStartServiceParams.setOrderItemId(paramLong);
                MHttpManagerFactory.getAccountManager().startService(getContext(), localHpStartServiceParams,
                        new HttpResponseHandler<String>() {

                            @Override
                            public void onSuccess(String result) {
                                // TODO Auto-generated method stub
                                ToastUtils.show(getContext(), "操作成功");
                                refresh(mType);
                            }

                            @Override
                            public void onStart() {
                                // TODO Auto-generated method stub

                            }

                            @Override
                            public void onError(String message) {
                                // TODO Auto-generated method stub

                            }
                        });
            }
        });
        dialog.show();

    }

    private void subimtSH(WaitItem paramWaitItem) {

        Intent in = new Intent(getContext(), Shenhe1Activity.class);
        in.putExtra("data", JSONUtil.writeEntityToJSONString(paramWaitItem));
        getContext().startActivity(in);
        // HpSubmit4AuditParams localHpSubmit4AuditParams = new
        // HpSubmit4AuditParams();
        // localHpSubmit4AuditParams.setOrderItemId(paramLong);
        // MHttpManagerFactory.getAccountManager().submit4Audit(getContext(),
        // localHpSubmit4AuditParams, new HttpResponseHandler<String>() {
        //
        // @Override
        // public void onSuccess(String result) {
        // // TODO Auto-generated method stub
        // ToastUtils.show(getContext(), "操作成功");
        // refresh(mType);
        // }
        //
        // @Override
        // public void onStart() {
        // // TODO Auto-generated method stub
        //
        // }
        //
        // @Override
        // public void onError(String message) {
        // // TODO Auto-generated method stub
        //
        // }
        // });
    }

    public void refresh(int paramInt) {
        this.mType = paramInt;
        this.mSryt.post(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                mSwipeRefreshHelper.autoRefresh();
            }
        });
    }
}