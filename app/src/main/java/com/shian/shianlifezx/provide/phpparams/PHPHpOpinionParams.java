package com.shian.shianlifezx.provide.phpparams;

import com.shian.shianlifezx.provide.base.BaseHttpParams;
import com.shian.shianlifezx.thisenum.SystemTypeEnum;

/**
 * Created by zm.
 */

public class PHPHpOpinionParams extends BaseHttpParams {
    private String user;
    private String tel;
    private String content;
    private int userType;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
}
