package com.vorobiev.data;

import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.vorobiev.gameInterface.FileIO;
import com.vorobiev.sk.MainActivity;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;

public class LoadingData
{
  public static void LoadGame(FileIO paramFileIO)
  {
    try
    {
      paramFileIO = new ObjectInputStream(paramFileIO.readFile("save.sk"));
      return;
    }
    catch (StreamCorruptedException paramFileIO)
    {
      try
      {
        Player.load(paramFileIO);
        RadarData.load(paramFileIO);
        RandomResource.load(paramFileIO);
        return;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        localClassNotFoundException.printStackTrace();
        return;
        paramFileIO = paramFileIO;
        MainActivity.fileIO.deleteFile("save.sk");
        return;
      }
      finally
      {
        paramFileIO.close();
      }
    }
    catch (IOException paramFileIO)
    {
      paramFileIO.printStackTrace();
    }
  }
  
  /* Error */
  public static void SaveGame(FileIO paramFileIO)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: new 63	java/io/ObjectOutputStream
    //   7: dup
    //   8: aload_0
    //   9: ldc 21
    //   11: invokeinterface 67 2 0
    //   16: invokespecial 70	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   19: astore_0
    //   20: aload_0
    //   21: invokestatic 74	com/vorobiev/data/Player:save	(Ljava/io/ObjectOutputStream;)V
    //   24: aload_0
    //   25: invokestatic 75	com/vorobiev/data/RadarData:save	(Ljava/io/ObjectOutputStream;)V
    //   28: aload_0
    //   29: invokestatic 76	com/vorobiev/data/RandomResource:save	(Ljava/io/ObjectOutputStream;)V
    //   32: aload_0
    //   33: invokevirtual 77	java/io/ObjectOutputStream:close	()V
    //   36: return
    //   37: astore_1
    //   38: aload_2
    //   39: astore_0
    //   40: aload_1
    //   41: astore_2
    //   42: aload_0
    //   43: astore_1
    //   44: aload_2
    //   45: invokevirtual 60	java/io/IOException:printStackTrace	()V
    //   48: aload_0
    //   49: invokevirtual 77	java/io/ObjectOutputStream:close	()V
    //   52: return
    //   53: astore_0
    //   54: aload_0
    //   55: invokevirtual 60	java/io/IOException:printStackTrace	()V
    //   58: return
    //   59: astore_0
    //   60: aload_1
    //   61: invokevirtual 77	java/io/ObjectOutputStream:close	()V
    //   64: aload_0
    //   65: athrow
    //   66: astore_1
    //   67: aload_1
    //   68: invokevirtual 60	java/io/IOException:printStackTrace	()V
    //   71: goto -7 -> 64
    //   74: astore_0
    //   75: aload_0
    //   76: invokevirtual 60	java/io/IOException:printStackTrace	()V
    //   79: return
    //   80: astore_2
    //   81: aload_0
    //   82: astore_1
    //   83: aload_2
    //   84: astore_0
    //   85: goto -25 -> 60
    //   88: astore_2
    //   89: goto -47 -> 42
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	paramFileIO	FileIO
    //   1	1	1	localObject1	Object
    //   37	4	1	localIOException1	IOException
    //   43	18	1	localFileIO1	FileIO
    //   66	2	1	localIOException2	IOException
    //   82	1	1	localFileIO2	FileIO
    //   3	42	2	localIOException3	IOException
    //   80	4	2	localObject2	Object
    //   88	1	2	localIOException4	IOException
    // Exception table:
    //   from	to	target	type
    //   4	20	37	java/io/IOException
    //   48	52	53	java/io/IOException
    //   4	20	59	finally
    //   44	48	59	finally
    //   60	64	66	java/io/IOException
    //   32	36	74	java/io/IOException
    //   20	32	80	finally
    //   20	32	88	java/io/IOException
  }
  
  public static void newGame(MainActivity paramMainActivity)
  {
    Player.initialPlayer();
    paramMainActivity = (FrameLayout)paramMainActivity.findViewById(2131361940);
    float f = paramMainActivity.getPaddingLeft() * 2;
    RadarData.initialized(paramMainActivity.getLayoutParams().width - f, paramMainActivity.getLayoutParams().height - f);
    RandomResource.initializeResource();
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\data\LoadingData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */