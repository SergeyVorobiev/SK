package com.vorobiev.glInstruments;

import java.util.Random;

public class JoltOfCamera
{
  private boolean activate = false;
  private float lastTime = 0.0F;
  private float offsetX;
  private float offsetY;
  private int push = 0;
  private Random rnd = new Random();
  private int strong;
  private float time;
  
  public JoltOfCamera(int paramInt, float paramFloat)
  {
    this.strong = paramInt;
    this.time = paramFloat;
  }
  
  public void activated()
  {
    this.activate = true;
    this.lastTime = 0.0F;
  }
  
  public float getOffsetX()
  {
    return this.offsetX;
  }
  
  public float getOffsetY()
  {
    return this.offsetY;
  }
  
  public boolean update(float paramFloat)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((this.lastTime > this.time) && (this.push == 0))
    {
      this.activate = false;
      this.lastTime = 0.0F;
      this.offsetX = 0.0F;
      this.offsetY = 0.0F;
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!this.activate);
      this.lastTime += paramFloat;
      if (this.push != 0) {
        break;
      }
      this.push += 1;
      this.offsetX = (this.rnd.nextInt(this.strong) * paramFloat);
      this.offsetY = (this.rnd.nextInt(this.strong) * paramFloat);
      if (this.rnd.nextInt(2) == 0) {
        this.offsetX *= -1.0F;
      }
      bool1 = bool2;
    } while (this.rnd.nextInt(2) != 0);
    this.offsetY *= -1.0F;
    return false;
    this.push = 0;
    this.offsetX *= -1.0F;
    this.offsetY *= -1.0F;
    return false;
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\glInstruments\JoltOfCamera.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */