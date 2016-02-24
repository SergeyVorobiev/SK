package com.vorobiev.gameInterface;

import com.vorobiev.objects.GLGraphics;

public abstract interface Game
{
  public abstract void Finish();
  
  public abstract ScreeN getCurrentScreen();
  
  public abstract FileIO getFileIO();
  
  public abstract GLGraphics getGLGraphics();
  
  public abstract Input getInputKey();
  
  public abstract Input getInputTouch();
  
  public abstract ScreeN getStartScreen();
  
  public abstract void setScreen(ScreeN paramScreeN);
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\gameInterface\Game.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */