import java.util.*;
import java.text.*;

public class ListUtil
{
  public static int getIndex(Date day, List<Note> notes)
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
