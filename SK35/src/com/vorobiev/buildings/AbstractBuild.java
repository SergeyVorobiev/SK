package com.vorobiev.buildings;

import com.vorobiev.data.Player;
import com.vorobiev.data.RadarData;
import com.vorobiev.objects.CityBounds;
import com.vorobiev.objects.MapPlace;
import com.vorobiev.objects.MyDate;
import com.vorobiev.sk.ComputThread;
import java.io.Serializable;

public abstract class AbstractBuild
  implements Build, Serializable
{
  private static final long serialVersionUID = 1L;
  protected boolean closing = false;
  protected int constructionTime;
  protected int[] consumption;
  protected long cost;
  protected long costLevelUp;
  protected int currentLife;
  protected boolean endResource = false;
  protected int finishWorkMounth;
  protected int home;
  protected int id;
  protected boolean isFire = false;
  protected boolean isNotPeople = false;
  protected boolean levelUp = false;
  protected int life;
  private final int numPlace;
  protected MapPlace place;
  private final int placeX;
  private final int placeY;
  protected int priceRecovery = 0;
  protected int[] profit;
  protected boolean ransom = false;
  protected float serviceOneDay;
  protected int startWorkMounth;
  protected boolean wintering = false;
  protected int worker;
  protected int workingDay;
  protected int workingDayLeep;
  
  public AbstractBuild(MapPlace paramMapPlace, int paramInt)
  {
    this.numPlace = paramInt;
    this.ransom = paramMapPlace.isBuy;
    paramMapPlace.isBuilding = this;
    this.place = paramMapPlace;
    this.placeY = (paramInt / 147);
    this.placeX = (paramInt - this.placeY * 147);
  }
  
  public AbstractBuild(MapPlace paramMapPlace, int paramInt1, int paramInt2)
  {
    this(paramMapPlace, paramInt1);
    if (paramInt2 == 1) {
      this.constructionTime = 0;
    }
  }
  
  private boolean validFire()
  {
    if (this.currentLife == 0)
    {
      this.place.isBuilding = null;
      RadarData.drawBuilding(this.numPlace, RadarData.Yellow);
      return false;
    }
    if (this.currentLife < 100)
    {
      this.isFire = true;
      RadarData.drawBuilding(this.numPlace, -65536);
    }
    for (;;)
    {
      return true;
      this.isFire = false;
    }
  }
  
  public int Repair()
  {
    if (this.id == 0) {
      return 1;
    }
    if (Player.resource[15] >= this.priceRecovery)
    {
      long[] arrayOfLong = Player.resource;
      arrayOfLong[15] -= this.priceRecovery;
      this.currentLife = this.life;
      this.isFire = false;
    }
    for (int i = 1;; i = 2)
    {
      this.priceRecovery = ((int)((this.life - this.currentLife) * this.serviceOneDay));
      return i;
      i = (int)((float)Player.resource[15] / this.serviceOneDay);
      Player.resource[15] = 0L;
      this.currentLife += i;
      if (this.currentLife >= 100) {
        this.isFire = false;
      }
    }
  }
  
  public boolean endResource()
  {
    return this.endResource;
  }
  
  public boolean getClose()
  {
    return this.closing;
  }
  
  public int getConstructionTime()
  {
    return this.constructionTime;
  }
  
  public int[] getConsumption()
  {
    return this.consumption;
  }
  
  public long getCost()
  {
    if (this.levelUp) {
      return this.costLevelUp;
    }
    return this.cost;
  }
  
  public int getCurrentLife()
  {
    return this.currentLife;
  }
  
  public int getHome()
  {
    return this.home;
  }
  
  public int getId()
  {
    try
    {
      int i = this.id;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean getLevelUp()
  {
    return this.levelUp;
  }
  
  public int getMaxLife()
  {
    return this.life;
  }
  
  public int getPriceRecovery()
  {
    if (this.id == 0) {
      return 0;
    }
    return this.priceRecovery;
  }
  
  public int[] getProfit()
  {
    return this.profit;
  }
  
  public boolean getWintering()
  {
    return this.wintering;
  }
  
  public int getWorkingDay(boolean paramBoolean)
  {
    if (this.home > 0) {
      return 0;
    }
    if (paramBoolean) {
      return this.workingDayLeep;
    }
    return this.workingDay;
  }
  
  public void improved()
  {
    if (this.constructionTime > 1) {
      this.constructionTime /= 2;
    }
    if (this.id == 0) {
      return;
    }
    this.life = ((int)(this.life * 1.5F));
    this.currentLife = ((int)(this.currentLife * 1.5F));
    this.serviceOneDay /= 1.5F;
  }
  
  public boolean isFire()
  {
    return this.isFire;
  }
  
  public boolean isRansom()
  {
    return this.ransom;
  }
  
  public boolean notPeople()
  {
    return this.isNotPeople;
  }
  
  public int setClose()
  {
    if (this.home > 0) {
      return 0;
    }
    if (this.constructionTime > 0) {
      return 1;
    }
    boolean bool;
    if (this.closing)
    {
      bool = false;
      this.closing = bool;
      if (!this.closing) {
        break label61;
      }
      this.isNotPeople = false;
      this.endResource = false;
      this.isFire = false;
    }
    for (;;)
    {
      return 2;
      bool = true;
      break;
      label61:
      if (this.currentLife < 100) {
        this.isFire = true;
      }
    }
  }
  
  public int setLevelUp()
  {
    if (this.id == 0) {}
    while (this.levelUp) {
      return 1;
    }
    if (this.constructionTime != 0) {
      return 2;
    }
    if (this.closing) {
      return 3;
    }
    if (this.currentLife != this.life) {
      return 4;
    }
    if (Player.resource[15] < this.costLevelUp) {
      return 5;
    }
    Object localObject = Player.resource;
    localObject[15] -= this.costLevelUp;
    this.levelUp = true;
    int i = 0;
    for (;;)
    {
      if (i >= this.profit.length)
      {
        this.worker *= 10;
        i = this.home;
        this.home *= 10;
        localObject = Player.resource;
        localObject[17] += this.home - i;
        return 6;
      }
      localObject = this.consumption;
      localObject[i] *= 10;
      localObject = this.profit;
      localObject[i] *= 10;
      i += 1;
    }
  }
  
  public void setRansom()
  {
    this.ransom = true;
  }
  
  public boolean workDay(MyDate paramMyDate1, MyDate paramMyDate2)
  {
    if (this.constructionTime > 0)
    {
      this.constructionTime -= 1;
      if ((this.constructionTime == 0) && (this.home > 0))
      {
        paramMyDate1 = Player.resource;
        paramMyDate1[17] += this.home;
        if (this.id == 0) {
          CityBounds.setLive(this.numPlace);
        }
      }
    }
    do
    {
      return true;
      if (this.home <= 0) {
        break;
      }
    } while (this.id == 0);
    this.currentLife -= 1;
    this.priceRecovery = ((int)((this.life - this.currentLife) * this.serviceOneDay));
    return validFire();
    int j;
    int i;
    if (this.id != 28) {
      if ((paramMyDate2.getIntMounth() > this.finishWorkMounth) || (paramMyDate2.getIntMounth() < this.startWorkMounth))
      {
        this.wintering = true;
        this.isNotPeople = false;
        this.endResource = false;
        if (!this.closing)
        {
          this.currentLife -= 1;
          this.priceRecovery = ((int)((this.life - this.currentLife) * this.serviceOneDay));
          j = 0;
          if ((paramMyDate1.getIntMounth() < this.startWorkMounth) || (paramMyDate1.getIntMounth() > this.finishWorkMounth) || (this.id == 28)) {
            break label394;
          }
          i = 1;
          label234:
          if (i != 0)
          {
            paramMyDate1 = Player.resource;
            paramMyDate1[19] += this.worker;
            this.endResource = false;
            i = 0;
            label263:
            if (i < this.consumption.length) {
              break label436;
            }
            label272:
            if (!this.endResource)
            {
              if (Player.resource[18] + this.worker > paramMyDate1[16]) {
                break label538;
              }
              paramMyDate2 = Player.resource;
              paramMyDate2[18] += this.worker;
              this.isNotPeople = false;
              i = 0;
              label324:
              if (i < this.profit.length) {
                break label465;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      return validFire();
      this.wintering = false;
      break;
      if ((paramMyDate2.getIntMounth() >= this.startWorkMounth) || (paramMyDate2.getIntMounth() <= this.finishWorkMounth))
      {
        this.wintering = false;
        break;
      }
      this.wintering = true;
      this.isNotPeople = false;
      this.endResource = false;
      break;
      label394:
      if (paramMyDate1.getIntMounth() < this.startWorkMounth)
      {
        i = j;
        if (paramMyDate1.getIntMounth() > this.finishWorkMounth) {
          break label234;
        }
      }
      i = j;
      if (this.id != 28) {
        break label234;
      }
      i = 1;
      break label234;
      label436:
      if (paramMyDate1[i] < this.consumption[i])
      {
        this.endResource = true;
        break label272;
      }
      i += 1;
      break label263;
      label465:
      ComputThread.tempScore += this.profit[i] * Player.sellResource[i];
      paramMyDate2 = Player.summResourceProfit;
      paramMyDate2[i] += this.profit[i];
      paramMyDate1[i] += this.profit[i];
      paramMyDate1[i] -= this.consumption[i];
      i += 1;
      break label324;
      label538:
      this.isNotPeople = true;
    }
  }
  
  public int worldCoordX()
  {
    return this.placeX;
  }
  
  public int worldCoordY()
  {
    return this.placeY;
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\buildings\AbstractBuild.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */