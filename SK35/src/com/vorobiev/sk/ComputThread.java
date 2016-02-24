package com.vorobiev.sk;

import com.vorobiev.buildings.Build;
import com.vorobiev.data.Player;
import com.vorobiev.data.RandomResource;
import com.vorobiev.gameInterface.Sound;
import com.vorobiev.gameclass.Assets;
import com.vorobiev.glInstruments.JoltOfCamera;
import com.vorobiev.handler.MyHandlers;
import com.vorobiev.objects.MapPlace;
import com.vorobiev.objects.MyDate;
import com.vorobiev.objects.RightPanel;

public class ComputThread
  implements Runnable
{
  public static double tempScore;
  private MyDate currentDate = new MyDate(1, 1, 1);
  public int id = 0;
  private boolean isFire = false;
  private RightPanel panel;
  Thread thread;
  
  public ComputThread(RightPanel paramRightPanel)
  {
    this.panel = paramRightPanel;
  }
  
  private void destroyedActivate(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      GameScreen.joltCamera.activated();
      Assets.explosion.play(1.0F);
    }
  }
  
  private boolean validateDialog()
  {
    if (RandomResource.getCurrentTax() < Player.resource[20])
    {
      MainActivity.myHandlers.send(308);
      return true;
    }
    if (RandomResource.paymentTax)
    {
      MainActivity.myHandlers.send(309);
      return true;
    }
    if (RandomResource.paymentBigTax)
    {
      MainActivity.myHandlers.send(310);
      return true;
    }
    return false;
  }
  
  public boolean isAlive()
  {
    return (this.thread != null) && (this.thread.isAlive());
  }
  
  public void run()
  {
    for (;;)
    {
      int i;
      int j;
      int i1;
      int i2;
      int k;
      boolean bool2;
      boolean bool1;
      int m;
      synchronized (GameLayout.block)
      {
        if (validateDialog()) {
          return;
        }
        i = this.id;
        MainActivity.myHandlers.send(315, i);
        int n = -i;
        j = 0;
        i = 0;
        i1 = this.panel.date.getIntMounth();
        i2 = this.panel.date.getDaysInMounth(i1) - this.panel.date.getDay();
        if (i2 != 0) {
          break label1622;
        }
        this.id = 1;
        break label1622;
        Player.resource[19] = 0L;
        Player.resource[18] = 0L;
        this.currentDate.setDate(this.panel.date);
        this.panel.date.addDay();
        Object localObject2 = RandomResource.map;
        tempScore = 0.0D;
        k = 0;
        bool1 = bool2;
        if (k >= localObject2.length)
        {
          Player.score += tempScore / Player.scoreKoef;
          m = j + 1;
          Player.livedDays += 1;
          if ((this.panel.date.getDay() == 1) && (this.panel.date.getIntMounth() == 3)) {
            RandomResource.paymentTax = true;
          }
          j = 1;
          if (this.panel.date.getYear() > 1890) {
            j = this.panel.date.getYear() % 10;
          }
          if ((this.panel.date.getDay() == 1) && (this.panel.date.getIntMounth() == 10) && (j == 0)) {
            MainActivity.myHandlers.send(307, 5);
          }
          if ((this.panel.date.getDay() == 1) && (this.panel.date.getIntMounth() == 11) && (j == 0)) {
            RandomResource.paymentBigTax = true;
          }
          if ((this.panel.date.getDay() == 1) && (this.panel.date.getIntMounth() == 1))
          {
            k = (GameLayout.date.getYear() - 1891) / 10;
            j = k;
            if (k < 0) {
              j = 0;
            }
            Player.scoreKoef = (int)(Player.scoreKoef + RandomResource.generalTax[j] / 102400L);
          }
          if (this.panel.date.getDay() == 1)
          {
            float f2 = (float)Player.resource[20] * 0.07F;
            f1 = f2;
            if (f2 != 0.0F)
            {
              f1 = f2;
              if (f2 < 1.0F) {
                f1 = 1.0F;
              }
            }
            localObject2 = Player.resource;
            localObject2[20] = (((float)localObject2[20] + f1));
            if (f1 > 0.0F) {
              MainActivity.myHandlers.send(307, 3);
            }
          }
          if (this.panel.date.getDay() == 1) {
            ChangeCostResource.update(this.panel.date);
          }
          float f1 = Player.numPeople;
          if (Player.resource[16] <= 100000L) {
            Player.koefPeopleTwo = 1.0F;
          }
          if (Player.resource[16] > 100000L) {
            Player.koefPeopleTwo = 4.0F;
          }
          if (Player.resource[16] > 1000000L) {
            Player.koefPeopleTwo = 6.0F;
          }
          if (Player.resource[16] > 2000000L) {
            Player.koefPeopleTwo = 9.0F;
          }
          Player.numPeople += Player.numPeople * Player.multiplePeople / Player.koefPeopleTwo;
          Player.tempPeople += Player.numPeople - f1;
          if (Player.tempPeople > 1.0F)
          {
            j = (int)Player.tempPeople;
            Player.tempPeople -= j;
            localObject2 = Player.resource;
            localObject2[16] += j;
            if (Player.resource[16] > Player.resource[17])
            {
              Player.resource[16] = Player.resource[17];
              Player.numPeople = (float)Player.resource[17];
            }
          }
          if ((this.panel.date.getDay() == 20) && (this.panel.date.getIntMounth() == 5) && (this.panel.date.getYear() > 1890)) {
            MainActivity.myHandlers.send(307, 2);
          }
          if ((this.panel.date.getDay() == 20) && (this.panel.date.getIntMounth() == 6) && (this.panel.date.getYear() > 1890))
          {
            j = 0;
            Player.numPeople += 15.0F;
            if (Player.numPeople > (float)Player.resource[17])
            {
              Player.numPeople = (float)Player.resource[17];
              j = 1;
            }
            Player.resource[16] = (Player.numPeople);
            MainActivity.myHandlers.send(307, j);
          }
          if (this.id != 1) {
            break label1178;
          }
          MainActivity.myHandlers.send(315, n);
          destroyedActivate(bool1);
          localObject2 = RandomResource.map;
          RandomResource.RecoverySizePick = 0L;
          i = 0;
          if (i < localObject2.length) {
            break label1284;
          }
          Player.resource[21] = ((int)Player.score);
          i = 0;
          if (i < Player.numberBuildings.length) {
            break label1335;
          }
          i = 0;
          break label1628;
          label924:
          if (i < 15) {
            break label1361;
          }
          bool2 = this.panel.date.isLeep();
          RandomResource.isLeep = bool2;
          RandomResource.nextMounth = this.panel.date.getIntMounth();
          Player.resource[17] = 0L;
          i = 0;
          if (i < localObject2.length) {
            break label1380;
          }
          if (Player.resource[16] > Player.resource[17])
          {
            Player.resource[16] = Player.resource[17];
            Player.numPeople = (float)Player.resource[17];
          }
          if ((this.isFire) || (!bool1)) {
            MainActivity.myHandlers.send(304);
          }
          if (this.isFire)
          {
            this.isFire = false;
            MainActivity.myHandlers.send(307, 4);
          }
          MainActivity.myHandlers.send(305, 0);
          MainActivity.myHandlers.send(306);
          if (RandomResource.sizePick != 1) {
            break label1616;
          }
          RandomResource.singlePick(RandomResource.firstPick);
          label1089:
          MainActivity.myHandlers.send(303);
          return;
        }
      }
      Build localBuild = localObject3[k].isBuilding;
      if (localBuild != null) {
        if (bool1)
        {
          bool1 = localBuild.workDay(this.currentDate, this.panel.date);
        }
        else
        {
          localBuild.workDay(this.currentDate, this.panel.date);
          break label1639;
          label1178:
          k = i;
          if (this.id == 2)
          {
            k = i + 14;
            MainActivity.myHandlers.send(305, k);
            if ((validateDialog()) || (m == 7)) {
              continue;
            }
          }
          j = m;
          bool2 = bool1;
          i = k;
          if (this.id != 3) {
            continue;
          }
          i = k + 100 / i2;
          MainActivity.myHandlers.send(305, i);
          j = m;
          bool2 = bool1;
          if (i1 == this.panel.date.getIntMounth()) {
            continue;
          }
          continue;
          label1284:
          if ((localObject3[i].isBuilding == null) || (!localObject3[i].isBuilding.isFire()) || (localObject3[i].isBuilding.getClose())) {
            break label1648;
          }
          this.isFire = true;
          continue;
          label1335:
          Player.numberBuildings[i] = 0;
          i += 1;
          continue;
          label1361:
          label1380:
          label1616:
          label1622:
          label1628:
          do
          {
            Player.numberBusyPlace[i] = 0;
            i += 1;
            continue;
            Player.summConsumptionResource[i] = 0L;
            Player.summProfitResource[i] = 0L;
            i += 1;
            break label924;
            localBuild = localObject3[i].isBuilding;
            if (localBuild == null) {
              break label1655;
            }
            Object localObject4 = Player.numberBusyPlace;
            j = localObject3[i].type;
            localObject4[j] += 1;
            localObject4 = Player.numberBuildings;
            j = localBuild.getId();
            localObject4[j] += 1;
            if (localBuild.getConstructionTime() != 0) {
              break label1655;
            }
            localObject4 = Player.resource;
            localObject4[17] += localBuild.getHome();
            if (localObject3[i].isPickOut) {
              RandomResource.RecoverySizePick += localObject3[i].isBuilding.getPriceRecovery();
            }
            if (localBuild.getClose()) {
              break label1655;
            }
            j = 0;
            while (j < 15)
            {
              localObject4 = Player.summConsumptionResource;
              localObject4[j] += localBuild.getConsumption()[j] * localBuild.getWorkingDay(bool2);
              localObject4 = Player.summProfitResource;
              localObject4[j] += localBuild.getProfit()[j] * localBuild.getWorkingDay(bool2);
              j += 1;
            }
            RandomResource.multiplePick();
            break label1089;
            bool2 = true;
            break;
          } while (i < 8);
          i = 0;
          continue;
        }
      }
      label1639:
      k += 1;
      continue;
      label1648:
      i += 1;
      continue;
      label1655:
      i += 1;
    }
  }
  
  public void start(int paramInt)
  {
    this.id = paramInt;
    if (!isAlive())
    {
      this.thread = new Thread(this);
      this.thread.start();
    }
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\sk\ComputThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */