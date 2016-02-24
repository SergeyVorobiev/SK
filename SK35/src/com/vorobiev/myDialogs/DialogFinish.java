package com.vorobiev.myDialogs;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import com.vorobiev.sk.ActivityFinish;

public class DialogFinish
  extends MyDialog
{
  private View view;
  
  @SuppressLint({"InflateParams"})
  public DialogFinish(Context paramContext)
  {
    super(paramContext);
    this.view = LayoutInflater.from(paramContext).inflate(2130903051, null);
  }
  
  protected void create(final AlertDialog paramAlertDialog)
  {
    paramAlertDialog.setTitle("Конец");
    paramAlertDialog.setView(this.view);
    paramAlertDialog.setCancelable(false);
    paramAlertDialog.setButton(-1, "Хорошо", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAlertDialog.cancel();
        paramAnonymousDialogInterface = new Intent();
        paramAnonymousDialogInterface.setClass(DialogFinish.this.activity, ActivityFinish.class);
        DialogFinish.this.activity.startActivityForResult(paramAnonymousDialogInterface, 205);
        com.vorobiev.sk.MainActivity.mainActive = false;
      }
    });
  }
  
  protected void prepare(AlertDialog paramAlertDialog) {}
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\myDialogs\DialogFinish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */