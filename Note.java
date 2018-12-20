import java.util.*;
import java.io.*;

public class Note implements Serializable{
  private Date day;
  private String text;

  public Note(Date day)
  {
    this.day = day;
    this.text = "";
  }

  public Note(Date day, String text)
  {
    this.day = day;
    this.text = text;
  }

  // public Date getDate()
  // {
  //     return this.day;
  // }

  public String getText()
  {
    return this.text;
  }

  public String toString()
  {
      return (day + " : " +text);
  }

}
