package com.vorobiev.handler;

import android.os.Message;
import com.vorobiev.myDialogs.DialogTax;

public class DialogTaxHandler
  extends AbstractHandler
{
  private DialogTax dialogTax;
  
  public DialogTaxHandler(DialogTax paramDialogTax, int paramInt)
  {
    super(paramInt);
    this.dialogTax = paramDialogTax;
  }
  
  public void update(Message paramMessage)
  {
    this.dialogTax.show();
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\handler\DialogTaxHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */