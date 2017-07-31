package com.shian.shianlifezx.thisenum;

/**
 * Created by zm.
 */

public enum StoreOrderListEnum {
    waitservice(1, "待服务"),
    inservice(2, "服务中"),
    inaduit(3, "审核中"),
    successservice(4, "成功服务"),
    nosuccess(5, "未通过"),
    cancel(6, "交易关闭");

    private int code;
    private String name;

    StoreOrderListEnum(int code, String name) {
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
}
