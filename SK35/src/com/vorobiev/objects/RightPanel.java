package com.vorobiev.objects;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.vorobiev.data.Player;
import com.vorobiev.data.ResourceArray;
import com.vorobiev.sk.ButtonPlayListener;
import com.vorobiev.sk.ComputThread;
import com.vorobiev.sk.GameLayout;
import com.vorobiev.sk.MainActivity;

public class RightPanel
{
  public static long[] itog = new long[15];
  public static long summYearProfit;
  private MainActivity activity;
  public ImageButton btn_day;
  public ImageButton btn_mounth;
  public ImageButton btn_week;
  public MyDate date;
  private ImageView imageProfit;
  private final TextView[] numPlaceArray = new TextView[7];
  private TextView profit;
  private StringBuilder stringBuilder = new StringBuilder();
  private final long[] tempResources = new long[15];
  private final TextView[] textArray = new TextView[21];
  private TextView textImproved;
  private TextView textRansom;
  private final TextView[] yearResources = new TextView[15];
  
  public RightPanel(MainActivity paramMainActivity, MyDate paramMyDate)
  {
    this.activity = paramMainActivity;
    this.date = paramMyDate;
    paramMyDate = (LinearLayout)paramMainActivity.findViewById(2131361949);
    int i = 0;
    View localView;
    if (i >= ResourceArray.res_mark.length)
    {
      localView = new View(paramMainActivity);
      localView.setLayoutParams(paramMainActivity.findViewById(2131361947).getLayoutParams());
      localView.setBackgroundColor(-1);
      paramMyDate.addView(localView);
      i = 16;
    }
    for (;;)
    {
      if (i >= 21)
      {
        inflateGeneralPanel();
        inflateNumberPlace(paramMyDate);
        return;
        localView = paramMainActivity.getLayoutInflater().inflate(2130903050, paramMyDate, false);
        ImageView localImageView = (ImageView)localView.findViewById(2131361913);
        this.textArray[i] = ((TextView)localView.findViewById(2131361914));
        this.textArray[i].setText(String.valueOf(Player.getResourceValue(i)));
        setColorText(i);
        localImageView.setBackgroundResource(ResourceArray.res_mark[i]);
        paramMyDate.addView(localView);
        i += 1;
        break;
      }
      localView = paramMainActivity.getLayoutInflater().inflate(2130903059, paramMyDate, false);
      ((TextView)localView.findViewById(2131361950)).setText(Player.name[(i - 16)]);
      this.textArray[i] = ((TextView)localView.findViewById(2131361903));
      this.textArray[i].setText(String.valueOf(Player.getResourceValue(i)));
      paramMyDate.addView(localView);
      i += 1;
    }
  }
  
  private void inflateGeneralPanel()
  {
    inflateDate();
    this.btn_day = ((ImageButton)this.activity.findViewById(2131361943));
    GameLayout.compThread = new ComputThread(this);
    Object localObject = new ButtonPlayListener(GameLayout.compThread);
    this.btn_day.setId(1);
    this.btn_day.setOnClickListener((View.OnClickListener)localObject);
    this.btn_week = ((ImageButton)this.activity.findViewById(2131361944));
    this.btn_week.setId(2);
    this.btn_week.setOnClickListener((View.OnClickListener)localObject);
    this.btn_mounth = ((ImageButton)this.activity.findViewById(2131361945));
    this.btn_mounth.setId(3);
    this.btn_mounth.setOnClickListener((View.OnClickListener)localObject);
    localObject = (LinearLayout)this.activity.findViewById(2131361939);
    View localView = this.activity.getLayoutInflater().inflate(2130903050, (ViewGroup)localObject, false);
    ((ImageView)localView.findViewById(2131361913)).setBackgroundResource(2130837621);
    this.textArray[15] = ((TextView)localView.findViewById(2131361914));
    this.textArray[15].setText(String.valueOf(Player.getResourceValue(15)));
    this.textArray[15].setTextColor(65280);
    ((LinearLayout)localObject).addView(localView);
    localView = new View(this.activity);
    localView.setLayoutParams(this.activity.findViewById(2131361947).getLayoutParams());
    localView.setBackgroundColor(-1);
    ((LinearLayout)localObject).addView(localView);
  }
  
  @SuppressLint({"CutPasteId"})
  private void inflateNumberPlace(LinearLayout paramLinearLayout)
  {
    paramLinearLayout.addView(this.activity.getLayoutInflater().inflate(2130903054, paramLinearLayout, false));
    inflateRansomImproved(paramLinearLayout);
    int i = 0;
    View localView;
    if (i >= 7)
    {
      localView = this.activity.getLayoutInflater().inflate(2130903054, paramLinearLayout, false);
      ((TextView)localView.findViewById(2131361969)).setText("Итог в год");
      paramLinearLayout.addView(localView);
      i = 0;
      if (i < 15) {
        break label326;
      }
      localView = this.activity.getLayoutInflater().inflate(2130903054, paramLinearLayout, false);
      ((TextView)localView.findViewById(2131361969)).setText("Прибыль в год");
      paramLinearLayout.addView(localView);
      localView = this.activity.getLayoutInflater().inflate(2130903050, paramLinearLayout, false);
      this.profit = ((TextView)localView.findViewById(2131361914));
      this.imageProfit = ((ImageView)localView.findViewById(2131361913));
      summYearProfit = 0L;
      i = 0;
      if (i < itog.length) {
        break label481;
      }
      this.profit.setText(String.valueOf(summYearProfit));
      if (summYearProfit <= 0L) {
        break label539;
      }
      this.imageProfit.setBackgroundResource(2130837510);
      this.profit.setTextColor(-16711936);
    }
    for (;;)
    {
      paramLinearLayout.addView(localView);
      return;
      this.stringBuilder.setLength(0);
      localView = this.activity.getLayoutInflater().inflate(2130903059, paramLinearLayout, false);
      ((TextView)localView.findViewById(2131361950)).setText(Player.namePlace[i]);
      this.numPlaceArray[i] = ((TextView)localView.findViewById(2131361903));
      this.stringBuilder.append(Player.numberBusyPlace[i]);
      this.stringBuilder.append(" / ");
      this.stringBuilder.append(com.vorobiev.data.RandomResource.resource[i]);
      this.numPlaceArray[i].setText(this.stringBuilder.toString());
      paramLinearLayout.addView(localView);
      i += 1;
      break;
      label326:
      localView = this.activity.getLayoutInflater().inflate(2130903050, paramLinearLayout, false);
      ImageView localImageView = (ImageView)localView.findViewById(2131361913);
      this.yearResources[i] = ((TextView)localView.findViewById(2131361914));
      Player.summProfitResource[i] -= Player.summConsumptionResource[i];
      this.yearResources[i].setText(String.valueOf(itog[i]));
      if (itog[i] > 0L) {
        this.yearResources[i].setTextColor(-16711936);
      }
      for (;;)
      {
        localImageView.setBackgroundResource(ResourceArray.res_mark[i]);
        paramLinearLayout.addView(localView);
        i += 1;
        break;
        if (itog[i] < 0L) {
          this.yearResources[i].setTextColor(-65536);
        } else {
          this.yearResources[i].setTextColor(-7829368);
        }
      }
      label481:
      if (itog[i] > 0L) {}
      for (summYearProfit += itog[i] * Player.sellResource[i];; summYearProfit += itog[i] * Player.buyResource[i])
      {
        i += 1;
        break;
      }
      label539:
      if (summYearProfit < 0L)
      {
        this.imageProfit.setBackgroundResource(2130837508);
        this.profit.setTextColor(-65536);
      }
      else
      {
        this.imageProfit.setBackgroundResource(2130837509);
        this.profit.setTextColor(-7829368);
      }
    }
  }
  
  @SuppressLint({"CutPasteId"})
  private void inflateRansomImproved(LinearLayout paramLinearLayout)
  {
    View localView = this.activity.getLayoutInflater().inflate(2130903059, paramLinearLayout, false);
    ((TextView)localView.findViewById(2131361950)).setText("+");
    this.textImproved = ((TextView)localView.findViewById(2131361903));
    paramLinearLayout.addView(localView);
    localView = this.activity.getLayoutInflater().inflate(2130903059, paramLinearLayout, false);
    ((TextView)localView.findViewById(2131361950)).setText("$");
    this.textRansom = ((TextView)localView.findViewById(2131361903));
    paramLinearLayout.addView(localView);
    updateRansomImproved();
  }
  
  private void setColorText(int paramInt)
  {
    if (Player.resource[paramInt] > this.tempResources[paramInt]) {
      this.textArray[paramInt].setTextColor(-16711936);
    }
    for (;;)
    {
      this.tempResources[paramInt] = Player.resource[paramInt];
      return;
      if (Player.resource[paramInt] < this.tempResources[paramInt]) {
        this.textArray[paramInt].setTextColor(-65536);
      } else {
        this.textArray[paramInt].setTextColor(-7829368);
      }
    }
  }
  
  public void inflateDate()
  {
    TextView localTextView = (TextView)this.activity.findViewById(2131361941);
    localTextView.setTextColor(-1);
    localTextView.setText(this.date.getDate());
    localTextView = (TextView)this.activity.findViewById(2131361942);
    String str = this.date.getSeason();
    if (str == "Зима") {
      localTextView.setTextColor(-16776961);
    }
    for (;;)
    {
      localTextView.setText(this.date.getSeason());
      return;
      if (str == "Весна") {
        localTextView.setTextColor(-16711936);
      } else if (str == "Лето") {
        localTextView.setTextColor(65280);
      } else {
        localTextView.setTextColor(-65281);
      }
    }
  }
  
  public void update()
  {
    int i = 0;
    if (i >= 15) {
      i = 16;
    }
    for (;;)
    {
      if (i >= 21)
      {
        return;
        this.textArray[i].setText(String.valueOf(Player.getResourceValue(i)));
        setColorText(i);
        i += 1;
        break;
      }
      this.textArray[i].setText(String.valueOf(Player.getResourceValue(i)));
      i += 1;
    }
  }
  
  public void updateHomeAndPeople()
  {
    int i = 16;
    for (;;)
    {
      if (i >= 18) {
        return;
      }
      this.textArray[i].setText(String.valueOf(Player.getResourceValue(i)));
      i += 1;
    }
  }
  
  public void updateMoney()
  {
    if (Player.getResourceValue(15) == 0L) {
      this.textArray[15].setTextColor(-7829368);
    }
    for (;;)
    {
      this.textArray[15].setText(String.valueOf(Player.getResourceValue(15)));
      return;
      this.textArray[15].setTextColor(65280);
    }
  }
  
  public void updateProfitConsumption()
  {
    int i = 0;
    for (;;)
    {
      if (i >= 7)
      {
        i = 0;
        if (i < 15) {
          break;
        }
        summYearProfit = 0L;
        i = 0;
        if (i < itog.length) {
          break label236;
        }
        this.profit.setText(String.valueOf(summYearProfit));
        if (summYearProfit <= 0L) {
          break label294;
        }
        this.imageProfit.setBackgroundResource(2130837510);
        this.profit.setTextColor(-16711936);
        return;
      }
      this.stringBuilder.setLength(0);
      this.stringBuilder.append(Player.numberBusyPlace[i]);
      this.stringBuilder.append(" / ");
      this.stringBuilder.append(com.vorobiev.data.RandomResource.resource[i]);
      this.numPlaceArray[i].setText(this.stringBuilder.toString());
      i += 1;
    }
    Player.summProfitResource[i] -= Player.summConsumptionResource[i];
    this.yearResources[i].setText(String.valueOf(itog[i]));
    if (itog[i] > 0L) {
      this.yearResources[i].setTextColor(-16711936);
    }
    for (;;)
    {
      i += 1;
      break;
      if (itog[i] < 0L) {
        this.yearResources[i].setTextColor(-65536);
      } else {
        this.yearResources[i].setTextColor(-7829368);
      }
    }
    label236:
    if (itog[i] > 0L) {}
    for (summYearProfit += itog[i] * Player.sellResource[i];; summYearProfit += itog[i] * Player.buyResource[i])
    {
      i += 1;
      break;
    }
    label294:
    if (summYearProfit < 0L)
    {
      this.imageProfit.setBackgroundResource(2130837508);
      this.profit.setTextColor(-65536);
      return;
    }
    this.imageProfit.setBackgroundResource(2130837509);
    this.profit.setTextColor(-7829368);
  }
  
  public void updateRansomImproved()
  {
    this.textImproved.setText(String.valueOf(Player.improved) + " / " + String.valueOf(14406));
    this.textRansom.setText(String.valueOf(Player.ransom) + " / " + String.valueOf(14406));
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\objects\RightPanel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */