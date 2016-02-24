package com.vorobiev.glInstruments;

public class ZeoVector
{
  public static float TO_DEGREES = 57.295776F;
  public static float TO_RADIANS = 0.017453294F;
  public float x;
  public float y;
  
  public ZeoVector()
  {
    this.x = 0.0F;
    this.y = 0.0F;
  }
  
  public ZeoVector(float paramFloat1, float paramFloat2)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
  }
  
  public ZeoVector(ZeoVector paramZeoVector)
  {
    this.x = paramZeoVector.x;
    this.y = paramZeoVector.y;
  }
  
  public ZeoVector add(float paramFloat1, float paramFloat2)
  {
    this.x += paramFloat1;
    this.y += paramFloat2;
    return this;
  }
  
  public ZeoVector add(ZeoVector paramZeoVector)
  {
    this.x += paramZeoVector.x;
    this.y += paramZeoVector.y;
    return this;
  }
  
  public ZeoVector copyVector()
  {
    return new ZeoVector(this.x, this.y);
  }
  
  public float dist(float paramFloat1, float paramFloat2)
  {
    paramFloat1 = this.x - paramFloat1;
    paramFloat2 = this.y - paramFloat2;
    return (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }
  
  public float dist(ZeoVector paramZeoVector)
  {
    float f1 = this.x - paramZeoVector.x;
    float f2 = this.y - paramZeoVector.y;
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  public float getAngle()
  {
    float f2 = (float)Math.atan2(this.y, this.x) * TO_DEGREES;
    float f1 = f2;
    if (f2 < 0.0F) {
      f1 = f2 + 360.0F;
    }
    return f1;
  }
  
  public ZeoVector getCoordOfRadiusVec(float paramFloat1, float paramFloat2)
  {
    float f = paramFloat2 * TO_RADIANS;
    paramFloat2 = (float)Math.cos(f);
    f = (float)Math.sin(f);
    this.x = (paramFloat1 * paramFloat2);
    this.y = (paramFloat1 * f);
    return this;
  }
  
  public float len()
  {
    Math.sqrt(this.x);
    return (float)Math.sqrt(this.x);
  }
  
  public ZeoVector multiple(float paramFloat)
  {
    this.x *= paramFloat;
    this.y *= paramFloat;
    return this;
  }
  
  public ZeoVector multiple(float paramFloat1, float paramFloat2)
  {
    this.x *= paramFloat1;
    this.y *= paramFloat2;
    return this;
  }
  
  public ZeoVector normalize()
  {
    float f = len();
    if (f != 0.0F)
    {
      this.x /= f;
      this.y /= f;
    }
    return this;
  }
  
  public ZeoVector rotate(float paramFloat)
  {
    float f1 = paramFloat * TO_RADIANS;
    paramFloat = (float)Math.cos(f1);
    f1 = (float)Math.sin(f1);
    float f2 = this.x;
    float f3 = this.y;
    float f4 = this.x;
    float f5 = this.y;
    this.x = (f2 * paramFloat - f3 * f1);
    this.y = (f4 * f1 + f5 * paramFloat);
    return this;
  }
  
  public ZeoVector set(float paramFloat1, float paramFloat2)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    return this;
  }
  
  public ZeoVector set(ZeoVector paramZeoVector)
  {
    this.x = paramZeoVector.x;
    this.y = paramZeoVector.y;
    return this;
  }
  
  public ZeoVector sub(float paramFloat1, float paramFloat2)
  {
    this.x -= paramFloat1;
    this.y -= paramFloat2;
    return this;
  }
  
  public ZeoVector sub(ZeoVector paramZeoVector)
  {
    this.x -= paramZeoVector.x;
    this.y -= paramZeoVector.y;
    return this;
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\glInstruments\ZeoVector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */