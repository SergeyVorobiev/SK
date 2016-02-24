package com.vorobiev.surfaceHolder;

import android.graphics.Bitmap;

public class MyAnimation
{
  private Bitmap[] bitmaps;
  private int curFrame = 0;
  private float delay = 0.0F;
  private float elapsedTime = 0.0F;
  public boolean isRevers = false;
  private int next = 1;
  private float time;
  
  public MyAnimation(Bitmap paramBitmap)
  {
    this.time = 0.0F;
    this.bitmaps = new Bitmap[1];
    this.bitmaps[0] = paramBitmap;
  }
  
  public MyAnimation(Bitmap[] paramArrayOfBitmap, float paramFloat)
  {
    float f = paramFloat;
    if (paramFloat < 0.0F) {
      f = 0.0F;
    }
    this.bitmaps = paramArrayOfBitmap;
    this.time = f;
  }
  
  public MyAnimation(Bitmap[] paramArrayOfBitmap, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    float f = paramFloat1;
    if (paramFloat1 < 0.0F) {
      f = 0.0F;
    }
    paramFloat1 = paramFloat2;
    if (paramFloat2 < 0.0F) {
      paramFloat1 = 0.0F;
    }
    this.delay = paramFloat1;
    this.isRevers = paramBoolean;
    this.bitmaps = paramArrayOfBitmap;
    this.time = f;
  }
  
  public Bitmap getCurFrame()
  {
    return this.bitmaps[this.curFrame];
  }
  
  public Bitmap getCurFrame(float paramFloat)
  {
    updateFrame(paramFloat);
    return this.bitmaps[this.curFrame];
  }
  
  public void setDelay(float paramFloat)
  {
    float f = paramFloat;
    if (paramFloat < 0.0F) {
      f = 0.0F;
    }
    this.delay = f;
  }
  
  public void updateFrame(float paramFloat)
  {
    this.elapsedTime += paramFloat;
    if (this.curFrame == 0)
    {
      if (this.elapsedTime > this.delay + this.time)
      {
        this.elapsedTime = 0.0F;
        this.curFrame += this.next;
      }
      if (this.curFrame == this.bitmaps.length) {
        if (this.isRevers) {
          break label130;
        }
      }
    }
    for (this.curFrame = 0;; this.curFrame += this.next)
    {
      if ((this.curFrame == 0) && (this.next == -1)) {
        this.next = 1;
      }
      return;
      if (this.elapsedTime <= this.time) {
        break;
      }
      this.elapsedTime = 0.0F;
      this.curFrame += this.next;
      break;
      label130:
      this.next = -1;
    }
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\surfaceHolder\MyAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */