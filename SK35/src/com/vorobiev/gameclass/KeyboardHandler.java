package com.vorobiev.gameclass;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.vorobiev.gameInterface.Input;
import com.vorobiev.gameInterface.Input.KeyEvent;
import com.vorobiev.gameInterface.Input.TouchEvent;
import com.vorobiev.sk.GLView;
import java.util.ArrayList;
import java.util.List;

public class KeyboardHandler
  implements View.OnKeyListener, Input
{
  Pool<Input.KeyEvent> keyEventPool = new Pool(new Pool.PoolObjectFactory()
  {
    public Input.KeyEvent CreatObject()
    {
      return new Input.KeyEvent();
    }
  }, 100);
  List<Input.KeyEvent> keyEvents = new ArrayList();
  List<Input.KeyEvent> keyEventsBuffer = new ArrayList();
  boolean[] pressedKeys = new boolean[''];
  
  public KeyboardHandler(GLView paramGLView)
  {
    paramGLView.setOnKeyListener(this);
    paramGLView.setFocusableInTouchMode(true);
    paramGLView.requestFocus();
  }
  
  /* Error */
  public List<Input.KeyEvent> getKeyEvents()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 33	com/vorobiev/gameclass/KeyboardHandler:keyEvents	Ljava/util/List;
    //   6: invokeinterface 66 1 0
    //   11: istore_2
    //   12: iconst_0
    //   13: istore_1
    //   14: iload_1
    //   15: iload_2
    //   16: if_icmplt +44 -> 60
    //   19: aload_0
    //   20: getfield 33	com/vorobiev/gameclass/KeyboardHandler:keyEvents	Ljava/util/List;
    //   23: invokeinterface 69 1 0
    //   28: aload_0
    //   29: getfield 33	com/vorobiev/gameclass/KeyboardHandler:keyEvents	Ljava/util/List;
    //   32: aload_0
    //   33: getfield 31	com/vorobiev/gameclass/KeyboardHandler:keyEventsBuffer	Ljava/util/List;
    //   36: invokeinterface 73 2 0
    //   41: pop
    //   42: aload_0
    //   43: getfield 31	com/vorobiev/gameclass/KeyboardHandler:keyEventsBuffer	Ljava/util/List;
    //   46: invokeinterface 69 1 0
    //   51: aload_0
    //   52: getfield 33	com/vorobiev/gameclass/KeyboardHandler:keyEvents	Ljava/util/List;
    //   55: astore_3
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_3
    //   59: areturn
    //   60: aload_0
    //   61: getfield 43	com/vorobiev/gameclass/KeyboardHandler:keyEventPool	Lcom/vorobiev/gameclass/Pool;
    //   64: aload_0
    //   65: getfield 33	com/vorobiev/gameclass/KeyboardHandler:keyEvents	Ljava/util/List;
    //   68: iload_1
    //   69: invokeinterface 77 2 0
    //   74: checkcast 79	com/vorobiev/gameInterface/Input$KeyEvent
    //   77: invokevirtual 83	com/vorobiev/gameclass/Pool:free	(Ljava/lang/Object;)V
    //   80: iload_1
    //   81: iconst_1
    //   82: iadd
    //   83: istore_1
    //   84: goto -70 -> 14
    //   87: astore_3
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_3
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	KeyboardHandler
    //   13	71	1	i	int
    //   11	6	2	j	int
    //   55	4	3	localList	List
    //   87	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	87	finally
    //   19	58	87	finally
    //   60	80	87	finally
    //   88	90	87	finally
  }
  
  public ArrayList<Input.TouchEvent> getTouchEvents()
  {
    return null;
  }
  
  public int getTouchX(int paramInt)
  {
    return 0;
  }
  
  public int getTouchY(int paramInt)
  {
    return 0;
  }
  
  public boolean isKeyPressed(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 127)) {
      return false;
    }
    return this.pressedKeys[paramInt];
  }
  
  public boolean isTouchDown(int paramInt)
  {
    return false;
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 2) {}
    while ((paramInt == 4) || (paramInt == 24) || (paramInt == 25)) {
      return false;
    }
    try
    {
      paramView = (Input.KeyEvent)this.keyEventPool.newObject();
      paramView.keyCode = paramInt;
      paramView.keyChar = ((char)paramKeyEvent.getUnicodeChar());
      if (paramKeyEvent.getAction() == 0)
      {
        paramView.type = 0;
        if ((paramInt > 0) && (paramInt < 127)) {
          this.pressedKeys[paramInt] = true;
        }
      }
      if (paramKeyEvent.getAction() == 1)
      {
        paramView.type = 1;
        if ((paramInt > 0) && (paramInt < 127)) {
          this.pressedKeys[paramInt] = false;
        }
      }
      this.keyEventsBuffer.add(paramView);
      return true;
    }
    finally {}
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\gameclass\KeyboardHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */