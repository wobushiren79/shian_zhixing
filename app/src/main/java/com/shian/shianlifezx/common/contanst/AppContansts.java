package com.shian.shianlifezx.common.contanst;

import com.shian.shianlifezx.provide.result.HrLoginResult;

public class AppContansts {
    public static final String BaseURL = "http://115.28.163.211:7080/shianlife-executor-1.0-SNAPSHOT";
    public static final String OSSURL = "http://shianlife123.oss-cn-qingdao.aliyuncs.com/";
    public static final String PhpURL = "http://192.168.0.72/shianapp";

    public static final String siftsPHPURL = PhpURL+"/home/index/sifts";//精选
    public static final String helpsPHPURL = PhpURL+"/home/index/helps";//帮助
    public static final String dynamicsPHPURL = PhpURL+"/home/index/dynamics";//动态
    public static final String phonePHPURL = PhpURL + "/home/index/phone";//通讯宝
    public static final String DiDichannel="";//滴滴渠道号

    public static int MessageCount = 0;
    public static String LOCAL_PROVINCE = "";
    public static String LOCAL_CITY = "";
    public static String LOCAL_COUNTY = "";
    public static String LocalString;
    public static String LOCAL_STREET = "";
    public static String LOCAL_STREETNUM = "";

    public static String LOCAL_ADDRESS = "";
    public static double LOCAL_latitude =30.6634450000;//纬度;
    public static double LOCAL_longitude=104.0722210000;//经度;

    public static HrLoginResult userLoginInfo=new HrLoginResult();

}
