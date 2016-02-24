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

public class ActivitySellResource
  extends Activity
{
  private MyListAdapter adapter;
  private ImageButton btn_close;
  private int[] btn_id = { 2131361885, 2131361886, 2131361887, 2131361888, 2131361889, 2131361890, 2131361891, 2131361892, 2131361893, 2131361894, 2131361895, 2131361896 };
  private Button[] btn_number = new Button[12];
  private StringBuilder builder = new StringBuilder();
  private ButtonNumberListener numberListener = new ButtonNumberListener(this.builder);
  private int pick = 0;
  private long[] profitResource = new long[15];
  private TextView text_cost;
  private TextView text_money;
  private TextView text_money_size;
  private TextView text_profit;
  private TextView text_resource_size;
  
  private void inflateLeftPanel()
  {
    this.text_cost = ((TextView)findViewById(2131361878));
    this.text_cost.setText("Золото, цена - " + String.valueOf(Player.sellResource[0]));
    this.text_resource_size = ((TextView)findViewById(2131361880));
    this.text_money_size = ((TextView)findViewById(2131361881));
    this.numberListener.textValue = this.text_resource_size;
    this.numberListener.textValueTwo = this.text_money_size;
    this.numberListener.cost = Player.sellResource[0];
    ((TextView)findViewById(2131361882)).setText("Избыток ресурса");
    ((TextView)findViewById(2131361884)).setText("");
    this.text_profit = ((TextView)findViewById(2131361883));
    if (this.profitResource[0] > 0L)
    {
      this.numberListener.builder.append(this.profitResource[0]);
      this.numberListener.toInt();
    }
    this.text_profit.setText(String.valueOf(this.profitResource[0]));
  }
  
  private void initialButtonSell()
  {
    ImageButton localImageButton = (ImageButton)findViewById(2131361879);
    localImageButton.setBackgroundResource(2130837559);
    localImageButton.setOnTouchListener(new MyTouchListener(2130837558, 2130837559, new MyTouchListener.MyDownButtonAction()
    {
      public void actionOnClick(View paramAnonymousView)
      {
        if (ActivitySellResource.this.numberListener.inputResource > 0L)
        {
          Assets.money.play(1.0F);
          paramAnonymousView = Player.resource;
          paramAnonymousView[15] += ActivitySellResource.this.numberListener.inputMoney;
          Player.nalogWithSell += ActivitySellResource.this.numberListener.inputMoney;
          paramAnonymousView = Player.resource;
          int i = ActivitySellResource.this.pick;
          paramAnonymousView[i] -= ActivitySellResource.this.numberListener.inputResource;
          ActivitySellResource.this.numberListener.builder.setLength(0);
          ActivitySellResource.this.numberListener.toInt();
          ActivitySellResource.this.updateProfitResources();
          if (ActivitySellResource.this.profitResource[ActivitySellResource.this.pick] <= 0L) {
            break label262;
          }
          ActivitySellResource.this.text_profit.setText(String.valueOf(ActivitySellResource.this.profitResource[ActivitySellResource.this.pick]));
        }
        for (;;)
        {
          ((ViewResources)ActivitySellResource.this.adapter.getItem(ActivitySellResource.this.pick)).setNumResources(Player.resource[ActivitySellResource.this.pick]);
          ActivitySellResource.this.text_money.setText(String.valueOf(Player.resource[15]));
          if (Player.resource[15] <= 0L) {
            break label277;
          }
          ActivitySellResource.this.text_money.setTextColor(65280);
          return;
          Assets.no.play(1.0F);
          break;
          label262:
          ActivitySellResource.this.text_profit.setText("0");
        }
        label277:
        ActivitySellResource.this.text_money.setTextColor(-7829368);
      }
    }));
  }
  
  private void updateProfitResources()
  {
    int i = 0;
    for (;;)
    {
      if (i >= this.profitResource.length) {
        return;
      }
      this.profitResource[i] = (Player.resource[i] - Player.summConsumptionResource[i]);
      i += 1;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
    setContentView(2130903046);
    ((TextView)findViewById(2131361792)).setText("Продажа ресурсов");
    paramBundle = new MyTouchListener(2130837546, 2130837547, this.numberListener);
    int i = 0;
    if (i >= this.btn_id.length)
    {
      this.numberListener.keyValid = 1L;
      updateProfitResources();
      inflateLeftPanel();
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
          ActivitySellResource.this.pick = paramAnonymousInt;
          ActivitySellResource.this.numberListener.pick = ActivitySellResource.this.pick;
          int i = 0;
          for (;;)
          {
            if (i >= ((Adapter)paramAnonymousAdapterView.getAdapter()).getCount())
            {
              ((ViewResources)((Adapter)paramAnonymousAdapterView.getAdapter()).getItem(paramAnonymousInt)).pick();
              ActivitySellResource.this.text_cost.setText(com.vorobiev.data.ResourceArray.res_name[paramAnonymousInt] + ", цена - " + String.valueOf(Player.sellResource[paramAnonymousInt]));
              ActivitySellResource.this.numberListener.cost = Player.sellResource[paramAnonymousInt];
              if (ActivitySellResource.this.profitResource[paramAnonymousInt] <= 0L) {
                break;
              }
              ActivitySellResource.this.text_profit.setText(String.valueOf(ActivitySellResource.this.profitResource[paramAnonymousInt]));
              ActivitySellResource.this.numberListener.builder.setLength(0);
              ActivitySellResource.this.numberListener.builder.append(ActivitySellResource.this.profitResource[paramAnonymousInt]);
              ActivitySellResource.this.numberListener.toInt();
              return;
            }
            ((ViewResources)((Adapter)paramAnonymousAdapterView.getAdapter()).getItem(i)).unPick();
            i += 1;
          }
          ActivitySellResource.this.text_profit.setText("0");
          ActivitySellResource.this.text_resource_size.setText("0");
          ActivitySellResource.this.text_money_size.setText("0");
          ActivitySellResource.this.builder.setLength(0);
          ActivitySellResource.this.numberListener.toInt();
        }
      });
      this.text_money = ((TextView)findViewById(2131361899));
      this.text_money.setText(String.valueOf(Player.resource[15]));
      if (Player.resource[15] != 0L) {
        break label259;
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
          ActivitySellResource.this.setResult(-1, paramAnonymousView);
          ActivitySellResource.this.finish();
        }
      });
      initialButtonSell();
      return;
      this.btn_number[i] = ((Button)findViewById(this.btn_id[i]));
      this.btn_number[i].setId(i + 1);
      this.btn_number[i].setOnTouchListener(paramBundle);
      i += 1;
      break;
      label259:
      this.text_money.setTextColor(65280);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return true;
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\sk\ActivitySellResource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */