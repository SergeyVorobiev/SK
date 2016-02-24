package com.vorobiev.myAnimation;

import android.content.Context;
import android.view.View;
import com.vorobiev.gameInterface.Sound;
import com.vorobiev.gameclass.Assets;

public class CongratulationView
  extends MyAnimation
{
  public CongratulationView(Context paramContext, View paramView, int paramInt)
  {
    super(paramContext, paramView, paramInt);
  }
  
  public View getView()
  {
    return this.view;
  }
  
  protected void update(View paramView)
  {
    Assets.congratulation.play(1.0F);
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\myAnimation\CongratulationView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */