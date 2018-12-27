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
        // List<Note> notes = new ArrayList<Note>();
        // List<Event> events = new ArrayList<Event>();

        Record rec = new Record();

         //rec.notes.add(note);
         //rec.events.add(event);
          
          //cal.setTime(day);
          //System.out.println(day);
          // cal.add(Calendar.DAY_OF_MONTH, 1);
          // day = cal.getTime();
          // //System.out.println(day);
          // note = new Note(day, "Bonjour");
          // //event = new Event(day, "Second Event test",1);
          // rec.notes.add(note);
           ////rec.events.add(event);
           //SeriUtil.saveNotes(rec.notes);
           //SeriUtil.saveEvents(rec.events);
          
           //cal.add(Calendar.DAY_OF_MONTH, -1);
           //day = cal.getTime();


        if ((rec.notes = SeriUtil.loadNotes()) == null)
        {
          System.out.println("Pas de fichier de notes, creation...");
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",Locale.FRANCE);
          Date dat = new Date();
          try {dat = sdf.parse("2000-01-01");}catch (ParseException e){e.printStackTrace();}
          Note ret = new Note(dat, "Debut du Millenaire.");
          rec.notes = new ArrayList<Note>();
          rec.notes.add(ret);
          SeriUtil.saveNotes(rec.notes);
        }else{
          System.out.println("Notes Loaded");
        }
        if ((rec.events = SeriUtil.loadEvents()) == null)
        {
          System.out.println("Pas de fichier de events, creation...");
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",Locale.FRANCE);
          Date dat = new Date();
          try {dat = sdf.parse("2000-01-01");}catch (ParseException e){e.printStackTrace();}
          Event ret = new Event(dat,"Debut du Millenaire.",0);
          rec.events = new ArrayList<Event>();
          rec.events.add(ret);
          SeriUtil.saveEvents(rec.events);
        }else{
          System.out.println("Events Loaded");
        }



        //Charger interface et update

        Window win = new Window("Agenda", day, rec);
        //Checker les rappels (POP UP ?)
        //Interpreter les boutons (Navigation, ajout de note ou rappel)


      }
}
