package com.vorobiev.sk;

import android.view.View;
import android.widget.TextView;
import com.vorobiev.gameInterface.Sound;
import com.vorobiev.gameclass.Assets;

public class ButtonNumberListener
  implements MyTouchListener.MyDownButtonAction
{
  public StringBuilder builder;
  public long cost = 1L;
  public long inputMoney = 0L;
  public long inputResource = 0L;
  public long keyValid = 0L;
  public long maxMoney = 0L;
  public long maxResource = 0L;
  public int pick = 0;
  public TextView textValue;
  public TextView textValueTwo = null;
  
  public ButtonNumberListener(StringBuilder paramStringBuilder)
  {
    this.builder = paramStringBuilder;
  }
  
  public void actionOnClick(View paramView)
  {
    if (paramView.getId() < 10)
    {
      this.builder.append(paramView.getId());
      if (this.builder.length() != 0) {
        break label155;
      }
      this.textValue.setText("0");
      if (this.textValueTwo != null) {
        this.textValueTwo.setText("0");
      }
    }
    for (;;)
    {
      Assets.btn_click.play(1.0F);
      return;
      if (paramView.getId() == 10)
      {
        this.builder.setLength(0);
        break;
      }
      if (paramView.getId() == 11)
      {
        if (this.builder.length() == 0) {
          break;
        }
        this.builder.append(0);
        break;
      }
      if ((paramView.getId() != 12) || (this.builder.length() == 0)) {
        break;
      }
      this.builder.setLength(this.builder.length() - 1);
      break;
      label155:
      toInt();
    }
  }
  
  public void toInt()
  {
    this.inputMoney = 0L;
    long l = 1L;
    int i = this.builder.length() - 1;
    for (;;)
    {
      if (i < 0)
      {
        if ((this.textValueTwo == null) || (this.keyValid != 0L)) {
          break;
        }
        this.inputResource = this.inputMoney;
        this.inputMoney = (this.inputResource * this.cost);
        if (this.inputMoney > com.vorobiev.data.Player.resource[15])
        {
          this.inputResource = (com.vorobiev.data.Player.resource[15] / this.cost);
          this.inputMoney = (this.inputResource * this.cost);
          this.builder.setLength(0);
          this.builder.append(this.inputResource);
        }
        this.textValueTwo.setText(String.valueOf(this.inputMoney));
        this.textValue.setText(String.valueOf(this.inputResource));
        return;
      }
      this.inputMoney += (this.builder.charAt(i) - '0') * l;
      l *= 10L;
      i -= 1;
    }
    if ((this.textValueTwo != null) && (this.keyValid == 1L))
    {
      this.inputResource = this.inputMoney;
      this.inputMoney = (this.inputResource * this.cost);
      if (com.vorobiev.data.Player.resource[this.pick] < this.inputResource)
      {
        this.inputResource = com.vorobiev.data.Player.resource[this.pick];
        this.inputMoney = (this.inputResource * this.cost);
        this.builder.setLength(0);
        this.builder.append(this.inputResource);
      }
      this.textValueTwo.setText(String.valueOf(this.inputMoney));
      this.textValue.setText(String.valueOf(this.inputResource));
      return;
    }
    if (this.inputMoney > this.maxMoney)
    {
      this.inputMoney = this.maxMoney;
      this.builder.setLength(0);
      this.builder.append(this.inputMoney);
    }
    this.textValue.setText(this.builder.toString());
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\sk\ButtonNumberListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */