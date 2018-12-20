import javax.swing.*;
import java.awt.*; //Pour les layouts
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.List;
import java.text.*;

public class PagePanel extends JPanel {

      private JLabel toptxt, menutxt, midtxt, bottxt;
      //private JButton toptxt, midtxt, bottxt;

      public PagePanel(Date day, List<Note> notes, List<Note> events)
      {
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");

        toptxt = new JLabel(fmt.format(day));
        menutxt = new JLabel("Commandes");
        //get index of corresponding day
        int i;
        String text;
        if ((i = ListUtil.getIndex(day, notes)) == -1)
        {
          text = "";
        }else{
          text = notes.get(i).getText();
        }
        System.out.println(text);
        //int ievents = ListUtil.getIndexEvents(day, events);
        midtxt = new JLabel(text);
        if ((i = ListUtil.getIndex(day, events)) == -1)
        {
          text = "";
        }else{
          text = events.get(i).getText();
        }
        bottxt = new JLabel(text);



        c.fill = GridBagConstraints.BOTH;
        c.gridy = 1;
        this.add(toptxt, c);
        c.gridy = 2;
        this.add(menutxt, c);
        c.gridy = 3;
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 2;
        c.weighty = 1.0;
        this.add(midtxt, c);
        c.gridy = 5;
        c.weighty = 0.0;
        c.gridheight = 1;
        //c.fill = GridBagConstraints.VERTICAL;

        this.add(bottxt, c);
      }
}
