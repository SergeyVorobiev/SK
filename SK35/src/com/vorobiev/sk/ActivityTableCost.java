package com.vorobiev.sk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActivityTableCost
  extends Activity
{
  private Button btnClose;
  
  private void validate(int paramInt1, int paramInt2, TextView paramTextView)
  {
    if (paramInt1 > paramInt2)
    {
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130837510, 0);
      return;
    }
    if (paramInt1 == paramInt2)
    {
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130837509, 0);
      return;
    }
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130837508, 0);
  }
  
  @SuppressLint({"InflateParams"})
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
    setContentView(2130903044);
    paramBundle = (LinearLayout)findViewById(2131361873);
    int i = 0;
    for (;;)
    {
      if (i >= 15)
      {
        this.btnClose = ((Button)findViewById(2131361875));
        this.btnClose.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            paramAnonymousView = new Intent();
            ActivityTableCost.this.setResult(-1, paramAnonymousView);
            ActivityTableCost.this.finish();
          }
        });
        return;
      }
      View localView = LayoutInflater.from(this).inflate(2130903061, null);
      TextView localTextView = (TextView)localView.findViewById(2131361911);
      localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.vorobiev.data.ResourceArray.res_mark[i], 0);
      localTextView.setText(com.vorobiev.data.ResourceArray.res_name[i]);
      localTextView = (TextView)localView.findViewById(2131362010);
      localTextView.setText(String.valueOf(com.vorobiev.data.Player.sellResource[i]));
      validate(com.vorobiev.data.Player.sellResource[i], com.vorobiev.data.Player.priceResourceStok[i], localTextView);
      localTextView = (TextView)localView.findViewById(2131362011);
      localTextView.setText(String.valueOf(com.vorobiev.data.Player.buyResource[i]));
      validate(com.vorobiev.data.Player.buyResource[i], com.vorobiev.data.Player.oldBuyResource[i], localTextView);
      localTextView = (TextView)localView.findViewById(2131362012);
      localTextView.setText(String.valueOf(com.vorobiev.data.Player.nextSellResource[i]) + "   (" + String.valueOf(com.vorobiev.data.Player.curCount[i]) + "m)");
      validate(com.vorobiev.data.Player.nextSellResource[i], com.vorobiev.data.Player.priceResourceStok[i], localTextView);
      paramBundle.addView(localView);
      i += 1;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return true;
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\sk\ActivityTableCost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */