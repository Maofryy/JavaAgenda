import java.util.*;
import java.io.*;
import java.text.*;




public class Launch{
  public static void main(String[] args){

          /**/
        //Si il n'existe pas de notes ou events : en creer.

        Calendar cal = Calendar.getInstance();
        Date day = new Date();
        day = cal.getTime();
        Note note = new Note(day, "First Note test");
        Event event = new Event(day, "First Event test", 2);
        List<Note> notes = new ArrayList<Note>();
        List<Event> events = new ArrayList<Event>();

        // notes.add(note);
        // events.add(event);
        //
        // cal.setTime(day);
        // //System.out.println(day);
        // cal.add(Calendar.DAY_OF_MONTH, 1);
        // day = cal.getTime();
        // System.out.println(day);
        // note = new Note(day, "Second Note test");
        // event = new Event(day, "Second Event test",1);
        // notes.add(note);
        // events.add(event);
        // SeriUtil.saveNotes(notes);
        // SeriUtil.saveEvents(events);
        // cal.add(Calendar.DAY_OF_MONTH, -1);
        // day = cal.getTime();

        if ((notes = SeriUtil.loadNotes()) == null)
        {
          System.out.println("Pas de fichier de notes, creation...");
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",Locale.FRANCE);
          Date dat = new Date();
          try {dat = sdf.parse("2000-01-01");}catch (ParseException e){e.printStackTrace();}
          Note ret = new Note(dat, "Debut du Millenaire.");
          notes = new ArrayList<Note>();
          notes.add(ret);
          SeriUtil.saveNotes(notes);
        }else{
          System.out.println("Notes Loaded");
        }
        if ((events = SeriUtil.loadEvents()) == null)
        {
          System.out.println("Pas de fichier de events, creation...");
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",Locale.FRANCE);
          Date dat = new Date();
          try {dat = sdf.parse("2000-01-01");}catch (ParseException e){e.printStackTrace();}
          Event ret = new Event(dat,"Debut du Millenaire.",0);
          events = new ArrayList<Event>();
          events.add(ret);
          SeriUtil.saveEvents(events);
        }else{
          System.out.println("Events Loaded");
        }



        //Charger interface et update

        Window win = new Window("Agenda", day, notes, events);
        //Checker les rappels (POP UP ?)
        //Interpreter les boutons (Navigation, ajout de note ou rappel)


      }
}
