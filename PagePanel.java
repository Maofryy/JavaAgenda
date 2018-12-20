import javax.swing.*;
import java.awt.*; //Pour les layouts
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PagePanel extends JPanel {

      private JLabel toptxt, menutxt, midtxt, bottxt;
      //private JButton toptxt, midtxt, bottxt;

      public PagePanel()
      {
        /*
        top.setLayout(new GridLayout(1,1));
        mid.setLayout(new GridLayout(1,1));
        bot.setLayout(new GridLayout(1,1));
        JLabel toptxt = new JLabel();
        JLabel midtxt = new JLabel();
        JLabel bottxt = new JLabel();
        toptxt.setText("TOP");
        midtxt.setText("MID");
        bottxt.setText("BOT");

        top.add(toptxt);
        contentPane.add(top);
        mid.add(midtxt);
        contentPane.add(mid);
        bot.add(bottxt);
        contentPane.add(bot);

        setVisible(true);*/
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        /*toptxt = new JLabel();
        midtxt = new JLabel();
        bottxt = new JLabel();
        toptxt.setText("TOP");
        midtxt.setText("MID");
        bottxt.setText("BOT");*/
        toptxt = new JLabel("Date");
        menutxt = new JLabel("Commandes");
        midtxt = new JLabel("Notes");
        bottxt = new JLabel("Rappels et Evenements");



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
