import java.util.*;
import java.io.*;

public class Note implements Serializable{
  private Date day;
  public String text;
  private Long serialVersionUID;

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

  public Date getD()
  {
      return this.day;
  }

  public String getText()
  {
    return this.text;
  }

  public String toString()
  {
      return (day + " : " +text);
  }

}
