package com.shian.shianlifezx.provide;

import com.shian.shianlifezx.provide.imp.FileManager;
import com.shian.shianlifezx.provide.imp.FuneralExecutorManager;
import com.shian.shianlifezx.provide.imp.PHPManager;
import com.shian.shianlifezx.provide.imp.StoreManager;
import com.shian.shianlifezx.provide.imp.SystemManager;
import com.shian.shianlifezx.provide.imp.WeChatManager;
import com.shian.shianlifezx.provide.imp.impl.FileManagerImpl;
import com.shian.shianlifezx.provide.imp.impl.FuneralExecutorManagerImp;
import com.shian.shianlifezx.provide.imp.impl.PHPManagerImpl;
import com.shian.shianlifezx.provide.imp.impl.StoreManagerImpl;
import com.shian.shianlifezx.provide.imp.impl.SystemManagerImpl;
import com.shian.shianlifezx.provide.imp.impl.WeChatManagerImpl;

/**
 * 接口工厂
 *
 * @author Administrator
 */
public class MHttpManagerFactory {
    /**
     * 获取账户接口manager
     *
     * @return
     */

    public static FileManager getFileManager() {
        return FileManagerImpl.getInstance();
    }

    public static PHPManager getPHPManager() {
        return PHPManagerImpl.getInstance();
    }

    //单项
    public static StoreManager getStoreManager() {
        return StoreManagerImpl.getInstance();
    }

    //殡仪执行
    public static FuneralExecutorManager getFuneralExecutorManager() {
        return FuneralExecutorManagerImp.getInstance();
    }
    //登录
    public static SystemManager getSystemManager() {
        return SystemManagerImpl.getInstance();
    }

    //积分管理
    public static WeChatManager getWeChatManager() {
        return WeChatManagerImpl.getInstance();
    }
}
