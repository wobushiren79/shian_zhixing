package com.shian.shianlifezx.common.utils;

import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.PersistentCookieStore;

import org.apache.http.cookie.Cookie;

import java.util.ArrayList;
import java.util.List;

public class CookieUtils {
  
    private static List<Cookie> cookies;
  
    /* 返回cookies列表 */  
    public static List<Cookie> getCookies() {  
        return cookies != null ? cookies : new ArrayList<Cookie>();
    }  
  
    /* 设置cookies列表 */  
    public static void setCookies(List<Cookie> cookies) {  
        CookieUtils.cookies = cookies;  
    }  
  
    /* 存储cookie */  
    public static void saveCookie(AsyncHttpClient client, Context context) {
        PersistentCookieStore cookieStore = new PersistentCookieStore(context);
        client.setCookieStore(cookieStore);  
    }  
  
    /* 得到cookie */  
    public static List<Cookie> getCookie(Context context) {  
        PersistentCookieStore cookieStore = new PersistentCookieStore(context);  
        List<Cookie> cookies = cookieStore.getCookies();  
        return cookies;  
    }  
  
    /* 清除cookie */  
    public static void clearCookie(Context context) {  
        PersistentCookieStore cookieStore = new PersistentCookieStore(context);  
        cookieStore.clear();  
    }  
}  