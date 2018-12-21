import java.util.*;
import java.text.*;

public class ListUtil
{
  public static int getIndexNotes(Date day, List<Note> notes)
  {
    Integer i = 0;
    SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");

    while (i < notes.size())
    {
      if (fmt.format(day).equals(fmt.format(notes.get(i).getD())))
        return i;
      i++;
    }
    return -1;
  }

  public static int getIndexEvents(Date day, List<Event> notes)
  {
    int i = 0;
    SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");

    while (i < notes.size())
    {
      if (fmt.format(day).equals(fmt.format(notes.get(i).getD())))
        return i;
      i++;
    }
    return -1;
  }
}
