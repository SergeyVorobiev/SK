package com.vorobiev.surfaceHolder;

import android.graphics.Bitmap;

public class MyView
{
  protected MyAnimation animation;
  protected int height;
  protected int positionX;
  protected int positionY;
  protected int width;
  
  MyView(MyAnimation paramMyAnimation, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.positionX = paramInt3;
    this.positionY = paramInt4;
    this.animation = paramMyAnimation;
  }
  
  public Bitmap getCurrentFrame()
  {
    return this.animation.getCurFrame();
  }
  
  public Bitmap getCurrentFrame(float paramFloat)
  {
    return this.animation.getCurFrame(paramFloat);
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public int getPositionX()
  {
    return this.positionX;
  }
  
  public int getPositionY()
  {
    return this.positionY;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public void setAnimation(MyAnimation paramMyAnimation)
  {
    this.animation = paramMyAnimation;
  }
  
  public void setHeight(int paramInt)
  {
    this.height = paramInt;
  }
  
  public void setPositionX(int paramInt)
  {
    this.positionX = paramInt;
  }
  
  public void setPositionY(int paramInt)
  {
    this.positionY = paramInt;
  }
  
  public void setWidth(int paramInt)
  {
    this.width = paramInt;
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\surfaceHolder\MyView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */