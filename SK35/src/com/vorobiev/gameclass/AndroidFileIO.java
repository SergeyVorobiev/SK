package com.vorobiev.gameclass;

import android.content.res.AssetManager;
import android.os.Environment;
import com.vorobiev.gameInterface.FileIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;

public class AndroidFileIO
  implements FileIO
{
  private AssetManager asset;
  private String extPath;
  
  public AndroidFileIO(AssetManager paramAssetManager)
  {
    this.asset = paramAssetManager;
    this.extPath = (Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator);
  }
  
  public boolean deleteFile(String paramString)
  {
    return new File(this.extPath + paramString).delete();
  }
  
  public boolean isExist(String paramString)
  {
    return new File(this.extPath + paramString).exists();
  }
  
  public InputStream readAsset(String paramString)
    throws IOException
  {
    return this.asset.open(paramString);
  }
  
  public InputStream readFile(String paramString)
    throws IOException
  {
    return new FileInputStream(this.extPath + paramString);
  }
  
  public RandomAccessFile rwRandomFile(String paramString)
    throws IOException
  {
    return new RandomAccessFile(this.extPath + paramString, "rw");
  }
  
  public OutputStream writeFile(String paramString)
    throws IOException
  {
    return new FileOutputStream(this.extPath + paramString);
  }
  
  public OutputStream writeFileNotDeleted(String paramString)
    throws IOException
  {
    return new FileOutputStream(this.extPath + paramString, false);
  }
}


/* Location:              C:\Users\Сергей\Desktop\SK35-dex2jar.jar!\com\vorobiev\gameclass\AndroidFileIO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */