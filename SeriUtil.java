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

  public static void saveEvents(List<Event> events){
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
    List<Event> e = null;
    try {
         FileInputStream fos = new FileInputStream("Events.ser");
         ObjectInputStream oos = new ObjectInputStream(fos);
         e = (List<Event>) oos.readObject();
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

  public static void saveRecord(Record rec){
    try {
    FileOutputStream fos = new FileOutputStream("Record.ser");
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(rec);
    oos.close();
    fos.close();
  }
  catch (IOException e){
    e.printStackTrace();
  }
  }

  @SuppressWarnings("unchecked")
  public static Record loadRecord(){
    Record e = null;
    try {
         FileInputStream fos = new FileInputStream("Record.ser");
         ObjectInputStream oos = new ObjectInputStream(fos);
         e = (Record) oos.readObject();
         oos.close();
         fos.close();
         return e;
      } catch (IOException i) {
         i.printStackTrace();
         return null;
      } catch (ClassNotFoundException c) {
         System.out.println("Record file not found");
         c.printStackTrace();
         return null;
      }
  }
}
