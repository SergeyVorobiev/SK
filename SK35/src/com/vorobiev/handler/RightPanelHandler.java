package com.vorobiev.handler;

import android.os.Message;
import com.vorobiev.objects.RightPanel;
import com.vorobiev.sk.GameLayout;

public class RightPanelHandler
  extends AbstractHandler
{
  private RightPanel rightPanel;
  
  public RightPanelHandler(RightPanel paramRightPanel, int paramInt)
  {
    super(paramInt);
    this.rightPanel = paramRightPanel;
  }
  
  public void update(Message arg1)
  {
    synchronized (GameLayout.block)
    {
      this.rightPanel.inflateDate();
      this.rightPanel.update();
      this.rightPanel.updateProfitConsumption();
      return;
    }
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\handler\RightPanelHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */