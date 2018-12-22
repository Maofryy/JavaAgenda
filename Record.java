import java.util.*;
import java.io.*;
import java.util.List;

public class Record implements Serializable {

  public List<Note> notes;
  public List<Event> events;
  public Date day;

  public Record(Date day){
    this.day = day;
    notes = new ArrayList<Note>();
    events = new ArrayList<Event>();
  }

  public Record(Date day, List<Note> notes, List<Event> events){
    this.day = day;
    this.notes = notes;
    this.events = events;
  }

}
