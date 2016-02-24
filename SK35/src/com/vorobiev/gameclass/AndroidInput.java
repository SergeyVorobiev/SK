package com.vorobiev.gameclass;

import android.annotation.SuppressLint;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.vorobiev.gameInterface.Input;
import com.vorobiev.gameInterface.Input.KeyEvent;
import com.vorobiev.gameInterface.Input.TouchEvent;
import java.util.ArrayList;

public class AndroidInput
  implements Input, View.OnTouchListener
{
  private ArrayList<Input.TouchEvent> bufferTouch = new ArrayList();
  private boolean[] isTouch = new boolean[20];
  private Pool<Input.TouchEvent> pool;
  private ArrayList<Input.TouchEvent> returnTouch = new ArrayList();
  
  public AndroidInput(GLSurfaceView paramGLSurfaceView)
  {
    paramGLSurfaceView.setOnTouchListener(this);
    this.pool = new Pool(new Pool.PoolObjectFactory()
    {
      public Input.TouchEvent CreatObject()
      {
        return new Input.TouchEvent();
      }
    }, 20);
  }
  
  public ArrayList<Input.KeyEvent> getKeyEvents()
  {
    return null;
  }
  
  /* Error */
  public ArrayList<Input.TouchEvent> getTouchEvents()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 33	com/vorobiev/gameclass/AndroidInput:returnTouch	Ljava/util/ArrayList;
    //   6: invokevirtual 62	java/util/ArrayList:size	()I
    //   9: istore_2
    //   10: iconst_0
    //   11: istore_1
    //   12: iload_1
    //   13: iload_2
    //   14: if_icmplt +38 -> 52
    //   17: aload_0
    //   18: getfield 33	com/vorobiev/gameclass/AndroidInput:returnTouch	Ljava/util/ArrayList;
    //   21: invokevirtual 65	java/util/ArrayList:clear	()V
    //   24: aload_0
    //   25: getfield 33	com/vorobiev/gameclass/AndroidInput:returnTouch	Ljava/util/ArrayList;
    //   28: aload_0
    //   29: getfield 31	com/vorobiev/gameclass/AndroidInput:bufferTouch	Ljava/util/ArrayList;
    //   32: invokevirtual 69	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   35: pop
    //   36: aload_0
    //   37: getfield 31	com/vorobiev/gameclass/AndroidInput:bufferTouch	Ljava/util/ArrayList;
    //   40: invokevirtual 65	java/util/ArrayList:clear	()V
    //   43: aload_0
    //   44: getfield 33	com/vorobiev/gameclass/AndroidInput:returnTouch	Ljava/util/ArrayList;
    //   47: astore_3
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_3
    //   51: areturn
    //   52: aload_0
    //   53: getfield 49	com/vorobiev/gameclass/AndroidInput:pool	Lcom/vorobiev/gameclass/Pool;
    //   56: aload_0
    //   57: getfield 33	com/vorobiev/gameclass/AndroidInput:returnTouch	Ljava/util/ArrayList;
    //   60: iload_1
    //   61: invokevirtual 73	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   64: checkcast 75	com/vorobiev/gameInterface/Input$TouchEvent
    //   67: invokevirtual 79	com/vorobiev/gameclass/Pool:free	(Ljava/lang/Object;)V
    //   70: iload_1
    //   71: iconst_1
    //   72: iadd
    //   73: istore_1
    //   74: goto -62 -> 12
    //   77: astore_3
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_3
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	AndroidInput
    //   11	63	1	i	int
    //   9	6	2	j	int
    //   47	4	3	localArrayList	ArrayList
    //   77	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	77	finally
    //   17	50	77	finally
    //   52	70	77	finally
    //   78	80	77	finally
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
    return false;
  }
  
  public boolean isTouchDown(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 10)) {
      return this.isTouch[paramInt];
    }
    return false;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    for (;;)
    {
      int k;
      try
      {
        i = paramMotionEvent.getAction();
        j = (paramMotionEvent.getAction() & 0xFF00) >> 8;
        k = paramMotionEvent.getPointerId(j);
        switch (i & 0xFF)
        {
        case 4: 
          return true;
        }
      }
      finally {}
      paramView = (Input.TouchEvent)this.pool.newObject();
      paramView.x = ((int)paramMotionEvent.getX(j));
      paramView.y = ((int)paramMotionEvent.getY(j));
      paramView.type = 0;
      paramView.Id = k;
      this.bufferTouch.add(paramView);
      this.isTouch[k] = true;
      continue;
      paramView = (Input.TouchEvent)this.pool.newObject();
      paramView.x = ((int)paramMotionEvent.getX(j));
      paramView.y = ((int)paramMotionEvent.getY(j));
      paramView.type = 1;
      paramView.Id = k;
      this.bufferTouch.add(paramView);
      this.isTouch[k] = false;
      continue;
      int j = paramMotionEvent.getPointerCount();
      int i = 0;
      while (i < j)
      {
        k = paramMotionEvent.getPointerId(i);
        paramView = (Input.TouchEvent)this.pool.newObject();
        paramView.type = 2;
        paramView.Id = k;
        paramView.x = ((int)paramMotionEvent.getX(i));
        paramView.y = ((int)paramMotionEvent.getY(i));
        this.bufferTouch.add(paramView);
        i += 1;
      }
    }
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\gameclass\AndroidInput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */