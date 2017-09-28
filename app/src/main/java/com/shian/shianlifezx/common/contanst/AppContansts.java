package com.shian.shianlifezx.common.contanst;

import com.shian.shianlifezx.mvp.login.bean.SystemLoginResultBean;
import com.shian.shianlifezx.provide.result.HrLoginResult;

import java.util.HashMap;
import java.util.List;

import okhttp3.Cookie;

public class AppContansts {
    //殡仪执行地址
    public static final String Funeral_Executor_BaseUrl = "http://115.28.163.211:7088/shianlife-executor-1.0-SNAPSHOT";
    //登陆地址
    public static final String Login_BaseUrl = "https://platform.shianlife.cn";
//    public static final String Login_BaseUrl = "http://192.168.0.57:8099/ki4so-web";
//    public static final String Login_BaseUrl = "http://prd-platform.xicp.cn";

    //单项地址
    public static final String Store_BaseUrl = "https://goods.shianlife.cn";
//    public static final String Store_BaseUrl = "http://192.168.0.57:8080/goods";
//    public static final String Store_BaseUrl = "http://prd-goods.xicp.cn";

    //PHP地址
    public static final String PHP_BaseUrl = "http://app.e-funeral.cn";
    public static final String PHP_Web_BaseUrl = "http://m.e-funeral.cn";
    public static final String PHP_WeChat_BaseUrl = "http://wechat.e-funeral.cn";

    public static final String siftsPHPURL = PHP_BaseUrl + "/home/index/sifts";//精选
    public static final String helpsPHPURL = PHP_BaseUrl + "/home/index/helps";//帮助
    public static final String dynamicsPHPURL = PHP_BaseUrl + "/home/index/dynamics";//动态
    public static final String phonePHPURL = PHP_BaseUrl + "/home/index/phone";//通讯宝
    public static final String DiDichannel = "";//滴滴渠道号

    //阿里云文件上传
    public static final String FILE_ALIYUN_UPDATA = Funeral_Executor_BaseUrl + "/file/upload";
    //阿里云文件查看地址
    public static final String OSSURL = "http://shianlife123.oss-cn-qingdao.aliyuncs.com/";


    //登陆系统KEY
    public static String System_Ki4so_Client_Ec;
    //子系统-单项  登陆地址
    public static final String Login_Store_Url = Store_BaseUrl + "/login_sys_api";

    public static int MessageCount = 0;
    public static String LOCAL_PROVINCE = "";
    public static String LOCAL_CITY = "";
    public static String LOCAL_COUNTY = "";
    public static String LocalString;
    public static String LOCAL_STREET = "";
    public static String LOCAL_STREETNUM = "";

    public static String LOCAL_ADDRESS = "";
    public static double LOCAL_latitude = 30.6634450000;//纬度;
    public static double LOCAL_longitude = 104.0722210000;//经度;

    //平台用户数据
    public static SystemLoginResultBean systemLoginInfo;

    //cookie保存
    public static final HashMap<String, List<Cookie>> cookieStore = new HashMap<>();

    //招商图片
    public static final String Cooperation_Pic_1 = "http://ovjs2f1iz.bkt.clouddn.com/index1.png";
    public static final String Cooperation_Pic_2 = "http://ovjs2f1iz.bkt.clouddn.com/index2.png";
    public static final String Cooperation_Pic_3 = "http://ovjs2f1iz.bkt.clouddn.com/index3.png";
}
