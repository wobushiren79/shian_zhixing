package com.shian.shianlifezx.provide.params;

import com.shian.shianlifezx.provide.base.BaseHttpParams;

public class HpLoginParams extends BaseHttpParams
{
  private String channelId;
  private String password;
  private String systemType;
  private String username;

  public String getChannelId()
  {
    return this.channelId;
  }

  public String getPassword()
  {
    return this.password;
  }

  public String getSystemType()
  {
    return this.systemType;
  }

  public String getUsername()
  {
    return this.username;
  }

  public void setChannelId(String paramString)
  {
    this.channelId = paramString;
  }

  public void setPassword(String paramString)
  {
    this.password = paramString;
  }

  public void setSystemType(String paramString)
  {
    this.systemType = paramString;
  }

  public void setUsername(String paramString)
  {
    this.username = paramString;
  }
}

/* Location:           F:\software\dex2jar-0.0.9.9\classes_dex2jar.jar
 * Qualified Name:     com.shian.shianlifezx.provide.params.HpLoginParams
 * JD-Core Version:    0.6.0
 */