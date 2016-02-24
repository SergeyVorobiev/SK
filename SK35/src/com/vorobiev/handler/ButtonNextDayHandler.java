package com.vorobiev.handler;

import android.os.Message;
import android.widget.ImageButton;
import com.vorobiev.objects.RightPanel;

public class ButtonNextDayHandler
  extends AbstractHandler
{
  RightPanel panel;
  
  public ButtonNextDayHandler(RightPanel paramRightPanel, int paramInt)
  {
    super(paramInt);
    this.panel = paramRightPanel;
  }
  
  public void update(Message paramMessage)
  {
    if (paramMessage.arg1 == 1) {
      this.panel.btn_day.setBackgroundResource(2130837575);
    }
    do
    {
      return;
      if (paramMessage.arg1 == 2)
      {
        this.panel.btn_week.setBackgroundResource(2130837698);
        return;
      }
      if (paramMessage.arg1 == 3)
      {
        this.panel.btn_mounth.setBackgroundResource(2130837623);
        return;
      }
      if (paramMessage.arg1 == -1)
      {
        this.panel.btn_day.setBackgroundResource(2130837574);
        return;
      }
      if (paramMessage.arg1 == -2)
      {
        this.panel.btn_week.setBackgroundResource(2130837697);
        return;
      }
    } while (paramMessage.arg1 != -3);
    this.panel.btn_mounth.setBackgroundResource(2130837622);
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\handler\ButtonNextDayHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */