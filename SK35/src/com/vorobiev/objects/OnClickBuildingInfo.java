package com.vorobiev.objects;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.vorobiev.buildings.BuildingsOptions;

public class OnClickBuildingInfo
  implements View.OnClickListener
{
  private TextView[] arrExpense = new TextView[7];
  private TextView[] arrProfit = new TextView[2];
  private Button btn_buy;
  private boolean firstClick = true;
  public int id;
  private StringBuilder stringBuilder = new StringBuilder();
  private TextView text;
  private View vInfo;
  
  public OnClickBuildingInfo(View paramView)
  {
    this.vInfo = paramView;
    this.arrExpense[0] = ((TextView)paramView.findViewById(2131361959));
    this.arrExpense[1] = ((TextView)paramView.findViewById(2131361961));
    this.arrExpense[2] = ((TextView)paramView.findViewById(2131361962));
    this.arrExpense[3] = ((TextView)paramView.findViewById(2131361963));
    this.arrExpense[4] = ((TextView)paramView.findViewById(2131361964));
    this.arrExpense[5] = ((TextView)paramView.findViewById(2131361965));
    this.arrExpense[6] = ((TextView)paramView.findViewById(2131361966));
    this.arrProfit[0] = ((TextView)paramView.findViewById(2131361957));
    this.arrProfit[1] = ((TextView)paramView.findViewById(2131361958));
    this.btn_buy = ((Button)paramView.findViewById(2131361967));
  }
  
  public void onClick(View paramView)
  {
    if (this.firstClick)
    {
      this.btn_buy.setVisibility(0);
      this.firstClick = false;
    }
    this.id = paramView.getId();
    paramView = BuildingsOptions.getOptions(this.id);
    this.stringBuilder.setLength(0);
    this.stringBuilder.append(BuildingsOptions.getName(this.id));
    this.stringBuilder.append(" - Cтоимость: ");
    this.stringBuilder.append(paramView[0]);
    this.text = ((TextView)this.vInfo.findViewById(2131361950));
    this.text.setText(this.stringBuilder.toString());
    this.stringBuilder.setLength(0);
    this.stringBuilder.append("Строится ");
    this.stringBuilder.append(BuildingsOptions.getStringPlace(this.id));
    this.stringBuilder.append(" ");
    this.stringBuilder.append(paramView[1]);
    this.stringBuilder.append(" дн.");
    this.text = ((TextView)this.vInfo.findViewById(2131361952));
    this.text.setText(this.stringBuilder.toString());
    this.stringBuilder.setLength(0);
    this.stringBuilder.append("Прослужит ");
    int j = paramView[2];
    int i;
    if (j == -1)
    {
      this.stringBuilder.append("вечно");
      this.text = ((TextView)this.vInfo.findViewById(2131361953));
      this.text.setText(this.stringBuilder);
      this.stringBuilder.setLength(0);
      this.stringBuilder.append("Работает - ");
      this.stringBuilder.append(BuildingsOptions.getStringWorking(this.id));
      this.text = ((TextView)this.vInfo.findViewById(2131361951));
      this.text.setText(this.stringBuilder.toString());
      this.stringBuilder.setLength(0);
      this.stringBuilder.append("Рабочих - ");
      i = paramView[3];
      if (i != 0) {
        break label611;
      }
      this.stringBuilder.append("Нет");
      label367:
      this.text = ((TextView)this.vInfo.findViewById(2131361954));
      this.text.setText(this.stringBuilder);
      this.stringBuilder.setLength(0);
      this.stringBuilder.append("Жилье ");
      i = paramView[4];
      if (i != 0) {
        break label623;
      }
      this.stringBuilder.append("- Нет");
      label430:
      this.text = ((TextView)this.vInfo.findViewById(2131361955));
      this.text.setText(this.stringBuilder.toString());
      this.text = ((TextView)this.vInfo.findViewById(2131361960));
      this.text.setText("Расход:");
      this.text = ((TextView)this.vInfo.findViewById(2131361956));
      this.text.setText("Прибыль:");
      j = 0;
      i = 0;
      label514:
      if (i < 7) {
        break label655;
      }
      i = 0;
      label522:
      if (i < 2) {
        break label673;
      }
      i = 0;
      label529:
      if (i < BuildingsOptions.getProfit(this.id).length) {
        break label691;
      }
      j = 0;
      i = 0;
    }
    for (;;)
    {
      if (i >= BuildingsOptions.getConsumption(this.id).length)
      {
        return;
        i = j / 365;
        j /= 243;
        this.stringBuilder.append(i);
        this.stringBuilder.append(" / ");
        this.stringBuilder.append(j);
        this.stringBuilder.append("+ г.");
        break;
        label611:
        this.stringBuilder.append(i);
        break label367;
        label623:
        this.stringBuilder.append("на ");
        this.stringBuilder.append(i);
        this.stringBuilder.append(" чел.");
        break label430;
        label655:
        this.arrExpense[i].setText("");
        i += 1;
        break label514;
        label673:
        this.arrProfit[i].setText("");
        i += 1;
        break label522;
        label691:
        m = BuildingsOptions.getProfit(this.id)[i];
        k = j;
        if (m > 0)
        {
          this.arrProfit[j].setText(com.vorobiev.data.ResourceArray.res_name[i] + " - " + String.valueOf(m));
          k = j + 1;
        }
        i += 1;
        j = k;
        break label529;
      }
      int m = BuildingsOptions.getConsumption(this.id)[i];
      int k = j;
      if (m > 0)
      {
        this.arrExpense[j].setText(com.vorobiev.data.ResourceArray.res_name[i] + " - " + String.valueOf(m));
        k = j + 1;
      }
      i += 1;
      j = k;
    }
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\objects\OnClickBuildingInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */