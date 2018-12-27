import javax.swing.*;
import java.awt.*; //Pour les layouts
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.List;
import java.lang.*;
import java.awt.event.*;

public class InputEvent extends JFrame implements ActionListener{

	JButton cancel, validate;
	Record rec;
	Date day;
	JComboBox<String> cb;
	JTextField input;
	Integer flag = 0;

	public InputEvent (String name, Date day, Record rec)
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
		JLabel text = new JLabel("Nouveau Rappel :");

		cb = new JComboBox<String>();
		int i = 0;
		while (i < rec.events.get(0).types.length)
		{
			cb.addItem(rec.events.get(0).types[i++]);
		}

		input = new JTextField();
		JPanel panButtons = new JPanel();
		validate = new JButton("Enregistrer");
		cancel = new JButton("Annuler");

		panButtons.setLayout(new GridLayout(0,2));
		pan.setLayout(new GridLayout(4,0));

		pan.add(text);
		pan.add(cb);
		pan.add(input);
		panButtons.add(cancel);
		panButtons.add(validate);
		pan.add(panButtons);

		contentPane.add(pan);
		setVisible(true);
		validate.addActionListener(this);
		cancel.addActionListener(this);
		this.getRootPane().setDefaultButton(validate);
		this.addWindowListener( new WindowAdapter() 
		{
			public void windowOpened( WindowEvent e )
			{
				input.requestFocus();
			}
		});
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
				Event event = new Event(this.day, this.input.getText(), this.cb.getSelectedIndex());
				System.out.println(this.rec);
				System.out.println(this.day);
				if ((i = ListUtil.getIndexEvents(this.day, this.rec.events)) != -1)
				{
					this.rec.events.get(i).addEvent(this.input.getText(), this.cb.getSelectedIndex());
					System.out.println(this.cb.getSelectedIndex());
				}else{
					this.rec.events.add(event);
				}
				//System.out.println("Adding new note : "+ this.input.getText());
				this.dispose();
			}

		}
	}
