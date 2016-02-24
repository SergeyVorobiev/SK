package com.vorobiev.sk;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.TextView;

public class MyTextView
  extends TextView
{
  private Paint linePaint;
  private Rect rect;
  
  public MyTextView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public MyTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public MyTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.linePaint = new Paint(1);
    this.linePaint.setStyle(Paint.Style.STROKE);
    this.linePaint.setColor(-16776961);
    this.rect = new Rect();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    getDrawingRect(this.rect);
    paramCanvas.drawRect(this.rect, this.linePaint);
    paramCanvas.save();
    super.onDraw(paramCanvas);
    paramCanvas.restore();
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\sk\MyTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */