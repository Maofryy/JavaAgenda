import javax.swing.*;
import java.awt.*; //Pour les layouts
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.List;



public class Window extends JFrame{


    String str;
	Date day;

    public Window(String name, Date day, Record rec){
      super(name);
	this.day = day;
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocation(300,100);
      setSize(1200,800);

      this.str = SeriUtil.loadNotes().toString();

      Container contentPane = getContentPane();

      JPanel pan = new JPanel();
      PagePanel left = new PagePanel(day, rec);

      Calendar cal = Calendar.getInstance();
      cal.setTime(day);
      cal.add(Calendar.DAY_OF_MONTH, 1);
      day = cal.getTime();
      PagePanel right = new PagePanel(day, rec);

      Color colo = new Color(255, 230, 179);
	left.setBackground(colo);
      pan.setLayout(new GridLayout(0,2));
      pan.add(left, "West");
      pan.add(right, "East");
      contentPane.add(pan);

      //pack();
      setVisible(true);
      while(true)
      {
        left.update(rec);
        right.update(rec);
        if (!rec.notes.toString().equals(this.str))
        {
          str = rec.notes.toString();
          // System.out.println("Record has been changed, serializing.");
          SeriUtil.saveNotes(rec.notes);
          SeriUtil.saveEvents(rec.events);
        }
      }
    }
}
