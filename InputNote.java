import javax.swing.*;
import java.awt.*; //Pour les layouts
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.List;
import java.lang.*;

public class InputNote extends JFrame implements ActionListener{

	JButton cancel, validate;
	Record rec;
	Date day;
	JTextField input;
	Integer flag = 0;

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
		int i;
		if ((i = ListUtil.getIndexNotes(day, rec.notes)) != -1)
		{
			input.setText(rec.notes.get(i).getText());
		}
		setVisible(true);
		validate.addActionListener(this);
		cancel.addActionListener(this);
		this.getRootPane().setDefaultButton(validate);
	}

	public void actionPerformed(ActionEvent e){
		Object ev=e.getSource();
		if (ev == cancel)
		{
			this.flag = -1;
			this.dispose();
		}else if (ev == validate)
		{
			this.flag = 1;
			Integer i;
			Note note = new Note(this.day, this.input.getText());
			if ((i = ListUtil.getIndexNotes(this.day, this.rec.notes)) != -1)
			{
				this.rec.notes.get(i).setText(note.getText());
			}
			else
			{
				this.rec.notes.add(note);
			}
			//si il existe une note dans la liste corespondant au meme jour, la remplacer.
			//System.out.println("Adding new note : "+ this.input.getText());
			this.dispose();
		}

	}
}
