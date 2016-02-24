package com.vorobiev.gameclass;

import android.media.SoundPool;
import com.vorobiev.gameInterface.Sound;

public class GameSound
  implements Sound
{
  public static boolean isVolume = true;
  private int soundId;
  private SoundPool soundPool;
  
  public GameSound(SoundPool paramSoundPool, int paramInt)
  {
    this.soundPool = paramSoundPool;
    this.soundId = paramInt;
  }
  
  public void dispose()
  {
    this.soundPool.unload(this.soundId);
  }
  
  public void play(float paramFloat)
  {
    if (isVolume) {
      this.soundPool.play(this.soundId, paramFloat, paramFloat, 0, 0, 1.0F);
    }
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\gameclass\GameSound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */