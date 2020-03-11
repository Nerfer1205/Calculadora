import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;

public class calculadora extends JFrame implements ActionListener{

	private JPanel contentPane;
	ArrayList<JButton> botones = new ArrayList<>();
	ArrayList<JButton> botones2 = new ArrayList<>();
	String mostrar =" ";
	JLabel lblNewLabel = new JLabel("");
	double num1=0;
	double num2 =0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calculadora frame = new calculadora();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public calculadora() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 392, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 83, 191, 167);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 11, 356, 49);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel.setBounds(0, 11, 356, 27);
		lblNewLabel.setVisible(true);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(211, 83, 155, 167);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		int posy=0;
		int posx=0;
		for (int i = 0; i < 10; i++) {
			if (i % 3 == 0) {
				posy = i*12;
				JButton a = new JButton(String.valueOf((i-9)*-1));
				botones.add(a);
				botones.get(i).setBounds(28 + 50, 31, 45, 23);
				botones.get(i).setLocation(0,posy);
				botones.get(i).setActionCommand("");
				botones.get(i).addActionListener(this);
				panel.add(botones.get(i));
				posx=0;
			} else {
				posx = posx+50;
				JButton a = new JButton(String.valueOf((i-9)*-1));
				botones.add(a);
				botones.get(i).setBounds(28 + 50, 31, 45, 23);
				botones.get(i).setLocation(posx, posy);
				botones.get(i).setActionCommand("");
				botones.get(i).addActionListener(this);
				panel.add(botones.get(i));
			}
		}
		JButton igual = new JButton("=");
		igual.setBounds(28 + 50, 31, 45, 23);
		igual.setLocation(posx+100,posy);
		igual.setActionCommand("igual");
		igual.addActionListener(this);
		botones.add(igual);
		panel.add(igual);
		
		JButton borrar = new JButton("C");
		borrar.setBounds(28 + 50, 31, 45, 23);
		borrar.setLocation(posx+50,posy);
		borrar.setActionCommand("borrar");
		borrar.addActionListener(this);
		botones.add(borrar);
		panel.add(borrar);
		
		for (int i = 0; i < 6; i++) {
			if (i % 2 == 0) {
				posy = i*16;
				JButton a = new JButton();
				botones2.add(a);
				botones2.get(i).setBounds(28 + 50, 31, 45, 23);
				botones2.get(i).setLocation(0,posy);
				panel_2.add(botones2.get(i));
				posx=0;
			} else {
				posx = posx+50;
				JButton a = new JButton();
				botones2.add(a);
				botones2.get(i).setBounds(28 + 50, 31, 45, 23);
				botones2.get(i).setLocation(posx, posy);
				panel_2.add(botones2.get(i));
			}
		}
		botones2.get(0).setText("+");
		botones2.get(0).setActionCommand("sumar");
		botones2.get(0).addActionListener(this);
		botones2.get(1).setText("-");
		botones2.get(1).setActionCommand("restar");
		botones2.get(1).addActionListener(this);
		botones2.get(2).setText("/");
		botones2.get(2).setActionCommand("dividir");
		botones2.get(2).addActionListener(this);
		botones2.get(3).setText("*");
		botones2.get(3).setActionCommand("multiplicar");
		botones2.get(3).addActionListener(this);
		botones2.get(4).setText("(");
		botones2.get(4).setActionCommand("(");
		botones2.get(4).addActionListener(this);
		botones2.get(5).setText(")");
		botones2.get(5).setActionCommand(")");
		botones2.get(5).addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 10; i++) {
			if (e.getSource().equals(botones.get(i))) {
				mostrar+= String.valueOf((i-9)*-1);
				lblNewLabel.setText(mostrar);
			}
		}
		if (e.getActionCommand().equals("borrar")) {
			mostrar=" ";
			lblNewLabel.setText(mostrar);
		}
		if (e.getActionCommand().equals("sumar")) {
			mostrar+= "+";
			lblNewLabel.setText(mostrar);
		}
		if (e.getActionCommand().equals("restar")) {
			mostrar+= "-";
			lblNewLabel.setText(mostrar);
		}
		if (e.getActionCommand().equals("multiplicar")) {
			mostrar+= "*";
			lblNewLabel.setText(mostrar);
		}
		if (e.getActionCommand().equals("dividir")) {
			mostrar+= "/";
			lblNewLabel.setText(mostrar);
		}
		if (e.getActionCommand().equals("(")) {
			mostrar+= "(";
			lblNewLabel.setText(mostrar);
		}
		if (e.getActionCommand().equals(")")) {
			mostrar+= ")";
			lblNewLabel.setText(mostrar);
		}
	}
}
