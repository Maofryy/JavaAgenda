import javax.swing.*;
import java.awt.*; //Pour les layouts
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.List;

public class InputNote extends JFrame implements ActionListener{

  JButton cancel, validate;
  Record rec;
  Date day;
  JTextField input;

  public InputNote (String name, Date day, Record rec)
  {
    super(name);
    this.day = day;
    // this.notes = notes;
    // this.events = events;
    this.rec = rec;
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setLocation(500,300);
    setSize(500, 400);

    Container contentPane = getContentPane();

    JPanel pan = new JPanel();
    JLabel text = new JLabel("Nouvelle note :");
    input = new JTextField();
    JPanel panButtons = new JPanel();
    validate = new JButton("Enregistrer");
    cancel = new JButton("Annuler");

    panButtons.setLayout(new GridLayout(0,2));
    pan.setLayout(new GridLayout(3,0));

    pan.add(text);
    pan.add(input);
    panButtons.add(cancel);
    panButtons.add(validate);
    pan.add(panButtons);

    contentPane.add(pan);
    setVisible(true);
    validate.addActionListener(this);
    cancel.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e){
    Object ev=e.getSource();
    if (ev == cancel)
    {
      this.dispose();
    }else if (ev == validate)
    {
      Note note = new Note(this.day, this.input.getText());
      //si il existe une note dans la liste corespondant au meme jour, la remplacer.
      this.rec.notes.add(note);
      System.out.println("Adding new note : "+ this.input.getText());
      this.dispose();
    }

  }
}
