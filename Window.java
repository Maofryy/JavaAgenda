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
      pan.setLayout(new GridLayout(1,2));
      pan.add(left);
      pan.add(right);
      contentPane.add(pan);

      //pack();
      setVisible(true);
    }
}
