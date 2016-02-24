package com.vorobiev.handler;

import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.vorobiev.myAnimation.CongratulationView;
import com.vorobiev.objects.MyDate;
import com.vorobiev.sk.GameLayout;

public class CongratulationHandler
  extends AbstractHandler
{
  CongratulationView congratView;
  
  public CongratulationHandler(CongratulationView paramCongratulationView, int paramInt)
  {
    super(paramInt);
    this.congratView = paramCongratulationView;
  }
  
  public void update(Message paramMessage)
  {
    View localView = this.congratView.getView();
    TextView localTextView = (TextView)localView.findViewById(2131361923);
    if (paramMessage.arg1 == 1) {
      localView.setBackgroundResource(2130837630);
    }
    if (paramMessage.arg1 == 2) {
      localView.setBackgroundResource(2130837629);
    }
    for (;;)
    {
      localTextView.setText(GameLayout.date.getDate());
      this.congratView.start();
      return;
      if (paramMessage.arg1 == 3) {
        localView.setBackgroundResource(2130837631);
      }
    }
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\handler\CongratulationHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */