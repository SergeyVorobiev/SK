package com.vorobiev.data;

import java.io.IOException;
import java.io.ObjectOutputStream;

public class BestScoreData
{
  public static int cubok;
  public static String dateMilliardBest = "";
  public static String dateMillionBest;
  public static String dateTrillionBest = "";
  public static int dayMilliardBest;
  public static int dayMillionBest;
  public static int dayTrillionBest;
  public static boolean isFile = false;
  public static int scoreBest;
  public static long summMoney;
  public static long[] summResourceProfitBest;
  
  static
  {
    dateMillionBest = "";
  }
  
  /* Error */
  public static void loadData(java.io.ObjectInputStream paramObjectInputStream)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 48	java/io/ObjectInputStream:readBoolean	()Z
    //   4: putstatic 24	com/vorobiev/data/BestScoreData:isFile	Z
    //   7: aload_0
    //   8: invokevirtual 52	java/io/ObjectInputStream:readInt	()I
    //   11: putstatic 54	com/vorobiev/data/BestScoreData:cubok	I
    //   14: aload_0
    //   15: invokevirtual 52	java/io/ObjectInputStream:readInt	()I
    //   18: putstatic 56	com/vorobiev/data/BestScoreData:scoreBest	I
    //   21: aload_0
    //   22: invokevirtual 52	java/io/ObjectInputStream:readInt	()I
    //   25: putstatic 58	com/vorobiev/data/BestScoreData:dayMillionBest	I
    //   28: aload_0
    //   29: invokevirtual 62	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   32: checkcast 64	java/lang/String
    //   35: putstatic 28	com/vorobiev/data/BestScoreData:dateMillionBest	Ljava/lang/String;
    //   38: aload_0
    //   39: invokevirtual 52	java/io/ObjectInputStream:readInt	()I
    //   42: putstatic 66	com/vorobiev/data/BestScoreData:dayMilliardBest	I
    //   45: aload_0
    //   46: invokevirtual 62	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   49: checkcast 64	java/lang/String
    //   52: putstatic 30	com/vorobiev/data/BestScoreData:dateMilliardBest	Ljava/lang/String;
    //   55: aload_0
    //   56: invokevirtual 52	java/io/ObjectInputStream:readInt	()I
    //   59: putstatic 68	com/vorobiev/data/BestScoreData:dayTrillionBest	I
    //   62: aload_0
    //   63: invokevirtual 62	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   66: checkcast 64	java/lang/String
    //   69: putstatic 32	com/vorobiev/data/BestScoreData:dateTrillionBest	Ljava/lang/String;
    //   72: bipush 15
    //   74: newarray <illegal type>
    //   76: putstatic 70	com/vorobiev/data/BestScoreData:summResourceProfitBest	[J
    //   79: iconst_0
    //   80: istore_1
    //   81: iload_1
    //   82: getstatic 70	com/vorobiev/data/BestScoreData:summResourceProfitBest	[J
    //   85: arraylength
    //   86: if_icmplt +56 -> 142
    //   89: aload_0
    //   90: invokevirtual 74	java/io/ObjectInputStream:readLong	()J
    //   93: putstatic 76	com/vorobiev/data/BestScoreData:summMoney	J
    //   96: return
    //   97: astore_0
    //   98: aload_0
    //   99: invokevirtual 79	java/lang/ClassNotFoundException:printStackTrace	()V
    //   102: new 81	java/lang/RuntimeException
    //   105: dup
    //   106: ldc 83
    //   108: invokespecial 86	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   111: athrow
    //   112: astore_0
    //   113: aload_0
    //   114: invokevirtual 79	java/lang/ClassNotFoundException:printStackTrace	()V
    //   117: new 81	java/lang/RuntimeException
    //   120: dup
    //   121: ldc 88
    //   123: invokespecial 86	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   126: athrow
    //   127: astore_0
    //   128: aload_0
    //   129: invokevirtual 79	java/lang/ClassNotFoundException:printStackTrace	()V
    //   132: new 81	java/lang/RuntimeException
    //   135: dup
    //   136: ldc 90
    //   138: invokespecial 86	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   141: athrow
    //   142: getstatic 70	com/vorobiev/data/BestScoreData:summResourceProfitBest	[J
    //   145: iload_1
    //   146: aload_0
    //   147: invokevirtual 74	java/io/ObjectInputStream:readLong	()J
    //   150: lastore
    //   151: iload_1
    //   152: iconst_1
    //   153: iadd
    //   154: istore_1
    //   155: goto -74 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	paramObjectInputStream	java.io.ObjectInputStream
    //   80	75	1	i	int
    // Exception table:
    //   from	to	target	type
    //   28	38	97	java/lang/ClassNotFoundException
    //   45	55	112	java/lang/ClassNotFoundException
    //   62	72	127	java/lang/ClassNotFoundException
  }
  
  public static void newData()
  {
    isFile = false;
    cubok = 0;
    scoreBest = 0;
    dayMillionBest = 100000;
    dayMilliardBest = 100000;
    dayTrillionBest = 100000;
    dateMillionBest = "";
    dateMilliardBest = "";
    dateTrillionBest = "";
    summResourceProfitBest = new long[15];
    summMoney = 0L;
  }
  
  public static void saveData(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeBoolean(isFile);
    paramObjectOutputStream.writeInt(cubok);
    int i = (int)Player.score;
    if (i > scoreBest)
    {
      scoreBest = i;
      paramObjectOutputStream.writeInt(i);
      paramObjectOutputStream.writeInt(dayMillionBest);
      paramObjectOutputStream.writeObject(dateMillionBest);
      paramObjectOutputStream.writeInt(dayMilliardBest);
      paramObjectOutputStream.writeObject(dateMilliardBest);
      paramObjectOutputStream.writeInt(dayTrillionBest);
      paramObjectOutputStream.writeObject(dateTrillionBest);
      i = 0;
    }
    for (;;)
    {
      if (i >= summResourceProfitBest.length)
      {
        paramObjectOutputStream.writeLong(summMoney);
        return;
        paramObjectOutputStream.writeInt(scoreBest);
        break;
      }
      if (summResourceProfitBest[i] < Player.summResourceProfit[i]) {
        summResourceProfitBest[i] = Player.summResourceProfit[i];
      }
      paramObjectOutputStream.writeLong(summResourceProfitBest[i]);
      i += 1;
    }
  }
  
  public static void saveDataNewGame(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeBoolean(isFile);
    paramObjectOutputStream.writeInt(cubok);
    paramObjectOutputStream.writeInt(scoreBest);
    paramObjectOutputStream.writeInt(dayMillionBest);
    paramObjectOutputStream.writeObject(dateMillionBest);
    paramObjectOutputStream.writeInt(dayMilliardBest);
    paramObjectOutputStream.writeObject(dateMilliardBest);
    paramObjectOutputStream.writeInt(dayTrillionBest);
    paramObjectOutputStream.writeObject(dateTrillionBest);
    int i = 0;
    for (;;)
    {
      if (i >= summResourceProfitBest.length)
      {
        paramObjectOutputStream.writeLong(summMoney);
        return;
      }
      paramObjectOutputStream.writeLong(summResourceProfitBest[i]);
      i += 1;
    }
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\data\BestScoreData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */