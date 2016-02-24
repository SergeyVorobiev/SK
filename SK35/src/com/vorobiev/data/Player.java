package com.vorobiev.data;

import com.vorobiev.objects.MyDate;
import com.vorobiev.sk.GameLayout;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

public class Player
{
  public static final int ANIMAL = 16;
  public static final int ATOM = 29;
  public static final int ATOMBIG = 30;
  public static final int BEEKEEPING = 20;
  public static final int BREAD = 1;
  public static final int CAREER = 6;
  public static final int CATACOMBS = 27;
  public static final int CITY = 0;
  public static final int COAL = 8;
  public static final int DEBT = 20;
  public static final int ELECTRO = 14;
  public static final int FARM = 19;
  public static final int FIELD = 1;
  public static final int FISH = 5;
  public static final int FISHING = 13;
  public static final int FRUCT = 2;
  public static final int GARDEN = 2;
  public static final int GOLD = 0;
  public static final int GOLDUTILITY = 8;
  public static final int GREENHOUSE = 22;
  public static final int HOME = 17;
  public static final int HOME1 = 11;
  public static final int HOME2 = 12;
  public static final int HOME3 = 18;
  public static final int HOME4 = 23;
  public static final int HONEY = 7;
  public static final int HUNTER = 15;
  public static final int HYDROSTATION = 9;
  public static final int MAINBIG = 14;
  public static final int MASHROOM = 17;
  public static final int MEAT = 4;
  public static final int METAL = 9;
  public static final int MINE = 5;
  public static final int MONEY = 15;
  public static final int MUSH = 6;
  public static final int OIL = 10;
  public static final int OILUTILITY = 7;
  public static final int OILUTILITYBIG = 26;
  public static final int PEOPLE = 16;
  public static final int SAWMILL = 4;
  public static final int SAWMILLBIG = 24;
  public static final int SCORE = 21;
  public static final int STONE = 11;
  public static final int TORCH = 21;
  public static final int TREE = 13;
  public static final int VEGET = 3;
  public static final int WATER = 12;
  public static final int WATERBIG = 25;
  public static final int WATERSTATION = 10;
  public static final int WATERUTILITY = 3;
  public static final int WINDSTATION = 28;
  public static final int WORKER = 19;
  public static final int WORKING = 18;
  public static final int addPeople = 15;
  public static int[] buyResource;
  public static long costBirth = 0L;
  public static final float creditProcent = 0.07F;
  public static int[] curCount;
  public static int curNumResourceBuy;
  public static long exemptionOnPeople;
  private static final int[] fluctuation = { 200, 2, 2, 2, 3, 3, 3, 3, 7, 8, 8, 3, 4, 5, 7 };
  public static int improved;
  public static boolean info;
  public static boolean isMilliard;
  public static boolean isMillion;
  public static boolean isTrillion;
  public static float koefPeopleTwo;
  public static int levelBirth;
  public static int livedDays;
  public static float multiplePeople;
  public static long nalogWithBuy;
  public static long nalogWithSell;
  public static final String[] name;
  public static final String[] namePlace;
  public static int[] nextSellResource;
  public static float numPeople;
  public static int[] numberBuildings;
  public static int[] numberBusyPlace;
  public static int[] oldBuyResource;
  public static int[] oldSellResource;
  public static final int[] priceResourceStok;
  public static int ransom;
  public static long[] resource;
  public static Random rnd = new Random();
  public static double score;
  public static int scoreKoef;
  public static int[] sellResource;
  public static int summBuildings;
  public static long[] summConsumptionResource;
  public static long summNalog;
  public static long[] summProfitResource;
  public static long[] summResourceProfit;
  public static float tempPeople;
  public static int yearGenSellRes;
  
  static
  {
    livedDays = 0;
    name = new String[] { "Люди", "Жилье", "Работают", "Тр. Рабоч.", "Долг" };
    namePlace = new String[] { "Земля", "Лес", "Уголь", "Нефть", "Металл", "Золото", "Вода" };
    priceResourceStok = new int[] { 1000, 1, 3, 3, 4, 4, 5, 5, 30, 50, 45, 4, 7, 15, 35 };
  }
  
  public static void GenerateBuyResources()
  {
    buyResource[0] = (sellResource[0] + rnd.nextInt(31) + 20);
    sellResource[1] += 1;
    buyResource[2] = (sellResource[2] + rnd.nextInt(2) + 1);
    buyResource[3] = (sellResource[3] + rnd.nextInt(2) + 1);
    buyResource[4] = (sellResource[4] + rnd.nextInt(2) + 1);
    buyResource[5] = (sellResource[5] + rnd.nextInt(2) + 1);
    buyResource[6] = (sellResource[6] + rnd.nextInt(2) + 1);
    buyResource[7] = (sellResource[7] + rnd.nextInt(3) + 1);
    buyResource[8] = (sellResource[8] + rnd.nextInt(4) + 2);
    buyResource[9] = (sellResource[9] + rnd.nextInt(6) + 2);
    buyResource[10] = (sellResource[10] + rnd.nextInt(6) + 2);
    buyResource[11] = (sellResource[11] + rnd.nextInt(3) + 1);
    buyResource[12] = (sellResource[12] + rnd.nextInt(3) + 1);
    buyResource[13] = (sellResource[13] + rnd.nextInt(3) + 2);
    buyResource[14] = (sellResource[14] + rnd.nextInt(4) + 2);
  }
  
  private static int GenerateCourse()
  {
    if (rnd.nextInt(2) == 0) {
      return 1;
    }
    return -1;
  }
  
  public static int GenerateSellOne()
  {
    int i = 0;
    if (i >= curCount.length) {
      i = 0;
    }
    for (;;)
    {
      if (i >= curCount.length)
      {
        return -1;
        int[] arrayOfInt = curCount;
        arrayOfInt[i] -= 1;
        i += 1;
        break;
      }
      if (curCount[i] == 0)
      {
        curCount[i] = generateTime(i);
        sellResource[i] = nextSellResource[i];
        priceResourceStok[i] += rnd.nextInt(fluctuation[i]) * GenerateCourse();
        if (nextSellResource[1] < 1) {
          nextSellResource[1] = 1;
        }
        return i;
      }
      i += 1;
    }
  }
  
  public static void GenerateSellResources()
  {
    int i = 0;
    if (i >= priceResourceStok.length) {
      i = 0;
    }
    for (;;)
    {
      if (i >= priceResourceStok.length)
      {
        if (nextSellResource[1] < 1) {
          nextSellResource[1] = 1;
        }
        return;
        sellResource[i] = nextSellResource[i];
        i += 1;
        break;
      }
      priceResourceStok[i] += rnd.nextInt(fluctuation[i]) * GenerateCourse();
      curCount[i] = generateTime(i);
      i += 1;
    }
  }
  
  private static int generateTime(int paramInt)
  {
    int j = 0;
    int k = 0;
    int i;
    if (paramInt == 0)
    {
      i = 61;
      paramInt = 60;
    }
    while (j != 0)
    {
      return k;
      if (((paramInt > 0) && (paramInt < 7)) || (paramInt == 11))
      {
        i = 25;
        paramInt = 24;
      }
      else if ((paramInt == 7) || (paramInt == 12) || (paramInt == 13))
      {
        i = 37;
        paramInt = 24;
      }
      else
      {
        i = 49;
        paramInt = 24;
      }
    }
    int n = rnd.nextInt(i) + paramInt;
    int i1 = 1;
    int m = 0;
    for (;;)
    {
      k = n;
      j = i1;
      if (m >= curCount.length) {
        break;
      }
      if (n == curCount[m])
      {
        j = 0;
        k = n;
        break;
      }
      m += 1;
    }
  }
  
  public static long getResourceValue(int paramInt)
  {
    numberBuildings[0] = 1;
    if (paramInt >= resource.length) {
      return 0L;
    }
    return resource[paramInt];
  }
  
