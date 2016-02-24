package com.vorobiev.surfaceHolder;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.vorobiev.data.BestScoreData;
import com.vorobiev.gameclass.Assets;
import com.vorobiev.sk.MainActivity;

public class Screen
  extends AbstractScreen
{
  public static final int ACTIV_PAUSE = 1;
  public static final int ACTIV_START = 0;
  private MyAnimation animCubokSilver;
  private ChampionView championView;
  private IGraphics.Coordinates coords;
  private int curActivity = 0;
  private GoldCapView goldCapView;
  private int heightLabel = 150;
  private Rect rect;
  
  public Screen(IGraphics paramIGraphics, int paramInt)
  {
    super(paramIGraphics);
    this.curActivity = paramInt;
    this.rect = new Rect(0, 0, paramIGraphics.getWidth(), paramIGraphics.getHeight());
    MyAnimation localMyAnimation1 = new MyAnimation(Assets.cubokAnim, 0.07F);
    MyAnimation localMyAnimation2 = new MyAnimation(Assets.ten_trln, 0.07F, 0.0F, true);
    localMyAnimation1.setDelay(4.0F);
    this.goldCapView = new GoldCapView(localMyAnimation1, 280, 220, 150, 120);
    this.championView = new ChampionView(localMyAnimation2, 200, 200, 710, 110);
    this.animCubokSilver = new MyAnimation(Assets.cubokAnimSilver, 0.07F);
    this.animCubokSilver.setDelay(4.0F);
    this.coords = new IGraphics.Coordinates();
    this.coords.coordsOnPictureX = 0;
    this.coords.coordsOnPictureY = 0;
    this.coords.coordsOnScreenX = (paramIGraphics.getWidth() / 2);
    this.coords.coordsOnScreenY = (paramIGraphics.getHeight() / 2);
    this.coords.widthOnScreen = 300;
    this.coords.heightOnScreen = 20;
    this.coords.widthOnPicture = Assets.progress.getWidth();
    this.coords.heightOnPicture = Assets.progress.getHeight();
  }
  
  private void breaking()
  {
    if (MainActivity.countLoading < 100) {}
    try
    {
      Thread.sleep(100L);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
      throw new RuntimeException("Поток не смог заснуть в классе Screen");
    }
  }
  
  private void drawScore(Bitmap[] paramArrayOfBitmap, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 0;
    long l = paramLong;
    int j = paramInt3 / 2;
    if (l == 0L) {
      paramInt1 = i * j + paramInt1 - j;
    }
    for (;;)
    {
      if (paramLong == 0L)
      {
        return;
        l /= 10L;
        i += 1;
        break;
      }
      i = (int)(paramLong % 10L);
      paramLong /= 10L;
      this.graphics.drawBitmapInCenterXY(paramArrayOfBitmap[i], paramInt1, paramInt2, paramInt3, paramInt4);
      paramInt1 -= paramInt3;
    }
  }
  
  private void gameBackground(float paramFloat)
  {
    if (this.curActivity == 0)
    {
      this.graphics.drawBitmapSizeOfRect(Assets.background_screen, this.rect);
      if (BestScoreData.cubok == 2) {
        this.graphics.drawObject(this.goldCapView, paramFloat);
      }
    }
    label255:
    label313:
    do
    {
      break label255;
      if (BestScoreData.cubok > 0) {
        drawScore(Assets.numbers, BestScoreData.scoreBest, 150, 180, 16, 24);
      }
      if (BestScoreData.summMoney >= 4000000000000L) {
        drawScore(Assets.numbersRed, BestScoreData.summMoney, 665, 455, 26, 35);
      }
      if (BestScoreData.summMoney >= 10000000000000L) {
        this.graphics.drawObject(this.championView, paramFloat);
      }
      for (;;)
      {
        if ((!MainActivity.startLoading) || (this.curActivity != 0)) {
          break label313;
        }
        this.graphics.drawBitmapInCenterXY(Assets.background_loading, this.graphics.getWidth() / 2, this.graphics.getHeight() / 2, 300, 20);
        this.graphics.drawLoading(Assets.progress, this.graphics.getWidth() / 2, this.graphics.getHeight() / 2, 300, 20, MainActivity.countLoading);
        this.graphics.drawBitmapInCenterXY(Assets.background_label, this.graphics.getWidth() / 2, this.heightLabel, 270, 100);
        breaking();
        return;
        if (BestScoreData.cubok != 1) {
          break;
        }
        this.graphics.drawBitmapInCenterXY(this.animCubokSilver.getCurFrame(paramFloat), 150, 120, 280, 220);
        break;
        this.graphics.drawBitmapSizeOfRect(Assets.background_pause, this.rect);
      }
    } while ((!MainActivity.startLoading) || (this.curActivity != 1));
    this.graphics.drawBitmapInCenterXY(Assets.background_loading, this.graphics.getWidth() / 2, this.graphics.getHeight() / 2, 300, 20);
    this.graphics.drawLoading(Assets.progress, this.graphics.getWidth() / 2, this.graphics.getHeight() / 2, 300, 20, MainActivity.countLoading);
    breaking();
  }
  
  public void present(float paramFloat)
  {
    gameBackground(paramFloat);
  }
  
  public void update(float paramFloat)
  {
    this.heightLabel = (MainActivity.countLoading + 50);
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\surfaceHolder\Screen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */