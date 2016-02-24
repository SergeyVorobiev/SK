package com.vorobiev.glInstruments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLUtils;
import com.vorobiev.gameInterface.FileIO;
import com.vorobiev.gameInterface.Game;
import com.vorobiev.objects.GLGraphics;
import java.io.IOException;
import java.io.InputStream;
import javax.microedition.khronos.opengles.GL10;

public class Texture
{
  private FileIO fileIO;
  private String fileName;
  private GLGraphics glGraphics;
  int height;
  int magFilter;
  int minFilter;
  int textureId;
  int width;
  
  public Texture(Game paramGame, String paramString, int paramInt1, int paramInt2)
  {
    this.glGraphics = paramGame.getGLGraphics();
    this.fileName = paramString;
    this.fileIO = paramGame.getFileIO();
    this.minFilter = 9728;
    this.magFilter = 9728;
    this.width = paramInt1;
    this.height = paramInt2;
    load();
  }
  
  public void bind()
  {
    this.glGraphics.getGL().glBindTexture(3553, this.textureId);
  }
  
  public void bindAndSetFilters(int paramInt1, int paramInt2)
  {
    GL10 localGL10 = this.glGraphics.getGL();
    localGL10.glBindTexture(3553, this.textureId);
    localGL10.glTexParameterf(3553, 10240, paramInt1);
    localGL10.glTexParameterf(3553, 10241, paramInt2);
  }
  
  public void dispose()
  {
    GL10 localGL10 = this.glGraphics.getGL();
    localGL10.glBindTexture(3553, this.textureId);
    localGL10.glDeleteTextures(1, new int[] { this.textureId }, 0);
  }
  
  public void load()
  {
    GL10 localGL10 = this.glGraphics.getGL();
    Object localObject1 = new int[1];
    localGL10.glGenTextures(1, (int[])localObject1, 0);
    this.textureId = localObject1[0];
    Object localObject3 = null;
    localObject1 = null;
    try
    {
      InputStream localInputStream = this.fileIO.readAsset(this.fileName);
      localObject1 = localInputStream;
      localObject3 = localInputStream;
      Bitmap localBitmap = BitmapFactory.decodeStream(localInputStream);
      localObject1 = localInputStream;
      localObject3 = localInputStream;
      localGL10.glBindTexture(3553, this.textureId);
      localObject1 = localInputStream;
      localObject3 = localInputStream;
      GLUtils.texImage2D(3553, 0, localBitmap, 0);
      localObject1 = localInputStream;
      localObject3 = localInputStream;
      localGL10.glTexParameterf(3553, 10240, this.magFilter);
      localObject1 = localInputStream;
      localObject3 = localInputStream;
      localGL10.glTexParameterf(3553, 10241, this.minFilter);
      localObject1 = localInputStream;
      localObject3 = localInputStream;
      localGL10.glBindTexture(3553, 0);
      localObject1 = localInputStream;
      localObject3 = localInputStream;
      localBitmap.recycle();
      Object localObject4;
      return;
    }
    catch (IOException localIOException2)
    {
      localIOException2 = localIOException2;
      localObject4 = localObject1;
      throw new RuntimeException("Couldn't load bitmap " + this.fileName);
    }
    finally
    {
      try
      {
        ((InputStream)localObject4).close();
        throw ((Throwable)localObject2);
      }
      catch (IOException localIOException3)
      {
        for (;;)
        {
          localIOException3.printStackTrace();
        }
      }
    }
  }
  
  public void unbind()
  {
    this.glGraphics.getGL().glBindTexture(3553, 0);
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\glInstruments\Texture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */