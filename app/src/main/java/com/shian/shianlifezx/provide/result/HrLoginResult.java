package com.shian.shianlifezx.provide.result;

public class HrLoginResult
{
  private String lastAccessTime;
  private String sessionId;
  private String startTimestamp;
  private long userId;


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }
  public String getLastAccessTime()
  {
    return this.lastAccessTime;
  }

  public String getSessionId()
  {
    return this.sessionId;
  }

  public String getStartTimestamp()
  {
    return this.startTimestamp;
  }

  public void setLastAccessTime(String paramString)
  {
    this.lastAccessTime = paramString;
  }

  public void setSessionId(String paramString)
  {
    this.sessionId = paramString;
  }

  public void setStartTimestamp(String paramString)
  {
    this.startTimestamp = paramString;
  }
}

/* Location:           F:\software\dex2jar-0.0.9.9\classes_dex2jar.jar
 * Qualified Name:     com.shian.shianlifezx.provide.result.HrLoginResult
 * JD-Core Version:    0.6.0
 */