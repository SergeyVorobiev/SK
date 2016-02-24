package com.vorobiev.myDialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.vorobiev.sk.MainActivity;

public class DialogNewGame
  extends MyDialog
{
  private MainActivity mainActivity;
  
  public DialogNewGame(Context paramContext)
  {
    super(paramContext);
    this.mainActivity = ((MainActivity)paramContext);
  }
  
  protected void create(AlertDialog paramAlertDialog)
  {
    paramAlertDialog.setTitle("Предупреждение");
    paramAlertDialog.setMessage("Вы действительно хотите начать новую игру? Текущая игра будет потеряна.");
    paramAlertDialog.setButton(-1, "Начать", new DialogInterface.OnClickListener()
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
        //   37: invokestatic 54	com/vorobiev/data/BestScoreData:saveDataNewGame	(Ljava/io/ObjectOutputStream;)V
        //   40: aload 4
        //   42: invokevirtual 57	java/io/ObjectOutputStream:close	()V
        //   45: aload_0
        //   46: getfield 17	com/vorobiev/myDialogs/DialogNewGame$1:this$0	Lcom/vorobiev/myDialogs/DialogNewGame;
        //   49: invokestatic 61	com/vorobiev/myDialogs/DialogNewGame:access$0	(Lcom/vorobiev/myDialogs/DialogNewGame;)Lcom/vorobiev/sk/MainActivity;
        //   52: iconst_0
        //   53: putfield 64	com/vorobiev/sk/MainActivity:mainMenu	Z
        //   56: aload_0
        //   57: getfield 17	com/vorobiev/myDialogs/DialogNewGame$1:this$0	Lcom/vorobiev/myDialogs/DialogNewGame;
        //   60: invokestatic 61	com/vorobiev/myDialogs/DialogNewGame:access$0	(Lcom/vorobiev/myDialogs/DialogNewGame;)Lcom/vorobiev/sk/MainActivity;
        //   63: invokevirtual 67	com/vorobiev/sk/MainActivity:hideButton	()V
        //   66: aload_0
        //   67: getfield 17	com/vorobiev/myDialogs/DialogNewGame$1:this$0	Lcom/vorobiev/myDialogs/DialogNewGame;
        //   70: invokestatic 61	com/vorobiev/myDialogs/DialogNewGame:access$0	(Lcom/vorobiev/myDialogs/DialogNewGame;)Lcom/vorobiev/sk/MainActivity;
        //   73: getfield 71	com/vorobiev/sk/MainActivity:renderView	Lcom/vorobiev/surfaceHolder/FastRenderView;
        //   76: invokevirtual 76	com/vorobiev/surfaceHolder/FastRenderView:pause	()V
        //   79: aload_0
        //   80: getfield 17	com/vorobiev/myDialogs/DialogNewGame$1:this$0	Lcom/vorobiev/myDialogs/DialogNewGame;
        //   83: invokestatic 61	com/vorobiev/myDialogs/DialogNewGame:access$0	(Lcom/vorobiev/myDialogs/DialogNewGame;)Lcom/vorobiev/sk/MainActivity;
        //   86: new 78	com/vorobiev/sk/GameLayout
        //   89: dup
        //   90: aload_0
        //   91: getfield 17	com/vorobiev/myDialogs/DialogNewGame$1:this$0	Lcom/vorobiev/myDialogs/DialogNewGame;
        //   94: invokestatic 61	com/vorobiev/myDialogs/DialogNewGame:access$0	(Lcom/vorobiev/myDialogs/DialogNewGame;)Lcom/vorobiev/sk/MainActivity;
        //   97: iconst_1
        //   98: invokespecial 81	com/vorobiev/sk/GameLayout:<init>	(Lcom/vorobiev/sk/MainActivity;Z)V
        //   101: putfield 85	com/vorobiev/sk/MainActivity:gameLayout	Lcom/vorobiev/sk/GameLayout;
        //   104: aload_1
        //   105: invokeinterface 90 1 0
        //   110: return
        //   111: astore_3
        //   112: aload 5
        //   114: astore 4
        //   116: aload_3
        //   117: astore 5
        //   119: aload 4
        //   121: astore_3
        //   122: aload 5
        //   124: invokevirtual 93	java/io/IOException:printStackTrace	()V
        //   127: aload 4
        //   129: invokevirtual 57	java/io/ObjectOutputStream:close	()V
        //   132: goto -87 -> 45
        //   135: astore_3
        //   136: aload_3
        //   137: invokevirtual 93	java/io/IOException:printStackTrace	()V
        //   140: goto -95 -> 45
        //   143: astore_1
        //   144: aload_3
        //   145: invokevirtual 57	java/io/ObjectOutputStream:close	()V
        //   148: aload_1
        //   149: athrow
        //   150: astore_3
        //   151: aload_3
        //   152: invokevirtual 93	java/io/IOException:printStackTrace	()V
        //   155: goto -7 -> 148
        //   158: astore_3
        //   159: aload_3
        //   160: invokevirtual 93	java/io/IOException:printStackTrace	()V
        //   163: goto -118 -> 45
        //   166: astore_1
        //   167: aload 4
        //   169: astore_3
        //   170: goto -26 -> 144
        //   173: astore 5
        //   175: goto -56 -> 119
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	178	0	this	1
        //   0	178	1	paramAnonymousDialogInterface	DialogInterface
        //   0	178	2	paramAnonymousInt	int
        //   8	8	3	localObject1	Object
        //   111	6	3	localIOException1	java.io.IOException
        //   121	1	3	localObject2	Object
        //   135	10	3	localIOException2	java.io.IOException
        //   150	2	3	localIOException3	java.io.IOException
        //   158	2	3	localIOException4	java.io.IOException
        //   169	1	3	localObject3	Object
        //   1	167	4	localObject4	Object
        //   4	119	5	localObject5	Object
        //   173	1	5	localIOException5	java.io.IOException
        // Exception table:
        //   from	to	target	type
        //   9	13	111	java/io/IOException
        //   16	35	111	java/io/IOException
        //   127	132	135	java/io/IOException
        //   9	13	143	finally
        //   16	35	143	finally
        //   122	127	143	finally
        //   144	148	150	java/io/IOException
        //   40	45	158	java/io/IOException
        //   35	40	166	finally
        //   35	40	173	java/io/IOException
      }
    });
    paramAlertDialog.setButton(-2, "Отмена", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.cancel();
      }
    });
    paramAlertDialog.setCancelable(false);
  }
  
  protected void prepare(AlertDialog paramAlertDialog) {}
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\myDialogs\DialogNewGame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */