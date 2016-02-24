package com.vorobiev.handler;

import android.os.Message;
import com.vorobiev.data.RandomResource;
import com.vorobiev.objects.CenterPanel;

public class TopStringHandler
  extends AbstractHandler
{
  private CenterPanel centerPanel;
  
  public TopStringHandler(CenterPanel paramCenterPanel, int paramInt)
  {
    super(paramInt);
    this.centerPanel = paramCenterPanel;
  }
  
  public void update()
  {
    this.centerPanel.inflateTopString(RandomResource.stringBuilder.toString());
  }
  
  public void update(Message paramMessage)
  {
    this.centerPanel.inflateTopString(RandomResource.stringBuilder.toString());
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\handler\TopStringHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */