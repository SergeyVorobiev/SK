package com.vorobiev.sk;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView.LayoutParams;
import android.widget.TextView;

public class ViewResources
{
  private TextView cost;
  private boolean isPick = false;
  private TextView name;
  public View view;
  
  public ViewResources(Context paramContext, int paramInt1, int paramInt2)
  {
    this.view = LayoutInflater.from(paramContext).inflate(paramInt1, null);
    paramInt1 = paramContext.getResources().getDimensionPixelSize(2131099664);
    this.view.setLayoutParams(new AbsListView.LayoutParams(-1, paramInt1));
    if (paramInt2 == 0) {
      this.view.setBackgroundResource(2130837521);
    }
    for (;;)
    {
      this.view.setId(paramInt2);
      this.name = ((TextView)this.view.findViewById(2131361911));
      this.name.setTextColor(65280);
      this.cost = ((TextView)this.view.findViewById(2131361912));
      return;
      this.view.setBackgroundResource(2130837522);
    }
  }
  
  public boolean getPick()
  {
    return this.isPick;
  }
  
  public void pick()
  {
    this.isPick = true;
    this.view.setBackgroundResource(2130837521);
  }
  
  public void setName(String paramString)
  {
    this.name.setText(paramString);
  }
  
  public void setNumResources(long paramLong)
  {
    this.cost.setText(String.valueOf(paramLong));
    if (paramLong == 0L)
    {
      this.cost.setTextColor(-7829368);
      return;
    }
    this.cost.setTextColor(-16711936);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.view.setOnClickListener(paramOnClickListener);
  }
  
  public void setPicture(int paramInt)
  {
    this.name.setCompoundDrawablesWithIntrinsicBounds(0, 0, paramInt, 0);
  }
  
  public void unPick()
  {
    this.isPick = false;
    this.view.setBackgroundResource(2130837522);
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\sk\ViewResources.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */