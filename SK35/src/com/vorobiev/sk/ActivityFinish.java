package com.vorobiev.sk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.vorobiev.data.Player;

public class ActivityFinish
  extends Activity
{
  private ImageButton btnClose;
  
  @SuppressLint({"InflateParams"})
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    requestWindowFeature(1);
    setContentView(2130903041);
    paramBundle = (LinearLayout)findViewById(2131361802);
    com.vorobiev.data.BestScoreData.cubok = 2;
    int i = 0;
    for (;;)
    {
      if (i >= 15)
      {
        this.btnClose = ((ImageButton)findViewById(2131361803));
        this.btnClose.setOnClickListener(new View.OnClickListener()
        {
          /* Error */
          public void onClick(View paramAnonymousView)
          {
            // Byte code:
            //   0: aconst_null
            //   1: astore_2
            //   2: aconst_null
            //   3: astore_3
            //   4: aload_2
            //   5: astore_1
            //   6: iconst_0
            //   7: putstatic 31	com/vorobiev/data/BestScoreData:isFile	Z
            //   10: aload_2
            //   11: astore_1
            //   12: new 33	java/io/ObjectOutputStream
            //   15: dup
            //   16: getstatic 39	com/vorobiev/sk/MainActivity:fileIO	Lcom/vorobiev/gameInterface/FileIO;
            //   19: ldc 41
            //   21: invokeinterface 47 2 0
            //   26: invokespecial 50	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
            //   29: astore_2
            //   30: aload_2
            //   31: invokestatic 54	com/vorobiev/data/BestScoreData:saveData	(Ljava/io/ObjectOutputStream;)V
            //   34: aload_2
            //   35: invokevirtual 57	java/io/ObjectOutputStream:close	()V
            //   38: new 59	android/content/Intent
            //   41: dup
            //   42: invokespecial 60	android/content/Intent:<init>	()V
            //   45: astore_1
            //   46: aload_1
            //   47: ldc 62
            //   49: iconst_1
            //   50: invokevirtual 66	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
            //   53: pop
            //   54: aload_0
            //   55: getfield 17	com/vorobiev/sk/ActivityFinish$1:this$0	Lcom/vorobiev/sk/ActivityFinish;
            //   58: iconst_m1
            //   59: aload_1
            //   60: invokevirtual 70	com/vorobiev/sk/ActivityFinish:setResult	(ILandroid/content/Intent;)V
            //   63: aload_0
            //   64: getfield 17	com/vorobiev/sk/ActivityFinish$1:this$0	Lcom/vorobiev/sk/ActivityFinish;
            //   67: invokevirtual 73	com/vorobiev/sk/ActivityFinish:finish	()V
            //   70: return
            //   71: astore_1
            //   72: aload_3
            //   73: astore_2
            //   74: aload_1
            //   75: astore_3
            //   76: aload_2
            //   77: astore_1
            //   78: aload_3
            //   79: invokevirtual 76	java/io/IOException:printStackTrace	()V
            //   82: aload_2
            //   83: invokevirtual 57	java/io/ObjectOutputStream:close	()V
            //   86: goto -48 -> 38
            //   89: astore_1
            //   90: aload_1
            //   91: invokevirtual 76	java/io/IOException:printStackTrace	()V
            //   94: goto -56 -> 38
            //   97: astore_2
            //   98: aload_1
            //   99: invokevirtual 57	java/io/ObjectOutputStream:close	()V
            //   102: aload_2
            //   103: athrow
            //   104: astore_1
            //   105: aload_1
            //   106: invokevirtual 76	java/io/IOException:printStackTrace	()V
            //   109: goto -7 -> 102
            //   112: astore_1
            //   113: aload_1
            //   114: invokevirtual 76	java/io/IOException:printStackTrace	()V
            //   117: goto -79 -> 38
            //   120: astore_3
            //   121: aload_2
            //   122: astore_1
            //   123: aload_3
            //   124: astore_2
            //   125: goto -27 -> 98
            //   128: astore_3
            //   129: goto -53 -> 76
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	132	0	this	1
            //   0	132	1	paramAnonymousView	View
            //   1	82	2	localObject1	Object
            //   97	25	2	localObject2	Object
            //   124	1	2	localObject3	Object
            //   3	76	3	localView	View
            //   120	4	3	localObject4	Object
            //   128	1	3	localIOException	java.io.IOException
            // Exception table:
            //   from	to	target	type
            //   6	10	71	java/io/IOException
            //   12	30	71	java/io/IOException
            //   82	86	89	java/io/IOException
            //   6	10	97	finally
            //   12	30	97	finally
            //   78	82	97	finally
            //   98	102	104	java/io/IOException
            //   34	38	112	java/io/IOException
            //   30	34	120	finally
            //   30	34	128	java/io/IOException
          }
        });
        return;
      }
      View localView = getLayoutInflater().inflate(2130903060, null);
      TextView localTextView1 = (TextView)localView.findViewById(2131361950);
      TextView localTextView2 = (TextView)localView.findViewById(2131362008);
      TextView localTextView3 = (TextView)localView.findViewById(2131362009);
      ((TextView)findViewById(2131361797)).setText(String.valueOf((int)Player.score));
      localTextView1.setText(com.vorobiev.data.ResourceArray.res_name[i]);
      localTextView1.setCompoundDrawablesWithIntrinsicBounds(com.vorobiev.data.ResourceArray.res_mark[i], 0, 0, 0);
      long l1 = Player.summResourceProfit[i];
      long l2 = Player.summResourceProfit[i];
      long l3 = Player.priceResourceStok[i];
      localTextView2.setText(String.valueOf(l1));
      localTextView3.setText(String.valueOf(l2 * l3));
      paramBundle.addView(localView);
      i += 1;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return true;
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\sk\ActivityFinish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */