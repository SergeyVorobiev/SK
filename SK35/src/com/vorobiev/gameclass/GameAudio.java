package com.vorobiev.gameclass;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.SoundPool;
import com.vorobiev.gameInterface.Audio;
import com.vorobiev.gameInterface.Sound;
import com.vorobiev.sk.MainActivity;
import java.io.IOException;

public class GameAudio
  implements Audio
{
  private AssetManager manager;
  private SoundPool soundPool;
  
  public GameAudio(MainActivity paramMainActivity)
  {
    paramMainActivity.setVolumeControlStream(3);
    this.soundPool = new SoundPool(40, 3, 0);
    this.manager = paramMainActivity.getAssets();
  }
  
  public Sound newSound(String paramString)
  {
    try
    {
      Object localObject = this.manager.openFd(paramString);
      localObject = new GameSound(this.soundPool, this.soundPool.load((AssetFileDescriptor)localObject, 0));
      return (Sound)localObject;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      throw new RuntimeException("Невозможно загрузить звук " + paramString);
    }
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\gameclass\GameAudio.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */