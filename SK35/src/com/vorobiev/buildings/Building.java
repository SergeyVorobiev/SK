package com.vorobiev.buildings;

import com.vorobiev.objects.MapPlace;

public class Building
  extends AbstractBuild
{
  private static final long serialVersionUID = 1L;
  
  public Building(MapPlace paramMapPlace, int paramInt1, int paramInt2)
  {
    super(paramMapPlace, paramInt1);
    this.constructionTime = BuildingsOptions.getOptions(paramInt2)[1];
    this.id = paramInt2;
    initial();
    if (paramMapPlace.isImproved) {
      improved();
    }
  }
  
  public Building(MapPlace paramMapPlace, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramMapPlace, paramInt1, paramInt3);
    this.id = paramInt2;
    initial();
    if (paramMapPlace.isImproved) {
      improved();
    }
  }
  
  private void initial()
  {
    int[] arrayOfInt = BuildingsOptions.getOptions(this.id);
    this.cost = arrayOfInt[0];
    this.costLevelUp = (arrayOfInt[0] * 30L);
    this.life = arrayOfInt[2];
    this.currentLife = arrayOfInt[2];
    this.worker = arrayOfInt[3];
    this.startWorkMounth = arrayOfInt[5];
    this.finishWorkMounth = arrayOfInt[6];
    this.workingDay = arrayOfInt[7];
    this.workingDayLeep = arrayOfInt[8];
    this.home = arrayOfInt[4];
    this.consumption = BuildingsOptions.getConsumption(this.id);
    this.profit = BuildingsOptions.getProfit(this.id);
    this.serviceOneDay = BuildingsOptions.getServiceOneDay(this.id);
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\buildings\Building.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */