package com.vorobiev.sk;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class MyTouchListener
  implements View.OnTouchListener
{
  private MyDownButtonAction action;
  private boolean isTouch = false;
  private boolean oldTouch = false;
  public int pictureOnDown;
  public int pictureOnUp;
  
  public MyTouchListener(int paramInt1, int paramInt2, MyDownButtonAction paramMyDownButtonAction)
  {
    this.action = paramMyDownButtonAction;
    this.pictureOnUp = paramInt2;
    this.pictureOnDown = paramInt1;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (((paramMotionEvent.getX() > paramView.getWidth()) || (paramMotionEvent.getY() > paramView.getHeight()) || (paramMotionEvent.getX() < 0.0F) || (paramMotionEvent.getY() < 0.0F)) && (!this.oldTouch))
    {
      this.oldTouch = true;
      paramView.setBackgroundResource(this.pictureOnUp);
    }
    for (;;)
    {
      if (paramMotionEvent.getAction() == 1)
      {
        paramView.setBackgroundResource(this.pictureOnUp);
        if ((this.action != null) && (this.isTouch) && (!this.oldTouch)) {
          this.action.actionOnClick(paramView);
        }
        this.oldTouch = false;
        this.isTouch = false;
      }
      return true;
      if (!this.oldTouch)
      {
        paramView.setBackgroundResource(this.pictureOnDown);
        this.isTouch = true;
      }
    }
  }
  
  public static abstract interface MyDownButtonAction
  {
    public abstract void actionOnClick(View paramView);
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\sk\MyTouchListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */