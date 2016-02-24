package com.vorobiev.glInstruments;

public class TextureRegion
{
  private float height;
  public final Texture texture;
  public float u1;
  public float u2;
  public float v1;
  public float v2;
  private float width;
  
  public TextureRegion(Texture paramTexture)
  {
    this.texture = paramTexture;
  }
  
  public TextureRegion(Texture paramTexture, float paramFloat1, float paramFloat2)
  {
    this.texture = paramTexture;
    this.width = paramFloat1;
    this.height = paramFloat2;
  }
  
  public TextureRegion(Texture paramTexture, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.texture = paramTexture;
    this.width = paramFloat3;
    this.height = paramFloat4;
    set(paramFloat1, paramFloat2);
  }
  
  public void set(float paramFloat1, float paramFloat2)
  {
    this.u1 = (paramFloat1 / this.texture.width);
    this.v1 = (paramFloat2 / this.texture.height);
    this.u2 = (this.u1 + this.width / this.texture.width);
    this.v2 = (this.v1 + this.height / this.texture.height);
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\glInstruments\TextureRegion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */