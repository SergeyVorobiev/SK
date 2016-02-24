package com.vorobiev.surfaceHolder;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class FastRenderView
  extends SurfaceView
  implements Runnable
{
  private SurfaceHolder holder;
  private volatile boolean runing = false;
  private AbstractScreen screen;
  private Thread thread;
  
  public FastRenderView(Context paramContext)
  {
    super(paramContext);
    initial(paramContext);
  }
  
  public FastRenderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initial(paramContext);
  }
  
  public FastRenderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initial(paramContext);
  }
  
  private void initial(Context paramContext)
  {
    this.holder = getHolder();
  }
  
  public void pause()
  {
    if (this.thread == null) {
      return;
    }
    this.runing = false;
  }
  
  public void registerGraphics(AbstractScreen paramAbstractScreen)
  {
    this.screen = paramAbstractScreen;
  }
  
  public void resume()
  {
    if (!this.runing)
    {
      this.thread = new Thread(this);
      this.runing = true;
      this.thread.start();
    }
  }
  
  public void run()
  {
    long l = System.nanoTime();
    for (;;)
    {
      if (!this.runing) {
        return;
      }
      if (this.holder.getSurface().isValid())
      {
        float f = (float)(System.nanoTime() - l) / 1.0E9F;
        l = System.nanoTime();
        Canvas localCanvas = this.holder.lockCanvas();
        this.screen.present(f);
        this.screen.update(f);
        if (localCanvas == null) {}
        localCanvas.drawBitmap(this.screen.graphics.getFrameBuffer(), 0.0F, 0.0F, null);
        this.holder.unlockCanvasAndPost(localCanvas);
      }
    }
  }
  
  public void stop()
  {
    if (this.thread == null) {
      return;
    }
    this.runing = false;
    try
    {
      this.thread.join();
      this.thread = null;
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\surfaceHolder\FastRenderView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */