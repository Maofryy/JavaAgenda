import java.util.*;
import java.io.*;
import java.text.*;




public class Launch{
  public static void main(String[] args){
          //Window win = new Window("Agenda");
          /**/
        //Si il n'existe pas de notes ou events : en creer.


        List<Note> notes = new ArrayList<Note>();
        Calendar cal = Calendar.getInstance();
        Date day = new Date();
        day = cal.getTime();

        /*Note note = new Note(day, "Premiere note");
        notes.add(note);
        //cal.add(Calendar.DATE, 1);
        cal.add(Calendar.DAY_OF_MONTH, 1);// Ajout d'un jour.
        //day = DateUtil.addDays(day, 1);
        day = cal.getTime();
        note = new Note(day, "Seconde note");
        notes.add(note);
        //System.out.println(notes.get(1));
        SeriUtil.saveNotes(notes);
        notes = null;*/
        if ((notes = SeriUtil.loadNotes()) == null)
        {
          System.out.println("Pas de fichier de notes");
          //Creer le fichier
        }
        //print notes
        int i = 0;
        while (i < notes.size())
        {
          System.out.println(notes.get(i));
          i++;
        }

        //Charger interface et update
        //Checker les rappels (POP UP ?)
        //Interpreter les boutons (Navigation, ajout de note ou rappel)


      }
}
