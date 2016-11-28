package com.shian.shianlifezx.provide.params;

import com.shian.shianlifezx.provide.base.BaseHttpParams;

public class HpOrderIdParams extends BaseHttpParams
{
  long orderId;
  long orderItemId;
  String payAmount;
  long payId;

  public long getOrderId()
  {
    return this.orderId;
  }

  public long getOrderItemId()
  {
    return this.orderItemId;
  }

  public String getPayAmount()
  {
    return this.payAmount;
  }

  public long getPayId()
  {
    return this.payId;
  }

  public void setOrderId(long paramLong)
  {
    this.orderId = paramLong;
  }

  public void setOrderItemId(long paramLong)
  {
    this.orderItemId = paramLong;
  }

  public void setPayAmount(String paramString)
  {
    this.payAmount = paramString;
  }

  public void setPayId(long paramLong)
  {
    this.payId = paramLong;
  }
}

/* Location:           F:\software\dex2jar-0.0.9.9\classes_dex2jar.jar
 * Qualified Name:     com.shian.shianlifezx.provide.params.HpOrderIdParams
 * JD-Core Version:    0.6.0
 */