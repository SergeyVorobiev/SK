package com.vorobiev.myDialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public class DialogTax
  extends MyDialog
{
  public DialogTax(Context paramContext)
  {
    super(paramContext);
  }
  
  protected void create(AlertDialog paramAlertDialog)
  {
    paramAlertDialog.setTitle("Предупреждение");
    paramAlertDialog.setMessage("Долг перед банком выше максимума, погасите долг!");
    paramAlertDialog.setButton(-1, "Хорошо", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.cancel();
      }
    });
    paramAlertDialog.setCancelable(false);
  }
  
  protected void prepare(AlertDialog paramAlertDialog) {}
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\myDialogs\DialogTax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */