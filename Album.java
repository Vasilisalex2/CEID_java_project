import java.util.Scanner;
public abstract class Album{
  private String albumTitle = "";
  private String albumArtist = "";
  Scanner keyboard =  new Scanner(System.in);
  static int counter = 0; static int ID;
  { if(counter==0) { System.out.println("Enter the 3-Digit Record Company ID Code: "); 
     ID = keyboard.nextInt();}   }
  private int albumID = (ID*10)+Counter();   
  int Counter()
  {
    return ++counter;
  }
  public void setAlbumTitle(String title)
  {
    albumTitle = title;
  }
  public String getAlbumTitle()
  {
     return albumTitle;
  }
  public void setAlbumArtist(String artist)
  {
    albumArtist = artist; 
  }
  public String getAlbumArtist()
  {
     return albumArtist;
  }
  public int getAlbumID()
  {
    return albumID;
  }
  public abstract String albumFormatDetails();
}
