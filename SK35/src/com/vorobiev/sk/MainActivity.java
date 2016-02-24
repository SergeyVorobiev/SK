package com.vorobiev.sk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;
import com.vorobiev.data.BestScoreData;
import com.vorobiev.data.ResourceArray;
import com.vorobiev.gameInterface.Audio;
import com.vorobiev.gameInterface.FileIO;
import com.vorobiev.gameclass.AndroidFileIO;
import com.vorobiev.gameclass.GameAudio;
import com.vorobiev.gameclass.GameSound;
import com.vorobiev.handler.ButtonVisibleHandler;
import com.vorobiev.handler.LoadingGameHandler;
import com.vorobiev.handler.MyHandlers;
import com.vorobiev.myDialogs.DialogNewGame;
import com.vorobiev.surfaceHolder.FastRenderView;
import com.vorobiev.surfaceHolder.MyGraphics;
import com.vorobiev.surfaceHolder.Screen;

public class MainActivity
  extends Activity
{
  public static final int IDH_ANIM_LEFT = 312;
  public static final int IDH_ANIM_TOP = 311;
  public static final int IDH_BUTTON_NEXT_DAY = 315;
  public static final int IDH_CONGRATULATION = 313;
  public static final int IDH_DIALOG_BIG_NALOG = 310;
  public static final int IDH_DIALOG_TAX = 308;
  public static final int IDH_DIALOG_YEAR_NALOG = 309;
  public static final int IDH_INFO = 302;
  public static final int IDH_LOADING = 301;
  public static final int IDH_PROGRESS_GAME = 305;
  public static final int IDH_RADAR = 304;
  public static final int IDH_RIGHT_PANEL = 306;
  public static final int IDH_TOAST = 307;
  public static final int IDH_TOP = 303;
  public static final int IDH_VISIBLE_BUTTONS = 314;
  public static final int IDM_BUY = 201;
  public static final int IDM_COST = 203;
  public static final int IDM_FINAL = 205;
  public static final int IDM_PAUSE = 204;
  public static final int IDM_SELL = 202;
  public static int countLoading;
  public static FileIO fileIO = null;
  public static MyGraphics graphics = null;
  private static boolean logo = true;
  public static boolean mainActive;
  public static MyHandlers myHandlers;
  public static boolean startLoading = false;
  private Audio audio;
  public Button btn_authors;
  public Button btn_continue_game;
  public Button btn_help;
  public Button btn_main_exit;
  public Button btn_records;
  private Button btn_volume;
  private StringBuilder builder = new StringBuilder();
  public DialogNewGame dialogNewGame;
  public GameLayout gameLayout;
  public ImageView label;
  public boolean mainMenu = true;
  private View main_view;
  public Button new_game;
  public FastRenderView renderView;
  
  static
  {
    countLoading = 0;
    mainActive = true;
    myHandlers = null;
  }
  
  private void inflateButtonsMenu()
  {
    this.label = ((ImageView)findViewById(2131361860));
    this.btn_volume = ((Button)findViewById(2131361867));
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
            MainActivity.this.btn_volume.setBackgroundResource(2130837561);
            return;
          }
          MainActivity.this.btn_volume.setBackgroundResource(2130837560);
        }
      });
      Object localObject = new ButtonMainListener(this);
      localObject = new MyButtonTouchListListener(ResourceArray.res_main_button_down, ResourceArray.res_main_button_up, (MyTouchListener.MyDownButtonAction)localObject);
      this.btn_continue_game = ((Button)findViewById(2131361861));
      this.btn_continue_game.setId(0);
      this.btn_continue_game.setOnTouchListener((View.OnTouchListener)localObject);
      this.new_game = ((Button)findViewById(2131361863));
      this.new_game.setId(1);
      this.new_game.setOnTouchListener((View.OnTouchListener)localObject);
      this.btn_records = ((Button)findViewById(2131361862));
      this.btn_records.setId(2);
      this.btn_records.setOnTouchListener((View.OnTouchListener)localObject);
      this.btn_authors = ((Button)findViewById(2131361864));
      this.btn_authors.setId(3);
      this.btn_authors.setOnTouchListener((View.OnTouchListener)localObject);
      this.btn_help = ((Button)findViewById(2131361865));
      this.btn_help.setId(4);
      this.btn_help.setOnTouchListener((View.OnTouchListener)localObject);
      this.btn_main_exit = ((Button)findViewById(2131361866));
      this.btn_main_exit.setId(5);
      this.btn_main_exit.setOnTouchListener((View.OnTouchListener)localObject);
      if (!isFile()) {
        break;
      }
      this.btn_continue_game.setVisibility(0);
      return;
      this.btn_volume.setBackgroundResource(2130837560);
    }
    this.btn_continue_game.setVisibility(4);
  }
  
  /* Error */
  private void initialScore()
  {
    // Byte code:
    //   0: getstatic 95	com/vorobiev/sk/MainActivity:fileIO	Lcom/vorobiev/gameInterface/FileIO;
    //   3: ldc -46
    //   5: invokeinterface 216 2 0
    //   10: ifeq +177 -> 187
    //   13: aconst_null
    //   14: astore 4
    //   16: aconst_null
    //   17: astore_1
    //   18: aconst_null
    //   19: astore_3
    //   20: new 218	java/io/ObjectInputStream
    //   23: dup
    //   24: getstatic 95	com/vorobiev/sk/MainActivity:fileIO	Lcom/vorobiev/gameInterface/FileIO;
    //   27: ldc -46
    //   29: invokeinterface 222 2 0
    //   34: invokespecial 225	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   37: astore_2
    //   38: aload_2
    //   39: invokestatic 231	com/vorobiev/data/BestScoreData:loadData	(Ljava/io/ObjectInputStream;)V
    //   42: aload_2
    //   43: ifnull +7 -> 50
    //   46: aload_2
    //   47: invokevirtual 234	java/io/ObjectInputStream:close	()V
    //   50: return
    //   51: astore_1
    //   52: aload_3
    //   53: astore_2
    //   54: aload_1
    //   55: astore_3
    //   56: aload_2
    //   57: astore_1
    //   58: aload_0
    //   59: ldc -20
    //   61: iconst_0
    //   62: invokestatic 242	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   65: invokevirtual 245	android/widget/Toast:show	()V
    //   68: aload_2
    //   69: astore_1
    //   70: getstatic 95	com/vorobiev/sk/MainActivity:fileIO	Lcom/vorobiev/gameInterface/FileIO;
    //   73: ldc -46
    //   75: invokeinterface 248 2 0
    //   80: pop
    //   81: aload_2
    //   82: astore_1
    //   83: invokestatic 251	com/vorobiev/data/BestScoreData:newData	()V
    //   86: aload_2
    //   87: astore_1
    //   88: aload_3
    //   89: invokevirtual 254	java/io/StreamCorruptedException:printStackTrace	()V
    //   92: aload_2
    //   93: ifnull -43 -> 50
    //   96: aload_2
    //   97: invokevirtual 234	java/io/ObjectInputStream:close	()V
    //   100: return
    //   101: astore_1
    //   102: aload_1
    //   103: invokevirtual 255	java/io/IOException:printStackTrace	()V
    //   106: return
    //   107: astore_3
    //   108: aload 4
    //   110: astore_2
    //   111: aload_2
    //   112: astore_1
    //   113: aload_0
    //   114: ldc -20
    //   116: iconst_0
    //   117: invokestatic 242	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   120: invokevirtual 245	android/widget/Toast:show	()V
    //   123: aload_2
    //   124: astore_1
    //   125: getstatic 95	com/vorobiev/sk/MainActivity:fileIO	Lcom/vorobiev/gameInterface/FileIO;
    //   128: ldc -46
    //   130: invokeinterface 248 2 0
    //   135: pop
    //   136: aload_2
    //   137: astore_1
    //   138: invokestatic 251	com/vorobiev/data/BestScoreData:newData	()V
    //   141: aload_2
    //   142: astore_1
    //   143: aload_3
    //   144: invokevirtual 255	java/io/IOException:printStackTrace	()V
    //   147: aload_2
    //   148: ifnull -98 -> 50
    //   151: aload_2
    //   152: invokevirtual 234	java/io/ObjectInputStream:close	()V
    //   155: return
    //   156: astore_1
    //   157: aload_1
    //   158: invokevirtual 255	java/io/IOException:printStackTrace	()V
    //   161: return
    //   162: astore_2
    //   163: aload_1
    //   164: ifnull +7 -> 171
    //   167: aload_1
    //   168: invokevirtual 234	java/io/ObjectInputStream:close	()V
    //   171: aload_2
    //   172: athrow
    //   173: astore_1
    //   174: aload_1
    //   175: invokevirtual 255	java/io/IOException:printStackTrace	()V
    //   178: goto -7 -> 171
    //   181: astore_1
    //   182: aload_1
    //   183: invokevirtual 255	java/io/IOException:printStackTrace	()V
    //   186: return
    //   187: invokestatic 251	com/vorobiev/data/BestScoreData:newData	()V
    //   190: return
    //   191: astore_3
    //   192: aload_2
    //   193: astore_1
    //   194: aload_3
    //   195: astore_2
    //   196: goto -33 -> 163
    //   199: astore_3
    //   200: goto -89 -> 111
    //   203: astore_3
    //   204: goto -148 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	this	MainActivity
    //   17	1	1	localObject1	Object
    //   51	4	1	localStreamCorruptedException1	java.io.StreamCorruptedException
    //   57	31	1	localObject2	Object
    //   101	2	1	localIOException1	java.io.IOException
    //   112	31	1	localObject3	Object
    //   156	12	1	localIOException2	java.io.IOException
    //   173	2	1	localIOException3	java.io.IOException
    //   181	2	1	localIOException4	java.io.IOException
    //   193	1	1	localObject4	Object
    //   37	115	2	localObject5	Object
    //   162	31	2	localObject6	Object
    //   195	1	2	localObject7	Object
    //   19	70	3	localStreamCorruptedException2	java.io.StreamCorruptedException
    //   107	37	3	localIOException5	java.io.IOException
    //   191	4	3	localObject8	Object
    //   199	1	3	localIOException6	java.io.IOException
    //   203	1	3	localStreamCorruptedException3	java.io.StreamCorruptedException
    //   14	95	4	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   20	38	51	java/io/StreamCorruptedException
    //   96	100	101	java/io/IOException
    //   20	38	107	java/io/IOException
    //   151	155	156	java/io/IOException
    //   20	38	162	finally
    //   58	68	162	finally
    //   70	81	162	finally
    //   83	86	162	finally
    //   88	92	162	finally
    //   113	123	162	finally
    //   125	136	162	finally
    //   138	141	162	finally
    //   143	147	162	finally
    //   167	171	173	java/io/IOException
    //   46	50	181	java/io/IOException
    //   38	42	191	finally
    //   38	42	199	java/io/IOException
    //   38	42	203	java/io/StreamCorruptedException
  }
  
  public Audio getAudio()
  {
    return this.audio;
  }
  
  public FileIO getFileIO()
  {
    return fileIO;
  }
  
  public void hideButton()
  {
    this.btn_authors.setVisibility(4);
    this.btn_continue_game.setVisibility(4);
    this.btn_help.setVisibility(4);
    this.btn_main_exit.setVisibility(4);
    this.btn_records.setVisibility(4);
    this.new_game.setVisibility(4);
    this.label.setVisibility(4);
    this.btn_volume.setVisibility(4);
  }
  
  /* Error */
  public boolean isFile()
  {
    // Byte code:
    //   0: getstatic 95	com/vorobiev/sk/MainActivity:fileIO	Lcom/vorobiev/gameInterface/FileIO;
    //   3: ldc -46
    //   5: invokeinterface 216 2 0
    //   10: ifne +5 -> 15
    //   13: iconst_0
    //   14: ireturn
    //   15: iconst_0
    //   16: istore_1
    //   17: aconst_null
    //   18: astore 6
    //   20: aconst_null
    //   21: astore_3
    //   22: aconst_null
    //   23: astore 5
    //   25: new 218	java/io/ObjectInputStream
    //   28: dup
    //   29: getstatic 95	com/vorobiev/sk/MainActivity:fileIO	Lcom/vorobiev/gameInterface/FileIO;
    //   32: ldc -46
    //   34: invokeinterface 222 2 0
    //   39: invokespecial 225	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   42: astore 4
    //   44: aload 4
    //   46: invokevirtual 266	java/io/ObjectInputStream:readBoolean	()Z
    //   49: istore_2
    //   50: iload_2
    //   51: istore_1
    //   52: aload 4
    //   54: invokevirtual 234	java/io/ObjectInputStream:close	()V
    //   57: iload_1
    //   58: ifeq -45 -> 13
    //   61: iconst_1
    //   62: ireturn
    //   63: astore_3
    //   64: aload 5
    //   66: astore 4
    //   68: aload_3
    //   69: astore 5
    //   71: aload 4
    //   73: astore_3
    //   74: getstatic 95	com/vorobiev/sk/MainActivity:fileIO	Lcom/vorobiev/gameInterface/FileIO;
    //   77: ldc -46
    //   79: invokeinterface 248 2 0
    //   84: pop
    //   85: aload 4
    //   87: astore_3
    //   88: aload 5
    //   90: invokevirtual 254	java/io/StreamCorruptedException:printStackTrace	()V
    //   93: aload 4
    //   95: invokevirtual 234	java/io/ObjectInputStream:close	()V
    //   98: goto -41 -> 57
    //   101: astore_3
    //   102: aload_3
    //   103: invokevirtual 255	java/io/IOException:printStackTrace	()V
    //   106: goto -49 -> 57
    //   109: astore 5
    //   111: aload 6
    //   113: astore 4
    //   115: aload 4
    //   117: astore_3
    //   118: getstatic 95	com/vorobiev/sk/MainActivity:fileIO	Lcom/vorobiev/gameInterface/FileIO;
    //   121: ldc -46
    //   123: invokeinterface 248 2 0
    //   128: pop
    //   129: aload 4
    //   131: astore_3
    //   132: aload 5
    //   134: invokevirtual 255	java/io/IOException:printStackTrace	()V
    //   137: aload 4
    //   139: invokevirtual 234	java/io/ObjectInputStream:close	()V
    //   142: goto -85 -> 57
    //   145: astore_3
    //   146: aload_3
    //   147: invokevirtual 255	java/io/IOException:printStackTrace	()V
    //   150: goto -93 -> 57
    //   153: astore 4
    //   155: aload_3
    //   156: invokevirtual 234	java/io/ObjectInputStream:close	()V
    //   159: aload 4
    //   161: athrow
    //   162: astore_3
    //   163: aload_3
    //   164: invokevirtual 255	java/io/IOException:printStackTrace	()V
    //   167: goto -8 -> 159
    //   170: astore_3
    //   171: aload_3
    //   172: invokevirtual 255	java/io/IOException:printStackTrace	()V
    //   175: goto -118 -> 57
    //   178: astore 5
    //   180: aload 4
    //   182: astore_3
    //   183: aload 5
    //   185: astore 4
    //   187: goto -32 -> 155
    //   190: astore 5
    //   192: goto -77 -> 115
    //   195: astore 5
    //   197: goto -126 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	this	MainActivity
    //   16	42	1	i	int
    //   49	2	2	bool	boolean
    //   21	1	3	localObject1	Object
    //   63	6	3	localStreamCorruptedException1	java.io.StreamCorruptedException
    //   73	15	3	localObject2	Object
    //   101	2	3	localIOException1	java.io.IOException
    //   117	15	3	localObject3	Object
    //   145	11	3	localIOException2	java.io.IOException
    //   162	2	3	localIOException3	java.io.IOException
    //   170	2	3	localIOException4	java.io.IOException
    //   182	1	3	localObject4	Object
    //   42	96	4	localObject5	Object
    //   153	28	4	localObject6	Object
    //   185	1	4	localObject7	Object
    //   23	66	5	localStreamCorruptedException2	java.io.StreamCorruptedException
    //   109	24	5	localIOException5	java.io.IOException
    //   178	6	5	localObject8	Object
    //   190	1	5	localIOException6	java.io.IOException
    //   195	1	5	localStreamCorruptedException3	java.io.StreamCorruptedException
    //   18	94	6	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   25	44	63	java/io/StreamCorruptedException
    //   93	98	101	java/io/IOException
    //   25	44	109	java/io/IOException
    //   137	142	145	java/io/IOException
    //   25	44	153	finally
    //   74	85	153	finally
    //   88	93	153	finally
    //   118	129	153	finally
    //   132	137	153	finally
    //   155	159	162	java/io/IOException
    //   52	57	170	java/io/IOException
    //   44	50	178	finally
    //   44	50	190	java/io/IOException
    //   44	50	195	java/io/StreamCorruptedException
  }
  
  public void loadRenderView()
  {
    com.vorobiev.gameclass.Assets.background_screen = graphics.newBitmapFromAssets("background_main.png");
    int i = 1;
    if (i >= 17)
    {
      i = 0;
      label22:
      if (i < 10) {
        break label263;
      }
      com.vorobiev.gameclass.Assets.background_loading = graphics.newBitmapFromAssets("background_loading.png");
      i = 1;
    }
    for (;;)
    {
      if (i >= 18)
      {
        com.vorobiev.gameclass.Assets.progress = graphics.newBitmapFromAssets("progress.png");
        com.vorobiev.gameclass.Assets.background_label = graphics.newBitmapFromAssets("background_label.png");
        com.vorobiev.gameclass.Assets.clickTwo = this.audio.newSound("sound/clickTwo.mp3");
        com.vorobiev.gameclass.Assets.btn_click = this.audio.newSound("sound/btn_number_click.mp3");
        this.renderView = ((FastRenderView)this.main_view.findViewById(2131361859));
        this.renderView.registerGraphics(new Screen(graphics, 0));
        return;
        this.builder.setLength(0);
        this.builder.append("picture/anim_cubok/cubok");
        this.builder.append(i);
        this.builder.append(".png");
        com.vorobiev.gameclass.Assets.cubokAnim[(i - 1)] = graphics.newBitmapFromAssets(this.builder.toString());
        this.builder.setLength(0);
        this.builder.append("picture/anim_cubok_silver/cubok");
        this.builder.append(i);
        this.builder.append(".png");
        com.vorobiev.gameclass.Assets.cubokAnimSilver[(i - 1)] = graphics.newBitmapFromAssets(this.builder.toString());
        i += 1;
        break;
        label263:
        this.builder.setLength(0);
        this.builder.append("picture/numbers/number_");
        this.builder.append(i);
        this.builder.append(".png");
        com.vorobiev.gameclass.Assets.numbers[i] = graphics.newBitmapFromAssets(this.builder.toString());
        this.builder.setLength(0);
        this.builder.append("picture/numbers/number");
        this.builder.append(i);
        this.builder.append(".png");
        com.vorobiev.gameclass.Assets.numbersRed[i] = graphics.newBitmapFromAssets(this.builder.toString());
        i += 1;
        break label22;
      }
      this.builder.setLength(0);
      this.builder.append("picture/label_champion/znak");
      this.builder.append(i);
      this.builder.append(".png");
      com.vorobiev.gameclass.Assets.ten_trln[(i - 1)] = graphics.newBitmapFromAssets(this.builder.toString());
      i += 1;
    }
  }
  
  /* Error */
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: iload_2
    //   3: aload_3
    //   4: invokespecial 376	android/app/Activity:onActivityResult	(IILandroid/content/Intent;)V
    //   7: getstatic 382	com/vorobiev/sk/GameLayout:block	Ljava/lang/Object;
    //   10: astore 6
    //   12: aload 6
    //   14: monitorenter
    //   15: iload_1
    //   16: tableswitch	default:+36->52, 201:+40->56, 202:+66->82, 203:+269->285, 204:+277->293, 205:+277->293
    //   52: aload 6
    //   54: monitorexit
    //   55: return
    //   56: iconst_1
    //   57: putstatic 91	com/vorobiev/sk/MainActivity:mainActive	Z
    //   60: getstatic 386	com/vorobiev/sk/GameLayout:rightPanel	Lcom/vorobiev/objects/RightPanel;
    //   63: invokevirtual 391	com/vorobiev/objects/RightPanel:updateMoney	()V
    //   66: getstatic 386	com/vorobiev/sk/GameLayout:rightPanel	Lcom/vorobiev/objects/RightPanel;
    //   69: invokevirtual 394	com/vorobiev/objects/RightPanel:update	()V
    //   72: aload 6
    //   74: monitorexit
    //   75: return
    //   76: astore_3
    //   77: aload 6
    //   79: monitorexit
    //   80: aload_3
    //   81: athrow
    //   82: iconst_1
    //   83: putstatic 91	com/vorobiev/sk/MainActivity:mainActive	Z
    //   86: getstatic 386	com/vorobiev/sk/GameLayout:rightPanel	Lcom/vorobiev/objects/RightPanel;
    //   89: invokevirtual 391	com/vorobiev/objects/RightPanel:updateMoney	()V
    //   92: getstatic 386	com/vorobiev/sk/GameLayout:rightPanel	Lcom/vorobiev/objects/RightPanel;
    //   95: invokevirtual 394	com/vorobiev/objects/RightPanel:update	()V
    //   98: getstatic 400	com/vorobiev/data/Player:resource	[J
    //   101: bipush 15
    //   103: laload
    //   104: lstore 4
    //   106: lload 4
    //   108: ldc2_w 401
    //   111: lcmp
    //   112: iflt +51 -> 163
    //   115: getstatic 405	com/vorobiev/data/Player:isMillion	Z
    //   118: ifne +45 -> 163
    //   121: getstatic 93	com/vorobiev/sk/MainActivity:myHandlers	Lcom/vorobiev/handler/MyHandlers;
    //   124: sipush 313
    //   127: iconst_1
    //   128: invokevirtual 411	com/vorobiev/handler/MyHandlers:send	(II)V
    //   131: iconst_1
    //   132: putstatic 405	com/vorobiev/data/Player:isMillion	Z
    //   135: getstatic 414	com/vorobiev/data/BestScoreData:dayMillionBest	I
    //   138: getstatic 417	com/vorobiev/data/Player:livedDays	I
    //   141: if_icmple +18 -> 159
    //   144: getstatic 417	com/vorobiev/data/Player:livedDays	I
    //   147: putstatic 414	com/vorobiev/data/BestScoreData:dayMillionBest	I
    //   150: getstatic 421	com/vorobiev/sk/GameLayout:date	Lcom/vorobiev/objects/MyDate;
    //   153: invokevirtual 426	com/vorobiev/objects/MyDate:getDate	()Ljava/lang/String;
    //   156: putstatic 430	com/vorobiev/data/BestScoreData:dateMillionBest	Ljava/lang/String;
    //   159: aload 6
    //   161: monitorexit
    //   162: return
    //   163: lload 4
    //   165: ldc2_w 431
    //   168: lcmp
    //   169: iflt +50 -> 219
    //   172: getstatic 435	com/vorobiev/data/Player:isMilliard	Z
    //   175: ifne +44 -> 219
    //   178: getstatic 93	com/vorobiev/sk/MainActivity:myHandlers	Lcom/vorobiev/handler/MyHandlers;
    //   181: sipush 313
    //   184: iconst_2
    //   185: invokevirtual 411	com/vorobiev/handler/MyHandlers:send	(II)V
    //   188: iconst_1
    //   189: putstatic 435	com/vorobiev/data/Player:isMilliard	Z
    //   192: getstatic 438	com/vorobiev/data/BestScoreData:dayMilliardBest	I
    //   195: getstatic 417	com/vorobiev/data/Player:livedDays	I
    //   198: if_icmple -39 -> 159
    //   201: getstatic 417	com/vorobiev/data/Player:livedDays	I
    //   204: putstatic 438	com/vorobiev/data/BestScoreData:dayMilliardBest	I
    //   207: getstatic 421	com/vorobiev/sk/GameLayout:date	Lcom/vorobiev/objects/MyDate;
    //   210: invokevirtual 426	com/vorobiev/objects/MyDate:getDate	()Ljava/lang/String;
    //   213: putstatic 441	com/vorobiev/data/BestScoreData:dateMilliardBest	Ljava/lang/String;
    //   216: goto -57 -> 159
    //   219: lload 4
    //   221: ldc2_w 442
    //   224: lcmp
    //   225: iflt -66 -> 159
    //   228: getstatic 446	com/vorobiev/data/Player:isTrillion	Z
    //   231: ifne -72 -> 159
    //   234: getstatic 93	com/vorobiev/sk/MainActivity:myHandlers	Lcom/vorobiev/handler/MyHandlers;
    //   237: sipush 313
    //   240: iconst_3
    //   241: invokevirtual 411	com/vorobiev/handler/MyHandlers:send	(II)V
    //   244: getstatic 449	com/vorobiev/data/BestScoreData:cubok	I
    //   247: ifne +7 -> 254
    //   250: iconst_1
    //   251: putstatic 449	com/vorobiev/data/BestScoreData:cubok	I
    //   254: iconst_1
    //   255: putstatic 446	com/vorobiev/data/Player:isTrillion	Z
    //   258: getstatic 452	com/vorobiev/data/BestScoreData:dayTrillionBest	I
    //   261: getstatic 417	com/vorobiev/data/Player:livedDays	I
    //   264: if_icmple -105 -> 159
    //   267: getstatic 417	com/vorobiev/data/Player:livedDays	I
    //   270: putstatic 452	com/vorobiev/data/BestScoreData:dayTrillionBest	I
    //   273: getstatic 421	com/vorobiev/sk/GameLayout:date	Lcom/vorobiev/objects/MyDate;
    //   276: invokevirtual 426	com/vorobiev/objects/MyDate:getDate	()Ljava/lang/String;
    //   279: putstatic 455	com/vorobiev/data/BestScoreData:dateTrillionBest	Ljava/lang/String;
    //   282: goto -123 -> 159
    //   285: iconst_1
    //   286: putstatic 91	com/vorobiev/sk/MainActivity:mainActive	Z
    //   289: aload 6
    //   291: monitorexit
    //   292: return
    //   293: iconst_1
    //   294: putstatic 91	com/vorobiev/sk/MainActivity:mainActive	Z
    //   297: aload_3
    //   298: ldc_w 457
    //   301: iconst_0
    //   302: invokevirtual 463	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   305: iconst_1
    //   306: if_icmpne +124 -> 430
    //   309: aload_0
    //   310: iconst_1
    //   311: putfield 105	com/vorobiev/sk/MainActivity:mainMenu	Z
    //   314: new 407	com/vorobiev/handler/MyHandlers
    //   317: dup
    //   318: invokespecial 464	com/vorobiev/handler/MyHandlers:<init>	()V
    //   321: putstatic 93	com/vorobiev/sk/MainActivity:myHandlers	Lcom/vorobiev/handler/MyHandlers;
    //   324: getstatic 93	com/vorobiev/sk/MainActivity:myHandlers	Lcom/vorobiev/handler/MyHandlers;
    //   327: new 466	com/vorobiev/handler/LoadingGameHandler
    //   330: dup
    //   331: aload_0
    //   332: sipush 301
    //   335: invokespecial 469	com/vorobiev/handler/LoadingGameHandler:<init>	(Lcom/vorobiev/sk/MainActivity;I)V
    //   338: invokevirtual 473	com/vorobiev/handler/MyHandlers:registerHandler	(Lcom/vorobiev/handler/AbstractHandler;)V
    //   341: getstatic 93	com/vorobiev/sk/MainActivity:myHandlers	Lcom/vorobiev/handler/MyHandlers;
    //   344: new 475	com/vorobiev/handler/ButtonVisibleHandler
    //   347: dup
    //   348: aload_0
    //   349: sipush 314
    //   352: invokespecial 476	com/vorobiev/handler/ButtonVisibleHandler:<init>	(Lcom/vorobiev/sk/MainActivity;I)V
    //   355: invokevirtual 473	com/vorobiev/handler/MyHandlers:registerHandler	(Lcom/vorobiev/handler/AbstractHandler;)V
    //   358: aload_0
    //   359: ldc_w 477
    //   362: invokevirtual 480	com/vorobiev/sk/MainActivity:setContentView	(I)V
    //   365: aload_0
    //   366: invokespecial 121	com/vorobiev/sk/MainActivity:inflateButtonsMenu	()V
    //   369: aload_0
    //   370: getfield 482	com/vorobiev/sk/MainActivity:gameLayout	Lcom/vorobiev/sk/GameLayout;
    //   373: getstatic 488	com/vorobiev/sk/GameLayout$GLGameState:Finish	Lcom/vorobiev/sk/GameLayout$GLGameState;
    //   376: putfield 491	com/vorobiev/sk/GameLayout:state	Lcom/vorobiev/sk/GameLayout$GLGameState;
    //   379: aload_0
    //   380: getfield 482	com/vorobiev/sk/MainActivity:gameLayout	Lcom/vorobiev/sk/GameLayout;
    //   383: invokevirtual 494	com/vorobiev/sk/GameLayout:dispose	()V
    //   386: aload_0
    //   387: aconst_null
    //   388: putfield 482	com/vorobiev/sk/MainActivity:gameLayout	Lcom/vorobiev/sk/GameLayout;
    //   391: aload_0
    //   392: aload_0
    //   393: ldc_w 314
    //   396: invokevirtual 130	com/vorobiev/sk/MainActivity:findViewById	(I)Landroid/view/View;
    //   399: checkcast 319	com/vorobiev/surfaceHolder/FastRenderView
    //   402: putfield 321	com/vorobiev/sk/MainActivity:renderView	Lcom/vorobiev/surfaceHolder/FastRenderView;
    //   405: aload_0
    //   406: getfield 321	com/vorobiev/sk/MainActivity:renderView	Lcom/vorobiev/surfaceHolder/FastRenderView;
    //   409: new 323	com/vorobiev/surfaceHolder/Screen
    //   412: dup
    //   413: getstatic 97	com/vorobiev/sk/MainActivity:graphics	Lcom/vorobiev/surfaceHolder/MyGraphics;
    //   416: iconst_0
    //   417: invokespecial 326	com/vorobiev/surfaceHolder/Screen:<init>	(Lcom/vorobiev/surfaceHolder/IGraphics;I)V
    //   420: invokevirtual 330	com/vorobiev/surfaceHolder/FastRenderView:registerGraphics	(Lcom/vorobiev/surfaceHolder/AbstractScreen;)V
    //   423: aload_0
    //   424: getfield 321	com/vorobiev/sk/MainActivity:renderView	Lcom/vorobiev/surfaceHolder/FastRenderView;
    //   427: invokevirtual 497	com/vorobiev/surfaceHolder/FastRenderView:resume	()V
    //   430: aload 6
    //   432: monitorexit
    //   433: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	434	0	this	MainActivity
    //   0	434	1	paramInt1	int
    //   0	434	2	paramInt2	int
    //   0	434	3	paramIntent	Intent
    //   104	116	4	l	long
    //   10	421	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   52	55	76	finally
    //   56	75	76	finally
    //   77	80	76	finally
    //   82	106	76	finally
    //   115	159	76	finally
    //   159	162	76	finally
    //   172	216	76	finally
    //   228	254	76	finally
    //   254	282	76	finally
    //   285	292	76	finally
    //   293	430	76	finally
    //   430	433	76	finally
  }
  
  @SuppressLint({"InflateParams"})
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
    this.main_view = getLayoutInflater().inflate(2130903043, null);
    if (logo)
    {
      setContentView(2130903058);
      paramBundle = (VideoView)findViewById(2131362007);
      paramBundle.setVideoURI(Uri.parse("android.resource://com.vorobiev.sk/2131034112"));
      paramBundle.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
      {
        public void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
        {
          MainActivity.logo = false;
          MainActivity.this.setContentView(MainActivity.this.main_view);
          MainActivity.this.inflateButtonsMenu();
        }
      });
      paramBundle.start();
    }
    for (;;)
    {
      graphics = new MyGraphics(this);
      this.audio = new GameAudio(this);
      loadRenderView();
      fileIO = new AndroidFileIO(getAssets());
      this.dialogNewGame = new DialogNewGame(this);
      myHandlers = new MyHandlers();
      myHandlers.registerHandler(new LoadingGameHandler(this, 301));
      myHandlers.registerHandler(new ButtonVisibleHandler(this, 314));
      initialScore();
      return;
      setContentView(this.main_view);
      inflateButtonsMenu();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt == 4)
    {
      bool1 = bool2;
      if (!this.mainMenu)
      {
        paramKeyEvent = new Intent();
        paramKeyEvent.setClass(this, ActivityPause.class);
        startActivityForResult(paramKeyEvent, 204);
        mainActive = false;
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void onPause()
  {
    if (this.gameLayout != null) {
      synchronized (this.gameLayout.changed)
      {
        if (isFinishing()) {
          this.gameLayout.state = GameLayout.GLGameState.Finish;
        }
      }
    }
    try
    {
      for (;;)
      {
        this.gameLayout.changed.wait();
        this.gameLayout.glView.onPause();
        super.onPause();
        return;
        if (mainActive)
        {
          Intent localIntent = new Intent();
          localIntent.setClass(this, ActivityPause.class);
          startActivityForResult(localIntent, 204);
          mainActive = false;
        }
        this.gameLayout.state = GameLayout.GLGameState.Pause;
      }
      localObject2 = finally;
      throw ((Throwable)localObject2);
      if (isFinishing())
      {
        this.renderView.stop();
        myHandlers.dispose();
        myHandlers = null;
        fileIO = null;
        graphics = null;
        startLoading = false;
        countLoading = 0;
        mainActive = true;
      }
      for (;;)
      {
        logo = true;
        break;
        this.renderView.pause();
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.gameLayout != null)
    {
      this.gameLayout.glView.onResume();
      return;
    }
    this.renderView.resume();
  }
  
  public void visibleButtons()
  {
    this.btn_authors.setVisibility(0);
    if (BestScoreData.isFile) {
      this.btn_continue_game.setVisibility(0);
    }
    this.btn_help.setVisibility(0);
    this.btn_main_exit.setVisibility(0);
    this.btn_records.setVisibility(0);
    this.new_game.setVisibility(0);
    this.label.setVisibility(0);
    this.btn_volume.setVisibility(0);
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\sk\MainActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */