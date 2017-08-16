package com.shian.shianlifezx.thisenum;

/**
 * Created by zm.
 */

public enum RoleEnum {
    Car_Driver("car.driver", "派车司机"),
    Goods_Audit("goods.auditor", "单项审核员"),
    Goods_Executor("goods.executor","单项执行者"),
    Funeral_Executor("funeral.executor","殡仪执行者");

    private String code;
    private String name;

    RoleEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
