package com.vorobiev.glInstruments;

import com.vorobiev.objects.GLGraphics;
import javax.microedition.khronos.opengles.GL10;

public class Camera2D
{
  private float backgroundColorB = 0.5764706F;
  private float backgroundColorG = 0.91764706F;
  private float backgroundColorR = 0.9019608F;
  public float centerToBoundsX;
  public float centerToBoundsY;
  private GLGraphics glGraphics;
  public float height;
  public float heightWorld;
  public JoltOfCamera jolt = null;
  public final ZeoVector position;
  public float width;
  public float widthWorld;
  public float zoom;
  
  public Camera2D(GLGraphics paramGLGraphics, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.glGraphics = paramGLGraphics;
    this.zoom = 1.0F;
    this.centerToBoundsX = (paramFloat1 / 2.0F * this.zoom);
    this.centerToBoundsY = (paramFloat2 / 2.0F * this.zoom);
    this.position = new ZeoVector(this.centerToBoundsX, this.centerToBoundsY);
    this.width = paramFloat1;
    this.height = paramFloat2;
    this.widthWorld = paramFloat3;
    this.heightWorld = paramFloat4;
  }
  
  public void addZoom(float paramFloat)
  {
    try
    {
      this.zoom -= 0.4F * paramFloat;
      if (this.zoom > 2.5F) {
        this.zoom = 2.5F;
      }
      if (this.zoom < 1.0F) {
        this.zoom = 1.0F;
      }
      this.centerToBoundsX = (this.width / 2.0F * this.zoom);
      this.centerToBoundsY = (this.height / 2.0F * this.zoom);
      paramFloat = this.position.x;
      float f = this.position.y;
      if (paramFloat < this.centerToBoundsX) {
        this.position.x = this.centerToBoundsX;
      }
      if (f < this.centerToBoundsY) {
        this.position.y = this.centerToBoundsY;
      }
      if (paramFloat > this.widthWorld - this.centerToBoundsX) {
        this.position.x = (this.widthWorld - this.centerToBoundsX);
      }
      if (f > this.heightWorld - this.centerToBoundsY) {
        this.position.y = (this.heightWorld - this.centerToBoundsY);
      }
      if (this.jolt != null)
      {
        ZeoVector localZeoVector = this.position;
        localZeoVector.x += this.jolt.getOffsetX();
        localZeoVector = this.position;
        localZeoVector.y += this.jolt.getOffsetY();
      }
      return;
    }
    finally {}
  }
  
  public void setPosition(float paramFloat1, float paramFloat2)
  {
    try
    {
      this.position.x = paramFloat1;
      this.position.y = paramFloat2;
      if (paramFloat1 < this.centerToBoundsX) {
        this.position.x = this.centerToBoundsX;
      }
      if (paramFloat2 < this.centerToBoundsY) {
        this.position.y = this.centerToBoundsY;
      }
      if (paramFloat1 > this.widthWorld - this.centerToBoundsX) {
        this.position.x = (this.widthWorld - this.centerToBoundsX);
      }
      if (paramFloat2 > this.heightWorld - this.centerToBoundsY) {
        this.position.y = (this.heightWorld - this.centerToBoundsY);
      }
      if (this.jolt != null)
      {
        ZeoVector localZeoVector = this.position;
        localZeoVector.x += this.jolt.getOffsetX();
        localZeoVector = this.position;
        localZeoVector.y += this.jolt.getOffsetY();
      }
      return;
    }
    finally {}
  }
  
  public void setPositionOfIndex(int paramInt)
  {
    try
    {
      int i = paramInt / 147;
      paramInt -= i * 147;
      this.position.x = paramInt;
      this.position.y = i;
      if (paramInt < this.centerToBoundsX) {
        this.position.x = this.centerToBoundsX;
      }
      if (i < this.centerToBoundsY) {
        this.position.y = this.centerToBoundsY;
      }
      if (paramInt > this.widthWorld - this.centerToBoundsX) {
        this.position.x = (this.widthWorld - this.centerToBoundsX);
      }
      if (i > this.heightWorld - this.centerToBoundsY) {
        this.position.y = (this.heightWorld - this.centerToBoundsY);
      }
      if (this.jolt != null)
      {
        ZeoVector localZeoVector = this.position;
        localZeoVector.x += this.jolt.getOffsetX();
        localZeoVector = this.position;
        localZeoVector.y += this.jolt.getOffsetY();
      }
      return;
    }
    finally {}
  }
  
  public void setViewportAndMatrices()
  {
    try
    {
      if (this.jolt != null)
      {
        localObject1 = this.position;
        ((ZeoVector)localObject1).x += this.jolt.getOffsetX();
        localObject1 = this.position;
        ((ZeoVector)localObject1).y += this.jolt.getOffsetY();
      }
      Object localObject1 = this.glGraphics.getGL();
      ((GL10)localObject1).glClear(16384);
      ((GL10)localObject1).glClearColor(this.backgroundColorR, this.backgroundColorG, this.backgroundColorB, 1.0F);
      ((GL10)localObject1).glMatrixMode(5889);
      ((GL10)localObject1).glLoadIdentity();
      ((GL10)localObject1).glOrthof(this.position.x - this.width * this.zoom / 2.0F, this.position.x + this.width * this.zoom / 2.0F, this.position.y - this.height * this.zoom / 2.0F, this.position.y + this.height * this.zoom / 2.0F, 1.0F, -1.0F);
      ((GL10)localObject1).glMatrixMode(5888);
      ((GL10)localObject1).glLoadIdentity();
      return;
    }
    finally {}
  }
  
  public void touchToScreen(ZeoVector paramZeoVector)
  {
    try
    {
      paramZeoVector.x = (paramZeoVector.x / this.glGraphics.getWidth() * this.width);
      paramZeoVector.y = ((1.0F - paramZeoVector.y / this.glGraphics.getHeight()) * this.height);
      return;
    }
    finally
    {
      paramZeoVector = finally;
      throw paramZeoVector;
    }
  }
  
  public void touchToWorld(ZeoVector paramZeoVector)
  {
    try
    {
      paramZeoVector.x = (paramZeoVector.x / this.glGraphics.getWidth() * this.width * this.zoom);
      paramZeoVector.y = ((1.0F - paramZeoVector.y / this.glGraphics.getHeight()) * this.height * this.zoom);
      paramZeoVector.set(paramZeoVector.x - this.width * this.zoom / 2.0F, paramZeoVector.y - this.height * this.zoom / 2.0F);
      paramZeoVector.x = (this.position.x + paramZeoVector.x);
      paramZeoVector.y = (this.position.y + paramZeoVector.y);
      return;
    }
    finally
    {
      paramZeoVector = finally;
      throw paramZeoVector;
    }
  }
  
  public void translate(float paramFloat1, float paramFloat2)
  {
    try
    {
      if (this.jolt != null)
      {
        localZeoVector = this.position;
        localZeoVector.x += this.jolt.getOffsetX();
        localZeoVector = this.position;
        localZeoVector.y += this.jolt.getOffsetY();
      }
      ZeoVector localZeoVector = this.position;
      localZeoVector.x += this.zoom * paramFloat1;
      localZeoVector = this.position;
      localZeoVector.y += this.zoom * paramFloat2;
      return;
    }
    finally {}
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\glInstruments\Camera2D.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */