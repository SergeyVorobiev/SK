package com.vorobiev.buildings;

import com.vorobiev.objects.MyDate;

public abstract interface Build
{
  public static final String[] nameBuild = { "Город", "Ферма", "Сад", "Водоканал", "Лесопилка", "Шахта", "Карьер", "Нефтедобыча", "Золотой прииск", "Электростанция", "Гидростанция", "Хижина", "Жилой дом", "Рыбный промысел", "Угольный разрез", "Охотничьи угодья", "Животноводство", "Грибная плантация", "Жилой район", "Хозяйство", "Пасека", "Факел", "Теплица", "Жилой центр", "Лесоповал", "Водокачка", "Нефтенасос", "Катакомбы", "Ветряная станция", "Малая АЭС", "АЭС" };
  
  public abstract int Repair();
  
  public abstract boolean endResource();
  
  public abstract boolean getClose();
  
  public abstract int getConstructionTime();
  
  public abstract int[] getConsumption();
  
  public abstract long getCost();
  
  public abstract int getCurrentLife();
  
  public abstract int getHome();
  
  public abstract int getId();
  
  public abstract boolean getLevelUp();
  
  public abstract int getMaxLife();
  
  public abstract int getPriceRecovery();
  
  public abstract int[] getProfit();
  
  public abstract boolean getWintering();
  
  public abstract int getWorkingDay(boolean paramBoolean);
  
  public abstract void improved();
  
  public abstract boolean isFire();
  
  public abstract boolean isRansom();
  
  public abstract boolean notPeople();
  
  public abstract int setClose();
  
  public abstract int setLevelUp();
  
  public abstract void setRansom();
  
  public abstract boolean workDay(MyDate paramMyDate1, MyDate paramMyDate2);
  
  public abstract int worldCoordX();
  
  public abstract int worldCoordY();
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\buildings\Build.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */