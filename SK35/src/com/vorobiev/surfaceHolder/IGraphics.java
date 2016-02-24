package com.vorobiev.surfaceHolder;

import android.graphics.Bitmap;
import android.graphics.Rect;

public abstract interface IGraphics
{
  public abstract void clear(int paramInt);
  
  public abstract void drawBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2);
  
  public abstract void drawBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  public abstract void drawBitmapInCenterXY(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void drawBitmapSizeOfRect(Bitmap paramBitmap, Rect paramRect);
  
  public abstract void drawLine(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public abstract void drawLoading(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public abstract void drawObject(MyView paramMyView);
  
  public abstract void drawObject(MyView paramMyView, float paramFloat);
  
  public abstract void drawPartBitmapInCenterXY(Bitmap paramBitmap, Coordinates paramCoordinates);
  
  public abstract void drawPixel(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void drawRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public abstract Bitmap getFrameBuffer();
  
  public abstract int getHeight();
  
  public abstract int getWidth();
  
  public static class Coordinates
  {
    public int coordsOnPictureX = 0;
    public int coordsOnPictureY = 0;
    public int coordsOnScreenX = 0;
    public int coordsOnScreenY = 0;
    public int heightOnPicture = 0;
    public int heightOnScreen = 0;
    public int widthOnPicture = 0;
    public int widthOnScreen = 0;
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\surfaceHolder\IGraphics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */