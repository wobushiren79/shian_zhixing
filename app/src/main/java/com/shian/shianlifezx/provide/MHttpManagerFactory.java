package com.shian.shianlifezx.provide;

import com.shian.shianlifezx.provide.imp.FileManager;
import com.shian.shianlifezx.provide.imp.MAccountManager;
import com.shian.shianlifezx.provide.imp.MUserManager;
import com.shian.shianlifezx.provide.imp.PHPManager;
import com.shian.shianlifezx.provide.imp.StoreManager;
import com.shian.shianlifezx.provide.imp.impl.FileManagerImpl;
import com.shian.shianlifezx.provide.imp.impl.MAccountManagerImpl;
import com.shian.shianlifezx.provide.imp.impl.MUserManagerImpl;
import com.shian.shianlifezx.provide.imp.impl.PHPManagerImpl;
import com.shian.shianlifezx.provide.imp.impl.StoreManagerImpl;

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
    public static MAccountManager getAccountManager() {
        return MAccountManagerImpl.getInstance();
    }

    public static MUserManager getMUserManager() {
        return MUserManagerImpl.getInstance();
    }

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
}
