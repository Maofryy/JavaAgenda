import java.util.*;

public class Event extends Note{
  private List<Integer> type;
  private List<String> str;
  private String[] Types = {"Anniversaire", "Rendez-vous", "A faire"};

  public Event(Date day)
  {
      super(day);
  }

  public Event(Date day, String text, int type)
  {
    super(day);
    this.type = new ArrayList<Integer>();
    this.str = new ArrayList<String>();
    this.type.add(type);
    this.str.add(text);
  }

  public void addEvent(String text, int type)
  {
    this.type.add(type);
    this.str.add(text);
  }

  public String getTypeString(int index)
  {
    return Types[this.type.get(index)];
  }

  public String getString(int index)
  {
    return this.str.get(index);
  }

  public int getSize()
  {
    return type.size();
  }

  public String getText()
  {
    String ret = "";
    int i = 0;
    while (i < str.size())
    {
      ret = this.getString(i) + "\n";
      i++;
    }
    return ret;
  }

}
