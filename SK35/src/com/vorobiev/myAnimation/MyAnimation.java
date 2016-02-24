package com.vorobiev.myAnimation;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;

public abstract class MyAnimation
{
  private Animation animation;
  protected View view;
  
  public MyAnimation(Context paramContext, final View paramView, int paramInt)
  {
    this.animation = AnimationUtils.loadAnimation(paramContext, paramInt);
    this.view = paramView;
    this.animation.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        paramView.setVisibility(4);
      }
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation)
      {
        paramView.setVisibility(0);
      }
      
      public void onAnimationStart(Animation paramAnonymousAnimation)
      {
        paramView.setVisibility(0);
      }
    });
  }
  
  public final void start()
  {
    update(this.view);
    this.view.startAnimation(this.animation);
  }
  
  protected abstract void update(View paramView);
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\myAnimation\MyAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */