package com.vorobiev.objects;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.vorobiev.sk.LeftPanelListener;
import com.vorobiev.sk.MyTouchListListener;

public class MyGridAdapter
  extends BaseAdapter
{
  private static final Integer[] images = { Integer.valueOf(2130837571), Integer.valueOf(2130837670), Integer.valueOf(2130837690), Integer.valueOf(2130837611), Integer.valueOf(2130837576), Integer.valueOf(2130837579), Integer.valueOf(2130837668), Integer.valueOf(2130837568), Integer.valueOf(2130837677), Integer.valueOf(2130837525), Integer.valueOf(2130837700), Integer.valueOf(2130837632), Integer.valueOf(2130837504), Integer.valueOf(2130837605) };
  private static final Integer[] imagesDown = { Integer.valueOf(2130837572), Integer.valueOf(2130837671), Integer.valueOf(2130837691), Integer.valueOf(2130837612), Integer.valueOf(2130837577), Integer.valueOf(2130837580), Integer.valueOf(2130837669), Integer.valueOf(2130837569), Integer.valueOf(2130837678), Integer.valueOf(2130837526), Integer.valueOf(2130837701), Integer.valueOf(2130837633), Integer.valueOf(2130837505), Integer.valueOf(2130837606) };
  private Activity activity;
  private int imageWidth;
  private MyTouchListListener touchListener;
  
  public MyGridAdapter(Activity paramActivity, LeftPanelListener paramLeftPanelListener)
  {
    this.activity = paramActivity;
    this.imageWidth = paramActivity.findViewById(2131361915).getLayoutParams().width;
    this.touchListener = new MyTouchListListener(imagesDown, images, paramLeftPanelListener);
  }
  
  public int getCount()
  {
    return images.length;
  }
  
  public Object getItem(int paramInt)
  {
    return images[paramInt];
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = new ImageView(this.activity);
      paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(this.imageWidth, this.imageWidth));
      paramViewGroup.setOnTouchListener(this.touchListener);
    }
    ((ImageView)paramViewGroup).setImageResource(images[paramInt].intValue());
    paramViewGroup.setId(paramInt);
    return paramViewGroup;
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\objects\MyGridAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */