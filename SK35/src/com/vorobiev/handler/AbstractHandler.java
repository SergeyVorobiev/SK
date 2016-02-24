package com.vorobiev.handler;

import android.os.Message;

public abstract class AbstractHandler
{
  private int id;
  
  public AbstractHandler(int paramInt)
  {
    this.id = paramInt;
  }
  
  public final int getId()
  {
    return this.id;
  }
  
  public abstract void update(Message paramMessage);
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\handler\AbstractHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */