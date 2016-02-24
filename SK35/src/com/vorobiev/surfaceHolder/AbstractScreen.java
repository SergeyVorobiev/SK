package com.vorobiev.surfaceHolder;

public abstract class AbstractScreen
{
  public IGraphics graphics;
  
  public AbstractScreen(IGraphics paramIGraphics)
  {
    this.graphics = paramIGraphics;
  }
  
  public abstract void present(float paramFloat);
  
  public abstract void update(float paramFloat);
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\surfaceHolder\AbstractScreen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */