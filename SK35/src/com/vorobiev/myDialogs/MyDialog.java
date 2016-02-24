package com.vorobiev.myDialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;

public abstract class MyDialog
{
  protected Activity activity;
  private AlertDialog dialog;
  private boolean onCreate = false;
  
  public MyDialog(Context paramContext)
  {
    this.dialog = new AlertDialog.Builder(paramContext).create();
    this.activity = ((Activity)paramContext);
  }
  
  protected abstract void create(AlertDialog paramAlertDialog);
  
  protected abstract void prepare(AlertDialog paramAlertDialog);
  
  public final void show()
  {
    if (this.onCreate) {
      prepare(this.dialog);
    }
    for (;;)
    {
      this.dialog.show();
      return;
      this.onCreate = true;
      create(this.dialog);
    }
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\myDialogs\MyDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */