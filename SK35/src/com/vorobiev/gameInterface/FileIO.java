package com.vorobiev.gameInterface;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;

public abstract interface FileIO
{
  public abstract boolean deleteFile(String paramString);
  
  public abstract boolean isExist(String paramString);
  
  public abstract InputStream readAsset(String paramString)
    throws IOException;
  
  public abstract InputStream readFile(String paramString)
    throws IOException;
  
  public abstract RandomAccessFile rwRandomFile(String paramString)
    throws IOException;
  
  public abstract OutputStream writeFile(String paramString)
    throws IOException;
  
  public abstract OutputStream writeFileNotDeleted(String paramString)
    throws IOException;
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\gameInterface\FileIO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */