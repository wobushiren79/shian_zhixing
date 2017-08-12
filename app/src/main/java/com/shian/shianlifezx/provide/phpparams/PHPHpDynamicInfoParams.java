package com.shian.shianlifezx.provide.phpparams;

import com.shian.shianlifezx.provide.base.BaseHttpParams;

/**
 * Created by zm.
 */

public class PHPHpDynamicInfoParams extends BaseHttpParams {
    private int number;
    private int pagerNumber;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPagerNumber() {
        return pagerNumber;
    }

    public void setPagerNumber(int pagerNumber) {
        this.pagerNumber = pagerNumber;
    }
}
