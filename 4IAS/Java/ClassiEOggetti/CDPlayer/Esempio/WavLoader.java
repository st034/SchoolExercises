import java.io.File;

public class WavLoader
{
  File audioIn = new File("audio/8k8bitpcm.wav");
  File audioOut = new File("audio/Modified8k8bitpcm.wav");
  long fileSize = audioIn.length();
  int[] arrayInt = new int[(int)fileSize];
  int[] arrayInt2 = new int[(int)fileSize];
  
  public WavLoader() {
    try {
      java.io.FileInputStream in = new java.io.FileInputStream(audioIn);
      for (int i = 0; i < fileSize; i++) {
        arrayInt[i] = in.read();
      }
    } catch (Exception localException) {}
    arrayInt = arrayInt;
  }
  
  public int[] getArray() {
    return arrayInt;
  }
  
  public long getSize() {
    return fileSize;
  }
  
  public void play(int[] arrayInt)
  {
    this.arrayInt = arrayInt;
    try
    {
      java.io.FileOutputStream out = new java.io.FileOutputStream(audioOut);
      for (int i = 0; i < fileSize; i++)
      {
        out.write(arrayInt[i]);
      }
    } catch (Exception e) {
      System.out.println("Problema di scrittura file audio");
    }
    
    AePlayWave pw1 = new AePlayWave("audio/Modified8k8bitpcm.wav");
    pw1.start();
  }
}
