package com.shian.shianlifezx.provide.params;

import com.shian.shianlifezx.provide.base.BaseHttpParams;

public class HpRejectParams extends BaseHttpParams
{
  private long id;
  private long orderItemId;

  public long getId()
  {
    return this.id;
  }

  public long getOrderItemId()
  {
    return this.orderItemId;
  }

  public void setId(long paramLong)
  {
    this.id = paramLong;
  }

  public void setOrderItemId(long paramLong)
  {
    this.orderItemId = paramLong;
  }
}

/* Location:           F:\software\dex2jar-0.0.9.9\classes_dex2jar.jar
 * Qualified Name:     com.shian.shianlifezx.provide.params.HpRejectParams
 * JD-Core Version:    0.6.0
 */