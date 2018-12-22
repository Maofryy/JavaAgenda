import javax.swing.*;
import java.awt.*; //Pour les layouts
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.List;
import java.text.*;

public class PagePanel extends JPanel implements ActionListener{

      private JLabel toptxt, midtxt, bottxt;
      private JPanel menutxt;
      //private JButton toptxt, midtxt, bottxt;
      private JButton newNote, newEvent;
      Record rec;
      Date day;

      public PagePanel(Record rec)
      {
        this.setLayout(new GridBagLayout());
        System.out.println(rec.day);
        this.day = rec.day;
        // this.notes = notes;
        // this.events = events;
        this.rec = rec;
        GridBagConstraints c = new GridBagConstraints();
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");

        //Affichage de la date en TOP
        toptxt = new JLabel(fmt.format(this.day));

        //Menu des boutons en Mid
        menutxt = new JPanel();
        newNote = new JButton("Nouvelle Note");
        newEvent = new JButton("Nouveau Rappel");
        menutxt.setLayout(new GridLayout(0,2));
        menutxt.add(newNote, "West");
        menutxt.add(newEvent, "East");

        //Affichage des Notes en milieu de Page
        //get index of corresponding day
        int i;
        String text;
        if ((i = ListUtil.getIndexNotes(this.day, rec.notes)) == -1)
        {
          text = "";
        }else{
          text = rec.notes.get(i).getText();
        }

        //Affichage des events en bas de page
        //int ievents = ListUtil.getIndexEvents(day, events);
        midtxt = new JLabel(text);
        if ((i = ListUtil.getIndexEvents(this.day, rec.events)) == -1)
        {
          text = "";
        }else{
          text = rec.events.get(i).getText();
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
        //Manipulation des boutons
        newNote.addActionListener(this);
        newEvent.addActionListener(this);
      }

      public void actionPerformed(ActionEvent e){

        Object ev=e.getSource();
        if (ev == newNote)
        {
          InputNote in = new InputNote("Nouvelle Note",this.day, this.rec);
          System.out.println("New Note pressed.");
          System.out.println(rec);

          SeriUtil.saveNotes(this.rec.notes);
        }else if (ev == newEvent)
        {
          System.out.println("New Event pressed.");
        }
      }

      public void update(Record rec)
      {
        int i;
        String text;
        //ListUtil.printNotes(rec.notes);
        //System.out.println(this.day);
        if ((i = ListUtil.getIndexNotes(this.day, rec.notes)) == -1)
        {
          text = "";
        }else{
          text = rec.notes.get(i).getText();
        }

        //Affichage des events en bas de page
        //int ievents = ListUtil.getIndexEvents(day, events);
        midtxt.setText(text);
        if ((i = ListUtil.getIndexEvents(this.day, rec.events)) == -1)
        {
          text = "";
        }else{
          text = rec.events.get(i).getText();
        }
        bottxt.setText(text);
      }
}
