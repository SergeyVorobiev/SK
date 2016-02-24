package com.vorobiev.myDialogs;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.vorobiev.data.Player;
import com.vorobiev.data.RandomResource;
import com.vorobiev.gameInterface.Sound;
import com.vorobiev.gameclass.Assets;
import com.vorobiev.objects.RightPanel;
import com.vorobiev.sk.GameLayout;
import com.vorobiev.sk.MainActivity;

public class DialogBigNalog
  extends MyDialog
{
  private TextView text;
  private View view;
  
  @SuppressLint({"InflateParams"})
  public DialogBigNalog(Context paramContext)
  {
    super(paramContext);
    this.view = LayoutInflater.from(paramContext).inflate(2130903045, null);
    this.text = ((TextView)this.view.findViewById(2131361876));
  }
  
  protected void create(AlertDialog paramAlertDialog)
  {
    paramAlertDialog.setTitle("Главный налог");
    paramAlertDialog.setView(this.view);
    this.text.setText(String.valueOf(RandomResource.generalTax[RandomResource.currentIndexTax]));
    paramAlertDialog.setButton(-1, "Оплатить", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        long l = Player.resource[15];
        synchronized (GameLayout.block)
        {
          if (Player.resource[15] >= RandomResource.generalTax[RandomResource.currentIndexTax])
          {
            long[] arrayOfLong = Player.resource;
            arrayOfLong[15] -= RandomResource.generalTax[RandomResource.currentIndexTax];
            RandomResource.currentIndexTax += 1;
            RandomResource.paymentBigTax = false;
            GameLayout.rightPanel.updateMoney();
            if (RandomResource.currentIndexTax < 14)
            {
              Assets.congratulation.play(1.0F);
              Toast.makeText(DialogBigNalog.this.activity, "Поздравляем с выплатой главного налога!", 0).show();
            }
          }
          paramAnonymousDialogInterface.cancel();
          if (RandomResource.currentIndexTax == 14)
          {
            com.vorobiev.data.BestScoreData.summMoney = l;
            Assets.congratulation.play(1.0F);
            ((MainActivity)DialogBigNalog.this.activity).gameLayout.dialogFinish.show();
          }
          return;
        }
      }
    });
    paramAlertDialog.setCancelable(false);
  }
  
  protected void prepare(AlertDialog paramAlertDialog)
  {
    this.text.setText(String.valueOf(RandomResource.generalTax[RandomResource.currentIndexTax]));
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\myDialogs\DialogBigNalog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */