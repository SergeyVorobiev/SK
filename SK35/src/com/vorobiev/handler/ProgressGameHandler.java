package com.vorobiev.handler;

import android.os.Message;
import android.widget.ProgressBar;

public class ProgressGameHandler
  extends AbstractHandler
{
  private ProgressBar progress;
  
  public ProgressGameHandler(ProgressBar paramProgressBar, int paramInt)
  {
    super(paramInt);
    this.progress = paramProgressBar;
  }
  
  public void update(Message paramMessage)
  {
    this.progress.setProgress(paramMessage.arg1);
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\handler\ProgressGameHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */