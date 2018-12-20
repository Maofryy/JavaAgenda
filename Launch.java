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
        Note event = new Note(day, "First Event test");
        List<Note> notes = new ArrayList<Note>();
        List<Note> events = new ArrayList<Note>();

        // notes.add(note);
        // events.add(event);
        //
        // cal.setTime(day);
        // System.out.println(day);
        // cal.add(Calendar.DAY_OF_MONTH, 1);
        // day = cal.getTime();
        // System.out.println(day);
        // note = new Note(day, "Second Note test");
        // event = new Note(day, "Second Event test");
        // notes.add(note);
        // events.add(event);
        // SeriUtil.saveNotes(notes);
        // SeriUtil.saveEvents(events);

        if ((notes = SeriUtil.loadNotes()) == null)
        {
          System.out.println("Pas de fichier de notes, creation...");
          SeriUtil.saveNotes(notes);
        }else{
          System.out.println("Notes Loaded");
        }
        if ((events = SeriUtil.loadEvents()) == null)
        {
          System.out.println("Pas de fichier de events, creation...");
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
