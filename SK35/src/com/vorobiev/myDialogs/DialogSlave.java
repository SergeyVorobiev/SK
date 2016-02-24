package com.vorobiev.myDialogs;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.vorobiev.data.Player;
import com.vorobiev.gameInterface.Sound;
import com.vorobiev.gameclass.Assets;
import com.vorobiev.objects.RightPanel;
import com.vorobiev.sk.GameLayout;
import com.vorobiev.sk.MyTouchListener;
import com.vorobiev.sk.MyTouchListener.MyDownButtonAction;

public class DialogSlave
  extends MyDialog
{
  private Button button_up;
  private View dialogSlaveView;
  private TextView textCost;
  private TextView textLevel;
  private TextView textSize;
  private TextView textZa;
  
  public DialogSlave(Context paramContext)
  {
    super(paramContext);
  }
  
  @SuppressLint({"InflateParams"})
  protected void create(AlertDialog paramAlertDialog)
  {
    this.dialogSlaveView = LayoutInflater.from(this.activity).inflate(2130903048, null);
    this.textLevel = ((TextView)this.dialogSlaveView.findViewById(2131361906));
    this.textSize = ((TextView)this.dialogSlaveView.findViewById(2131361907));
    this.textCost = ((TextView)this.dialogSlaveView.findViewById(2131361910));
    this.button_up = ((Button)this.dialogSlaveView.findViewById(2131361908));
    this.textZa = ((TextView)this.dialogSlaveView.findViewById(2131361909));
    MyTouchListener localMyTouchListener = new MyTouchListener(2130837533, 2130837534, new MyTouchListener.MyDownButtonAction()
    {
      public void actionOnClick(View paramAnonymousView)
      {
        if ((Player.resource[15] >= Player.costBirth) && (Player.levelBirth < 20))
        {
          Assets.money.play(1.0F);
          paramAnonymousView = Player.resource;
          paramAnonymousView[15] -= Player.costBirth;
          Player.costBirth *= 2L;
          double d = 1.0D / Player.levelBirth;
          Player.multiplePeople = (float)(Player.multiplePeople * Math.pow(2.0D, d));
          Player.levelBirth += 1;
          DialogSlave.this.textLevel.setText("Уровень " + String.valueOf(Player.levelBirth));
          int i = (int)(Player.multiplePeople / Player.koefPeopleTwo * Player.numPeople * 365.0F);
          DialogSlave.this.textSize.setText(String.valueOf(i));
          DialogSlave.this.textCost.setText(String.valueOf(Player.costBirth));
          GameLayout.rightPanel.updateMoney();
        }
        for (;;)
        {
          if (Player.levelBirth == 20)
          {
            DialogSlave.this.textLevel.setText("МАКСИМУМ");
            DialogSlave.this.textCost.setVisibility(4);
            DialogSlave.this.textZa.setVisibility(4);
            DialogSlave.this.button_up.setVisibility(4);
          }
          return;
          Assets.no.play(1.0F);
        }
      }
    });
    this.button_up.setOnTouchListener(localMyTouchListener);
    prepare(paramAlertDialog);
    paramAlertDialog.setView(this.dialogSlaveView);
    paramAlertDialog.setButton(-1, "Хорошо", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.cancel();
      }
    });
    paramAlertDialog.setCancelable(false);
  }
  
  protected void prepare(AlertDialog paramAlertDialog)
  {
    if (Player.resource[16] <= 100000L) {
      Player.koefPeopleTwo = 1.0F;
    }
    if (Player.resource[16] > 100000L) {
      Player.koefPeopleTwo = 4.0F;
    }
    if (Player.resource[16] > 1000000L) {
      Player.koefPeopleTwo = 6.0F;
    }
    if (Player.resource[16] > 2000000L) {
      Player.koefPeopleTwo = 9.0F;
    }
    if (Player.levelBirth == 20)
    {
      this.textLevel.setText("МАКСИМУМ");
      this.textCost.setVisibility(4);
      this.textZa.setVisibility(4);
      this.button_up.setVisibility(4);
    }
    for (;;)
    {
      int i = (int)(Player.multiplePeople / Player.koefPeopleTwo * Player.numPeople * 365.0F);
      this.textSize.setText(String.valueOf(i));
      return;
      this.textLevel.setText("Уровень " + String.valueOf(Player.levelBirth));
      this.textCost.setText(String.valueOf(Player.costBirth));
    }
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\myDialogs\DialogSlave.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */