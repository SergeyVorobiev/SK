package com.vorobiev.myDialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.vorobiev.data.RandomResource;
import com.vorobiev.sk.LeftPanelListener;

public class DialogDestroy
  extends MyDialog
{
  private LeftPanelListener listener;
  
  public DialogDestroy(Context paramContext, LeftPanelListener paramLeftPanelListener)
  {
    super(paramContext);
    this.listener = paramLeftPanelListener;
  }
  
  protected void create(AlertDialog paramAlertDialog)
  {
    paramAlertDialog.setTitle("Предупреждение");
    paramAlertDialog.setMessage("Вы действительно хотите разрушить выделенные строения? Вернется " + String.valueOf(RandomResource.returnMoneyBuildings));
    paramAlertDialog.setButton(-1, "Разрушить", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        DialogDestroy.this.listener.destroying();
        paramAnonymousDialogInterface.cancel();
      }
    });
    paramAlertDialog.setButton(-2, "Отмена", new DialogInterface.OnClickListener()
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
    paramAlertDialog.setMessage("Вы действительно хотите разрушить выделенные строения? Вернется " + String.valueOf(RandomResource.returnMoneyBuildings));
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\myDialogs\DialogDestroy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */