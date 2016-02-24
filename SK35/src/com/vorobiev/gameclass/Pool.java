package com.vorobiev.gameclass;

import java.util.ArrayList;
import java.util.List;

public class Pool<T>
{
  private final PoolObjectFactory<T> factory;
  private final List<T> freeObject;
  private final int maxSize;
  
  public Pool(PoolObjectFactory<T> paramPoolObjectFactory, int paramInt)
  {
    this.factory = paramPoolObjectFactory;
    this.maxSize = paramInt;
    this.freeObject = new ArrayList(paramInt);
  }
  
  public void free(T paramT)
  {
    if (this.freeObject.size() < this.maxSize) {
      this.freeObject.add(paramT);
    }
  }
  
  public T newObject()
  {
    if (this.freeObject.size() > 0) {
      return (T)this.freeObject.remove(this.freeObject.size() - 1);
    }
    return (T)this.factory.CreatObject();
  }
  
  public static abstract interface PoolObjectFactory<T>
  {
    public abstract T CreatObject();
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\gameclass\Pool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */