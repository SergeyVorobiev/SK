package com.vorobiev.objects;

import java.io.Serializable;

public class MyDate
  implements Serializable
{
  private static final StringBuilder builder = new StringBuilder();
  private static final long serialVersionUID = 1L;
  private int day;
  private int mounth;
  private int year;
  
  public MyDate(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 < 0) || (paramInt3 > 9999))
    {
      this.year = 0;
      if ((paramInt2 >= 1) && (paramInt2 <= 12)) {
        break label63;
      }
    }
    label63:
    for (this.mounth = 1;; this.mounth = paramInt2)
    {
      if ((paramInt1 >= 1) && (!checkDay(paramInt1))) {
        return;
      }
      this.day = paramInt1;
      return;
      this.year = paramInt3;
      break;
    }
  }
  
  private boolean checkDay(int paramInt)
  {
    int i = 28;
    if (this.year % 4 == 0) {
      i = 29;
    }
    switch (this.mounth)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            return false;
                          } while (paramInt > 31);
                          return true;
                        } while (paramInt > i);
                        return true;
                      } while (paramInt > 31);
                      return true;
                    } while (paramInt > 30);
                    return true;
                  } while (paramInt > 31);
                  return true;
                } while (paramInt > 30);
                return true;
              } while (paramInt > 31);
              return true;
            } while (paramInt > 31);
            return true;
          } while (paramInt > 30);
          return true;
        } while (paramInt > 31);
        return true;
      } while (paramInt > 30);
      return true;
    } while (paramInt > 31);
    return true;
  }
  
  public void addDay()
  {
    int i = this.day + 1;
    this.day = i;
    if (!checkDay(i))
    {
      this.day = 1;
      i = this.mounth + 1;
      this.mounth = i;
      if (i > 12)
      {
        this.mounth = 1;
        this.year += 1;
      }
    }
  }
  
  public String getDate()
  {
    builder.setLength(0);
    builder.append(this.day);
    builder.append(" ");
    builder.append(getMounth());
    builder.append(" ");
    builder.append(this.year);
    return builder.toString();
  }
  
  public int getDay()
  {
    return this.day;
  }
  
  public int getDaysInMounth(int paramInt)
  {
    int i = 28;
    if (this.year % 4 == 0) {
      i = 29;
    }
    switch (paramInt)
    {
    default: 
      i = 0;
    case 2: 
      return i;
    case 1: 
      return 31;
    case 3: 
      return 31;
    case 4: 
      return 30;
    case 5: 
      return 31;
    case 6: 
      return 30;
    case 7: 
      return 31;
    case 8: 
      return 31;
    case 9: 
      return 30;
    case 10: 
      return 31;
    case 11: 
      return 30;
    }
    return 31;
  }
  
  public int getIntMounth()
  {
    return this.mounth;
  }
  
  public String getMounth()
  {
    switch (this.mounth)
    {
    default: 
      return "NONE";
    case 1: 
      return "Января";
    case 2: 
      return "Февраля";
    case 3: 
      return "Марта";
    case 4: 
      return "Апреля";
    case 5: 
      return "Мая";
    case 6: 
      return "Июня";
    case 7: 
      return "Июля";
    case 8: 
      return "Августа";
    case 9: 
      return "Сентября";
    case 10: 
      return "Октября";
    case 11: 
      return "Ноября";
    }
    return "Декабря";
  }
  
  public String getSeason()
  {
    if ((this.mounth <= 2) || (this.mounth == 12)) {
      return "Зима";
    }
    if ((this.mounth > 2) && (this.mounth <= 5)) {
      return "Весна";
    }
    if ((this.mounth > 5) && (this.mounth <= 8)) {
      return "Лето";
    }
    return "Осень";
  }
  
  public int getYear()
  {
    return this.year;
  }
  
  public boolean isLeep()
  {
    return this.year % 4 == 0;
  }
  
  public void setDate(MyDate paramMyDate)
  {
    this.day = paramMyDate.day;
    this.mounth = paramMyDate.mounth;
    this.year = paramMyDate.year;
  }
  
  public String toString()
  {
    builder.setLength(0);
    builder.append(this.day);
    builder.append(".");
    builder.append(getIntMounth());
    builder.append(".");
    builder.append(this.year);
    return builder.toString();
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\objects\MyDate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */