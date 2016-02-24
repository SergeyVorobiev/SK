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
import com.vorobiev.data.RandomResource;
import com.vorobiev.sk.ButtonNumberListener;
import com.vorobiev.sk.GameLayout;
import com.vorobiev.sk.LeftPanelListener;
import com.vorobiev.sk.MyTouchListener;

public class DialogBank
  extends MyDialog
{
  private int[] btn_id;
  private Button[] btn_number;
  private StringBuilder builder;
  private long maxTax;
  private ButtonNumberListener numberListener;
  private TextView textCurrentTax;
  private TextView textLimit;
  private TextView textMaxTax;
  private TextView value;
  private View view;
  
  public DialogBank(Context paramContext)
  {
    super(paramContext);
  }
  
  @SuppressLint({"InflateParams"})
  protected void create(AlertDialog paramAlertDialog)
  {
    this.builder = new StringBuilder();
    this.numberListener = new ButtonNumberListener(this.builder);
    this.btn_number = new Button[12];
    this.btn_id = new int[] { 2131361885, 2131361886, 2131361887, 2131361888, 2131361889, 2131361890, 2131361891, 2131361892, 2131361893, 2131361894, 2131361895, 2131361896 };
    this.view = LayoutInflater.from(this.activity).inflate(2130903047, null);
    paramAlertDialog.setView(this.view);
    paramAlertDialog.setTitle("БАНК");
    this.textMaxTax = ((TextView)this.view.findViewById(2131361901));
    this.textCurrentTax = ((TextView)this.view.findViewById(2131361905));
    this.maxTax = RandomResource.getCurrentTax();
    this.textLimit = ((TextView)this.view.findViewById(2131361900));
    int i = (int)(this.maxTax - Player.resource[20]);
    label361:
    MyTouchListener localMyTouchListener;
    if (i < 0)
    {
      this.textLimit.setText("Лимит привышен на ");
      i *= -1;
      this.textMaxTax.setText(String.valueOf(i));
      this.textCurrentTax.setText("Текущий долг " + String.valueOf(Player.resource[20]));
      this.value = ((TextView)this.view.findViewById(2131361903));
      this.numberListener.textValue = this.value;
      this.numberListener.maxMoney = 2140000000L;
      this.numberListener.inputMoney = Player.resource[20];
      this.builder.setLength(0);
      if (Player.resource[20] == 0L) {
        break label453;
      }
      this.builder.append(String.valueOf(Player.resource[20]));
      this.numberListener.toInt();
      localMyTouchListener = new MyTouchListener(2130837546, 2130837547, this.numberListener);
      i = 0;
    }
    for (;;)
    {
      if (i >= this.btn_id.length)
      {
        paramAlertDialog.setButton(-1, "Отмена", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        paramAlertDialog.setButton(-2, "Взять", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface arg1, int paramAnonymousInt)
          {
            synchronized (GameLayout.block)
            {
              if (DialogBank.this.numberListener.inputMoney + Player.resource[20] <= DialogBank.this.maxTax)
              {
                long[] arrayOfLong = Player.resource;
                arrayOfLong[20] += DialogBank.this.numberListener.inputMoney;
                arrayOfLong = Player.resource;
                arrayOfLong[15] += DialogBank.this.numberListener.inputMoney;
                LeftPanelListener.updateTax();
              }
              return;
            }
          }
        });
        paramAlertDialog.setButton(-3, "Вернуть", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface arg1, int paramAnonymousInt)
          {
            for (;;)
            {
              synchronized (GameLayout.block)
              {
                if (Player.resource[15] < Player.resource[20]) {
                  break label197;
                }
                if (DialogBank.this.numberListener.inputMoney <= Player.resource[15])
                {
                  if (DialogBank.this.numberListener.inputMoney <= Player.resource[20])
                  {
                    arrayOfLong1 = Player.resource;
                    arrayOfLong1[15] -= DialogBank.this.numberListener.inputMoney;
                    arrayOfLong1 = Player.resource;
                    arrayOfLong1[20] -= DialogBank.this.numberListener.inputMoney;
                    LeftPanelListener.updateTax();
                    return;
                  }
                  long[] arrayOfLong1 = Player.resource;
                  arrayOfLong1[15] -= Player.resource[20];
                  Player.resource[20] = 0L;
                }
              }
              if (DialogBank.this.numberListener.inputMoney > Player.resource[15])
              {
                long[] arrayOfLong2 = Player.resource;
                arrayOfLong2[15] -= Player.resource[20];
                Player.resource[20] = 0L;
                continue;
                label197:
                if (DialogBank.this.numberListener.inputMoney <= Player.resource[15])
                {
                  arrayOfLong2 = Player.resource;
                  arrayOfLong2[15] -= DialogBank.this.numberListener.inputMoney;
                  arrayOfLong2 = Player.resource;
                  arrayOfLong2[20] -= DialogBank.this.numberListener.inputMoney;
                }
                else
                {
                  arrayOfLong2 = Player.resource;
                  arrayOfLong2[20] -= Player.resource[15];
                  Player.resource[15] = 0L;
                }
              }
            }
          }
        });
        paramAlertDialog.setCancelable(false);
        return;
        this.textLimit.setText("Макс. сумма займа");
        break;
        label453:
        this.value.setText("0");
        break label361;
      }
      this.btn_number[i] = ((Button)this.view.findViewById(this.btn_id[i]));
      this.btn_number[i].setId(i + 1);
      this.btn_number[i].setOnTouchListener(localMyTouchListener);
      i += 1;
    }
  }
  
  protected void prepare(AlertDialog paramAlertDialog)
  {
    this.maxTax = RandomResource.getCurrentTax();
    this.numberListener.inputMoney = Player.resource[20];
    this.builder.setLength(0);
    int i;
    if (Player.resource[20] != 0L)
    {
      this.builder.append(String.valueOf(Player.resource[20]));
      this.numberListener.toInt();
      i = (int)(this.maxTax - Player.resource[20]);
      if (i >= 0) {
        break label149;
      }
      this.textLimit.setText("Лимит привышен на ");
      i *= -1;
    }
    for (;;)
    {
      this.textMaxTax.setText(String.valueOf(i));
      this.textCurrentTax.setText("Текущий долг " + String.valueOf(Player.resource[20]));
      return;
      this.value.setText("0");
      break;
      label149:
      this.textLimit.setText("Макс. сумма займа");
    }
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\myDialogs\DialogBank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */