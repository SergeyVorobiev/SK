package com.vorobiev.sk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class MyListAdapter
  extends BaseAdapter
{
  private ViewResources[] viewResources = new ViewResources[15];
  
  public MyListAdapter(Context paramContext)
  {
    int i = 0;
    for (;;)
    {
      if (i >= this.viewResources.length) {
        return;
      }
      this.viewResources[i] = new ViewResources(paramContext, 2130903049, i);
      this.viewResources[i].setName(com.vorobiev.data.ResourceArray.res_name[i]);
      this.viewResources[i].setNumResources(com.vorobiev.data.Player.resource[i]);
      this.viewResources[i].setPicture(com.vorobiev.data.ResourceArray.res_mark[i]);
      i += 1;
    }
  }
  
  public int getCount()
  {
    return this.viewResources.length;
  }
  
  public Object getItem(int paramInt)
  {
    return this.viewResources[paramInt];
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  @SuppressLint({"InflateParams"})
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return this.viewResources[paramInt].view;
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\sk\MyListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */