package com.vorobiev.objects;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import javax.microedition.khronos.opengles.GL10;

public class MyFrame
{
  private float alpha = 1.0F;
  private float blue = 0.0F;
  private FloatBuffer colorVert;
  private float[] colors = new float[16];
  private float[] coords = new float[8];
  private GL10 gl;
  private float green = 0.0F;
  private ShortBuffer indices;
  private float red = 1.0F;
  private boolean up = true;
  private FloatBuffer vertices;
  
  public MyFrame()
  {
    Object localObject = new short[8];
    localObject[1] = 1;
    localObject[2] = 1;
    localObject[3] = 2;
    localObject[4] = 2;
    localObject[5] = 3;
    localObject[6] = 3;
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(32);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.vertices = localByteBuffer.asFloatBuffer();
    localByteBuffer = ByteBuffer.allocateDirect(16);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.indices = localByteBuffer.asShortBuffer();
    this.indices.put((short[])localObject);
    this.indices.flip();
    localObject = ByteBuffer.allocateDirect(64);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    this.colorVert = ((ByteBuffer)localObject).asFloatBuffer();
  }
  
  private void inflateArrayColors(float paramFloat)
  {
    if (this.green > 1.0F) {
      this.up = false;
    }
    if (this.green < 0.0F) {
      this.up = true;
    }
    int i;
    if (this.up)
    {
      this.green += paramFloat * 2.0F;
      i = 0;
    }
    for (;;)
    {
      if (i >= 16)
      {
        this.colorVert.clear();
        this.colorVert.put(this.colors);
        this.colorVert.flip();
        return;
        this.green -= paramFloat * 2.0F;
        break;
      }
      this.colors[(i + 0)] = this.red;
      this.colors[(i + 1)] = this.green;
      this.colors[(i + 2)] = this.blue;
      this.colors[(i + 3)] = this.alpha;
      i += 4;
    }
  }
  
  private void inflateArrayCoords(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.coords[0] = (paramFloat3 - paramFloat1);
    this.coords[1] = (paramFloat4 - paramFloat2);
    this.coords[2] = (paramFloat3 + paramFloat1);
    this.coords[3] = this.coords[1];
    this.coords[4] = this.coords[2];
    this.coords[5] = (paramFloat4 + paramFloat2);
    this.coords[6] = this.coords[0];
    this.coords[7] = this.coords[5];
    this.vertices.clear();
    this.vertices.put(this.coords);
    this.vertices.flip();
  }
  
  public void DrawSquade(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    inflateArrayCoords(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    this.gl.glDrawElements(1, 8, 5123, this.indices);
  }
  
  public void bind(GL10 paramGL10, float paramFloat)
  {
    this.gl = paramGL10;
    paramGL10.glEnableClientState(32884);
    this.vertices.position(0);
    paramGL10.glVertexPointer(2, 5126, 0, this.vertices);
    paramGL10.glEnableClientState(32886);
    this.vertices.position(0);
    paramGL10.glColorPointer(4, 5126, 0, this.colorVert);
    inflateArrayColors(paramFloat);
  }
  
  public void unbind()
  {
    this.gl.glDisableClientState(32884);
    this.gl.glDisableClientState(32886);
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\objects\MyFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */