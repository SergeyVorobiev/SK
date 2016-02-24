package com.vorobiev.sk;

import android.view.View;
import android.view.View.OnClickListener;

public class ButtonPlayListener
  implements View.OnClickListener
{
  ComputThread comput;
  
  public ButtonPlayListener(ComputThread paramComputThread)
  {
    this.comput = paramComputThread;
  }
  
  public void onClick(View paramView)
  {
    this.comput.start(paramView.getId());
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\sk\ButtonPlayListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */