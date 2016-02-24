package com.vorobiev.sk;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

public class MyTouchListListener
  implements View.OnTouchListener
{
  private MyDownButtonAction action;
  private boolean isTouch = false;
  private boolean oldTouch = false;
  public Integer[] pictureOnDown;
  public Integer[] pictureOnUp;
  
  public MyTouchListListener(Integer[] paramArrayOfInteger1, Integer[] paramArrayOfInteger2, MyDownButtonAction paramMyDownButtonAction)
  {
    this.action = paramMyDownButtonAction;
    this.pictureOnUp = paramArrayOfInteger2;
    this.pictureOnDown = paramArrayOfInteger1;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      this.oldTouch = false;
    }
    if (paramMotionEvent.getAction() == 3)
    {
      this.oldTouch = false;
      ((ImageView)paramView).setImageResource(this.pictureOnUp[paramView.getId()].intValue());
    }
    for (;;)
    {
      return true;
      if (((paramMotionEvent.getX() > paramView.getWidth()) || (paramMotionEvent.getY() > paramView.getHeight()) || (paramMotionEvent.getX() < 0.0F) || (paramMotionEvent.getY() < 0.0F)) && (!this.oldTouch))
      {
        this.oldTouch = true;
        ((ImageView)paramView).setImageResource(this.pictureOnUp[paramView.getId()].intValue());
      }
      while (paramMotionEvent.getAction() == 1)
      {
        ((ImageView)paramView).setImageResource(this.pictureOnUp[paramView.getId()].intValue());
        if ((this.action != null) && (this.isTouch) && (!this.oldTouch)) {
          this.action.actionOnClick(paramView);
        }
        this.oldTouch = false;
        this.isTouch = false;
        return true;
        if (!this.oldTouch)
        {
          ((ImageView)paramView).setImageResource(this.pictureOnDown[paramView.getId()].intValue());
          this.isTouch = true;
        }
      }
    }
  }
  
  static abstract interface MyDownButtonAction
  {
    public abstract void actionOnClick(View paramView);
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\sk\MyTouchListListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */