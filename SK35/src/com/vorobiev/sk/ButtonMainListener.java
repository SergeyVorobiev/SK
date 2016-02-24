package com.vorobiev.sk;

import android.content.Intent;
import android.view.View;
import com.vorobiev.gameInterface.Sound;
import com.vorobiev.gameclass.Assets;
import com.vorobiev.handler.MyHandlers;
import com.vorobiev.myDialogs.DialogNewGame;

public class ButtonMainListener
  implements MyTouchListener.MyDownButtonAction
{
  private MainActivity activity;
  
  public ButtonMainListener(MainActivity paramMainActivity)
  {
    this.activity = paramMainActivity;
  }
  
  public void actionOnClick(View paramView)
  {
    Assets.btn_click.play(0.5F);
    switch (paramView.getId())
    {
    default: 
      return;
    case 0: 
      this.activity.mainMenu = false;
      this.activity.hideButton();
      MainActivity.myHandlers.send(301, 1);
      return;
    case 1: 
      if (this.activity.isFile())
      {
        this.activity.dialogNewGame.show();
        return;
      }
      this.activity.mainMenu = false;
      this.activity.hideButton();
      MainActivity.myHandlers.send(301);
      return;
    case 2: 
      paramView = new Intent();
      paramView.setClass(this.activity, ActivityScore.class);
      this.activity.startActivity(paramView);
      return;
    case 3: 
      paramView = new Intent();
      paramView.setClass(this.activity, ActivityAuthors.class);
      this.activity.startActivity(paramView);
      return;
    case 4: 
      paramView = new Intent();
      paramView.setClass(this.activity, ActivityHelp.class);
      this.activity.startActivity(paramView);
      return;
    }
    this.activity.finish();
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\sk\ButtonMainListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */