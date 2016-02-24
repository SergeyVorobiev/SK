package com.vorobiev.myDialogs;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;

public class DialogStart
  extends MyDialog
{
  View view;
  
  @SuppressLint({"InflateParams"})
  public DialogStart(Context paramContext)
  {
    super(paramContext);
    this.view = LayoutInflater.from(paramContext).inflate(2130903057, null);
  }
  
  protected void create(final AlertDialog paramAlertDialog)
  {
    paramAlertDialog.setTitle("Легенда");
    paramAlertDialog.setView(this.view);
    paramAlertDialog.setButton(-1, "Хорошо", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAlertDialog.cancel();
      }
    });
    paramAlertDialog.setCancelable(false);
  }
  
  protected void prepare(AlertDialog paramAlertDialog) {}
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\myDialogs\DialogStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */