package com.vorobiev.myDialogs;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.vorobiev.buildings.Build;
import com.vorobiev.data.Player;
import com.vorobiev.objects.MapPlace;
import com.vorobiev.objects.RightPanel;
import com.vorobiev.sk.GameLayout;

public class DialogNalog
  extends MyDialog
{
  private View dialogNalogView;
  private long nalogOnEarth = 2000L;
  
  public DialogNalog(Context paramContext)
  {
    super(paramContext);
  }
  
  @SuppressLint({"InflateParams"})
  protected void create(AlertDialog paramAlertDialog)
  {
    paramAlertDialog.setTitle("Оплата налогов");
    this.dialogNalogView = LayoutInflater.from(this.activity).inflate(2130903063, null);
    paramAlertDialog.setView(this.dialogNalogView);
    prepare(paramAlertDialog);
    paramAlertDialog.setButton(-1, "Оплатить", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        synchronized (GameLayout.block)
        {
          if (Player.resource[15] >= Player.summNalog)
          {
            Player.nalogWithSell = 0L;
            Player.nalogWithBuy = 0L;
            long[] arrayOfLong = Player.resource;
            arrayOfLong[15] -= Player.summNalog;
            com.vorobiev.data.RandomResource.paymentTax = false;
            GameLayout.rightPanel.updateMoney();
            paramAnonymousDialogInterface.cancel();
          }
          return;
        }
      }
    });
    paramAlertDialog.setCancelable(false);
  }
  
  protected void prepare(AlertDialog paramAlertDialog)
  {
    int j = 0;
    int i = 0;
    if (j >= 14406)
    {
      Player.summNalog = 0L;
      paramAlertDialog = (TextView)this.dialogNalogView.findViewById(2131362013);
      long l = this.nalogOnEarth * i;
      Player.summNalog += l;
      paramAlertDialog.setText(String.valueOf(l));
      paramAlertDialog = (TextView)this.dialogNalogView.findViewById(2131362014);
      l = Player.nalogWithSell / 50L;
      Player.summNalog += l;
      paramAlertDialog.setText(String.valueOf(l));
      paramAlertDialog = (TextView)this.dialogNalogView.findViewById(2131362015);
      l = Player.nalogWithBuy / 100L;
      Player.summNalog += l;
      paramAlertDialog.setText(String.valueOf(l));
      paramAlertDialog = (TextView)this.dialogNalogView.findViewById(2131362016);
      l = Player.resource[16] * 32L;
      Player.summNalog -= l;
      if (Player.summNalog < 0L) {
        Player.summNalog = 0L;
      }
      paramAlertDialog.setText(String.valueOf(l));
      ((TextView)this.dialogNalogView.findViewById(2131362017)).setText(String.valueOf(Player.summNalog));
      return;
    }
    paramAlertDialog = com.vorobiev.data.RandomResource.map[j].isBuilding;
    if ((paramAlertDialog != null) && (!paramAlertDialog.isRansom())) {
      i += 1;
    }
    for (;;)
    {
      j += 1;
      break;
    }
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\myDialogs\DialogNalog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */