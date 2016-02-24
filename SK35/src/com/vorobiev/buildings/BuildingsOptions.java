package com.vorobiev.buildings;

public class BuildingsOptions
{
  public static final int COST = 0;
  public static final int FIWORKMOUNTH = 6;
  public static final int HOME = 4;
  public static final int LIFE = 2;
  public static final int STWORKMOUNTH = 5;
  public static final int TIMECONSTR = 1;
  public static final int WORKDAY = 7;
  public static final int WORKDAYLEEP = 8;
  public static final int WORKER = 3;
  private static final int[] animal;
  private static final int[] atom;
  private static final int[] atomBig;
  private static final int[] catacombs;
  private static final int[] city;
  private static final int[] coal;
  private static final int[] coalBig;
  private static final int[] electro;
  private static final int[] farmBig;
  private static final int[] fish;
  private static final int[] garden;
  private static final int[] gold;
  private static final int[] greenhouse;
  private static final int[] home1;
  private static final int[] home2;
  private static final int[] home3;
  private static final int[] home4;
  private static final int[] honey;
  private static final int[] hunt;
  private static final int[] hydro;
  private static final int[] mush;
  private static final int[] oil;
  private static final int[] oilBig;
  private static final int[] pit;
  private static final int[] pole;
  private static final int[] sawmill;
  private static final int[] sawmillBig;
  private static final int[] torch;
  private static final int[] water;
  private static final int[] waterBig;
  private static final int[] wind;
  
  static
  {
    int[] arrayOfInt = new int[9];
    arrayOfInt[0] = 250000000;
    arrayOfInt[1] = 360;
    arrayOfInt[2] = -1;
    arrayOfInt[4] = 50;
    arrayOfInt[5] = 1;
    arrayOfInt[6] = 12;
    city = arrayOfInt;
    arrayOfInt = new int[9];
    arrayOfInt[0] = 28900;
    arrayOfInt[1] = 38;
    arrayOfInt[2] = 120;
    arrayOfInt[3] = 6;
    arrayOfInt[5] = 3;
    arrayOfInt[6] = 11;
    arrayOfInt[7] = 275;
    arrayOfInt[8] = 275;
    pole = arrayOfInt;
    arrayOfInt = new int[9];
    arrayOfInt[0] = 17020;
    arrayOfInt[1] = 20;
    arrayOfInt[2] = 8760;
    arrayOfInt[3] = 4;
    arrayOfInt[5] = 6;
    arrayOfInt[6] = 11;
    arrayOfInt[7] = 183;
    arrayOfInt[8] = 183;
    garden = arrayOfInt;
    arrayOfInt = new int[9];
    arrayOfInt[0] = 29250;
    arrayOfInt[1] = 46;
    arrayOfInt[2] = 2920;
    arrayOfInt[3] = 7;
    arrayOfInt[5] = 3;
    arrayOfInt[6] = 11;
    arrayOfInt[7] = 275;
    arrayOfInt[8] = 275;
    water = arrayOfInt;
    arrayOfInt = new int[9];
    arrayOfInt[0] = 64900;
    arrayOfInt[1] = 16;
    arrayOfInt[2] = 2450;
    arrayOfInt[3] = 16;
    arrayOfInt[5] = 1;
    arrayOfInt[6] = 12;
    arrayOfInt[7] = 365;
    arrayOfInt[8] = 366;
    sawmill = arrayOfInt;
    arrayOfInt = new int[9];
    arrayOfInt[0] = 123790;
    arrayOfInt[1] = 68;
    arrayOfInt[2] = 3900;
    arrayOfInt[3] = 40;
    arrayOfInt[5] = 1;
    arrayOfInt[6] = 12;
    arrayOfInt[7] = 365;
    arrayOfInt[8] = 366;
    coal = arrayOfInt;
    arrayOfInt = new int[9];
    arrayOfInt[0] = 108620;
    arrayOfInt[1] = 18;
    arrayOfInt[2] = 3410;
    arrayOfInt[3] = 35;
    arrayOfInt[5] = 3;
    arrayOfInt[6] = 11;
    arrayOfInt[7] = 275;
    arrayOfInt[8] = 275;
    pit = arrayOfInt;
    arrayOfInt = new int[9];
    arrayOfInt[0] = 88000;
    arrayOfInt[1] = 25;
    arrayOfInt[2] = 2920;
    arrayOfInt[3] = 24;
    arrayOfInt[5] = 6;
    arrayOfInt[6] = 8;
    arrayOfInt[7] = 92;
    arrayOfInt[8] = 92;
    oil = arrayOfInt;
    arrayOfInt = new int[9];
    arrayOfInt[0] = 444444;
    arrayOfInt[1] = 10;
    arrayOfInt[2] = 2450;
    arrayOfInt[3] = 77;
    arrayOfInt[5] = 6;
    arrayOfInt[6] = 8;
    arrayOfInt[7] = 92;
    arrayOfInt[8] = 92;
    gold = arrayOfInt;
    arrayOfInt = new int[9];
    arrayOfInt[0] = 401000;
    arrayOfInt[1] = 65;
    arrayOfInt[2] = 11680;
    arrayOfInt[3] = 60;
    arrayOfInt[5] = 1;
    arrayOfInt[6] = 12;
    arrayOfInt[7] = 365;
    arrayOfInt[8] = 366;
    electro = arrayOfInt;
    arrayOfInt = new int[9];
    arrayOfInt[0] = 304800;
    arrayOfInt[1] = 70;
    arrayOfInt[2] = 9750;
    arrayOfInt[3] = 39;
    arrayOfInt[5] = 1;
    arrayOfInt[6] = 12;
    arrayOfInt[7] = 365;
    arrayOfInt[8] = 366;
    hydro = arrayOfInt;
    arrayOfInt = new int[9];
    arrayOfInt[0] = 5900;
    arrayOfInt[1] = 8;
    arrayOfInt[2] = 3900;
    arrayOfInt[4] = 20;
    arrayOfInt[5] = 1;
    arrayOfInt[6] = 12;
    arrayOfInt[7] = 365;
    arrayOfInt[8] = 366;
    home1 = arrayOfInt;
    arrayOfInt = new int[9];
    arrayOfInt[0] = 14100;
    arrayOfInt[1] = 26;
    arrayOfInt[2] = 13140;
    arrayOfInt[4] = 60;
    arrayOfInt[5] = 1;
    arrayOfInt[6] = 12;
    arrayOfInt[7] = 365;
    arrayOfInt[8] = 366;
    home2 = arrayOfInt;
    arrayOfInt = new int[9];
    arrayOfInt[0] = 43460;
    arrayOfInt[1] = 18;
    arrayOfInt[2] = 3900;
    arrayOfInt[3] = 12;
    arrayOfInt[5] = 1;
    arrayOfInt[6] = 12;
    arrayOfInt[7] = 365;
    arrayOfInt[8] = 366;
    fish = arrayOfInt;
    arrayOfInt = new int[9];
    arrayOfInt[0] = 310650;
    arrayOfInt[1] = 30;
    arrayOfInt[2] = 10220;
    arrayOfInt[3] = 45;
    arrayOfInt[5] = 6;
    arrayOfInt[6] = 11;
    arrayOfInt[7] = 183;
    arrayOfInt[8] = 183;
    coalBig = arrayOfInt;
    arrayOfInt = new int[9];
    arrayOfInt[0] = 55200;
    arrayOfInt[1] = 9;
    arrayOfInt[2] = 3410;
    arrayOfInt[3] = 14;
    arrayOfInt[5] = 1;
    arrayOfInt[6] = 12;
    arrayOfInt[7] = 365;
    arrayOfInt[8] = 366;
    hunt = arrayOfInt;
    arrayOfInt = new int[9];
    arrayOfInt[0] = 52170;
    arrayOfInt[1] = 45;
    arrayOfInt[2] = 3900;
    arrayOfInt[3] = 13;
    arrayOfInt[5] = 1;
    arrayOfInt[6] = 12;
    arrayOfInt[7] = 365;
    arrayOfInt[8] = 366;
    animal = arrayOfInt;
    arrayOfInt = new int[9];
    arrayOfInt[0] = 67200;
    arrayOfInt[1] = 8;
    arrayOfInt[2] = 2920;
    arrayOfInt[3] = 17;
    arrayOfInt[5] = 9;
    arrayOfInt[6] = 11;
    arrayOfInt[7] = 91;
    arrayOfInt[8] = 91;
    mush = arrayOfInt;
    arrayOfInt = new int[9];
    arrayOfInt[0] = 66400;
    arrayOfInt[1] = 100;
    arrayOfInt[2] = 18500;
    arrayOfInt[4] = 200;
    arrayOfInt[5] = 1;
    arrayOfInt[6] = 12;
    arrayOfInt[7] = 365;
    arrayOfInt[8] = 366;
    home3 = arrayOfInt;
    arrayOfInt = new int[9];
    arrayOfInt[0] = 610000;
    arrayOfInt[1] = 80;
    arrayOfInt[2] = 7790;
    arrayOfInt[3] = 96;
    arrayOfInt[5] = 1;
    arrayOfInt[6] = 12;
    arrayOfInt[7] = 365;
    arrayOfInt[8] = 366;
    farmBig = arrayOfInt;
    arrayOfInt = new int[9];
    arrayOfInt[0] = 517400;
    arrayOfInt[1] = 25;
    arrayOfInt[2] = 2450;
    arrayOfInt[3] = 61;
    arrayOfInt[5] = 3;
    arrayOfInt[6] = 11;
    arrayOfInt[7] = 275;
    arrayOfInt[8] = 275;
    honey = arrayOfInt;
    arrayOfInt = new int[9];
    arrayOfInt[0] = 205000;
    arrayOfInt[1] = 40;
    arrayOfInt[2] = 2450;
    arrayOfInt[3] = 27;
    arrayOfInt[5] = 1;
    arrayOfInt[6] = 12;
    arrayOfInt[7] = 365;
    arrayOfInt[8] = 366;
    torch = arrayOfInt;
    arrayOfInt = new int[9];
    arrayOfInt[0] = 39440;
    arrayOfInt[1] = 30;
    arrayOfInt[2] = 4380;
    arrayOfInt[3] = 9;
    arrayOfInt[5] = 1;
    arrayOfInt[6] = 12;
    arrayOfInt[7] = 365;
    arrayOfInt[8] = 366;
    greenhouse = arrayOfInt;
    arrayOfInt = new int[9];
    arrayOfInt[0] = 971000;
    arrayOfInt[1] = 320;
    arrayOfInt[2] = 29200;
    arrayOfInt[4] = 8000;
    arrayOfInt[5] = 1;
    arrayOfInt[6] = 12;
    arrayOfInt[7] = 365;
    arrayOfInt[8] = 366;
    home4 = arrayOfInt;
    arrayOfInt = new int[9];
    arrayOfInt[0] = 2260000;
    arrayOfInt[1] = 20;
    arrayOfInt[2] = 2450;
    arrayOfInt[3] = 67;
    arrayOfInt[5] = 6;
    arrayOfInt[6] = 8;
    arrayOfInt[7] = 92;
    arrayOfInt[8] = 92;
    sawmillBig = arrayOfInt;
    arrayOfInt = new int[9];
    arrayOfInt[0] = 3370000;
    arrayOfInt[1] = 66;
    arrayOfInt[2] = 17040;
    arrayOfInt[3] = 57;
    arrayOfInt[5] = 1;
    arrayOfInt[6] = 12;
    arrayOfInt[7] = 365;
    arrayOfInt[8] = 366;
    waterBig = arrayOfInt;
    arrayOfInt = new int[9];
    arrayOfInt[0] = 5250000;
    arrayOfInt[1] = 120;
    arrayOfInt[2] = 7600;
    arrayOfInt[3] = 97;
    arrayOfInt[5] = 6;
    arrayOfInt[6] = 8;
    arrayOfInt[7] = 92;
    arrayOfInt[8] = 92;
    oilBig = arrayOfInt;
    arrayOfInt = new int[9];
    arrayOfInt[0] = 6200000;
    arrayOfInt[1] = 30;
    arrayOfInt[2] = 7300;
    arrayOfInt[3] = 100;
    arrayOfInt[5] = 1;
    arrayOfInt[6] = 12;
    arrayOfInt[7] = 365;
    arrayOfInt[8] = 366;
    catacombs = arrayOfInt;
    arrayOfInt = new int[9];
    arrayOfInt[0] = 79920;
    arrayOfInt[1] = 12;
    arrayOfInt[2] = 4380;
    arrayOfInt[3] = 18;
    arrayOfInt[5] = 9;
    arrayOfInt[6] = 2;
    arrayOfInt[7] = 181;
    arrayOfInt[8] = 182;
    wind = arrayOfInt;
    arrayOfInt = new int[9];
    arrayOfInt[0] = 29000000;
    arrayOfInt[1] = 260;
    arrayOfInt[2] = 17040;
    arrayOfInt[3] = 217;
    arrayOfInt[5] = 1;
    arrayOfInt[6] = 12;
    arrayOfInt[7] = 365;
    arrayOfInt[8] = 366;
    atom = arrayOfInt;
    arrayOfInt = new int[9];
    arrayOfInt[0] = 120000000;
    arrayOfInt[1] = 480;
    arrayOfInt[2] = 24500;
    arrayOfInt[3] = 578;
    arrayOfInt[5] = 1;
    arrayOfInt[6] = 12;
    arrayOfInt[7] = 365;
    arrayOfInt[8] = 366;
    atomBig = arrayOfInt;
  }
  
  public static int[] getConsumption(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return ArrayResource.getNewArray();
    case 1: 
      ArrayResource.setWater(1);
      return ArrayResource.getNewArray();
    case 2: 
      ArrayResource.setWater(2);
      return ArrayResource.getNewArray();
    case 3: 
      return ArrayResource.getNewArray();
    case 4: 
      ArrayResource.setOil(1);
      return ArrayResource.getNewArray();
    case 5: 
      ArrayResource.setElectro(1);
      ArrayResource.setForest(2);
      return ArrayResource.getNewArray();
    case 6: 
      ArrayResource.setOil(2);
      return ArrayResource.getNewArray();
    case 7: 
      return ArrayResource.getNewArray();
    case 8: 
      ArrayResource.setWater(220);
      return ArrayResource.getNewArray();
    case 9: 
      ArrayResource.setCoal(8);
      return ArrayResource.getNewArray();
    case 10: 
      return ArrayResource.getNewArray();
    case 11: 
      return ArrayResource.getNewArray();
    case 12: 
      return ArrayResource.getNewArray();
    case 13: 
      ArrayResource.setForest(1);
      return ArrayResource.getNewArray();
    case 14: 
      ArrayResource.setOil(9);
      return ArrayResource.getNewArray();
    case 15: 
      ArrayResource.setForest(1);
      return ArrayResource.getNewArray();
    case 16: 
      ArrayResource.setForest(1);
      ArrayResource.setWater(1);
      return ArrayResource.getNewArray();
    case 17: 
      return ArrayResource.getNewArray();
    case 18: 
      return ArrayResource.getNewArray();
    case 19: 
      ArrayResource.setCoal(1);
      ArrayResource.setElectro(1);
      ArrayResource.setForest(1);
      ArrayResource.setStone(1);
      ArrayResource.setMetal(1);
      ArrayResource.setOil(1);
      ArrayResource.setForest(1);
      return ArrayResource.getNewArray();
    case 20: 
      return ArrayResource.getNewArray();
    case 21: 
      return ArrayResource.getNewArray();
    case 22: 
      ArrayResource.setWater(1);
      return ArrayResource.getNewArray();
    case 23: 
      return ArrayResource.getNewArray();
    case 24: 
      ArrayResource.setMetal(4);
      ArrayResource.setOil(8);
      return ArrayResource.getNewArray();
    case 25: 
      return ArrayResource.getNewArray();
    case 26: 
      return ArrayResource.getNewArray();
    case 27: 
      ArrayResource.setForest(5);
      ArrayResource.setElectro(1);
      return ArrayResource.getNewArray();
    case 28: 
      return ArrayResource.getNewArray();
    case 29: 
      return ArrayResource.getNewArray();
    }
    return ArrayResource.getNewArray();
  }
  
  public static String getName(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 0: 
      return "Город";
    case 1: 
      return "Ферма";
    case 2: 
      return "Сад";
    case 3: 
      return "Водоканал";
    case 4: 
      return "Лесопилка";
    case 5: 
      return "Шахта";
    case 6: 
      return "Карьер";
    case 7: 
      return "Нефть";
    case 8: 
      return "Золотой прииск";
    case 9: 
      return "Электростанция";
    case 10: 
      return "Гидростанция";
    case 11: 
      return "Хижина";
    case 12: 
      return "Жилой дом";
    case 13: 
      return "Рыбный промысел";
    case 14: 
      return "Угольный разрез";
    case 15: 
      return "Охотничьи угодья";
    case 16: 
      return "Животноводческая ферма";
    case 17: 
      return "Грибная плантация";
    case 18: 
      return "Жилой район";
    case 19: 
      return "Хозяйство";
    case 20: 
      return "Пасека";
    case 21: 
      return "Факел";
    case 22: 
      return "Теплица";
    case 23: 
      return "Жилой центр";
    case 24: 
      return "Лесоповал";
    case 25: 
      return "Водокачка";
    case 26: 
      return "Нефтенасос";
    case 27: 
      return "Катакомбы";
    case 28: 
      return "Ветряк";
    case 29: 
      return "Малая АЭС";
    }
    return "АЭС";
  }
  
  public static int[] getOptions(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return city;
    case 1: 
      return pole;
    case 2: 
      return garden;
    case 3: 
      return water;
    case 4: 
      return sawmill;
    case 5: 
      return coal;
    case 6: 
      return pit;
    case 7: 
      return oil;
    case 8: 
      return gold;
    case 9: 
      return electro;
    case 10: 
      return hydro;
    case 11: 
      return home1;
    case 12: 
      return home2;
    case 13: 
      return fish;
    case 14: 
      return coalBig;
    case 15: 
      return hunt;
    case 16: 
      return animal;
    case 17: 
      return mush;
    case 18: 
      return home3;
    case 19: 
      return farmBig;
    case 20: 
      return honey;
    case 21: 
      return torch;
    case 22: 
      return greenhouse;
    case 23: 
      return home4;
    case 24: 
      return sawmillBig;
    case 25: 
      return waterBig;
    case 26: 
      return oilBig;
    case 27: 
      return catacombs;
    case 28: 
      return wind;
    case 29: 
      return atom;
    }
    return atomBig;
  }
  
  public static int[] getProfit(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return ArrayResource.getNewArray();
    case 1: 
      ArrayResource.setBread(36);
      return ArrayResource.getNewArray();
    case 2: 
      ArrayResource.setFruct(20);
      return ArrayResource.getNewArray();
    case 3: 
      ArrayResource.setWater(7);
      return ArrayResource.getNewArray();
    case 4: 
      ArrayResource.setForest(8);
      return ArrayResource.getNewArray();
    case 5: 
      ArrayResource.setCoal(4);
      ArrayResource.setStone(24);
      return ArrayResource.getNewArray();
    case 6: 
      ArrayResource.setMetal(3);
      ArrayResource.setStone(29);
      return ArrayResource.getNewArray();
    case 7: 
      ArrayResource.setOil(9);
      return ArrayResource.getNewArray();
    case 8: 
      ArrayResource.setStone(50);
      ArrayResource.setGold(3);
      return ArrayResource.getNewArray();
    case 9: 
      ArrayResource.setElectro(17);
      return ArrayResource.getNewArray();
    case 10: 
      ArrayResource.setElectro(7);
      return ArrayResource.getNewArray();
    case 11: 
      return ArrayResource.getNewArray();
    case 12: 
      return ArrayResource.getNewArray();
    case 13: 
      ArrayResource.setFish(17);
      return ArrayResource.getNewArray();
    case 14: 
      ArrayResource.setCoal(30);
      ArrayResource.setMetal(1);
      return ArrayResource.getNewArray();
    case 15: 
      ArrayResource.setMeat(20);
      return ArrayResource.getNewArray();
    case 16: 
      ArrayResource.setMeat(21);
      return ArrayResource.getNewArray();
    case 17: 
      ArrayResource.setMush(62);
      return ArrayResource.getNewArray();
    case 18: 
      return ArrayResource.getNewArray();
    case 19: 
      ArrayResource.setBread(50);
      ArrayResource.setMeat(170);
      return ArrayResource.getNewArray();
    case 20: 
      ArrayResource.setHoney(110);
      return ArrayResource.getNewArray();
    case 21: 
      ArrayResource.setElectro(5);
      return ArrayResource.getNewArray();
    case 22: 
      ArrayResource.setVeget(18);
      return ArrayResource.getNewArray();
    case 23: 
      return ArrayResource.getNewArray();
    case 24: 
      ArrayResource.setForest(360);
      return ArrayResource.getNewArray();
    case 25: 
      ArrayResource.setWater(200);
      return ArrayResource.getNewArray();
    case 26: 
      ArrayResource.setOil(200);
      return ArrayResource.getNewArray();
    case 27: 
      ArrayResource.setMetal(50);
      ArrayResource.setStone(30);
      return ArrayResource.getNewArray();
    case 28: 
      ArrayResource.setElectro(5);
      return ArrayResource.getNewArray();
    case 29: 
      ArrayResource.setElectro(270);
      return ArrayResource.getNewArray();
    }
    ArrayResource.setElectro(900);
    return ArrayResource.getNewArray();
  }
  
  public static float getServiceOneDay(int paramInt)
  {
    int[] arrayOfInt = getOptions(paramInt);
    return arrayOfInt[0] / arrayOfInt[2] * 0.5F;
  }
  
  public static String getStringPlace(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 0: 
      return "на фундаменте";
    case 1: 
      return "везде";
    case 2: 
      return "везде";
    case 3: 
      return "на воде";
    case 4: 
      return "в лесу";
    case 5: 
      return "на угле";
    case 6: 
      return "на руде";
    case 7: 
      return "на нефти";
    case 8: 
      return "на золоте";
    case 9: 
      return "везде";
    case 10: 
      return "на воде";
    case 11: 
      return "везде";
    case 12: 
      return "на земле";
    case 13: 
      return "на воде";
    case 14: 
      return "на угле";
    case 15: 
      return "в лесу";
    case 16: 
      return "везде";
    case 17: 
      return "в лесу";
    case 18: 
      return "на земле";
    case 19: 
      return "на земле";
    case 20: 
      return "везде";
    case 21: 
      return "на нефти";
    case 22: 
      return "на земле";
    case 23: 
      return "на земле";
    case 24: 
      return "в лесу";
    case 25: 
      return "на воде";
    case 26: 
      return "на нефти";
    case 27: 
      return "на руде";
    case 28: 
      return "везде";
    case 29: 
      return "на воде";
    }
    return "на воде";
  }
  
  public static String getStringWorking(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 0: 
      return "Нет";
    case 1: 
      return "(Лето, Осень, Весна)";
    case 2: 
      return "(Лето, Осень)";
    case 3: 
      return "(Лето, Осень, Весна)";
    case 4: 
      return "(Лето, Осень, Зима, Весна)";
    case 5: 
      return "(Лето, Осень, Зима, Весна)";
    case 6: 
      return "(Лето, Осень, Весна)";
    case 7: 
      return "(Лето)";
    case 8: 
      return "(Лето)";
    case 9: 
      return "(Лето, Осень, Зима, Весна)";
    case 10: 
      return "(Лето, Осень, Зима, Весна)";
    case 11: 
      return "Нет";
    case 12: 
      return "Нет";
    case 13: 
      return "(Лето, Осень, Зима, Весна)";
    case 14: 
      return "(Лето, Осень)";
    case 15: 
      return "(Лето, Осень, Зима, Весна)";
    case 16: 
      return "(Лето, Осень, Зима, Весна)";
    case 17: 
      return "(Осень)";
    case 18: 
      return "Нет";
    case 19: 
      return "(Лето, Осень, Зима, Весна)";
    case 20: 
      return "(Лето, Осень, Весна)";
    case 21: 
      return "(Лето, Осень, Зима, Весна)";
    case 22: 
      return "(Лето, Осень, Зима, Весна)";
    case 23: 
      return "Нет";
    case 24: 
      return "(Лето)";
    case 25: 
      return "(Лето, Осень, Зима, Весна)";
    case 26: 
      return "(Лето)";
    case 27: 
      return "(Лето, Осень, Зима, Весна)";
    case 28: 
      return "(Осень, Зима)";
    case 29: 
      return "(Лето, Осень, Зима, Весна)";
    }
    return "(Лето, Осень, Зима, Весна)";
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\buildings\BuildingsOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */