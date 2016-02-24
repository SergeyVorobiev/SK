package com.vorobiev.handler;

import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;

public class MyHandlers
  extends Handler
{
  private SparseArray<AbstractHandler> arrayHandler = new SparseArray();
  
  public void dispose()
  {
    this.arrayHandler.clear();
  }
  
  public AbstractHandler getHandler(int paramInt)
  {
    return (AbstractHandler)this.arrayHandler.get(paramInt);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    AbstractHandler localAbstractHandler = (AbstractHandler)this.arrayHandler.get(paramMessage.what);
    if (localAbstractHandler != null) {
      localAbstractHandler.update(paramMessage);
    }
  }
  
  public void registerHandler(AbstractHandler paramAbstractHandler)
  {
    if (this.arrayHandler.get(paramAbstractHandler.getId()) == null)
    {
      this.arrayHandler.put(paramAbstractHandler.getId(), paramAbstractHandler);
      return;
    }
    throw new RuntimeException("Handler с таким ID уже существует: " + String.valueOf(paramAbstractHandler.getId()));
  }
  
  public void send(int paramInt)
  {
    sendMessage(obtainMessage(paramInt));
  }
  
  public void send(int paramInt1, int paramInt2)
  {
    sendMessage(obtainMessage(paramInt1, paramInt2, 0));
  }
  
  public void send(int paramInt1, int paramInt2, int paramInt3)
  {
    sendMessage(obtainMessage(paramInt1, paramInt2, paramInt3));
  }
  
  public void send(AbstractHandler paramAbstractHandler)
  {
    sendMessage(obtainMessage(paramAbstractHandler.getId()));
  }
  
  public void send(AbstractHandler paramAbstractHandler, int paramInt)
  {
    sendMessage(obtainMessage(paramAbstractHandler.getId(), paramInt, 0));
  }
  
  public void send(AbstractHandler paramAbstractHandler, int paramInt1, int paramInt2)
  {
    sendMessage(obtainMessage(paramAbstractHandler.getId(), paramInt1, paramInt2));
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\handler\MyHandlers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */