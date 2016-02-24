package com.vorobiev.sk;

import android.app.Activity;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class ActivityAuthors
  extends Activity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
    setContentView(2130903040);
    ((TextView)findViewById(2131361792)).setText("Авторы");
    TextView localTextView = new TextView(this);
    localTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    localTextView.setText("Автор идеи и разработчик PC версии игры  - Жмулевский Григорий.");
    Linkify.addLinks(localTextView, 15);
    localTextView.setTextSize(16.0F);
    localTextView.setTextColor(-1);
    paramBundle = (LinearLayout)findViewById(2131361795);
    paramBundle.addView(localTextView);
    localTextView = new TextView(this);
    localTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    localTextView.setText("Доработка и порт на Android - Воробьёв Сергей.");
    Linkify.addLinks(localTextView, 15);
    localTextView.setTextSize(16.0F);
    localTextView.setTextColor(-1);
    paramBundle.addView(localTextView);
    localTextView = new TextView(this);
    localTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    localTextView.setText("Вопросы и пожелания - http://vk.com/kalambur3000");
    Linkify.addLinks(localTextView, 15);
    localTextView.setTextSize(16.0F);
    localTextView.setTextColor(-1);
    paramBundle.addView(localTextView);
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\sk\ActivityAuthors.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */