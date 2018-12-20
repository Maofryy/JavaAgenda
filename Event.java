import java.util.*;
import java.text.*;

public class Event extends Date{
    private Date day;
    private String text;

    public Event(Date day)
    {
      this.day = day;
      this.text = "";
    }

    public Event(Date day, String text)
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
}
