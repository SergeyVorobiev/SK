package com.vorobiev.sk;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import com.vorobiev.gameInterface.Sound;
import com.vorobiev.gameclass.Assets;
import com.vorobiev.surfaceHolder.FastRenderView;

public class MyTouchButtonPause
  implements MyTouchListener.MyDownButtonAction
{
  private ActivityPause activity;
  
  public MyTouchButtonPause(ActivityPause paramActivityPause)
  {
    this.activity = paramActivityPause;
  }
  
  public void actionOnClick(View paramView)
  {
    Assets.btn_click.play(0.5F);
    switch (paramView.getId())
    {
    default: 
      return;
    case 0: 
      paramView = new Intent();
      paramView.putExtra("result", 2);
      this.activity.setResult(-1, paramView);
      this.activity.renderView.pause();
      this.activity.finish();
      return;
    case 1: 
      ActivityPause.saved = true;
      this.activity.hideButtons();
      this.activity.handler.sendMessageDelayed(this.activity.handler.obtainMessage(), 1L);
      return;
    case 2: 
      paramView = new Intent();
      paramView.setClass(this.activity, ActivityHelp.class);
      this.activity.startActivity(paramView);
      return;
    case 3: 
      this.activity.showDialog(101);
      return;
    }
    if (ActivityPause.saved)
    {
      paramView = new Intent();
      paramView.putExtra("result", 1);
      this.activity.setResult(-1, paramView);
      this.activity.renderView.pause();
      this.activity.finish();
      return;
    }
    this.activity.showDialog(100);
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\sk\MyTouchButtonPause.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */