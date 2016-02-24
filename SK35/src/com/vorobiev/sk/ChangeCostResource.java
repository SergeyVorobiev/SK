package com.vorobiev.sk;

import com.vorobiev.data.Player;
import com.vorobiev.handler.MyHandlers;
import com.vorobiev.objects.MyDate;
import java.util.Random;

public class ChangeCostResource
{
  private static Random rnd = new Random();
  
  public static void update(MyDate paramMyDate)
  {
    int i = Player.GenerateSellOne();
    boolean bool = true;
    if ((i == -1) && (paramMyDate.getYear() == 1890)) {
      return;
    }
    int j = i;
    if (i == -1)
    {
      bool = false;
      j = Player.curNumResourceBuy;
    }
    i = 100;
    switch (j)
    {
    }
    for (;;)
    {
      Player.oldBuyResource[j] = Player.buyResource[j];
      Player.sellResource[j] += i;
      if (!bool)
      {
        Player.curNumResourceBuy += 1;
        if (Player.curNumResourceBuy > 14) {
          Player.curNumResourceBuy = 0;
        }
      }
      if (j == Player.curNumResourceBuy)
      {
        Player.curNumResourceBuy += 1;
        if (Player.curNumResourceBuy > 14) {
          Player.curNumResourceBuy = 0;
        }
      }
      validate(bool, j);
      return;
      i = rnd.nextInt(31) + 20;
      continue;
      i = 1;
      continue;
      i = rnd.nextInt(2) + 1;
      continue;
      i = rnd.nextInt(3) + 1;
      continue;
      i = rnd.nextInt(4) + 2;
      continue;
      i = rnd.nextInt(6) + 2;
      continue;
      i = rnd.nextInt(3) + 1;
      continue;
      i = rnd.nextInt(3) + 2;
      continue;
      i = rnd.nextInt(4) + 2;
    }
  }
  
  private static void validate(boolean paramBoolean, int paramInt)
  {
    int j = 100;
    int i;
    if (Player.buyResource[paramInt] < Player.nextSellResource[paramInt])
    {
      i = paramInt;
      if (i != 100) {
        MainActivity.myHandlers.send(311, i);
      }
      if (paramBoolean)
      {
        if (Player.priceResourceStok[paramInt] <= Player.sellResource[paramInt]) {
          break label94;
        }
        i = -1;
      }
    }
    for (;;)
    {
      MainActivity.myHandlers.send(312, i, paramInt);
      return;
      i = j;
      if (Player.nextSellResource[paramInt] <= Player.sellResource[paramInt]) {
        break;
      }
      i = j;
      if (!paramBoolean) {
        break;
      }
      i = paramInt + 15;
      break;
      label94:
      if (Player.priceResourceStok[paramInt] < Player.sellResource[paramInt]) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\sk\ChangeCostResource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */