import javax.swing.*;
import java.awt.*; //Pour les layouts
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class Window extends JFrame{




    public Window(String name){
      super(name);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocation(300,100);
      setSize(1200,800);

      Container contentPane = getContentPane();

      JPanel pan = new JPanel();
      JPanel left = new PagePanel();
      JPanel right = new PagePanel();
      left.setBackground(Color.green);
      pan.setLayout(new GridLayout(0,2));
      pan.add(left, "West");
      pan.add(right, "East");
      contentPane.add(pan);

      //pack();
      setVisible(true);
    }
}
