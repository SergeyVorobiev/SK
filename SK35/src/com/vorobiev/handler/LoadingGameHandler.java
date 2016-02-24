package com.vorobiev.handler;

import android.os.Message;
import com.vorobiev.data.LoadingData;
import com.vorobiev.sk.GameLayout;
import com.vorobiev.sk.MainActivity;
import com.vorobiev.surfaceHolder.FastRenderView;

public class LoadingGameHandler
  extends AbstractHandler
{
  private MainActivity activity;
  
  public LoadingGameHandler(MainActivity paramMainActivity, int paramInt)
  {
    super(paramInt);
    this.activity = paramMainActivity;
  }
  
  public void update(Message paramMessage)
  {
    if (paramMessage.arg1 == 1)
    {
      MainActivity.startLoading = true;
      LoadingData.LoadGame(this.activity.getFileIO());
      MainActivity.countLoading = 0;
      MainActivity.startLoading = false;
      this.activity.renderView.pause();
      this.activity.gameLayout = new GameLayout(this.activity, false);
      return;
    }
    this.activity.renderView.pause();
    this.activity.gameLayout = new GameLayout(this.activity, true);
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\handler\LoadingGameHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */