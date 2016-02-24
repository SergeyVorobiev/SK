package com.vorobiev.sk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import com.vorobiev.data.Player;
import com.vorobiev.gameInterface.Sound;
import com.vorobiev.gameclass.Assets;

public class ActivityBuyResource
  extends Activity
{
  private MyListAdapter adapter;
  private ImageButton btn_buy;
  private ImageButton btn_close;
  private int[] btn_id = { 2131361885, 2131361886, 2131361887, 2131361888, 2131361889, 2131361890, 2131361891, 2131361892, 2131361893, 2131361894, 2131361895, 2131361896 };
  private Button[] btn_number = new Button[12];
  private StringBuilder builder = new StringBuilder();
  private long[] lossResource = new long[15];
  private ButtonNumberListener numberListener = new ButtonNumberListener(this.builder);
  private int pick = 0;
  private TextView text_cost;
  private TextView text_loss;
  private TextView text_money;
  private TextView text_money_size;
  private TextView text_resource_size;
  private MyTouchListener touchListener = new MyTouchListener(2130837546, 2130837547, this.numberListener);
  
  private void inflateLeftPanel()
  {
    this.text_cost = ((TextView)findViewById(2131361878));
    this.text_cost.setText("Золото, цена - " + String.valueOf(Player.buyResource[0]));
    this.text_resource_size = ((TextView)findViewById(2131361880));
    this.text_money_size = ((TextView)findViewById(2131361881));
    this.numberListener.textValue = this.text_resource_size;
    this.numberListener.textValueTwo = this.text_money_size;
    this.numberListener.cost = Player.buyResource[0];
    this.text_loss = ((TextView)findViewById(2131361884));
  }
  
  private void initialButtonBuy()
  {
    this.btn_buy = ((ImageButton)findViewById(2131361879));
    this.btn_buy.setOnTouchListener(new MyTouchListener(2130837566, 2130837567, new MyTouchListener.MyDownButtonAction()
    {
      public void actionOnClick(View paramAnonymousView)
      {
        if (ActivityBuyResource.this.numberListener.inputResource > 0L)
        {
          Assets.money.play(1.0F);
          paramAnonymousView = Player.resource;
          paramAnonymousView[15] -= ActivityBuyResource.this.numberListener.inputMoney;
          Player.nalogWithBuy += ActivityBuyResource.this.numberListener.inputMoney;
          paramAnonymousView = Player.resource;
          int i = ActivityBuyResource.this.pick;
          paramAnonymousView[i] += ActivityBuyResource.this.numberListener.inputResource;
          ActivityBuyResource.this.numberListener.builder.setLength(0);
          ActivityBuyResource.this.numberListener.toInt();
          ActivityBuyResource.this.updateLossResources();
          if (ActivityBuyResource.this.lossResource[ActivityBuyResource.this.pick] <= 0L) {
            break label262;
          }
          ActivityBuyResource.this.text_loss.setText(String.valueOf(ActivityBuyResource.this.lossResource[ActivityBuyResource.this.pick]));
        }
        for (;;)
        {
          ((ViewResources)ActivityBuyResource.this.adapter.getItem(ActivityBuyResource.this.pick)).setNumResources(Player.resource[ActivityBuyResource.this.pick]);
          ActivityBuyResource.this.text_money.setText(String.valueOf(Player.resource[15]));
          if (Player.resource[15] <= 0L) {
            break label277;
          }
          ActivityBuyResource.this.text_money.setTextColor(65280);
          return;
          Assets.no.play(1.0F);
          break;
          label262:
          ActivityBuyResource.this.text_loss.setText("0");
        }
        label277:
        ActivityBuyResource.this.text_money.setTextColor(-7829368);
      }
    }));
  }
  
  private void updateLossResources()
  {
    int i = 0;
    for (;;)
    {
      if (i >= this.lossResource.length) {
        return;
      }
      this.lossResource[i] = (Player.summConsumptionResource[i] - Player.resource[i]);
      i += 1;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
    setContentView(2130903046);
    int i = 0;
    if (i >= this.btn_id.length)
    {
      updateLossResources();
      inflateLeftPanel();
      initialButtonBuy();
      paramBundle = (ListView)findViewById(2131361898);
      this.adapter = new MyListAdapter(this);
      paramBundle.setAdapter(this.adapter);
      paramBundle.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          if (((ViewResources)((Adapter)paramAnonymousAdapterView.getAdapter()).getItem(paramAnonymousInt)).getPick()) {
            return;
          }
          ActivityBuyResource.this.pick = paramAnonymousInt;
          int i = 0;
          for (;;)
          {
            if (i >= ((Adapter)paramAnonymousAdapterView.getAdapter()).getCount())
            {
              ((ViewResources)((Adapter)paramAnonymousAdapterView.getAdapter()).getItem(paramAnonymousInt)).pick();
              ActivityBuyResource.this.text_cost.setText(com.vorobiev.data.ResourceArray.res_name[paramAnonymousInt] + ", цена - " + String.valueOf(Player.buyResource[paramAnonymousInt]));
              ActivityBuyResource.this.numberListener.cost = Player.buyResource[paramAnonymousInt];
              if (ActivityBuyResource.this.lossResource[paramAnonymousInt] <= 0L) {
                break;
              }
              ActivityBuyResource.this.text_loss.setText(String.valueOf(ActivityBuyResource.this.lossResource[paramAnonymousInt]));
              ActivityBuyResource.this.numberListener.builder.setLength(0);
              ActivityBuyResource.this.numberListener.builder.append(ActivityBuyResource.this.lossResource[paramAnonymousInt]);
              ActivityBuyResource.this.numberListener.toInt();
              return;
            }
            ((ViewResources)((Adapter)paramAnonymousAdapterView.getAdapter()).getItem(i)).unPick();
            i += 1;
          }
          ActivityBuyResource.this.text_loss.setText("0");
          ActivityBuyResource.this.text_resource_size.setText("0");
          ActivityBuyResource.this.text_money_size.setText("0");
          ActivityBuyResource.this.builder.setLength(0);
          ActivityBuyResource.this.numberListener.toInt();
        }
      });
      this.text_money = ((TextView)findViewById(2131361899));
      this.text_money.setText(String.valueOf(Player.resource[15]));
      if (Player.resource[15] != 0L) {
        break label224;
      }
      this.text_money.setTextColor(-7829368);
    }
    for (;;)
    {
      this.btn_close = ((ImageButton)findViewById(2131361897));
      this.btn_close.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          paramAnonymousView = new Intent();
          ActivityBuyResource.this.setResult(-1, paramAnonymousView);
          ActivityBuyResource.this.finish();
        }
      });
      return;
      this.btn_number[i] = ((Button)findViewById(this.btn_id[i]));
      this.btn_number[i].setId(i + 1);
      this.btn_number[i].setOnTouchListener(this.touchListener);
      i += 1;
      break;
      label224:
      this.text_money.setTextColor(65280);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return true;
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\sk\ActivityBuyResource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */