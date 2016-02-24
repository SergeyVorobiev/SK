package com.vorobiev.sk;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class MyButtonTouchListListener
  implements View.OnTouchListener
{
  private MyTouchListener.MyDownButtonAction action;
  private boolean isTouch = false;
  private boolean oldTouch = false;
  public int[] pictureOnDown;
  public int[] pictureOnUp;
  
  public MyButtonTouchListListener(int[] paramArrayOfInt1, int[] paramArrayOfInt2, MyTouchListener.MyDownButtonAction paramMyDownButtonAction)
  {
    this.action = paramMyDownButtonAction;
    this.pictureOnUp = paramArrayOfInt2;
    this.pictureOnDown = paramArrayOfInt1;
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
      paramView.setBackgroundResource(this.pictureOnUp[paramView.getId()]);
    }
    if (((paramMotionEvent.getX() > paramView.getWidth()) || (paramMotionEvent.getY() > paramView.getHeight()) || (paramMotionEvent.getX() < 0.0F) || (paramMotionEvent.getY() < 0.0F)) && (!this.oldTouch))
    {
      this.oldTouch = true;
      paramView.setBackgroundResource(this.pictureOnUp[paramView.getId()]);
    }
    for (;;)
    {
      if (paramMotionEvent.getAction() == 1)
      {
        paramView.setBackgroundResource(this.pictureOnUp[paramView.getId()]);
        if ((this.action != null) && (this.isTouch) && (!this.oldTouch)) {
          this.action.actionOnClick(paramView);
        }
        this.oldTouch = false;
        this.isTouch = false;
      }
      return true;
      if (!this.oldTouch)
      {
        paramView.setBackgroundResource(this.pictureOnDown[paramView.getId()]);
        this.isTouch = true;
      }
    }
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\sk\MyButtonTouchListListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */