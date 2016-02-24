package com.vorobiev.buildings;

public class ArrayResource
{
  private static int[] arr = new int[15];
  
  public static int[] getNewArray()
  {
    int[] arrayOfInt = new int[arr.length];
    int i = 0;
    for (;;)
    {
      if (i >= arr.length)
      {
        reset();
        return arrayOfInt;
      }
      arrayOfInt[i] = arr[i];
      i += 1;
    }
  }
  
  private static void reset()
  {
    int i = 0;
    for (;;)
    {
      if (i >= arr.length) {
        return;
      }
      arr[i] = 0;
      i += 1;
    }
  }
  
  public static void setBread(int paramInt)
  {
    arr[1] = paramInt;
  }
  
  public static void setCoal(int paramInt)
  {
    arr[8] = paramInt;
  }
  
  public static void setElectro(int paramInt)
  {
    arr[14] = paramInt;
  }
  
  public static void setFish(int paramInt)
  {
    arr[5] = paramInt;
  }
  
  public static void setForest(int paramInt)
  {
    arr[13] = paramInt;
  }
  
  public static void setFruct(int paramInt)
  {
    arr[2] = paramInt;
  }
  
  public static void setGold(int paramInt)
  {
    arr[0] = paramInt;
  }
  
  public static void setHoney(int paramInt)
  {
    arr[7] = paramInt;
  }
  
  public static void setMeat(int paramInt)
  {
    arr[4] = paramInt;
  }
  
  public static void setMetal(int paramInt)
  {
    arr[9] = paramInt;
  }
  
  public static void setMush(int paramInt)
  {
    arr[6] = paramInt;
  }
  
  public static void setOil(int paramInt)
  {
    arr[10] = paramInt;
  }
  
  public static void setStone(int paramInt)
  {
    arr[11] = paramInt;
  }
  
  public static void setVeget(int paramInt)
  {
    arr[3] = paramInt;
  }
  
  public static void setWater(int paramInt)
  {
    arr[12] = paramInt;
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\buildings\ArrayResource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */