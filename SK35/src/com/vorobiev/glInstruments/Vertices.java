package com.vorobiev.glInstruments;

import com.vorobiev.objects.GLGraphics;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import javax.microedition.khronos.opengles.GL10;

public class Vertices
{
  private final GLGraphics glGraphics;
  private final boolean hasColor;
  private final boolean hasTexCoords;
  private final ShortBuffer indices;
  private final int vertexSize;
  private final FloatBuffer vertices;
  
  public Vertices(GLGraphics paramGLGraphics, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.glGraphics = paramGLGraphics;
    this.hasColor = paramBoolean1;
    this.hasTexCoords = paramBoolean2;
    if (paramBoolean1) {}
    for (int i = 4;; i = 0)
    {
      if (paramBoolean2) {
        j = 2;
      }
      this.vertexSize = ((j + (i + 2)) * 4);
      paramGLGraphics = ByteBuffer.allocateDirect(this.vertexSize * paramInt1);
      paramGLGraphics.order(ByteOrder.nativeOrder());
      this.vertices = paramGLGraphics.asFloatBuffer();
      if (paramInt2 <= 0) {
        break;
      }
      paramGLGraphics = ByteBuffer.allocateDirect(paramInt2 * 2);
      paramGLGraphics.order(ByteOrder.nativeOrder());
      this.indices = paramGLGraphics.asShortBuffer();
      return;
    }
    this.indices = null;
  }
  
  public void bind()
  {
    GL10 localGL10 = this.glGraphics.getGL();
    localGL10.glEnableClientState(32884);
    this.vertices.position(0);
    localGL10.glVertexPointer(2, 5126, this.vertexSize, this.vertices);
    if (this.hasColor)
    {
      localGL10.glEnableClientState(32886);
      this.vertices.position(2);
      localGL10.glColorPointer(4, 5126, this.vertexSize, this.vertices);
    }
    FloatBuffer localFloatBuffer;
    if (this.hasTexCoords)
    {
      localGL10.glEnableClientState(32888);
      localFloatBuffer = this.vertices;
      if (!this.hasColor) {
        break label140;
      }
    }
    label140:
    for (int i = 6;; i = 2)
    {
      localFloatBuffer.position(i);
      localGL10.glTexCoordPointer(2, 5126, this.vertexSize, this.vertices);
      return;
    }
  }
  
  public void draw(int paramInt1, int paramInt2, int paramInt3)
  {
    GL10 localGL10 = this.glGraphics.getGL();
    if (this.indices != null)
    {
      this.indices.position(paramInt2);
      localGL10.glDrawElements(paramInt1, paramInt3, 5123, this.indices);
      return;
    }
    localGL10.glDrawArrays(paramInt1, paramInt2, paramInt3);
  }
  
  public void setIndices(short[] paramArrayOfShort)
  {
    this.indices.clear();
    this.indices.put(paramArrayOfShort);
    this.indices.flip();
  }
  
  public void setIndices(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    this.indices.clear();
    this.indices.put(paramArrayOfShort, paramInt1, paramInt2);
    this.indices.flip();
  }
  
  public void setVertices(float[] paramArrayOfFloat)
  {
    this.vertices.clear();
    this.vertices.put(paramArrayOfFloat);
    this.vertices.flip();
  }
  
  public void setVertices(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    this.vertices.clear();
    this.vertices.put(paramArrayOfFloat, paramInt1, paramInt2);
    this.vertices.flip();
  }
  
  public void unbind()
  {
    GL10 localGL10 = this.glGraphics.getGL();
    localGL10.glDisableClientState(32884);
    if (this.hasTexCoords) {
      localGL10.glDisableClientState(32888);
    }
    if (this.hasColor) {
      localGL10.glDisableClientState(32886);
    }
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\glInstruments\Vertices.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */