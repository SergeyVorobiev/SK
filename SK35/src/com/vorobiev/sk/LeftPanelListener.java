package com.vorobiev.sk;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.vorobiev.buildings.Build;
import com.vorobiev.data.Player;
import com.vorobiev.data.RadarData;
import com.vorobiev.data.RandomResource;
import com.vorobiev.gameInterface.Sound;
import com.vorobiev.gameclass.Assets;
import com.vorobiev.glInstruments.Camera2D;
import com.vorobiev.glInstruments.JoltOfCamera;
import com.vorobiev.glInstruments.ZeoVector;
import com.vorobiev.handler.MyHandlers;
import com.vorobiev.myDialogs.DialogBank;
import com.vorobiev.myDialogs.DialogDestroy;
import com.vorobiev.myDialogs.DialogSlave;
import com.vorobiev.objects.CenterPanel;
import com.vorobiev.objects.MapPlace;
import com.vorobiev.objects.RightPanel;
import com.vorobiev.objects.ViewRadar;

public class LeftPanelListener
  implements MyTouchListListener.MyDownButtonAction
{
  private MainActivity activity;
  private Camera2D camera;
  
  public LeftPanelListener(MainActivity paramMainActivity)
  {
    this.activity = paramMainActivity;
  }
  
  private void allPick()
  {
    Assets.clickThree.play(1.0F);
    int j = 0;
    RandomResource.RecoverySizePick = 0L;
    int i = 0;
    if (i >= 14406)
    {
      RandomResource.sizePick = 0;
      i = 0;
    }
    int k;
    for (;;)
    {
      if (i >= 98)
      {
        RandomResource.multiplePick();
        GameLayout.centerPanel.inflateTopString(RandomResource.stringBuilder.toString());
        return;
        RandomResource.map[i].isPickOut = false;
        i += 1;
        break;
      }
      k = 0;
      if (k < 147) {
        break label84;
      }
      i += 1;
    }
    label84:
    int m = 0;
    for (;;)
    {
      if (m >= 6)
      {
        j += 1;
        k += 1;
        break;
      }
      int[] arrayOfInt = com.vorobiev.objects.CityBounds.placeCityCoords[m];
      if ((arrayOfInt[0] == 1) && (arrayOfInt[3] <= k) && (arrayOfInt[4] >= k) && (arrayOfInt[6] <= i) && (arrayOfInt[5] >= i))
      {
        RandomResource.sizePick += 1;
        RandomResource.map[j].isPickOut = true;
        if (RandomResource.map[j].isBuilding != null) {
          RandomResource.RecoverySizePick += RandomResource.map[j].isBuilding.getPriceRecovery();
        }
      }
      m += 1;
    }
  }
  
  private void bank()
  {
    Assets.sound_dialog2.play(0.5F);
    this.activity.gameLayout.dialogBank.show();
  }
  
  private void birthRate()
  {
    Assets.sound_dialog2.play(0.5F);
    this.activity.gameLayout.dialogSlave.show();
  }
  
  private void buyPlace()
  {
    int i = 0;
    int m = 0;
    MapPlace[] arrayOfMapPlace = RandomResource.map;
    int n = arrayOfMapPlace.length;
    int j = 0;
    for (;;)
    {
      if (j >= n) {}
      for (j = m;; j = 1)
      {
        if (i == 0) {
          break label187;
        }
        Assets.ransom_sound.play(1.0F);
        GameLayout.rightPanel.updateRansomImproved();
        if (RandomResource.sizePick == 1)
        {
          RandomResource.singlePick(RandomResource.firstPick);
          GameLayout.centerPanel.inflateTopString(RandomResource.stringBuilder.toString());
        }
        GameLayout.rightPanel.updateMoney();
        return;
        k = i;
        if (!arrayOfMapPlace[j].isPickOut) {
          break label178;
        }
        k = i;
        if (arrayOfMapPlace[j].isBuy) {
          break label178;
        }
        if (Player.resource[15] >= 50000L) {
          break;
        }
      }
      long[] arrayOfLong = Player.resource;
      arrayOfLong[15] -= 50000L;
      Player.ransom += 1;
      if (arrayOfMapPlace[j].isBuilding != null) {
        arrayOfMapPlace[j].isBuilding.setRansom();
      }
      arrayOfMapPlace[j].isBuy = true;
      int k = 1;
      label178:
      j += 1;
      i = k;
    }
    label187:
    Assets.no3.play(1.0F);
    if (j != 0)
    {
      Toast.makeText(this.activity, "Недостаточно средств", 0).show();
      return;
    }
    Toast.makeText(this.activity, "Нет земли для покупки", 0).show();
  }
  
  private void buyResource()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.activity, ActivityBuyResource.class);
    this.activity.startActivityForResult(localIntent, 201);
    MainActivity.mainActive = false;
  }
  
  private void close()
  {
    int k = 0;
    int j = 0;
    MapPlace[] arrayOfMapPlace = RandomResource.map;
    int i1 = arrayOfMapPlace.length;
    int i = 0;
    boolean bool;
    if (i >= i1)
    {
      if (k != 0)
      {
        Assets.close.play(1.0F);
        bool = RandomResource.isLeep;
        i = 0;
      }
    }
    else
    {
      for (;;)
      {
        if (i >= 15)
        {
          i = 0;
          if (i < arrayOfMapPlace.length) {
            break label177;
          }
          GameLayout.rightPanel.updateProfitConsumption();
          return;
          localBuild = arrayOfMapPlace[i].isBuilding;
          int m = k;
          int n = j;
          if (localBuild != null)
          {
            if (arrayOfMapPlace[i].isPickOut) {
              break label113;
            }
            n = j;
            m = k;
          }
          for (;;)
          {
            i += 1;
            k = m;
            j = n;
            break;
            label113:
            int i2 = localBuild.setClose();
            if (i2 == 1)
            {
              n = 1;
              m = k;
            }
            else
            {
              m = k;
              n = j;
              if (i2 == 2)
              {
                m = 1;
                n = j;
              }
            }
          }
        }
        Player.summConsumptionResource[i] = 0L;
        Player.summProfitResource[i] = 0L;
        i += 1;
      }
      label177:
      Build localBuild = arrayOfMapPlace[i].isBuilding;
      if ((localBuild == null) || (localBuild.getConstructionTime() != 0) || (localBuild.getClose())) {}
      for (;;)
      {
        i += 1;
        break;
        j = 0;
        while (j < 15)
        {
          long[] arrayOfLong = Player.summConsumptionResource;
          arrayOfLong[j] += localBuild.getConsumption()[j] * localBuild.getWorkingDay(bool);
          arrayOfLong = Player.summProfitResource;
          arrayOfLong[j] += localBuild.getProfit()[j] * localBuild.getWorkingDay(bool);
          j += 1;
        }
      }
    }
    Assets.no3.play(1.0F);
    if (j != 0)
    {
      Toast.makeText(this.activity, "Нельзя закрыть строящиеся объекты", 0).show();
      return;
    }
    Toast.makeText(this.activity, "Закрывать нечего", 0).show();
  }
  
  private void destroy()
  {
    RandomResource.returnMoneyBuildings = 0L;
    MapPlace[] arrayOfMapPlace = RandomResource.map;
    int j = arrayOfMapPlace.length;
    int i = 0;
    for (;;)
    {
      if (i >= j)
      {
        if (RandomResource.returnMoneyBuildings != 0L) {
          break;
        }
        Assets.no3.play(1.0F);
        Toast.makeText(this.activity, "Нет строений для разрушения", 0).show();
        return;
      }
      Build localBuild = arrayOfMapPlace[i].isBuilding;
      if ((arrayOfMapPlace[i].isPickOut) && (localBuild != null) && (localBuild.getCurrentLife() != -1)) {
        RandomResource.returnMoneyBuildings += localBuild.getCost() / 10L;
      }
      i += 1;
    }
    Assets.sound_dialog2.play(0.5F);
    this.activity.gameLayout.dialogDestroy.show();
  }
  
  private void findWeakBuilding()
  {
    int j = 25000;
    int m = 1000000;
    MapPlace[] arrayOfMapPlace = RandomResource.map;
    int i1 = arrayOfMapPlace.length;
    int i = 0;
    if (i >= i1)
    {
      if (j == 25000)
      {
        Toast.makeText(this.activity, "Нет сломанных строений", 0).show();
        Assets.no3.play(1.0F);
      }
    }
    else
    {
      Build localBuild = arrayOfMapPlace[i].isBuilding;
      int k = m;
      int n = j;
      if (localBuild != null)
      {
        k = m;
        n = j;
        if (localBuild.getCurrentLife() != localBuild.getMaxLife())
        {
          if (!localBuild.getClose()) {
            break label144;
          }
          n = j;
          k = m;
        }
      }
      for (;;)
      {
        i += 1;
        m = k;
        j = n;
        break;
        label144:
        k = m;
        n = j;
        if (m > localBuild.getCurrentLife())
        {
          k = localBuild.getCurrentLife();
          n = i;
        }
      }
    }
    if (this.camera == null)
    {
      Toast.makeText(this.activity, "Камера не активирована", 0).show();
      return;
    }
    Assets.chuh.play(1.0F);
    this.camera.setPositionOfIndex(j);
    RandomResource.RecoverySizePick = 0L;
    i = 0;
    for (;;)
    {
      if (i >= RandomResource.map.length)
      {
        RandomResource.map[j].isPickOut = true;
        RandomResource.RecoverySizePick += RandomResource.map[j].isBuilding.getPriceRecovery();
        RandomResource.singlePick(j);
        RandomResource.sizePick = 1;
        RandomResource.firstPick = j;
        GameLayout.centerPanel.inflateTopString(RandomResource.stringBuilder.toString());
        float f1 = this.camera.position.x;
        float f2 = RadarData.ratioRadarToWorldWidth;
        float f3 = this.camera.position.y;
        float f4 = RadarData.ratioRadarToWorldHeight;
        RadarData.positionX = f1 * f2;
        RadarData.positionY = RadarData.height - f3 * f4;
        GameLayout.radar.invalidate();
        return;
      }
      RandomResource.map[i].isPickOut = false;
      i += 1;
    }
  }
  
  private void improvedPlace()
  {
    int k = 0;
    int i = 0;
    MapPlace[] arrayOfMapPlace = RandomResource.map;
    int i1 = arrayOfMapPlace.length;
    int j = 0;
    if (j >= i1)
    {
      if (k != 0)
      {
        Assets.update.play(1.0F);
        GameLayout.rightPanel.updateRansomImproved();
        if (RandomResource.sizePick == 1)
        {
          RandomResource.singlePick(RandomResource.firstPick);
          GameLayout.centerPanel.inflateTopString(RandomResource.stringBuilder.toString());
        }
        GameLayout.rightPanel.updateMoney();
      }
    }
    else
    {
      int m = k;
      int n = i;
      if (arrayOfMapPlace[j].isPickOut)
      {
        m = k;
        n = i;
        if (!arrayOfMapPlace[j].isImproved)
        {
          if (Player.resource[15] >= arrayOfMapPlace[j].getCostImproved()) {
            break label142;
          }
          n = 1;
          m = k;
        }
      }
      for (;;)
      {
        j += 1;
        k = m;
        i = n;
        break;
        label142:
        long[] arrayOfLong = Player.resource;
        arrayOfLong[15] -= arrayOfMapPlace[j].getCostImproved();
        Player.improved += 1;
        arrayOfMapPlace[j].isImproved = true;
        k = 1;
        m = k;
        n = i;
        if (arrayOfMapPlace[j].isBuilding != null)
        {
          arrayOfMapPlace[j].isBuilding.improved();
          m = k;
          n = i;
        }
      }
    }
    Assets.no3.play(1.0F);
    if (i != 0)
    {
      Toast.makeText(this.activity, "Недостаточно средств", 0).show();
      return;
    }
    Toast.makeText(this.activity, "Нет земли для улучшения", 0).show();
  }
  
  private void levelUp()
  {
    int i = 0;
    int i1 = 0;
    int i2 = 0;
    int k = 0;
    int n = 0;
    int j = 0;
    MapPlace[] arrayOfMapPlace = RandomResource.map;
    int i9 = arrayOfMapPlace.length;
    int m = 0;
    boolean bool;
    if (m >= i9)
    {
      if (i != 0)
      {
        Assets.repair.play(1.0F);
        bool = RandomResource.isLeep;
        i = 0;
      }
    }
    else
    {
      for (;;)
      {
        if (i >= 15)
        {
          i = 0;
          if (i < arrayOfMapPlace.length) {
            break label471;
          }
          if (RandomResource.sizePick == 1)
          {
            RandomResource.singlePick(RandomResource.firstPick);
            GameLayout.centerPanel.inflateTopString(RandomResource.stringBuilder.toString());
          }
          GameLayout.rightPanel.updateMoney();
          GameLayout.rightPanel.updateProfitConsumption();
          GameLayout.rightPanel.updateHomeAndPeople();
          return;
          localBuild = arrayOfMapPlace[m].isBuilding;
          int i3 = i2;
          int i4 = i1;
          int i5 = n;
          int i6 = k;
          int i7 = j;
          int i8 = i;
          if (localBuild != null)
          {
            i3 = i2;
            i4 = i1;
            i5 = n;
            i6 = k;
            i7 = j;
            i8 = i;
            if (localBuild.getId() != 0)
            {
              i3 = i2;
              i4 = i1;
              i5 = n;
              i6 = k;
              i7 = j;
              i8 = i;
              if (arrayOfMapPlace[m].isPickOut) {
                switch (localBuild.setLevelUp())
                {
                default: 
                  i8 = i;
                  i7 = j;
                  i6 = k;
                  i5 = n;
                  i4 = i1;
                  i3 = i2;
                }
              }
            }
          }
          for (;;)
          {
            m += 1;
            i2 = i3;
            i1 = i4;
            n = i5;
            k = i6;
            j = i7;
            i = i8;
            break;
            i7 = 1;
            i3 = i2;
            i4 = i1;
            i5 = n;
            i6 = k;
            i8 = i;
            continue;
            i4 = 1;
            i3 = i2;
            i5 = n;
            i6 = k;
            i7 = j;
            i8 = i;
            continue;
            i3 = 1;
            i4 = i1;
            i5 = n;
            i6 = k;
            i7 = j;
            i8 = i;
            continue;
            i5 = 1;
            i3 = i2;
            i4 = i1;
            i6 = k;
            i7 = j;
            i8 = i;
            continue;
            i6 = 1;
            i3 = i2;
            i4 = i1;
            i5 = n;
            i7 = j;
            i8 = i;
            continue;
            i8 = 1;
            i3 = i2;
            i4 = i1;
            i5 = n;
            i6 = k;
            i7 = j;
          }
        }
        Player.summConsumptionResource[i] = 0L;
        Player.summProfitResource[i] = 0L;
        i += 1;
      }
      label471:
      Build localBuild = arrayOfMapPlace[i].isBuilding;
      if ((localBuild == null) || (localBuild.getConstructionTime() != 0) || (localBuild.getClose())) {}
      for (;;)
      {
        i += 1;
        break;
        j = 0;
        while (j < 15)
        {
          long[] arrayOfLong = Player.summConsumptionResource;
          arrayOfLong[j] += localBuild.getConsumption()[j] * localBuild.getWorkingDay(bool);
          arrayOfLong = Player.summProfitResource;
          arrayOfLong[j] += localBuild.getProfit()[j] * localBuild.getWorkingDay(bool);
          j += 1;
        }
      }
    }
    Assets.no3.play(1.0F);
    if (k != 0)
    {
      Toast.makeText(this.activity, "Недостаточно средств", 0).show();
      return;
    }
    if (n != 0)
    {
      Toast.makeText(this.activity, "Необходим полный ремонт", 0).show();
      return;
    }
    if (i2 != 0)
    {
      Toast.makeText(this.activity, "Нельзя улучшать закрытые строения", 0).show();
      return;
    }
    if (i1 != 0)
    {
      Toast.makeText(this.activity, "Нельзя улучшать на стадии строительства", 0).show();
      return;
    }
    if (j != 0)
    {
      Toast.makeText(this.activity, "Выбранные строения уже улучшены", 0).show();
      return;
    }
    Toast.makeText(this.activity, "Нет строений для улучшения", 0).show();
  }
  
  private void repairBuilding()
  {
    int j = 0;
    int i = 0;
    int i2 = 0;
    RandomResource.RecoverySizePick = 0L;
    MapPlace[] arrayOfMapPlace = RandomResource.map;
    int i3 = arrayOfMapPlace.length;
    int k = 0;
    if (k >= i3)
    {
      if (i2 == 0)
      {
        Toast.makeText(this.activity, "Нет сломанных строений", 0).show();
        Assets.no3.play(1.0F);
      }
    }
    else
    {
      Build localBuild = arrayOfMapPlace[k].isBuilding;
      int m = i2;
      int n = j;
      int i1 = i;
      if (arrayOfMapPlace[k].isPickOut)
      {
        m = i2;
        n = j;
        i1 = i;
        if (localBuild != null)
        {
          m = i2;
          n = j;
          i1 = i;
          if (localBuild.getCurrentLife() != localBuild.getMaxLife())
          {
            m = 1;
            if (Player.resource[15] != 0L) {
              break label181;
            }
            RandomResource.RecoverySizePick += localBuild.getPriceRecovery();
            i1 = i;
            n = j;
          }
        }
      }
      for (;;)
      {
        k += 1;
        i2 = m;
        j = n;
        i = i1;
        break;
        label181:
        n = localBuild.Repair();
        if (arrayOfMapPlace[k].isBuilding.getCurrentLife() >= 100) {
          RadarData.drawBuilding(k, -7829368);
        }
        if (n == 1) {
          j = 1;
        }
        if (n == 2)
        {
          j = 1;
          i = 1;
        }
        RandomResource.RecoverySizePick += localBuild.getPriceRecovery();
        n = j;
        i1 = i;
      }
    }
    if (j != 0)
    {
      Assets.repair.play(1.0F);
      if (i != 0) {
        Toast.makeText(this.activity, "Недостаточно средств для полного восстановления", 0).show();
      }
      if (RandomResource.sizePick == 1) {
        RandomResource.singlePick(RandomResource.firstPick);
      }
      for (;;)
      {
        GameLayout.rightPanel.updateMoney();
        GameLayout.centerPanel.inflateTopString(RandomResource.stringBuilder.toString());
        MainActivity.myHandlers.send(304);
        return;
        RandomResource.multiplePick();
      }
    }
    Assets.no3.play(1.0F);
    Toast.makeText(this.activity, "Нет средств", 0).show();
  }
  
  private void sellResource()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.activity, ActivitySellResource.class);
    this.activity.startActivityForResult(localIntent, 202);
    MainActivity.mainActive = false;
  }
  
  private void setInfo()
  {
    if (Player.info) {}
    for (boolean bool = false;; bool = true)
    {
      Player.info = bool;
      if (!Player.info) {
        break;
      }
      GameLayout.textScore.setText("Очки: " + String.valueOf(Player.resource[21]));
      GameLayout.textScore.setVisibility(0);
      GameLayout.textGL.setVisibility(0);
      GameLayout.textFPS.setVisibility(0);
      return;
    }
    GameLayout.textScore.setVisibility(4);
    GameLayout.textGL.setVisibility(4);
    GameLayout.textFPS.setVisibility(4);
  }
  
  private void tableCost()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.activity, ActivityTableCost.class);
    this.activity.startActivityForResult(localIntent, 203);
    MainActivity.mainActive = false;
  }
  
  public static void updateTax()
  {
    GameLayout.rightPanel.updateMoney();
    GameLayout.rightPanel.update();
  }
  
  public void actionOnClick(View paramView)
  {
    if (GameLayout.compThread.isAlive()) {
      return;
    }
    for (;;)
    {
      synchronized (GameLayout.block)
      {
        switch (paramView.getId())
        {
        case 0: 
          return;
        }
      }
      findWeakBuilding();
      return;
      repairBuilding();
      return;
      levelUp();
      return;
      close();
      return;
      destroy();
      return;
      improvedPlace();
      return;
      buyPlace();
      return;
      buyResource();
      return;
      sellResource();
      return;
      bank();
      return;
      tableCost();
      return;
      birthRate();
      return;
      allPick();
      continue;
      setInfo();
      return;
    }
  }
  
  public void cameraActivated(Camera2D paramCamera2D)
  {
    this.camera = paramCamera2D;
  }
  
  public void destroying()
  {
    Object localObject1 = GameLayout.block;
    int i = 0;
    for (;;)
    {
      try
      {
        Object localObject2;
        if (i >= Player.numberBuildings.length)
        {
          i = 0;
          break label500;
          if (i >= 15)
          {
            localObject2 = RandomResource.map;
            int k = localObject2.length;
            i = 0;
            if (i < k) {
              continue;
            }
            if (RandomResource.sizePick != 1) {
              continue;
            }
            RandomResource.singlePick(RandomResource.firstPick);
            GameLayout.centerPanel.inflateTopString(RandomResource.stringBuilder.toString());
            localObject2 = Player.resource;
            localObject2[15] += RandomResource.returnMoneyBuildings;
            GameLayout.rightPanel.updateMoney();
            GameLayout.rightPanel.updateHomeAndPeople();
            GameLayout.rightPanel.updateProfitConsumption();
            GameScreen.joltCamera.activated();
            Assets.explosion.play(1.0F);
            MainActivity.myHandlers.send(304);
          }
        }
        else
        {
          Player.numberBuildings[i] = 0;
          i += 1;
          continue;
          Player.numberBusyPlace[i] = 0;
          i += 1;
          break label500;
        }
        Player.summConsumptionResource[i] = 0L;
        Player.summProfitResource[i] = 0L;
        i += 1;
        continue;
        Object localObject4 = localObject2[i].isBuilding;
        if ((localObject2[i].isPickOut) && (localObject4 != null) && (((Build)localObject4).getCurrentLife() != -1))
        {
          if (localObject2[i].isBuilding.getConstructionTime() == 0)
          {
            j = localObject2[i].isBuilding.getHome();
            localObject4 = Player.resource;
            localObject4[17] -= j;
            if (Player.resource[17] < Player.resource[16])
            {
              Player.resource[16] = Player.resource[17];
              Player.numPeople = (float)Player.resource[17];
            }
          }
          localObject2[i].isBuilding = null;
          RadarData.drawBuilding(i, RadarData.Yellow);
        }
        localObject4 = localObject2[i].isBuilding;
        if (localObject4 == null) {
          break label511;
        }
        Object localObject5 = Player.numberBusyPlace;
        int j = localObject2[i].type;
        localObject5[j] += 1;
        localObject5 = Player.numberBuildings;
        j = ((Build)localObject4).getId();
        localObject5[j] += 1;
        if (((Build)localObject4).getConstructionTime() != 0) {
          break label511;
        }
        RandomResource.RecoverySizePick = 0L;
        if (((Build)localObject4).getClose()) {
          break label511;
        }
        j = 0;
        if (j >= 15) {
          break label511;
        }
        localObject5 = Player.summConsumptionResource;
        localObject5[j] += localObject4.getConsumption()[j] * ((Build)localObject4).getWorkingDay(RandomResource.isLeep);
        localObject5 = Player.summProfitResource;
        localObject5[j] += localObject4.getProfit()[j] * ((Build)localObject4).getWorkingDay(RandomResource.isLeep);
        j += 1;
        continue;
        RandomResource.multiplePick();
        continue;
        if (i < 8) {
          continue;
        }
      }
      finally {}
      label500:
      i = 0;
      continue;
      label511:
      i += 1;
    }
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\sk\LeftPanelListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */