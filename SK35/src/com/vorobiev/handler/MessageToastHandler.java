package com.vorobiev.handler;

import android.os.Message;
import android.widget.Toast;
import com.vorobiev.gameInterface.Sound;
import com.vorobiev.gameclass.Assets;
import com.vorobiev.myDialogs.DialogStart;
import com.vorobiev.sk.GameLayout;
import com.vorobiev.sk.MainActivity;

public class MessageToastHandler
  extends AbstractHandler
{
  private MainActivity activity;
  
  public MessageToastHandler(MainActivity paramMainActivity, int paramInt)
  {
    super(paramInt);
    this.activity = paramMainActivity;
  }
  
  public void update(Message paramMessage)
  {
    if (paramMessage.arg1 == 0) {
      Toast.makeText(this.activity, "Прибыла группа ссыльных (" + String.valueOf(15) + " человек)", 0).show();
    }
    do
    {
      return;
      if (paramMessage.arg1 == 1)
      {
        Toast.makeText(this.activity, "Прибыла группа ссыльных (" + String.valueOf(15) + " человек). Не всем людям хватило места", 0).show();
        return;
      }
      if (paramMessage.arg1 == 2)
      {
        Toast.makeText(this.activity, "Через месяц прибудет группа ссыльных, подготовьте жилье", 0).show();
        return;
      }
      if (paramMessage.arg1 == 3)
      {
        Toast.makeText(this.activity, "Долг по кредиту вырос до: " + String.valueOf(com.vorobiev.data.Player.resource[20]), 0).show();
        return;
      }
      if (paramMessage.arg1 == 4)
      {
        Toast.makeText(this.activity, "Одно или несколько зданий изношены", 0).show();
        return;
      }
      if (paramMessage.arg1 == 5)
      {
        Toast.makeText(this.activity, "Через месяц необходимо будет выплатить главный налог", 0).show();
        return;
      }
    } while (paramMessage.arg1 != 6);
    this.activity.gameLayout.dialogStart.show();
    Assets.start.play(1.0F);
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\handler\MessageToastHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */