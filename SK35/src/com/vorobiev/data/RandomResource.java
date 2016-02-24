package com.vorobiev.data;

import com.vorobiev.buildings.Build;
import com.vorobiev.buildings.Building;
import com.vorobiev.objects.CityBounds;
import com.vorobiev.objects.MapPlace;
import com.vorobiev.sk.MainActivity;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.Random;

public class RandomResource
{
  public static final int BREAD = 0;
  public static final int COAL = 2;
  public static final int FOREST = 1;
  public static final int GOLD = 5;
  public static final int METAL = 4;
  public static final int MapHeight = 98;
  public static final int MapWidth = 147;
  public static final int OIL = 3;
  public static final int PLATE = 7;
  public static long RecoverySizePick = 0L;
  public static final int WATER = 6;
  public static int currentIndexTax = 0;
  public static int currentTaxYear = 0;
  public static int firstCity = 0;
  public static int firstPick = 0;
  public static final long[] generalTax = { 1024000L, 4096000L, 32768000L, 131072000L, 524288000L, 2097152000L, 4194304000L, 8388608000L, 16777216000L, 33554432000L, 67108864000L, 134217728000L, 268435456000L, 2147483648000L };
  public static boolean isLeep = false;
  public static MapPlace[] map;
  public static final int maxTax = 2000000000;
  public static int nextMounth = 0;
  public static boolean paymentBigTax = false;
  public static boolean paymentTax = false;
  public static int[] resource;
  public static long returnMoneyBuildings = 0L;
  private static final Random rnd = new Random();
  public static int sizePick = 0;
  public static final StringBuilder stringBuilder = new StringBuilder();
  public static final int sumBuild = 14406;
  
  public static void activePick()
  {
    try
    {
      stringBuilder.setLength(0);
      stringBuilder.append("Выделение");
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private static boolean check(int paramInt)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      bool = false;
    }
    return bool;
  }
  
  private static int findCity(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return 3552;
    case 1: 
      return 3601;
    case 2: 
      return 3650;
    case 3: 
      return 10755;
    case 4: 
      return 10804;
    }
    return 10853;
  }
  
  private static void generate()
  {
    firstCity = findCity(rnd.nextInt(6));
    resource[0] = (rnd.nextInt(2380) + 2160);
    resource[1] = (rnd.nextInt(3380) + 2160);
    int i = 0;
    if (resource[0] + resource[1] < 8000) {
      i = rnd.nextInt(8000 - (resource[0] + resource[1]));
    }
    resource[2] = (i + 720);
    resource[3] = (rnd.nextInt(700) + 900);
    resource[4] = (rnd.nextInt(700) + 450);
    resource[5] = (rnd.nextInt(350) + 50);
    int j = 0;
    i = 0;
    for (;;)
    {
      if (i >= 6)
      {
        resource[6] = (14400 - j);
        i = 0;
        j = 0;
        if (j < 7) {
          break;
        }
        map[firstCity].isBuilding = new Building(map[firstCity], firstCity, 0, 1);
        RadarData.drawBuilding(firstCity, -65536);
        CityBounds.setLive(firstCity);
        return;
      }
      j += resource[i];
      i += 1;
    }
    int k = 0;
    for (;;)
    {
      if (k >= resource[j])
      {
        j += 1;
        break;
      }
      int m = i;
      if (check(i))
      {
        map[i] = new MapPlace();
        map[i].type = 7;
        RadarData.drawBuilding(i, -16776961);
        m = i + 1;
      }
      map[m] = new MapPlace();
      map[m].type = j;
      k += 1;
      i = m + 1;
    }
  }
  
  public static void generateMap()
  {
    generate();
    int i = 0;
    if (i >= 14405) {
      return;
    }
    if (check(14405 - i)) {}
    for (;;)
    {
      i += 1;
      break;
      int j;
      do
      {
        j = rnd.nextInt(14406 - i);
      } while (check(j));
      MapPlace localMapPlace = map[(14405 - i)];
      map[(14405 - i)] = map[j];
      map[j] = localMapPlace;
    }
  }
  
  public static int getCurrentTax()
  {
    if (currentIndexTax < 8) {
      return (int)(generalTax[currentIndexTax] / 8L);
    }
    return 2000000000;
  }
  
  public static void initializeResource()
  {
    CityBounds.newCityBounds();
    resource = new int[7];
    map = new MapPlace['㡆'];
    sizePick = 1;
    RecoverySizePick = 0L;
    isLeep = false;
    nextMounth = 0;
    paymentTax = false;
    paymentBigTax = false;
    returnMoneyBuildings = 0L;
    currentTaxYear = 1900;
    currentIndexTax = 0;
    generateMap();
    firstPick = firstCity;
  }
  
  public static void load(ObjectInputStream paramObjectInputStream)
    throws IOException
  {
    resource = new int[7];
    int i = 0;
    if (i >= resource.length)
    {
      map = new MapPlace['㡆'];
      i = 0;
      j = 0;
    }
    for (;;)
    {
      if (j >= map.length)
      {
        sizePick = 1;
        RecoverySizePick = 0L;
        isLeep = paramObjectInputStream.readBoolean();
        nextMounth = paramObjectInputStream.readInt();
        paymentTax = paramObjectInputStream.readBoolean();
        paymentBigTax = paramObjectInputStream.readBoolean();
        returnMoneyBuildings = 0L;
        currentTaxYear = paramObjectInputStream.readInt();
        currentIndexTax = paramObjectInputStream.readInt();
        firstCity = paramObjectInputStream.readInt();
        firstPick = firstCity;
        CityBounds.placeCityCoords = (int[][])Array.newInstance(Integer.TYPE, new int[] { 6, 7 });
        i = 0;
        if (i < 6) {
          break label207;
        }
        return;
        resource[i] = paramObjectInputStream.readInt();
        i += 1;
        break;
      }
      int k = i + 1;
      try
      {
        map[j] = ((MapPlace)paramObjectInputStream.readObject());
        i = k;
        if (k == 144)
        {
          i = 0;
          MainActivity.countLoading += 1;
        }
        j += 1;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        for (;;)
        {
          localClassNotFoundException.printStackTrace();
        }
      }
    }
    label207:
    int j = 0;
    for (;;)
    {
      if (j >= 7)
      {
        i += 1;
        break;
      }
      CityBounds.placeCityCoords[i][j] = paramObjectInputStream.readInt();
      j += 1;
    }
  }
  
  public static void multiplePick()
  {
    try
    {
      stringBuilder.setLength(0);
      stringBuilder.append("Выделено ");
      stringBuilder.append(sizePick);
      if (RecoverySizePick > 0L)
      {
        stringBuilder.append(", восстановление за ");
        stringBuilder.append(RecoverySizePick);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void save(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    int i = 0;
    if (i >= resource.length)
    {
      i = 0;
      j = 0;
    }
    for (;;)
    {
      if (j >= map.length)
      {
        paramObjectOutputStream.writeBoolean(isLeep);
        paramObjectOutputStream.writeInt(nextMounth);
        paramObjectOutputStream.writeBoolean(paymentTax);
        paramObjectOutputStream.writeBoolean(paymentBigTax);
        paramObjectOutputStream.writeInt(currentTaxYear);
        paramObjectOutputStream.writeInt(currentIndexTax);
        paramObjectOutputStream.writeInt(firstCity);
        i = 0;
        if (i < 6) {
          break label144;
        }
        return;
        paramObjectOutputStream.writeInt(resource[i]);
        i += 1;
        break;
      }
      int k = i + 1;
      map[j].isPickOut = false;
      paramObjectOutputStream.writeObject(map[j]);
      i = k;
      if (k == 144)
      {
        i = 0;
        MainActivity.countLoading += 1;
      }
      j += 1;
    }
    label144:
    int j = 0;
    for (;;)
    {
      if (j >= 7)
      {
        i += 1;
        break;
      }
      paramObjectOutputStream.writeInt(CityBounds.placeCityCoords[i][j]);
      j += 1;
    }
  }
  
  public static void singlePick(int paramInt)
  {
    label180:
    label269:
    for (;;)
    {
      Build localBuild;
      try
      {
        MapPlace localMapPlace = map[paramInt];
        localBuild = localMapPlace.isBuilding;
        stringBuilder.setLength(0);
        if (localMapPlace.isBuy) {
          stringBuilder.append("$ ");
        }
        if (localMapPlace.isImproved) {
          stringBuilder.append("+ ");
        }
        if (localBuild == null)
        {
          stringBuilder.append("Пусто");
          stringBuilder.append(" (");
          stringBuilder.append(MapPlace.typeString[localMapPlace.type]);
          stringBuilder.append(")");
          if (localBuild != null)
          {
            if (localBuild.getConstructionTime() <= 0) {
              break label180;
            }
            stringBuilder.append(", строится ");
            stringBuilder.append(localBuild.getConstructionTime());
            stringBuilder.append(" дн.");
          }
        }
        else
        {
          stringBuilder.append(Build.nameBuild[localBuild.getId()]);
          continue;
        }
        stringBuilder.append(", прослужит ");
      }
      finally {}
      if (localBuild.getCurrentLife() == -1) {
        stringBuilder.append("вечно");
      }
      for (;;)
      {
        if (localBuild.getPriceRecovery() <= 0) {
          break label269;
        }
        stringBuilder.append(", восстанов. за ");
        stringBuilder.append(localBuild.getPriceRecovery());
        break;
        stringBuilder.append(localBuild.getCurrentLife());
        stringBuilder.append(" дн.");
      }
    }
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\data\RandomResource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */