package com.vorobiev.surfaceHolder;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.view.Display;
import android.view.WindowManager;
import java.io.IOException;
import java.io.InputStream;

public class MyGraphics
  implements IGraphics
{
  AssetManager asset;
  Canvas canvas;
  Rect dstRect = new Rect();
  Bitmap frameBuffer;
  Paint paint;
  Rect srcRect = new Rect();
  
  public MyGraphics(Activity paramActivity)
  {
    Rect localRect = new Rect();
    paramActivity.getWindowManager().getDefaultDisplay().getRectSize(localRect);
    this.frameBuffer = Bitmap.createBitmap(localRect.width(), localRect.height(), Bitmap.Config.ARGB_8888);
    this.asset = paramActivity.getAssets();
    this.canvas = new Canvas(this.frameBuffer);
    this.paint = new Paint();
  }
  
  public void clear(int paramInt)
  {
    this.canvas.drawRGB((0xFF0000 & paramInt) >> 16, (0xFF00 & paramInt) >> 8, paramInt & 0xFF);
  }
  
  public void drawBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    this.canvas.drawBitmap(paramBitmap, paramInt1, paramInt2, null);
  }
  
  public void drawBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.srcRect.left = paramInt3;
    this.srcRect.top = paramInt4;
    this.srcRect.right = (paramInt3 + paramInt5 - 1);
    this.srcRect.bottom = (paramInt4 + paramInt6 - 1);
    this.dstRect.left = paramInt1;
    this.dstRect.top = paramInt2;
    this.dstRect.right = (paramInt1 + paramInt5 - 1);
    this.dstRect.bottom = (paramInt2 + paramInt6 - 1);
    this.canvas.drawBitmap(paramBitmap, this.srcRect, this.dstRect, null);
  }
  
  public void drawBitmapInCenterXY(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.dstRect.left = (paramInt1 - paramInt3 / 2);
    this.dstRect.top = (paramInt2 - paramInt4 / 2);
    this.dstRect.right = (this.dstRect.left + paramInt3);
    this.dstRect.bottom = (this.dstRect.top + paramInt4);
    this.canvas.drawBitmap(paramBitmap, null, this.dstRect, null);
  }
  
  public void drawBitmapSizeOfRect(Bitmap paramBitmap, Rect paramRect)
  {
    this.canvas.drawBitmap(paramBitmap, null, paramRect, null);
  }
  
  public void drawLine(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.paint.setColor(paramInt5);
    this.canvas.drawLine(paramInt1, paramInt2, paramInt3, paramInt4, this.paint);
  }
  
  public void drawLoading(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    paramInt3 /= 100;
    this.dstRect.left = (paramInt1 - paramInt3 * paramInt5 / 2);
    this.dstRect.top = (paramInt2 - paramInt4 / 2);
    this.dstRect.right = (this.dstRect.left + paramInt3 * paramInt5);
    this.dstRect.bottom = (this.dstRect.top + paramInt4);
    this.canvas.drawBitmap(paramBitmap, null, this.dstRect, null);
  }
  
  public void drawObject(MyView paramMyView)
  {
    this.dstRect.left = (paramMyView.getPositionX() - paramMyView.getWidth() / 2);
    this.dstRect.top = (paramMyView.getPositionY() - paramMyView.getHeight() / 2);
    this.dstRect.right = (this.dstRect.left + paramMyView.getWidth());
    this.dstRect.bottom = (this.dstRect.top + paramMyView.getHeight());
    this.canvas.drawBitmap(paramMyView.getCurrentFrame(), null, this.dstRect, null);
  }
  
  public void drawObject(MyView paramMyView, float paramFloat)
  {
    this.dstRect.left = (paramMyView.getPositionX() - paramMyView.getWidth() / 2);
    this.dstRect.top = (paramMyView.getPositionY() - paramMyView.getHeight() / 2);
    this.dstRect.right = (this.dstRect.left + paramMyView.getWidth());
    this.dstRect.bottom = (this.dstRect.top + paramMyView.getHeight());
    this.canvas.drawBitmap(paramMyView.getCurrentFrame(paramFloat), null, this.dstRect, null);
  }
  
  public void drawPartBitmapInCenterXY(Bitmap paramBitmap, IGraphics.Coordinates paramCoordinates)
  {
    this.dstRect.left = (paramCoordinates.coordsOnScreenX - paramCoordinates.widthOnScreen / 2);
    this.dstRect.top = (paramCoordinates.coordsOnScreenY - paramCoordinates.heightOnScreen / 2);
    this.dstRect.right = (this.dstRect.left + paramCoordinates.widthOnScreen);
    this.dstRect.bottom = (this.dstRect.top + paramCoordinates.heightOnScreen);
    this.srcRect.left = paramCoordinates.coordsOnPictureX;
    this.srcRect.top = paramCoordinates.coordsOnPictureY;
    this.srcRect.right = (this.srcRect.left + paramCoordinates.widthOnPicture);
    this.srcRect.bottom = (this.srcRect.top + paramCoordinates.heightOnPicture);
    this.canvas.drawBitmap(paramBitmap, this.srcRect, this.dstRect, null);
  }
  
  public void drawPixel(int paramInt1, int paramInt2, int paramInt3)
  {
    this.paint.setColor(paramInt3);
    this.canvas.drawPoint(paramInt1, paramInt2, this.paint);
  }
  
  public void drawRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.paint.setColor(paramInt5);
    this.paint.setStyle(Paint.Style.FILL);
    this.canvas.drawRect(paramInt1, paramInt2, paramInt1 + paramInt3 - 1, paramInt2 + paramInt3 - 1, this.paint);
  }
  
  public Bitmap getFrameBuffer()
  {
    return this.frameBuffer;
  }
  
  public int getHeight()
  {
    return this.frameBuffer.getHeight();
  }
  
  public int getWidth()
  {
    return this.frameBuffer.getWidth();
  }
  
  public Bitmap newBitmapFromAssets(String paramString)
  {
    Object localObject = null;
    String str = null;
    try
    {
      paramString = this.asset.open(paramString);
      str = paramString;
      localObject = paramString;
      Bitmap localBitmap = BitmapFactory.decodeStream(paramString);
      if (paramString != null) {}
      return localBitmap;
    }
    catch (IOException paramString)
    {
      paramString = paramString;
      localObject = str;
      paramString.printStackTrace();
      localObject = str;
      throw new RuntimeException("Не могу создать Bitmap в классе LoadingBitmap");
    }
    finally
    {
      if (localObject != null) {}
      try
      {
        ((InputStream)localObject).close();
        throw paramString;
      }
      catch (IOException localIOException)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\surfaceHolder\MyGraphics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */