package com.vorobiev.objects;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.vorobiev.buildings.Build;
import com.vorobiev.buildings.Building;
import com.vorobiev.data.Player;
import com.vorobiev.data.RadarData;
import com.vorobiev.data.RandomResource;
import com.vorobiev.data.ResourceArray;
import com.vorobiev.gameInterface.Sound;
import com.vorobiev.gameclass.Assets;
import com.vorobiev.handler.MyHandlers;
import com.vorobiev.sk.ComputThread;
import com.vorobiev.sk.GameLayout;
import com.vorobiev.sk.MainActivity;
import com.vorobiev.sk.MyTouchListener;
import com.vorobiev.sk.MyTouchListener.MyDownButtonAction;

public class CenterPanel
{
  RightPanel rightPanel;
  private TextView topString;
  
  public CenterPanel(MainActivity paramMainActivity, RightPanel paramRightPanel)
  {
    this.rightPanel = paramRightPanel;
    this.topString = ((TextView)paramMainActivity.findViewById(2131361919));
    inflateBuilderPanel(paramMainActivity);
  }
  
  private void buyBuilding(int paramInt)
  {
    int i = 0;
    int m = RandomResource.sizePick;
    int j = 0;
    if (j >= RandomResource.map.length)
    {
      label17:
      if (i == 0) {
        break label157;
      }
      MainActivity.myHandlers.send(304);
      Assets.build.play(1.0F);
    }
    for (;;)
    {
      this.rightPanel.updateProfitConsumption();
      this.rightPanel.updateMoney();
      return;
      MapPlace localMapPlace = RandomResource.map[j];
      Build localBuild = localMapPlace.isBuilding;
      int k = i;
      if (localMapPlace.isPickOut)
      {
        k = i;
        if (localBuild == null)
        {
          int n = checkEarth(paramInt, localMapPlace, j);
          k = i;
          if (n != 0)
          {
            k = 1;
            i = 1;
            Player.summBuildings += 1;
            RadarData.drawBuilding(j, n);
            if (m == 1)
            {
              RandomResource.singlePick(j);
              inflateTopString(RandomResource.stringBuilder.toString());
              break label17;
            }
          }
        }
      }
      j += 1;
      i = k;
      break;
      label157:
      Assets.no.play(1.0F);
    }
  }
  
  private int checkEarth(int paramInt1, MapPlace paramMapPlace, int paramInt2)
  {
    Object localObject = MapPlace.allowed[paramMapPlace.type];
    int i;
    if (Player.resource[15] >= com.vorobiev.buildings.BuildingsOptions.getOptions(paramInt1)[0]) {
      i = 0;
    }
    for (;;)
    {
      if (i >= localObject.length) {
        return 0;
      }
      if (localObject[i] == paramInt1)
      {
        localObject = Player.resource;
        localObject[15] -= com.vorobiev.buildings.BuildingsOptions.getOptions(paramInt1)[0];
        new Building(paramMapPlace, paramInt2, paramInt1);
        if (paramInt1 == 0) {
          return -65536;
        }
        localObject = Player.numberBusyPlace;
        paramInt1 = paramMapPlace.type;
        localObject[paramInt1] += 1;
        return -7829368;
      }
      i += 1;
    }
  }
  
  private void inflateBuilderPanel(MainActivity paramMainActivity)
  {
    final Object localObject1 = (FrameLayout)paramMainActivity.findViewById(2131361934);
    Object localObject2 = paramMainActivity.getLayoutInflater().inflate(2130903053, (ViewGroup)localObject1, false);
    ((FrameLayout)localObject1).addView((View)localObject2);
    localObject1 = new OnClickBuildingInfo((View)localObject2);
    ((Button)((View)localObject2).findViewById(2131361967)).setOnTouchListener(new MyTouchListener(2130837564, 2130837565, new MyTouchListener.MyDownButtonAction()
    {
      public void actionOnClick(View arg1)
      {
        if (GameLayout.compThread.isAlive()) {
          return;
        }
        synchronized (GameLayout.block)
        {
          CenterPanel.this.buyBuilding(localObject1.id);
          return;
        }
      }
    }));
    localObject2 = (LinearLayout)paramMainActivity.findViewById(2131361936);
    int j = ((LinearLayout)localObject2).getLayoutParams().width;
    int i = 0;
    for (;;)
    {
      if (i >= ResourceArray.res_build.length) {
        return;
      }
      ImageView localImageView = new ImageView(paramMainActivity);
      localImageView.setLayoutParams(new LinearLayout.LayoutParams(j, j));
      localImageView.setBackgroundResource(ResourceArray.res_build[i]);
      localImageView.setId(i);
      localImageView.setOnClickListener((View.OnClickListener)localObject1);
      ((LinearLayout)localObject2).addView(localImageView);
      i += 1;
    }
  }
  
  public void inflateTopString(String paramString)
  {
    this.topString.setText(paramString);
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\objects\CenterPanel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */