package com.vorobiev.sk;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;
import com.vorobiev.data.BestScoreData;

public class ActivityScore
  extends Activity
{
  private final int[] resource = { 2131361980, 2131361981, 2131361982, 2131361983, 2131361984, 2131361991, 2131361992, 2131361993, 2131361994, 2131361995, 2131362002, 2131362003, 2131362004, 2131362005, 2131362006 };
  
  private void inflateLayout()
  {
    ((TextView)findViewById(2131361924)).setText(String.valueOf(BestScoreData.scoreBest));
    Object localObject = (TextView)findViewById(2131361978);
    label87:
    label129:
    int i;
    if (BestScoreData.dayMillionBest == 100000)
    {
      ((TextView)localObject).setText(String.valueOf("Не заработан"));
      ((TextView)findViewById(2131361979)).setText(BestScoreData.dateMillionBest);
      localObject = (TextView)findViewById(2131361986);
      if (BestScoreData.dayMilliardBest != 100000) {
        break label190;
      }
      ((TextView)localObject).setText(String.valueOf("Не заработан"));
      ((TextView)findViewById(2131361987)).setText(BestScoreData.dateMilliardBest);
      localObject = (TextView)findViewById(2131361997);
      if (BestScoreData.dayTrillionBest != 100000) {
        break label223;
      }
      ((TextView)localObject).setText(String.valueOf("Не заработан"));
      ((TextView)findViewById(2131361998)).setText(BestScoreData.dateTrillionBest);
      localObject = BestScoreData.summResourceProfitBest;
      i = 0;
    }
    for (;;)
    {
      if (i >= localObject.length)
      {
        return;
        ((TextView)localObject).setText("Заработан за " + String.valueOf(BestScoreData.dayMillionBest) + " дн.");
        break;
        label190:
        ((TextView)localObject).setText("Заработан за " + String.valueOf(BestScoreData.dayMilliardBest) + " дн.");
        break label87;
        label223:
        ((TextView)localObject).setText("Заработан за " + String.valueOf(BestScoreData.dayTrillionBest) + " дн.");
        break label129;
      }
      ((TextView)findViewById(this.resource[i])).setText(String.valueOf(localObject[i]));
      i += 1;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
    setContentView(2130903056);
    inflateLayout();
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\sk\ActivityScore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */