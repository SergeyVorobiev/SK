package com.vorobiev.handler;

import android.os.Message;
import com.vorobiev.myDialogs.DialogNalog;

public class DialogNalogHandler
  extends AbstractHandler
{
  private DialogNalog dialogNalog;
  
  public DialogNalogHandler(DialogNalog paramDialogNalog, int paramInt)
  {
    super(paramInt);
    this.dialogNalog = paramDialogNalog;
  }
  
  public void update(Message paramMessage)
  {
    this.dialogNalog.show();
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\handler\DialogNalogHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */