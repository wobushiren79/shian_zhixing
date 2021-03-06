package com.shian.shianlifezx.thisenum;


import com.shian.shianlifezx.R;
import com.shian.shianlifezx.activity.order.FuneralServiceActivity;
import com.shian.shianlifezx.activity.order.StoreServiceActivity;

/**
 * Created by zm.
 */

public enum OrderItemShowEnum {
    cemetery(1, "圆满-公墓", R.drawable.order_cemetery_icon, null),
    funeral(2, "圆满-白事", R.drawable.order_funeral_icon, FuneralServiceActivity.class),
    store(3, "圆满-商城", R.drawable.order_store_icon, StoreServiceActivity.class);

    private int code;
    private String name;
    private int itemPic;
    private Class<?> intentClass;

    OrderItemShowEnum(int code, String name, int itemPic, Class<?> intentClass) {
        this.code = code;
        this.name = name;
        this.itemPic = itemPic;
        this.intentClass = intentClass;
    }


    public Class<?> getIntentClass() {
        return intentClass;
    }

    public void setIntentClass(Class<?> intentClass) {
        this.intentClass = intentClass;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getItemPic() {
        return itemPic;
    }

    public void setItemPic(int itemPic) {
        this.itemPic = itemPic;
    }
}
