package com.vorobiev.sk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import com.vorobiev.data.LoadingData;
import com.vorobiev.data.ResourceArray;
import com.vorobiev.gameclass.GameSound;
import com.vorobiev.surfaceHolder.FastRenderView;
import com.vorobiev.surfaceHolder.MyGraphics;
import com.vorobiev.surfaceHolder.Screen;

public class ActivityPause
  extends Activity
{
  public static final int IDD_EXIT = 100;
  public static final int IDD_WHITE_FLAG = 101;
  public static MyGraphics graphics;
  static boolean saved = false;
  Button btn_continue;
  Button btn_exit;
  Button btn_pause_cry;
  Button btn_pause_help;
  Button btn_pause_save;
  private Button btn_volume;
  public Handler handler;
  public FastRenderView renderView;
  
  public void hideButtons()
  {
    this.btn_exit.setVisibility(4);
    this.btn_continue.setVisibility(4);
    this.btn_pause_help.setVisibility(4);
    this.btn_pause_save.setVisibility(4);
    this.btn_pause_cry.setVisibility(4);
    this.btn_volume.setVisibility(4);
  }
  
  @SuppressLint({"HandlerLeak"})
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    saved = false;
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
    setContentView(2130903055);
    graphics = new MyGraphics(this);
    com.vorobiev.gameclass.Assets.background_pause = graphics.newBitmapFromAssets("background_pause.png");
    com.vorobiev.gameclass.Assets.background_loading = graphics.newBitmapFromAssets("background_loading.png");
    com.vorobiev.gameclass.Assets.progress = graphics.newBitmapFromAssets("progress.png");
    com.vorobiev.gameclass.Assets.background_label = graphics.newBitmapFromAssets("background_label.png");
    this.renderView = ((FastRenderView)findViewById(2131361971));
    this.renderView.registerGraphics(new Screen(graphics, 1));
    paramBundle = new MyTouchButtonPause(this);
    paramBundle = new MyButtonTouchListListener(ResourceArray.res_pause_button_down, ResourceArray.res_pause_button_up, paramBundle);
    this.btn_continue = ((Button)findViewById(2131361972));
    this.btn_continue.setId(0);
    this.btn_continue.setOnTouchListener(paramBundle);
    this.btn_pause_save = ((Button)findViewById(2131361973));
    this.btn_pause_save.setId(1);
    this.btn_pause_save.setOnTouchListener(paramBundle);
    this.btn_pause_help = ((Button)findViewById(2131361974));
    this.btn_pause_help.setId(2);
    this.btn_pause_help.setOnTouchListener(paramBundle);
    this.btn_pause_cry = ((Button)findViewById(2131361975));
    this.btn_pause_cry.setId(3);
    this.btn_pause_cry.setOnTouchListener(paramBundle);
    this.btn_exit = ((Button)findViewById(2131361976));
    this.btn_exit.setId(4);
    this.btn_exit.setOnTouchListener(paramBundle);
    this.btn_volume = ((Button)findViewById(2131361977));
    if (GameSound.isVolume) {
      this.btn_volume.setBackgroundResource(2130837561);
    }
    for (;;)
    {
      this.btn_volume.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (GameSound.isVolume) {}
          for (boolean bool = false;; bool = true)
          {
            GameSound.isVolume = bool;
            if (!GameSound.isVolume) {
              break;
            }
            ActivityPause.this.btn_volume.setBackgroundResource(2130837561);
            return;
          }
          ActivityPause.this.btn_volume.setBackgroundResource(2130837560);
        }
      });
      this.handler = new Handler()
      {
        public void handleMessage(Message paramAnonymousMessage)
        {
          MainActivity.startLoading = true;
          LoadingData.SaveGame(MainActivity.fileIO);
          MainActivity.countLoading = 0;
          MainActivity.startLoading = false;
          ActivityPause.this.showButtons();
        }
      };
      return;
      this.btn_volume.setBackgroundResource(2130837560);
    }
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    localBuilder.setTitle("Предупреждение");
    if (paramInt == 100)
    {
      localBuilder.setMessage("Вы действительно хотите выйти? Все несохраненные данные будут потеряны.");
      localBuilder.setPositiveButton("Да", new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("result", 1);
          ActivityPause.this.setResult(-1, localIntent);
          ActivityPause.this.renderView.pause();
          ActivityPause.this.finish();
          paramAnonymousDialogInterface.cancel();
        }
      });
    }
    for (;;)
    {
      localBuilder.setNegativeButton("Отмена", new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramAnonymousDialogInterface.cancel();
        }
      });
      localBuilder.setCancelable(false);
      return localBuilder.create();
      if (paramInt == 101)
      {
        localBuilder.setMessage("Вы действительно хотите сдаться? Ваша текущая игра будет потеряна, а достижения будут сохранены.");
        localBuilder.setPositiveButton("Да", new DialogInterface.OnClickListener()
        {
          /* Error */
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            // Byte code:
            //   0: aconst_null
            //   1: astore 4
            //   3: aconst_null
            //   4: astore 5
            //   6: aload 4
            //   8: astore_3
            //   9: iconst_0
            //   10: putstatic 31	com/vorobiev/data/BestScoreData:isFile	Z
            //   13: aload 4
            //   15: astore_3
            //   16: new 33	java/io/ObjectOutputStream
            //   19: dup
            //   20: getstatic 39	com/vorobiev/sk/MainActivity:fileIO	Lcom/vorobiev/gameInterface/FileIO;
            //   23: ldc 41
            //   25: invokeinterface 47 2 0
            //   30: invokespecial 50	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
            //   33: astore 4
            //   35: aload 4
            //   37: invokestatic 54	com/vorobiev/data/BestScoreData:saveData	(Ljava/io/ObjectOutputStream;)V
            //   40: aload 4
            //   42: invokevirtual 57	java/io/ObjectOutputStream:close	()V
            //   45: new 59	android/content/Intent
            //   48: dup
            //   49: invokespecial 60	android/content/Intent:<init>	()V
            //   52: astore_3
            //   53: aload_3
            //   54: ldc 62
            //   56: iconst_1
            //   57: invokevirtual 66	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
            //   60: pop
            //   61: aload_0
            //   62: getfield 17	com/vorobiev/sk/ActivityPause$4:this$0	Lcom/vorobiev/sk/ActivityPause;
            //   65: iconst_m1
            //   66: aload_3
            //   67: invokevirtual 70	com/vorobiev/sk/ActivityPause:setResult	(ILandroid/content/Intent;)V
            //   70: aload_0
            //   71: getfield 17	com/vorobiev/sk/ActivityPause$4:this$0	Lcom/vorobiev/sk/ActivityPause;
            //   74: getfield 74	com/vorobiev/sk/ActivityPause:renderView	Lcom/vorobiev/surfaceHolder/FastRenderView;
            //   77: invokevirtual 79	com/vorobiev/surfaceHolder/FastRenderView:pause	()V
            //   80: aload_0
            //   81: getfield 17	com/vorobiev/sk/ActivityPause$4:this$0	Lcom/vorobiev/sk/ActivityPause;
            //   84: invokevirtual 82	com/vorobiev/sk/ActivityPause:finish	()V
            //   87: aload_1
            //   88: invokeinterface 87 1 0
            //   93: return
            //   94: astore_3
            //   95: aload 5
            //   97: astore 4
            //   99: aload_3
            //   100: astore 5
            //   102: aload 4
            //   104: astore_3
            //   105: aload 5
            //   107: invokevirtual 90	java/io/IOException:printStackTrace	()V
            //   110: aload 4
            //   112: invokevirtual 57	java/io/ObjectOutputStream:close	()V
            //   115: goto -70 -> 45
            //   118: astore_3
            //   119: aload_3
            //   120: invokevirtual 90	java/io/IOException:printStackTrace	()V
            //   123: goto -78 -> 45
            //   126: astore_1
            //   127: aload_3
            //   128: invokevirtual 57	java/io/ObjectOutputStream:close	()V
            //   131: aload_1
            //   132: athrow
            //   133: astore_3
            //   134: aload_3
            //   135: invokevirtual 90	java/io/IOException:printStackTrace	()V
            //   138: goto -7 -> 131
            //   141: astore_3
            //   142: aload_3
            //   143: invokevirtual 90	java/io/IOException:printStackTrace	()V
            //   146: goto -101 -> 45
            //   149: astore_1
            //   150: aload 4
            //   152: astore_3
            //   153: goto -26 -> 127
            //   156: astore 5
            //   158: goto -56 -> 102
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	161	0	this	4
            //   0	161	1	paramAnonymousDialogInterface	DialogInterface
            //   0	161	2	paramAnonymousInt	int
            //   8	59	3	localObject1	Object
            //   94	6	3	localIOException1	java.io.IOException
            //   104	1	3	localObject2	Object
            //   118	10	3	localIOException2	java.io.IOException
            //   133	2	3	localIOException3	java.io.IOException
            //   141	2	3	localIOException4	java.io.IOException
            //   152	1	3	localObject3	Object
            //   1	150	4	localObject4	Object
            //   4	102	5	localObject5	Object
            //   156	1	5	localIOException5	java.io.IOException
            // Exception table:
            //   from	to	target	type
            //   9	13	94	java/io/IOException
            //   16	35	94	java/io/IOException
            //   110	115	118	java/io/IOException
            //   9	13	126	finally
            //   16	35	126	finally
            //   105	110	126	finally
            //   127	131	133	java/io/IOException
            //   40	45	141	java/io/IOException
            //   35	40	149	finally
            //   35	40	156	java/io/IOException
          }
        });
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return true;
  }
  
  protected void onPause()
  {
    this.renderView.pause();
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.renderView.resume();
  }
  
  public void showButtons()
  {
    this.btn_exit.setVisibility(0);
    this.btn_continue.setVisibility(0);
    this.btn_pause_help.setVisibility(0);
    this.btn_pause_save.setVisibility(0);
    this.btn_pause_cry.setVisibility(0);
    this.btn_volume.setVisibility(0);
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\sk\ActivityPause.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */