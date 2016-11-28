package com.shian.shianlifezx.provide.params;

import com.shian.shianlifezx.provide.base.BaseHttpParams;

public class HpPageParams extends BaseHttpParams
{
  private int pageNum;
  private int pageSize;
  int ctgId;

  
  public int getCtgId() {
	return ctgId;
}

public void setCtgId(int ctgId) {
	this.ctgId = ctgId;
}

public int getPageNum()
  {
    return this.pageNum;
  }

  public int getPageSize()
  {
    return this.pageSize;
  }

  public void setPageNum(int paramInt)
  {
    this.pageNum = paramInt;
  }

  public void setPageSize(int paramInt)
  {
    this.pageSize = paramInt;
  }
}

/* Location:           F:\software\dex2jar-0.0.9.9\classes_dex2jar.jar
 * Qualified Name:     com.shian.shianlifezx.provide.params.HpPageParams
 * JD-Core Version:    0.6.0
 */