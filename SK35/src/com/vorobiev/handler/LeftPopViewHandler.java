package com.vorobiev.handler;

import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.vorobiev.myAnimation.LeftPopView;

public class LeftPopViewHandler
  extends AbstractHandler
{
  LeftPopView leftPopView;
  
  public LeftPopViewHandler(LeftPopView paramLeftPopView, int paramInt)
  {
    super(paramInt);
    this.leftPopView = paramLeftPopView;
  }
  
  public void update(Message paramMessage)
  {
    View localView = this.leftPopView.getView();
    ((ImageView)localView.findViewById(2131361928)).setImageResource(com.vorobiev.data.ResourceArray.res_mark[paramMessage.arg2]);
    ImageView localImageView = (ImageView)localView.findViewById(2131361929);
    if (paramMessage.arg1 > 0) {
      localImageView.setImageResource(2130837510);
    }
    for (;;)
    {
      ((TextView)localView.findViewById(2131361930)).setText(String.valueOf(com.vorobiev.data.Player.sellResource[paramMessage.arg2]));
      this.leftPopView.start();
      return;
      if (paramMessage.arg1 < 0) {
        localImageView.setImageResource(2130837508);
      } else {
        localImageView.setImageResource(2130837509);
      }
    }
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\handler\LeftPopViewHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */