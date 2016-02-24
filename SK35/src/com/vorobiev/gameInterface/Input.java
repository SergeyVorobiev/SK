package com.vorobiev.gameInterface;

import java.util.ArrayList;
import java.util.List;

public abstract interface Input
{
  public abstract List<KeyEvent> getKeyEvents();
  
  public abstract ArrayList<TouchEvent> getTouchEvents();
  
  public abstract int getTouchX(int paramInt);
  
  public abstract int getTouchY(int paramInt);
  
  public abstract boolean isKeyPressed(int paramInt);
  
  public abstract boolean isTouchDown(int paramInt);
  
  public static class KeyEvent
  {
    public static final int KEY_DOWN = 0;
    public static final int KEY_UP = 1;
    public int keyChar;
    public int keyCode;
    public int type;
  }
  
  public static class TouchEvent
  {
    public static final int TOUCH_DOWN = 0;
    public static final int TOUCH_DRAGGED = 2;
    public static final int TOUCH_UP = 1;
    public int Id;
    public int type;
    public int x;
    public int y;
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\gameInterface\Input.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */