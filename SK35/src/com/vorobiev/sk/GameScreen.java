package com.vorobiev.sk;

import com.vorobiev.buildings.Build;
import com.vorobiev.data.Player;
import com.vorobiev.data.RadarData;
import com.vorobiev.data.RandomResource;
import com.vorobiev.gameInterface.Game;
import com.vorobiev.gameInterface.Input;
import com.vorobiev.gameInterface.Input.TouchEvent;
import com.vorobiev.gameInterface.ScreeN;
import com.vorobiev.gameInterface.Sound;
import com.vorobiev.gameclass.Assets;
import com.vorobiev.glInstruments.Camera2D;
import com.vorobiev.glInstruments.JoltOfCamera;
import com.vorobiev.glInstruments.SpriteBatcher;
import com.vorobiev.glInstruments.Texture;
import com.vorobiev.glInstruments.ZeoVector;
import com.vorobiev.handler.InfoHandler;
import com.vorobiev.handler.MyHandlers;
import com.vorobiev.objects.GLGraphics;
import com.vorobiev.objects.MapPlace;
import com.vorobiev.objects.MyFrame;
import com.vorobiev.objects.ViewRadar;
import java.util.ArrayList;
import javax.microedition.khronos.opengles.GL10;

public class GameScreen
  extends ScreeN
{
  public static JoltOfCamera joltCamera;
  private SpriteBatcher batcher;
  private boolean blockZoom = false;
  private int bottom;
  private Camera2D camera;
  private float diffX = 0.0F;
  private float diffY = 0.0F;
  private boolean dragged = false;
  private Game game;
  private GameLayout gameLayout;
  private Texture gameMap;
  private GLGraphics graphics;
  private float heightVisible = 0.0F;
  private float heightWorld = 98.0F;
  private int lastClick;
  private int left;
  private MyFrame myFrame = new MyFrame();
  private boolean offset = false;
  private int pickId;
  private boolean pickIsBuild;
  private boolean pickOut = false;
  private float ratioRadarToWorldHeight;
  private float ratioRadarToWorldWidth;
  private int right;
  private ZeoVector tempTouchPosition = new ZeoVector();
  private float timeFPS;
  private float timeTouch;
  private float timerDoubleClick = 0.0F;
  private boolean timerDoubleClickActivated = false;
  private int top;
  private ZeoVector touchPosition = new ZeoVector();
  private ZeoVector touchToScreen = new ZeoVector();
  private ZeoVector touchToScreenTwo = new ZeoVector();
  private float widthVisible = 12.0F;
  private float widthWorld = 147.0F;
  private boolean zoom = false;
  
  public GameScreen(Game paramGame, MainActivity paramMainActivity)
  {
    super(paramGame, paramMainActivity);
    MainActivity.myHandlers.registerHandler(new InfoHandler(302));
    this.gameLayout = ((GameLayout)paramGame);
    this.game = paramGame;
    this.graphics = paramGame.getGLGraphics();
    this.heightVisible = (this.widthVisible / this.graphics.getRatio());
    this.camera = new Camera2D(this.graphics, this.widthVisible, this.heightVisible, this.widthWorld, this.heightWorld);
    this.gameLayout.camera = this.camera;
    GameLayout.listenerLeftPanel.cameraActivated(this.camera);
    this.gameMap = Assets.gameTexture;
    this.camera.setPositionOfIndex(RandomResource.firstCity);
    RandomResource.map[RandomResource.firstCity].isPickOut = true;
    this.ratioRadarToWorldWidth = (RadarData.width / this.widthWorld);
    this.ratioRadarToWorldHeight = (RadarData.height / this.heightWorld);
    RadarData.positionX = this.camera.position.x * this.ratioRadarToWorldWidth;
    RadarData.positionY = RadarData.height - this.camera.position.y * this.ratioRadarToWorldHeight;
    RadarData.frameWidthToCenter = this.camera.centerToBoundsX * this.ratioRadarToWorldWidth;
    RadarData.frameHeightToCenter = this.camera.centerToBoundsY * this.ratioRadarToWorldHeight;
    MainActivity.myHandlers.send(304);
    this.batcher = new SpriteBatcher(this.graphics, 10000);
    joltCamera = new JoltOfCamera(10, 1.0F);
    this.camera.jolt = joltCamera;
    if (this.gameLayout.newGame) {
      MainActivity.myHandlers.send(307, 6);
    }
  }
  
  private void drag(float paramFloat1, float paramFloat2, Input.TouchEvent paramTouchEvent)
  {
    this.camera.translate(paramFloat1, paramFloat2);
    paramFloat1 = this.camera.centerToBoundsX;
    paramFloat2 = this.camera.centerToBoundsY;
    if (this.camera.position.x < paramFloat1) {
      this.camera.position.x = paramFloat1;
    }
    if (this.camera.position.y < paramFloat2) {
      this.camera.position.y = paramFloat2;
    }
    if (this.camera.position.x + paramFloat1 > this.widthWorld) {
      this.camera.position.x = (this.widthWorld - paramFloat1);
    }
    if (this.camera.position.y + paramFloat2 > this.heightWorld) {
      this.camera.position.y = (this.heightWorld - paramFloat2);
    }
    this.tempTouchPosition.set(this.touchToScreen);
    this.camera.touchToWorld(this.touchPosition.set(paramTouchEvent.x, paramTouchEvent.y));
    paramFloat1 = this.camera.position.x;
    paramFloat2 = this.ratioRadarToWorldWidth;
    float f1 = this.camera.position.y;
    float f2 = this.ratioRadarToWorldHeight;
    RadarData.positionX = paramFloat1 * paramFloat2;
    RadarData.positionY = RadarData.height - f1 * f2;
    GameLayout.radar.postInvalidate();
  }
  
  private void drawingBorder()
  {
    int i = (int)this.camera.position.x + 1;
    int j = (int)this.camera.position.y + 1;
    this.left = (i - 16);
    if (this.left < 0) {
      this.left = 0;
    }
    this.right = (i + 15);
    if (this.right > 146) {
      this.right = 146;
    }
    this.top = (j + 13);
    if (this.top > 97) {
      this.top = 97;
    }
    this.bottom = (j - 13);
    if (this.bottom < 0) {
      this.bottom = 0;
    }
  }
  
  private void onDoubleClick(int paramInt)
  {
    int j = 0;
    int i = 0;
    RandomResource.RecoverySizePick = 0L;
    RandomResource.sizePick = 0;
    int m;
    if (RandomResource.map[paramInt].isBuilding == null)
    {
      m = RandomResource.map[paramInt].type;
      paramInt = 0;
      if (paramInt < 98) {}
    }
    int[] arrayOfInt;
    label191:
    boolean bool;
    for (;;)
    {
      RandomResource.multiplePick();
      MainActivity.myHandlers.send(303);
      return;
      j = 0;
      if (j >= 147)
      {
        paramInt += 1;
        break;
      }
      k = 0;
      for (;;)
      {
        if (k >= 6) {}
        for (;;)
        {
          i += 1;
          j += 1;
          break;
          arrayOfInt = com.vorobiev.objects.CityBounds.placeCityCoords[k];
          if (((m != 7) && ((arrayOfInt[0] != 1) || (arrayOfInt[3] > j) || (arrayOfInt[4] < j) || (arrayOfInt[6] > paramInt) || (arrayOfInt[5] < paramInt))) || (RandomResource.map[i].type != m) || (RandomResource.map[i].isBuilding != null)) {
            break label191;
          }
          RandomResource.sizePick += 1;
          RandomResource.map[i].isPickOut = true;
        }
        k += 1;
      }
      m = RandomResource.map[paramInt].isBuilding.getId();
      bool = RandomResource.map[paramInt].isBuilding.getClose();
      paramInt = 0;
      i = j;
      while (paramInt < 98)
      {
        j = 0;
        if (j < 147) {
          break label256;
        }
        paramInt += 1;
      }
    }
    label256:
    int k = 0;
    for (;;)
    {
      if (k >= 6) {}
      for (;;)
      {
        i += 1;
        j += 1;
        break;
        arrayOfInt = com.vorobiev.objects.CityBounds.placeCityCoords[k];
        if ((arrayOfInt[0] != 1) || (arrayOfInt[3] > j) || (arrayOfInt[4] < j) || (arrayOfInt[6] > paramInt) || (arrayOfInt[5] < paramInt) || (RandomResource.map[i].isBuilding == null) || (RandomResource.map[i].isBuilding.getId() != m) || (bool != RandomResource.map[i].isBuilding.getClose())) {
          break label414;
        }
        RandomResource.sizePick += 1;
        RandomResource.map[i].isPickOut = true;
        RandomResource.RecoverySizePick += RandomResource.map[i].isBuilding.getPriceRecovery();
      }
      label414:
      k += 1;
    }
  }
  
  private void onMyClick(ZeoVector paramZeoVector)
  {
    RandomResource.RecoverySizePick = 0L;
    int j = (int)paramZeoVector.x;
    int k = (int)paramZeoVector.y;
    int i = 0;
    for (;;)
    {
      if (i >= 6) {}
      do
      {
        return;
        paramZeoVector = com.vorobiev.objects.CityBounds.placeCityCoords[i];
        if (((paramZeoVector[0] != 1) || (paramZeoVector[3] > j) || (paramZeoVector[4] < j) || (paramZeoVector[6] > k) || (paramZeoVector[5] < k)) && ((paramZeoVector[1] != j) || (paramZeoVector[2] != k))) {
          break;
        }
        i = 0;
        for (;;)
        {
          if (i >= RandomResource.map.length)
          {
            RandomResource.firstPick = k * 147 + j;
            RandomResource.map[RandomResource.firstPick].isPickOut = true;
            if (RandomResource.map[RandomResource.firstPick].isBuilding != null) {
              RandomResource.RecoverySizePick += RandomResource.map[RandomResource.firstPick].isBuilding.getPriceRecovery();
            }
            RandomResource.singlePick(RandomResource.firstPick);
            RandomResource.sizePick = 1;
            MainActivity.myHandlers.send(303);
            if (this.timerDoubleClickActivated) {
              break;
            }
            this.lastClick = RandomResource.firstPick;
            this.timerDoubleClickActivated = true;
            Assets.clickSix.play(0.7F);
            return;
          }
          RandomResource.map[i].isPickOut = false;
          i += 1;
        }
      } while (this.lastClick != RandomResource.firstPick);
      onDoubleClick(this.lastClick);
      this.timerDoubleClickActivated = false;
      this.timerDoubleClick = 0.0F;
      Assets.clickFour.play(0.5F);
      return;
      i += 1;
    }
  }
  
  private void onPick(ZeoVector paramZeoVector)
  {
    int k = (int)paramZeoVector.x;
    int m = (int)paramZeoVector.y;
    int n = m * 147 + k;
    int i1;
    int i;
    int j;
    if (RandomResource.map[n].isBuilding != null)
    {
      i1 = 1;
      i = RandomResource.map[n].isBuilding.getId();
      j = 0;
    }
    for (;;)
    {
      if (j >= 6) {}
      for (;;)
      {
        MainActivity.myHandlers.send(303);
        return;
        i = RandomResource.map[n].type;
        i1 = 0;
        break;
        paramZeoVector = com.vorobiev.objects.CityBounds.placeCityCoords[j];
        if ((paramZeoVector[0] != 1) || (paramZeoVector[3] > k) || (paramZeoVector[4] < k) || (paramZeoVector[6] > m) || (paramZeoVector[5] < m)) {
          break label231;
        }
        if ((i == this.pickId) && (i1 == this.pickIsBuild) && (!RandomResource.map[n].isPickOut))
        {
          RandomResource.sizePick += 1;
          RandomResource.map[n].isPickOut = true;
          Assets.tick.play(1.0F);
          if (RandomResource.map[n].isBuilding != null) {
            RandomResource.RecoverySizePick += RandomResource.map[n].isBuilding.getPriceRecovery();
          }
          RandomResource.multiplePick();
        }
      }
      label231:
      j += 1;
    }
  }
  
  private void stretch(ZeoVector paramZeoVector, int paramInt)
  {
    if (this.blockZoom) {
      return;
    }
    if ((!this.game.getInputTouch().isTouchDown(0)) || (!this.game.getInputTouch().isTouchDown(1)))
    {
      this.blockZoom = true;
      return;
    }
    float f2 = Math.abs(this.touchToScreen.x - this.touchToScreenTwo.x) - this.diffX;
    this.diffX = Math.abs(this.touchToScreen.x - this.touchToScreenTwo.x);
    float f4 = Math.abs(this.touchToScreen.y - this.touchToScreenTwo.y) - this.diffY;
    this.diffY = Math.abs(this.touchToScreen.y - this.touchToScreenTwo.y);
    if (((f2 >= 0.0F) && (f4 >= 0.0F)) || ((f2 <= 0.0F) && (f4 <= 0.0F)))
    {
      f3 = f4;
      f1 = f3;
      if (f2 > 0.0F)
      {
        f1 = f3;
        if (f2 > f4) {
          f1 = f2;
        }
      }
      f3 = f1;
      if (f2 < 0.0F)
      {
        f3 = f1;
        if (f2 < f4) {
          f3 = f2;
        }
      }
      this.camera.addZoom(f3);
    }
    float f1 = this.camera.position.x;
    f2 = this.ratioRadarToWorldWidth;
    float f3 = this.camera.position.y;
    f4 = this.ratioRadarToWorldHeight;
    RadarData.frameWidthToCenter = this.camera.centerToBoundsX * this.ratioRadarToWorldWidth;
    RadarData.frameHeightToCenter = this.camera.centerToBoundsY * this.ratioRadarToWorldHeight;
    RadarData.positionX = f1 * f2;
    RadarData.positionY = RadarData.height - f3 * f4 - 1.0F;
    GameLayout.radar.postInvalidate();
  }
  
  private void touchHandler(float paramFloat, ArrayList<Input.TouchEvent> paramArrayList)
  {
    if (this.timerDoubleClickActivated)
    {
      this.timerDoubleClick += paramFloat;
      if (this.timerDoubleClick >= 0.3F)
      {
        this.timerDoubleClick = 0.0F;
        this.timerDoubleClickActivated = false;
      }
    }
    int j = 1;
    int k = 0;
    if (k >= paramArrayList.size()) {
      return;
    }
    Input.TouchEvent localTouchEvent = (Input.TouchEvent)paramArrayList.get(k);
    if ((localTouchEvent.type == 0) && (localTouchEvent.Id == 0))
    {
      this.timeTouch = 0.0F;
      this.camera.touchToWorld(this.touchPosition.set(localTouchEvent.x, localTouchEvent.y));
      this.camera.touchToScreen(this.touchToScreen.set(localTouchEvent.x, localTouchEvent.y));
      this.tempTouchPosition.set(this.touchToScreen);
      if (this.game.getInputTouch().isTouchDown(1))
      {
        this.diffX = Math.abs(this.touchToScreen.x - this.touchToScreenTwo.x);
        this.diffY = Math.abs(this.touchToScreen.y - this.touchToScreenTwo.y);
      }
    }
    if ((localTouchEvent.type == 0) && (localTouchEvent.Id == 1) && (!this.pickOut) && (!this.dragged))
    {
      this.camera.touchToScreen(this.touchToScreenTwo.set(localTouchEvent.x, localTouchEvent.y));
      this.diffX = Math.abs(this.touchToScreen.x - this.touchToScreenTwo.x);
      this.diffY = Math.abs(this.touchToScreen.y - this.touchToScreenTwo.y);
      this.zoom = true;
    }
    int m = j;
    float f1;
    float f2;
    int i;
    if (localTouchEvent.type == 2)
    {
      m = j;
      if (localTouchEvent.Id == 0)
      {
        this.camera.touchToScreen(this.touchToScreen.set(localTouchEvent.x, localTouchEvent.y));
        f1 = this.tempTouchPosition.x - this.touchToScreen.x;
        f2 = this.tempTouchPosition.y - this.touchToScreen.y;
        i = j;
        if (j != 0)
        {
          i = j;
          if (!this.pickOut)
          {
            this.timeTouch += paramFloat;
            i = 0;
          }
        }
        if ((this.timeTouch > 0.3F) && (!this.zoom) && (!this.dragged) && (!this.pickOut))
        {
          j = (int)this.touchPosition.x;
          j = (int)this.touchPosition.y * 147 + j;
          if (RandomResource.map[j].isBuilding == null) {
            break label860;
          }
          this.pickIsBuild = true;
          this.pickId = RandomResource.map[j].isBuilding.getId();
          label529:
          this.pickOut = true;
          Assets.clickTwo.play(1.0F);
          onPick(this.touchPosition);
        }
        if ((!this.offset) && ((Math.abs(f1) >= 0.2F) || (Math.abs(f2) >= 0.2F))) {
          this.offset = true;
        }
        m = i;
        if (this.offset)
        {
          if (this.pickOut) {
            break label908;
          }
          if (!this.zoom) {
            this.dragged = true;
          }
          if (!this.zoom) {
            break label881;
          }
          stretch(this.touchToScreen, 1);
          m = i;
        }
      }
    }
    for (;;)
    {
      if ((localTouchEvent.type == 2) && (localTouchEvent.Id == 1))
      {
        this.camera.touchToScreen(this.touchToScreenTwo.set(localTouchEvent.x, localTouchEvent.y));
        if (this.zoom) {
          stretch(this.touchToScreenTwo, 2);
        }
      }
      if ((localTouchEvent.type == 1) && (localTouchEvent.Id == 0))
      {
        this.dragged = false;
        this.pickOut = false;
        this.offset = false;
        if (this.timeTouch < 0.15F)
        {
          this.camera.touchToWorld(this.touchPosition.set(localTouchEvent.x, localTouchEvent.y));
          onMyClick(this.touchPosition);
        }
        if (!this.game.getInputTouch().isTouchDown(1))
        {
          this.zoom = false;
          this.blockZoom = false;
        }
      }
      if ((localTouchEvent.type == 1) && (localTouchEvent.Id == 1) && (!this.game.getInputTouch().isTouchDown(0)))
      {
        this.zoom = false;
        this.blockZoom = false;
      }
      k += 1;
      j = m;
      break;
      label860:
      this.pickId = RandomResource.map[j].type;
      this.pickIsBuild = false;
      break label529;
      label881:
      m = i;
      if (this.dragged)
      {
        drag(f1, f2, localTouchEvent);
        m = i;
        continue;
        label908:
        m = i;
        if (this.pickOut)
        {
          this.camera.touchToWorld(this.touchPosition.set(localTouchEvent.x, localTouchEvent.y));
          onPick(this.touchPosition);
          m = i;
        }
      }
    }
  }
  
  public void dispose()
  {
    joltCamera = null;
    Assets.gameTexture.unbind();
  }
  
  public void pause() {}
  
  public void present(float paramFloat)
  {
    if (Player.info)
    {
      this.timeFPS += paramFloat;
      if (this.timeFPS > 0.1F)
      {
        this.timeFPS = 0.0F;
        GameLayout.fps = 1.0F / paramFloat;
        MainActivity.myHandlers.send(302);
      }
    }
    this.camera.setViewportAndMatrices();
    this.batcher.beginBatch(this.gameMap);
    int i = this.bottom;
    if (i > this.top)
    {
      this.batcher.endBatch(this.gameMap);
      this.myFrame.bind(this.game.getGLGraphics().getGL(), paramFloat);
      i = this.bottom;
    }
    int j;
    for (;;)
    {
      if (i > this.top)
      {
        this.myFrame.unbind();
        return;
        j = this.left;
        if (j > this.right)
        {
          i += 1;
          break;
        }
        MapPlace localMapPlace = RandomResource.map[(i * 147 + j)];
        Build localBuild = localMapPlace.isBuilding;
        if (localBuild != null)
        {
          k = 0;
          this.batcher.drawSprite(0.5F + j, 0.5F + i, 1.0F, 1.0F, Assets.buildings[localBuild.getId()]);
          if (localBuild.getConstructionTime() > 0) {
            this.batcher.drawSprite(0.75F + j, 0.25F + i, 0.5F, 0.5F, Assets.construction);
          }
        }
        for (;;)
        {
          j += 1;
          break;
          if (localBuild.getLevelUp()) {
            this.batcher.drawSprite(0.5F + j, 0.5F + i, 1.0F, 1.0F, Assets.upgrade);
          }
          if (localBuild.getClose())
          {
            this.batcher.drawSprite(0.5F + j, 0.5F + i, 1.0F, 1.0F, Assets.lock);
            k = 1;
          }
          if (localBuild.getWintering()) {
            this.batcher.drawSprite(0.75F + j, 0.25F + i, 0.5F, 0.5F, Assets.snow);
          }
          for (;;)
          {
            if ((!localBuild.isFire()) || (localBuild.getClose())) {
              break label492;
            }
            this.batcher.drawSprite(0.5F + j, 0.5F + i, 1.0F, 1.0F, Assets.fire);
            break;
            if ((localBuild.notPeople()) && (k == 0)) {
              this.batcher.drawSprite(0.5F + j, 0.5F + i, 1.0F, 1.0F, Assets.notPeople);
            } else if (localBuild.endResource()) {
              this.batcher.drawSprite(0.75F + j, 0.25F + i, 0.5F, 0.5F, Assets.endResource);
            }
          }
          label492:
          continue;
          this.batcher.drawSprite(0.5F + j, 0.5F + i, 1.0F, 1.0F, Assets.map[localMapPlace.type]);
          if (localMapPlace.isBuy) {
            this.batcher.drawSprite(0.75F + j, 0.75F + i, 0.5F, 0.5F, Assets.ransom);
          }
          if (localMapPlace.isImproved) {
            this.batcher.drawSprite(0.25F + j, 0.25F + i, 0.5F, 0.5F, Assets.plus);
          }
        }
      }
      j = this.left;
      if (j <= this.right) {
        break label619;
      }
      i += 1;
    }
    label619:
    int k = i * 147 + j;
    if (RandomResource.map[k].isPickOut)
    {
      if (k != RandomResource.firstPick) {
        break label680;
      }
      this.myFrame.DrawSquade(0.4F, 0.4F, 0.5F + j, 0.5F + i);
    }
    for (;;)
    {
      j += 1;
      break;
      label680:
      this.myFrame.DrawSquade(0.3F, 0.3F, 0.5F + j, 0.5F + i);
    }
  }
  
  public void resume()
  {
    GL10 localGL10 = this.graphics.getGL();
    localGL10.glEnable(3553);
    localGL10.glEnable(3042);
    Assets.gameTexture.load();
    localGL10.glBlendFunc(770, 771);
  }
  
  public void update(float paramFloat)
  {
    ArrayList localArrayList = this.game.getInputTouch().getTouchEvents();
    joltCamera.update(paramFloat);
    if (GameLayout.compThread.isAlive()) {
      return;
    }
    synchronized (GameLayout.block)
    {
      touchHandler(paramFloat, localArrayList);
      drawingBorder();
      return;
    }
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\sk\GameScreen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */