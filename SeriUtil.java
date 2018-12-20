import java.util.*;
import java.io.*;

public class SeriUtil
{
  public static void saveNotes(List<Note> notes){
    try {
    FileOutputStream fos = new FileOutputStream("Notes.ser");
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(notes);
    oos.close();
    fos.close();
  }
  catch (IOException e){
    e.printStackTrace();
  }
  }

  @SuppressWarnings("unchecked")
  public static List<Note> loadNotes(){
    List<Note> e = null;
    try {
         FileInputStream fos = new FileInputStream("Notes.ser");
         ObjectInputStream oos = new ObjectInputStream(fos);
         e = (List<Note>) oos.readObject();
         oos.close();
         fos.close();
         return e;
      } catch (IOException i) {
         i.printStackTrace();
         return null;
      } catch (ClassNotFoundException c) {
         System.out.println("Notes file not found");
         c.printStackTrace();
         return null;
      }
  }

  public static void saveNotes(List<Events> events){
    try {
    FileOutputStream fos = new FileOutputStream("Events.ser");
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(events);
    oos.close();
    fos.close();
  }
  catch (IOException e){
    e.printStackTrace();
  }
  }

  @SuppressWarnings("unchecked")
  public static List<Event> loadEvents(){
    List<Note> e = null;
    try {
         FileInputStream fos = new FileInputStream("Events.ser");
         ObjectInputStream oos = new ObjectInputStream(fos);
         e = (List<Note>) oos.readObject();
         oos.close();
         fos.close();
         return e;
      } catch (IOException i) {
         i.printStackTrace();
         return null;
      } catch (ClassNotFoundException c) {
         System.out.println("Events file not found");
         c.printStackTrace();
         return null;
      }
  }
}
