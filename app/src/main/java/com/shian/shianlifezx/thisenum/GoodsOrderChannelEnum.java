package com.shian.shianlifezx.thisenum;

/**
 * Created by zm
 * 订单来源
 */
public enum GoodsOrderChannelEnum{
    app(0, "顾问APP"),
    wechat(1, "客户小程序"),
    counselor_wechat(2,"顾问小程序");

    private int code;
    private String name;

    GoodsOrderChannelEnum(int code, String name) {
        this.code = code;
        this.name = name;
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

    public static String getValueText(Integer status) {
        if (status == null)
            return null;
        for (GoodsOrderChannelEnum e : GoodsOrderChannelEnum.values()) {
            if (e.getCode() == status) {
                return e.getName();
            }
        }
        return null;
    }
}
