package com.vorobiev.handler;

import android.os.Message;
import com.vorobiev.sk.MainActivity;

public class ButtonVisibleHandler
  extends AbstractHandler
{
  private MainActivity activity;
  
  public ButtonVisibleHandler(MainActivity paramMainActivity, int paramInt)
  {
    super(paramInt);
    this.activity = paramMainActivity;
  }
  
  public void update(Message paramMessage)
  {
    this.activity.visibleButtons();
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\handler\ButtonVisibleHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */