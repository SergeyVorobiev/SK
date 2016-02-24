package com.vorobiev.handler;

import android.os.Message;
import com.vorobiev.myDialogs.DialogBigNalog;

public class BigNalogHandler
  extends AbstractHandler
{
  private DialogBigNalog bigNalog;
  
  public BigNalogHandler(DialogBigNalog paramDialogBigNalog, int paramInt)
  {
    super(paramInt);
    this.bigNalog = paramDialogBigNalog;
  }
  
  public void update(Message paramMessage)
  {
    this.bigNalog.show();
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\handler\BigNalogHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */