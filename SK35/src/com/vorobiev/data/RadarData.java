package com.vorobiev.data;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class RadarData
{
  public static int Yellow = Color.rgb(230, 234, 147);
  public static float frameHeightToCenter;
  public static float frameWidthToCenter;
  public static float height;
  public static Bitmap mapRadar;
  public static float positionX;
  public static float positionY;
  public static int[] radarColor;
  public static float ratioRadarToWorldHeight;
  public static float ratioRadarToWorldWidth = 0.0F;
  public static float width;
  
  static
  {
    ratioRadarToWorldHeight = 0.0F;
  }
  
  public static void drawBuilding(int paramInt1, int paramInt2)
  {
    synchronized (radarColor)
    {
      radarColor[paramInt1] = paramInt2;
      return;
    }
  }
  
  public static void initialized(float paramFloat1, float paramFloat2)
  {
    width = paramFloat1;
    height = paramFloat2;
    mapRadar = Bitmap.createBitmap(147, 98, Bitmap.Config.RGB_565);
    radarColor = new int['㡆'];
    int i = 0;
    for (;;)
    {
      if (i >= radarColor.length)
      {
        ratioRadarToWorldWidth = width / 147.0F;
        ratioRadarToWorldHeight = height / 98.0F;
        return;
      }
      radarColor[i] = Yellow;
      i += 1;
    }
  }
  
  public static void load(ObjectInputStream paramObjectInputStream)
    throws IOException
  {
    width = paramObjectInputStream.readFloat();
    height = paramObjectInputStream.readFloat();
    ratioRadarToWorldWidth = paramObjectInputStream.readFloat();
    ratioRadarToWorldHeight = paramObjectInputStream.readFloat();
    radarColor = new int['㡆'];
    mapRadar = Bitmap.createBitmap(147, 98, Bitmap.Config.RGB_565);
    int i = 0;
    for (;;)
    {
      if (i >= radarColor.length) {
        return;
      }
      radarColor[i] = paramObjectInputStream.readInt();
      i += 1;
    }
  }
  
  public static void save(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeFloat(width);
    paramObjectOutputStream.writeFloat(height);
    paramObjectOutputStream.writeFloat(ratioRadarToWorldWidth);
    paramObjectOutputStream.writeFloat(ratioRadarToWorldHeight);
    int i = 0;
    for (;;)
    {
      if (i >= radarColor.length) {
        return;
      }
      paramObjectOutputStream.writeInt(radarColor[i]);
      i += 1;
    }
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\data\RadarData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */