package com.vorobiev.gameInterface;

import com.vorobiev.sk.MainActivity;

public abstract class ScreeN
{
  protected final MainActivity activity;
  protected final Game game;
  
  public ScreeN(Game paramGame, MainActivity paramMainActivity)
  {
    this.game = paramGame;
    this.activity = paramMainActivity;
  }
  
  public abstract void dispose();
  
  public abstract void pause();
  
  public abstract void present(float paramFloat);
  
  public abstract void resume();
  
  public abstract void update(float paramFloat);
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\gameInterface\ScreeN.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */