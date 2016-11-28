package com.shian.shianlifezx.provide.base;

import android.util.Log;

import com.shian.shianlifezx.common.utils.JSONUtil;
import com.shian.shianlifezx.provide.params.ContentParams;

/**
 * 接口参数
 * 
 * @author Administrator
 * 
 */
public class BaseHttpParams
{

	public String getHttpParams() {
		ContentParams<BaseHttpParams> pa=	new ContentParams<BaseHttpParams>();
		pa.setContent(this);
		String contentParams=JSONUtil.writeEntityToJSONString(pa);
		Log.e("tag", "contentParams="+contentParams);
		return contentParams;
	}
}
