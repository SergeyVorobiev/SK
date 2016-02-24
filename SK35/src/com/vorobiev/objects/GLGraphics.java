package com.vorobiev.objects;

import com.vorobiev.sk.GLView;
import javax.microedition.khronos.opengles.GL10;

public class GLGraphics
{
  private GL10 gl;
  private GLView glGraphics;
  private int height = 0;
  private float oneDp = 0.0F;
  private float ratio = 0.0F;
  private int width = 0;
  
  public GLGraphics(GLView paramGLView)
  {
    this.glGraphics = paramGLView;
  }
  
  public GL10 getGL()
  {
    return this.gl;
  }
  
  public GLView getGLView()
  {
    return this.glGraphics;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public float getOneDp()
  {
    return this.oneDp;
  }
  
  public float getRatio()
  {
    return this.ratio;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public void setGL(GL10 paramGL10)
  {
    this.gl = paramGL10;
  }
  
  public void setOneDp(float paramFloat)
  {
    this.oneDp = paramFloat;
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.ratio = (paramInt1 / paramInt2);
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\objects\GLGraphics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */