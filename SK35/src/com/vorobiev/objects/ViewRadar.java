package com.vorobiev.objects;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.view.View;
import com.vorobiev.data.RadarData;

public class ViewRadar
  extends View
{
  private Paint paint = new Paint();
  private Rect rect = new Rect();
  int x = 0;
  
  public ViewRadar(Context paramContext)
  {
    super(paramContext);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.getClipBounds(this.rect);
    paramCanvas.drawBitmap(RadarData.mapRadar, null, this.rect, null);
    this.paint.setColor(-16777216);
    this.paint.setStyle(Paint.Style.STROKE);
    float f1 = RadarData.positionX - RadarData.frameWidthToCenter;
    float f2 = RadarData.positionY - RadarData.frameHeightToCenter;
    paramCanvas.drawRect(f1, f2, f1 + RadarData.frameWidthToCenter * 2.0F, f2 + RadarData.frameHeightToCenter * 2.0F, this.paint);
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\objects\ViewRadar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */