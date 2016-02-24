package com.vorobiev.objects;

import com.vorobiev.buildings.Build;
import java.io.Serializable;

public class MapPlace
  implements Serializable
{
  public static final int[][] allowed;
  public static final int cost = 50000;
  public static final int costImproved = 45000;
  public static final int costImprovedOne = 15000;
  private static final long serialVersionUID = 1L;
  public static final String[] typeString = { "Земля", "Лес", "Уголь", "Нефть", "Металл", "Золото", "Вода", "Фундамент" };
  public Build isBuilding = null;
  public boolean isBuy = false;
  public boolean isImproved = false;
  public boolean isPickOut = false;
  public int type;
  
  static
  {
    int[] arrayOfInt2 = { 1, 2, 3, 4, 9, 11, 15, 16, 17, 20, 22, 24, 28 };
    int[] arrayOfInt1 = new int[1];
    allowed = new int[][] { { 1, 2, 3, 9, 11, 12, 16, 18, 19, 20, 22, 23, 28 }, arrayOfInt2, { 1, 2, 5, 3, 9, 11, 14, 16, 20, 22, 28 }, { 1, 2, 7, 3, 9, 11, 16, 20, 21, 22, 26, 28 }, { 1, 2, 6, 3, 9, 11, 16, 20, 22, 27, 28 }, { 1, 2, 8, 3, 9, 11, 16, 20, 22, 28 }, { 1, 2, 3, 3, 9, 10, 11, 13, 16, 20, 22, 25, 28, 29, 30 }, arrayOfInt1 };
  }
  
  public int getCostImproved()
  {
    if (this.isBuilding == null) {
      return 15000;
    }
    return 45000;
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\objects\MapPlace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */