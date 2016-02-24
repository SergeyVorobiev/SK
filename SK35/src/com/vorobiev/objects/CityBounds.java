package com.vorobiev.objects;

import java.lang.reflect.Array;

public class CityBounds
{
  public static final int BOTTOM = 6;
  public static final int LEFT = 3;
  public static final int LIVE = 0;
  public static final int MapHeight = 98;
  public static final int MapWidth = 147;
  public static final int RIGHT = 4;
  public static final int TOP = 5;
  public static final int X = 1;
  public static final int Y = 2;
  public static final int[] placeCity = { 3552, 3601, 3650, 10755, 10804, 10853 };
  public static int[][] placeCityCoords;
  
  public static void newCityBounds()
  {
    placeCityCoords = (int[][])Array.newInstance(Integer.TYPE, new int[] { 6, 7 });
    int i = 0;
    for (;;)
    {
      if (i >= 6) {
        return;
      }
      int j = placeCity[i] / 147;
      int k = placeCity[i] - j * 147;
      placeCityCoords[i][0] = 0;
      placeCityCoords[i][1] = k;
      placeCityCoords[i][2] = j;
      placeCityCoords[i][3] = (k - 24);
      placeCityCoords[i][4] = (k + 24);
      placeCityCoords[i][5] = (j + 24);
      placeCityCoords[i][6] = (j - 24);
      i += 1;
    }
  }
  
  public static boolean setLive(int paramInt)
  {
    boolean bool = false;
    int i = 0;
    for (;;)
    {
      if (i >= 6) {}
      for (;;)
      {
        if (bool) {
          placeCityCoords[i][0] = 1;
        }
        return bool;
        if (paramInt != placeCity[i]) {
          break;
        }
        bool = true;
      }
      i += 1;
    }
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\objects\CityBounds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */