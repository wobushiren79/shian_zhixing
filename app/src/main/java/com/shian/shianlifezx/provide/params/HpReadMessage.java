package com.shian.shianlifezx.provide.params;

import java.util.List;

import com.shian.shianlifezx.provide.base.BaseHttpParams;

public class HpReadMessage extends BaseHttpParams{
	private List<Long> msgIds;

	public List<Long> getMsgIds() {
		return msgIds;
	}

	public void setMsgIds(List<Long> msgIds) {
		this.msgIds = msgIds;
	}
	
}
