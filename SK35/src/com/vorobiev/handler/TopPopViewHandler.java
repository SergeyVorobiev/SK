package com.vorobiev.handler;

import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.vorobiev.myAnimation.TopRightPopView;

public class TopPopViewHandler
  extends AbstractHandler
{
  private TopRightPopView topRightPopView;
  
  public TopPopViewHandler(TopRightPopView paramTopRightPopView, int paramInt)
  {
    super(paramInt);
    this.topRightPopView = paramTopRightPopView;
  }
  
  public void update(Message paramMessage)
  {
    int j = paramMessage.arg1;
    paramMessage = this.topRightPopView.getView();
    paramMessage.setBackgroundResource(com.vorobiev.data.ResourceArray.res_pop_resource[j]);
    int i = j;
    if (j > 14) {
      i = j - 15;
    }
    paramMessage = (TextView)paramMessage.findViewById(2131361938);
    if ((i == 8) || (i == 10) || (i == 11) || (i == 13)) {
      paramMessage.setTextColor(-1);
    }
    for (;;)
    {
      paramMessage.setText(String.valueOf(com.vorobiev.data.Player.curCount[i] + "m"));
      this.topRightPopView.start();
      return;
      paramMessage.setTextColor(-16777216);
    }
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\handler\TopPopViewHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */