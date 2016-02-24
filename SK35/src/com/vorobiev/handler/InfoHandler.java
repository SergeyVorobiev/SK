package com.vorobiev.handler;

import android.os.Message;
import android.widget.TextView;
import com.vorobiev.sk.GameLayout;

public class InfoHandler
  extends AbstractHandler
{
  public InfoHandler(int paramInt)
  {
    super(paramInt);
  }
  
  public void update(Message paramMessage)
  {
    GameLayout.textScore.setText("Очки: " + String.valueOf(com.vorobiev.data.Player.resource[21]));
    GameLayout.textFPS.setText("FPS: " + String.valueOf(GameLayout.fps));
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\handler\InfoHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */