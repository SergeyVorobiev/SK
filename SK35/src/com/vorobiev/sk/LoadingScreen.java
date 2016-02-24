package com.vorobiev.sk;

import com.vorobiev.gameInterface.Audio;
import com.vorobiev.gameInterface.Game;
import com.vorobiev.gameInterface.ScreeN;
import com.vorobiev.gameclass.Assets;
import com.vorobiev.glInstruments.Texture;
import com.vorobiev.glInstruments.TextureRegion;

public class LoadingScreen
  extends ScreeN
{
  Audio audio;
  Game game;
  
  public LoadingScreen(Game paramGame, MainActivity paramMainActivity)
  {
    super(paramGame, paramMainActivity);
    this.game = paramGame;
    this.audio = paramMainActivity.getAudio();
  }
  
  public void dispose() {}
  
  public void pause() {}
  
  public void present(float paramFloat) {}
  
  public void resume() {}
  
  public void update(float paramFloat)
  {
    Assets.gameTexture = new Texture(this.game, "picture/building.png", 1024, 256);
    int i = 0;
    if (i >= 16) {
      i = 0;
    }
    for (;;)
    {
      if (i >= 9)
      {
        Assets.construction = new TextureRegion(Assets.gameTexture, 0.0F, 192.0F, 64.0F, 64.0F);
        Assets.snow = new TextureRegion(Assets.gameTexture, 64.0F, 192.0F, 64.0F, 64.0F);
        Assets.endResource = new TextureRegion(Assets.gameTexture, 128.0F, 192.0F, 64.0F, 64.0F);
        Assets.fire = new TextureRegion(Assets.gameTexture, 192.0F, 192.0F, 64.0F, 64.0F);
        Assets.notPeople = new TextureRegion(Assets.gameTexture, 256.0F, 192.0F, 64.0F, 64.0F);
        Assets.upgrade = new TextureRegion(Assets.gameTexture, 320.0F, 192.0F, 64.0F, 64.0F);
        Assets.lock = new TextureRegion(Assets.gameTexture, 384.0F, 192.0F, 64.0F, 64.0F);
        Assets.plus = new TextureRegion(Assets.gameTexture, 448.0F, 192.0F, 64.0F, 64.0F);
        Assets.ransom = new TextureRegion(Assets.gameTexture, 512.0F, 192.0F, 64.0F, 64.0F);
        Assets.explosion = this.audio.newSound("sound/explosionTwo.mp3");
        Assets.build = this.audio.newSound("sound/build.mp3");
        Assets.money = this.audio.newSound("sound/money.mp3");
        Assets.no = this.audio.newSound("sound/no.mp3");
        Assets.no3 = this.audio.newSound("sound/no3.mp3");
        Assets.repair = this.audio.newSound("sound/repair.mp3");
        Assets.chuh = this.audio.newSound("sound/chuh.mp3");
        Assets.close = this.audio.newSound("sound/close.mp3");
        Assets.ransom_sound = this.audio.newSound("sound/ransom.mp3");
        Assets.update = this.audio.newSound("sound/update.mp3");
        Assets.sound_dialog1 = this.audio.newSound("sound/sound_dialog1.mp3");
        Assets.sound_dialog2 = this.audio.newSound("sound/sound_dialog2.mp3");
        Assets.tick = this.audio.newSound("sound/tickTwo.mp3");
        Assets.clickThree = this.audio.newSound("sound/clickThree.mp3");
        Assets.clickFour = this.audio.newSound("sound/clickFour.mp3");
        Assets.clickFive = this.audio.newSound("sound/clickFive.mp3");
        Assets.clickSix = this.audio.newSound("sound/clickSix.mp3");
        Assets.congratulation = this.audio.newSound("sound/congratulation.mp3");
        this.game.setScreen(new GameScreen(this.game, this.activity));
        return;
        Assets.buildings[i] = new TextureRegion(Assets.gameTexture, i * 64, 0.0F, 64.0F, 64.0F);
        Assets.buildings[(i + 16)] = new TextureRegion(Assets.gameTexture, i * 64, 64.0F, 64.0F, 64.0F);
        i += 1;
        break;
      }
      Assets.map[i] = new TextureRegion(Assets.gameTexture, i * 64, 128.0F, 64.0F, 64.0F);
      i += 1;
    }
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\sk\LoadingScreen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */