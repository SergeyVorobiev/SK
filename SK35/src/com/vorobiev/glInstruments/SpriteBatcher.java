package com.vorobiev.glInstruments;

import android.annotation.SuppressLint;
import android.util.FloatMath;
import com.vorobiev.objects.GLGraphics;

public class SpriteBatcher
{
  int bufferIndex;
  int numSprites;
  final Vertices vertices;
  final float[] verticesBuffer;
  
  public SpriteBatcher(GLGraphics paramGLGraphics, int paramInt)
  {
    this.verticesBuffer = new float[paramInt * 4 * 4];
    this.vertices = new Vertices(paramGLGraphics, paramInt * 4, paramInt * 6, false, true);
    this.bufferIndex = 0;
    this.numSprites = 0;
    paramGLGraphics = new short[paramInt * 6];
    int j = paramGLGraphics.length;
    paramInt = 0;
    int i = 0;
    for (;;)
    {
      if (i >= j)
      {
        this.vertices.setIndices(paramGLGraphics, 0, paramGLGraphics.length);
        return;
      }
      paramGLGraphics[(i + 0)] = ((short)(paramInt + 0));
      paramGLGraphics[(i + 1)] = ((short)(paramInt + 1));
      paramGLGraphics[(i + 2)] = ((short)(paramInt + 2));
      paramGLGraphics[(i + 3)] = ((short)(paramInt + 2));
      paramGLGraphics[(i + 4)] = ((short)(paramInt + 3));
      paramGLGraphics[(i + 5)] = ((short)(paramInt + 0));
      i += 6;
      paramInt = (short)(paramInt + 4);
    }
  }
  
  public void beginBatch(Texture paramTexture)
  {
    paramTexture.bind();
    this.vertices.bind();
    this.numSprites = 0;
    this.bufferIndex = 0;
  }
  
  @SuppressLint({"FloatMath"})
  public void drawSprite(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, TextureRegion paramTextureRegion)
  {
    paramFloat3 /= 2.0F;
    paramFloat4 /= 2.0F;
    float f1 = paramFloat5 * ZeoVector.TO_RADIANS;
    paramFloat5 = FloatMath.cos(f1);
    f1 = FloatMath.sin(f1);
    float f2 = -paramFloat3;
    float f3 = -paramFloat4;
    float f4 = -paramFloat3;
    float f5 = -paramFloat4;
    float f6 = -paramFloat4;
    float f7 = -paramFloat4;
    float f8 = -paramFloat3;
    float f9 = -paramFloat3;
    float[] arrayOfFloat = this.verticesBuffer;
    int i = this.bufferIndex;
    this.bufferIndex = (i + 1);
    arrayOfFloat[i] = (f2 * paramFloat5 - f3 * f1 + paramFloat1);
    arrayOfFloat = this.verticesBuffer;
    i = this.bufferIndex;
    this.bufferIndex = (i + 1);
    arrayOfFloat[i] = (f4 * f1 + f5 * paramFloat5 + paramFloat2);
    arrayOfFloat = this.verticesBuffer;
    i = this.bufferIndex;
    this.bufferIndex = (i + 1);
    arrayOfFloat[i] = paramTextureRegion.u1;
    arrayOfFloat = this.verticesBuffer;
    i = this.bufferIndex;
    this.bufferIndex = (i + 1);
    arrayOfFloat[i] = paramTextureRegion.v2;
    arrayOfFloat = this.verticesBuffer;
    i = this.bufferIndex;
    this.bufferIndex = (i + 1);
    arrayOfFloat[i] = (paramFloat3 * paramFloat5 - f6 * f1 + paramFloat1);
    arrayOfFloat = this.verticesBuffer;
    i = this.bufferIndex;
    this.bufferIndex = (i + 1);
    arrayOfFloat[i] = (paramFloat3 * f1 + f7 * paramFloat5 + paramFloat2);
    arrayOfFloat = this.verticesBuffer;
    i = this.bufferIndex;
    this.bufferIndex = (i + 1);
    arrayOfFloat[i] = paramTextureRegion.u2;
    arrayOfFloat = this.verticesBuffer;
    i = this.bufferIndex;
    this.bufferIndex = (i + 1);
    arrayOfFloat[i] = paramTextureRegion.v2;
    arrayOfFloat = this.verticesBuffer;
    i = this.bufferIndex;
    this.bufferIndex = (i + 1);
    arrayOfFloat[i] = (paramFloat3 * paramFloat5 - paramFloat4 * f1 + paramFloat1);
    arrayOfFloat = this.verticesBuffer;
    i = this.bufferIndex;
    this.bufferIndex = (i + 1);
    arrayOfFloat[i] = (paramFloat3 * f1 + paramFloat4 * paramFloat5 + paramFloat2);
    arrayOfFloat = this.verticesBuffer;
    i = this.bufferIndex;
    this.bufferIndex = (i + 1);
    arrayOfFloat[i] = paramTextureRegion.u2;
    arrayOfFloat = this.verticesBuffer;
    i = this.bufferIndex;
    this.bufferIndex = (i + 1);
    arrayOfFloat[i] = paramTextureRegion.v1;
    arrayOfFloat = this.verticesBuffer;
    i = this.bufferIndex;
    this.bufferIndex = (i + 1);
    arrayOfFloat[i] = (f8 * paramFloat5 - paramFloat4 * f1 + paramFloat1);
    arrayOfFloat = this.verticesBuffer;
    i = this.bufferIndex;
    this.bufferIndex = (i + 1);
    arrayOfFloat[i] = (f9 * f1 + paramFloat4 * paramFloat5 + paramFloat2);
    arrayOfFloat = this.verticesBuffer;
    i = this.bufferIndex;
    this.bufferIndex = (i + 1);
    arrayOfFloat[i] = paramTextureRegion.u1;
    arrayOfFloat = this.verticesBuffer;
    i = this.bufferIndex;
    this.bufferIndex = (i + 1);
    arrayOfFloat[i] = paramTextureRegion.v1;
    this.numSprites += 1;
  }
  
  public void drawSprite(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, TextureRegion paramTextureRegion)
  {
    float f1 = paramFloat3 / 2.0F;
    float f2 = paramFloat4 / 2.0F;
    paramFloat3 = paramFloat1 - f1;
    paramFloat4 = paramFloat2 - f2;
    paramFloat1 += f1;
    paramFloat2 += f2;
    float[] arrayOfFloat = this.verticesBuffer;
    int i = this.bufferIndex;
    this.bufferIndex = (i + 1);
    arrayOfFloat[i] = paramFloat3;
    arrayOfFloat = this.verticesBuffer;
    i = this.bufferIndex;
    this.bufferIndex = (i + 1);
    arrayOfFloat[i] = paramFloat4;
    arrayOfFloat = this.verticesBuffer;
    i = this.bufferIndex;
    this.bufferIndex = (i + 1);
    arrayOfFloat[i] = paramTextureRegion.u1;
    arrayOfFloat = this.verticesBuffer;
    i = this.bufferIndex;
    this.bufferIndex = (i + 1);
    arrayOfFloat[i] = paramTextureRegion.v2;
    arrayOfFloat = this.verticesBuffer;
    i = this.bufferIndex;
    this.bufferIndex = (i + 1);
    arrayOfFloat[i] = paramFloat1;
    arrayOfFloat = this.verticesBuffer;
    i = this.bufferIndex;
    this.bufferIndex = (i + 1);
    arrayOfFloat[i] = paramFloat4;
    arrayOfFloat = this.verticesBuffer;
    i = this.bufferIndex;
    this.bufferIndex = (i + 1);
    arrayOfFloat[i] = paramTextureRegion.u2;
    arrayOfFloat = this.verticesBuffer;
    i = this.bufferIndex;
    this.bufferIndex = (i + 1);
    arrayOfFloat[i] = paramTextureRegion.v2;
    arrayOfFloat = this.verticesBuffer;
    i = this.bufferIndex;
    this.bufferIndex = (i + 1);
    arrayOfFloat[i] = paramFloat1;
    arrayOfFloat = this.verticesBuffer;
    i = this.bufferIndex;
    this.bufferIndex = (i + 1);
    arrayOfFloat[i] = paramFloat2;
    arrayOfFloat = this.verticesBuffer;
    i = this.bufferIndex;
    this.bufferIndex = (i + 1);
    arrayOfFloat[i] = paramTextureRegion.u2;
    arrayOfFloat = this.verticesBuffer;
    i = this.bufferIndex;
    this.bufferIndex = (i + 1);
    arrayOfFloat[i] = paramTextureRegion.v1;
    arrayOfFloat = this.verticesBuffer;
    i = this.bufferIndex;
    this.bufferIndex = (i + 1);
    arrayOfFloat[i] = paramFloat3;
    arrayOfFloat = this.verticesBuffer;
    i = this.bufferIndex;
    this.bufferIndex = (i + 1);
    arrayOfFloat[i] = paramFloat2;
    arrayOfFloat = this.verticesBuffer;
    i = this.bufferIndex;
    this.bufferIndex = (i + 1);
    arrayOfFloat[i] = paramTextureRegion.u1;
    arrayOfFloat = this.verticesBuffer;
    i = this.bufferIndex;
    this.bufferIndex = (i + 1);
    arrayOfFloat[i] = paramTextureRegion.v1;
    this.numSprites += 1;
  }
  
  public void endBatch(Texture paramTexture)
  {
    this.vertices.setVertices(this.verticesBuffer, 0, this.bufferIndex);
    this.vertices.draw(4, 0, this.numSprites * 6);
    paramTexture.unbind();
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\glInstruments\SpriteBatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */