import java.util.*;
import java.io.*;
import java.util.List;

public class Record implements Serializable {

  public List<Note> notes;
  public List<Event> events;

  public Record(){
    notes = new ArrayList<Note>();
    events = new ArrayList<Event>();
  }

  public Record(List<Note> notes, List<Event> events){
    this.notes = notes;
    this.events = events;
  }

  public String toString(){
    return this.notes.toString() + this.events.toString();
  }

  public Note getNote(Date day)
  {
  	int i = 0;
	if ((i = ListUtil.getIndexNotes(day, this.notes)) == -1)
	{
		return null;
	}
	return this.notes.get(i);
  }

  public Event getEvent(Date day)
  {
  	int i = 0;
	if ((i = ListUtil.getIndexEvents(day, this.events)) == -1)
	{
		return null;
	}
	return this.events.get(i);
  }

}
