import javax.swing.*;
import java.awt.*; //Pour les layouts
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.List;



public class Window extends JFrame{




    public Window(String name, Date day, List<Note> notes, List<Event> events){
      super(name);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocation(300,100);
      setSize(1200,800);



      Container contentPane = getContentPane();

      JPanel pan = new JPanel();
      JPanel left = new PagePanel(day, notes, events);

      Calendar cal = Calendar.getInstance();
      cal.setTime(day);
      cal.add(Calendar.DAY_OF_MONTH, 1);
      day = cal.getTime();
      JPanel right = new PagePanel(day, notes, events);

      left.setBackground(Color.green);
      pan.setLayout(new GridLayout(0,2));
      pan.add(left, "West");
      pan.add(right, "East");
      contentPane.add(pan);

      //pack();
      setVisible(true);
    }
}