  public static void initialPlayer()
  {
    summResourceProfit = new long[15];
    GameLayout.date = new MyDate(1, 3, 1890);
    score = 0.0D;
    nalogWithBuy = 0L;
    nalogWithSell = 0L;
    exemptionOnPeople = 0L;
    scoreKoef = 100;
    long[] arrayOfLong = new long[22];
    arrayOfLong[15] = 82000L;
    arrayOfLong[16] = 28L;
    arrayOfLong[17] = 50L;
    resource = arrayOfLong;
    numPeople = 28.0F;
    koefPeopleTwo = 1.0F;
    tempPeople = 0.0F;
    multiplePeople = 1.0E-4F;
    numberBuildings = new int[31];
    summProfitResource = new long[15];
    summConsumptionResource = new long[15];
    numberBusyPlace = new int[8];
    ransom = 0;
    improved = 0;
    summBuildings = 1;
    summNalog = 0L;
    info = false;
    buyResource = new int[] { 1000, 1, 3, 3, 4, 4, 4, 5, 30, 50, 45, 4, 7, 15, 35 };
    sellResource = new int[] { 1000, 1, 3, 3, 4, 4, 4, 5, 30, 50, 45, 4, 7, 15, 35 };
    oldBuyResource = new int[15];
    oldSellResource = new int[] { 1000, 1, 3, 3, 4, 4, 4, 5, 30, 50, 45, 4, 7, 15, 35 };
    nextSellResource = new int[] { 1000, 1, 3, 3, 4, 4, 4, 5, 30, 50, 45, 4, 7, 15, 35 };
    curNumResourceBuy = 0;
    yearGenSellRes = 1895;
    curCount = new int[15];
    levelBirth = 1;
    costBirth = 100000L;
    isMillion = false;
    isMilliard = false;
    isTrillion = false;
    GenerateSellResources();
    GenerateSellResources();
    GenerateBuyResources();
  }
  
  public static void load(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    BestScoreData.loadData(paramObjectInputStream);
    summResourceProfit = new long[15];
    int i = 0;
    for (;;)
    {
      if (i >= summResourceProfit.length)
      {
        resource = new long[22];
        numberBuildings = new int[31];
        summProfitResource = new long[15];
        summConsumptionResource = new long[15];
        buyResource = new int[15];
        sellResource = new int[15];
        oldBuyResource = new int[15];
        oldSellResource = new int[15];
        nextSellResource = new int[15];
        numberBusyPlace = new int[8];
        curCount = new int[15];
      }
      try
      {
        GameLayout.date = (MyDate)paramObjectInputStream.readObject();
        score = paramObjectInputStream.readDouble();
        nalogWithBuy = paramObjectInputStream.readLong();
        nalogWithSell = paramObjectInputStream.readLong();
        exemptionOnPeople = paramObjectInputStream.readLong();
        scoreKoef = paramObjectInputStream.readInt();
        i = 0;
        if (i >= resource.length)
        {
          koefPeopleTwo = 1.0F;
          if (resource[16] <= 100000L) {
            koefPeopleTwo = 1.0F;
          }
          if (resource[16] > 100000L) {
            koefPeopleTwo = 4.0F;
          }
          if (resource[16] > 1000000L) {
            koefPeopleTwo = 6.0F;
          }
          if (resource[16] > 2000000L) {
            koefPeopleTwo = 9.0F;
          }
          numPeople = paramObjectInputStream.readFloat();
          tempPeople = paramObjectInputStream.readFloat();
          multiplePeople = paramObjectInputStream.readFloat();
          i = 0;
          if (i < numberBuildings.length) {
            break label424;
          }
          i = 0;
          if (i < summProfitResource.length) {
            break label440;
          }
          i = 0;
          if (i < numberBusyPlace.length) {
            break label465;
          }
          ransom = paramObjectInputStream.readInt();
          improved = paramObjectInputStream.readInt();
          summBuildings = paramObjectInputStream.readInt();
          summNalog = paramObjectInputStream.readLong();
          info = paramObjectInputStream.readBoolean();
          i = 0;
          if (i < buyResource.length) {
            break label481;
          }
          curNumResourceBuy = paramObjectInputStream.readInt();
          yearGenSellRes = paramObjectInputStream.readInt();
          levelBirth = paramObjectInputStream.readInt();
          costBirth = paramObjectInputStream.readLong();
          isMillion = paramObjectInputStream.readBoolean();
          isMilliard = paramObjectInputStream.readBoolean();
          isTrillion = paramObjectInputStream.readBoolean();
          livedDays = paramObjectInputStream.readInt();
          return;
          summResourceProfit[i] = paramObjectInputStream.readLong();
          i += 1;
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        for (;;)
        {
          localClassNotFoundException.printStackTrace();
          continue;
          resource[i] = paramObjectInputStream.readLong();
          i += 1;
          continue;
          label424:
          numberBuildings[i] = paramObjectInputStream.readInt();
          i += 1;
          continue;
          label440:
          summProfitResource[i] = paramObjectInputStream.readLong();
          summConsumptionResource[i] = paramObjectInputStream.readLong();
          i += 1;
          continue;
          label465:
          numberBusyPlace[i] = paramObjectInputStream.readInt();
          i += 1;
          continue;
          label481:
          buyResource[i] = paramObjectInputStream.readInt();
          sellResource[i] = paramObjectInputStream.readInt();
          oldBuyResource[i] = paramObjectInputStream.readInt();
          oldSellResource[i] = paramObjectInputStream.readInt();
          nextSellResource[i] = paramObjectInputStream.readInt();
          curCount[i] = paramObjectInputStream.readInt();
          i += 1;
        }
      }
    }
  }
  
  public static void save(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    BestScoreData.isFile = true;
    BestScoreData.saveData(paramObjectOutputStream);
    int i = 0;
    if (i >= summResourceProfit.length)
    {
      paramObjectOutputStream.writeObject(GameLayout.date);
      paramObjectOutputStream.writeDouble(score);
      paramObjectOutputStream.writeLong(nalogWithBuy);
      paramObjectOutputStream.writeLong(nalogWithSell);
      paramObjectOutputStream.writeLong(exemptionOnPeople);
      paramObjectOutputStream.writeInt(scoreKoef);
      i = 0;
      label62:
      if (i < resource.length) {
        break label239;
      }
      paramObjectOutputStream.writeFloat(numPeople);
      paramObjectOutputStream.writeFloat(tempPeople);
      paramObjectOutputStream.writeFloat(multiplePeople);
      i = 0;
      label93:
      if (i < numberBuildings.length) {
        break label255;
      }
      i = 0;
      label103:
      if (i < summProfitResource.length) {
        break label271;
      }
      i = 0;
      label113:
      if (i < numberBusyPlace.length) {
        break label296;
      }
      paramObjectOutputStream.writeInt(ransom);
      paramObjectOutputStream.writeInt(improved);
      paramObjectOutputStream.writeInt(summBuildings);
      paramObjectOutputStream.writeLong(summNalog);
      paramObjectOutputStream.writeBoolean(info);
      i = 0;
    }
    for (;;)
    {
      if (i >= buyResource.length)
      {
        paramObjectOutputStream.writeInt(curNumResourceBuy);
        paramObjectOutputStream.writeInt(yearGenSellRes);
        paramObjectOutputStream.writeInt(levelBirth);
        paramObjectOutputStream.writeLong(costBirth);
        paramObjectOutputStream.writeBoolean(isMillion);
        paramObjectOutputStream.writeBoolean(isMilliard);
        paramObjectOutputStream.writeBoolean(isTrillion);
        paramObjectOutputStream.writeInt(livedDays);
        return;
        paramObjectOutputStream.writeLong(summResourceProfit[i]);
        i += 1;
        break;
        label239:
        paramObjectOutputStream.writeLong(resource[i]);
        i += 1;
        break label62;
        label255:
        paramObjectOutputStream.writeInt(numberBuildings[i]);
        i += 1;
        break label93;
        label271:
        paramObjectOutputStream.writeLong(summProfitResource[i]);
        paramObjectOutputStream.writeLong(summConsumptionResource[i]);
        i += 1;
        break label103;
        label296:
        paramObjectOutputStream.writeInt(numberBusyPlace[i]);
        i += 1;
        break label113;
      }
      paramObjectOutputStream.writeInt(buyResource[i]);
      paramObjectOutputStream.writeInt(sellResource[i]);
      paramObjectOutputStream.writeInt(oldBuyResource[i]);
      paramObjectOutputStream.writeInt(oldSellResource[i]);
      paramObjectOutputStream.writeInt(nextSellResource[i]);
      paramObjectOutputStream.writeInt(curCount[i]);
      i += 1;
    }
  }
  
  public static void saveFileNotExists(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeBoolean(false);
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\data\Player.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */