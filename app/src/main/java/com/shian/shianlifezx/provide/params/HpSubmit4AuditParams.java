package com.shian.shianlifezx.provide.params;

import java.util.List;

import com.shian.shianlifezx.provide.base.BaseHttpParams;

public class HpSubmit4AuditParams extends BaseHttpParams
{
  private List<AddAddition> addAdditions;
  private String executorNote;
  private long orderItemId;
  private List<RemoveAddition> removeAdditions;

  public List<AddAddition> getAddAdditions()
  {
    return this.addAdditions;
  }

  public String getExecutorNote()
  {
    return this.executorNote;
  }

  public long getOrderItemId()
  {
    return this.orderItemId;
  }

  public List<RemoveAddition> getRemoveAdditions()
  {
    return this.removeAdditions;
  }

  public void setAddAdditions(List<AddAddition> paramList)
  {
    this.addAdditions = paramList;
  }

  public void setExecutorNote(String paramString)
  {
    this.executorNote = paramString;
  }

  public void setOrderItemId(long paramLong)
  {
    this.orderItemId = paramLong;
  }

  public void setRemoveAdditions(List<RemoveAddition> paramList)
  {
    this.removeAdditions = paramList;
  }

  public static class AddAddition
  {
    private String fileName;
    private String fileUrl;

    public AddAddition()
    {
    }

    public String getFileName()
    {
      return this.fileName;
    }

    public String getFileUrl()
    {
      return this.fileUrl;
    }

    public void setFileName(String paramString)
    {
      this.fileName = paramString;
    }

    public void setFileUrl(String paramString)
    {
      this.fileUrl = paramString;
    }
  }

  public class RemoveAddition
  {
    private long id;

    public RemoveAddition()
    {
    }

    public long getId()
    {
      return this.id;
    }

    public void setId(long paramLong)
    {
      this.id = paramLong;
    }
  }
}

/* Location:           F:\software\dex2jar-0.0.9.9\classes_dex2jar.jar
 * Qualified Name:     com.shian.shianlifezx.provide.params.HpSubmit4AuditParams
 * JD-Core Version:    0.6.0
 */