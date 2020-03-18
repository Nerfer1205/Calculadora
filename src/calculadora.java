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
	char operacion =' ';
	boolean res = false;
	String ans="";

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
		setBounds(100, 100, 340, 342);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 83, 191, 203);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 11, 298, 49);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel.setBounds(0, 11, 298, 27);
		lblNewLabel.setVisible(true);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(209, 83, 115, 203);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		int posy=0;
		int posx=0;
		for (int i = 0; i < 10; i++) {
			if (i % 3 == 0) {
				if(i!=0)
					posy = posy+50;
				JButton a = new JButton(String.valueOf((i-9)*-1));
				botones.add(a);
				botones.get(i).setBounds(28 + 50, 70, 50, 50);
				botones.get(i).setLocation(0,posy);
				botones.get(i).setActionCommand("");
				botones.get(i).addActionListener(this);
				panel.add(botones.get(i));
				posx=0;
			} else {
				posx = posx+50;
				JButton a = new JButton(String.valueOf((i-9)*-1));
				botones.add(a);
				botones.get(i).setBounds(28 + 50, 70, 50, 50);
				botones.get(i).setLocation(posx, posy);
				botones.get(i).setActionCommand("");
				botones.get(i).addActionListener(this);
				panel.add(botones.get(i));
			}
		}
		JButton igual = new JButton("=");
		igual.setBounds(28 + 50, 31, 50, 50);
		igual.setLocation(posx+100,posy);
		igual.setActionCommand("igual");
		igual.addActionListener(this);
		botones.add(igual);
		panel.add(igual);
		
		JButton borrar = new JButton("C");
		borrar.setBounds(28 + 50, 31, 50, 50);
		borrar.setLocation(posx+50,posy);
		borrar.setActionCommand("borrar");
		borrar.addActionListener(this);
		botones.add(borrar);
		panel.add(borrar);
		posy =0;
		for (int i = 0; i < 6; i++) {
			if (i % 2 == 0) {
				if(i!=0)
					posy = posy+50;
				JButton a = new JButton();
				botones2.add(a);
				botones2.get(i).setBounds(28 + 50, 31, 50, 50);
				botones2.get(i).setLocation(0,posy);
				panel_2.add(botones2.get(i));
				posx=0;
			} else {
				posx = posx+50;
				JButton a = new JButton();
				botones2.add(a);
				botones2.get(i).setBounds(28 + 50, 31, 50, 50);
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
		botones2.get(4).setText("¬");
		botones2.get(4).setActionCommand("¬");
		botones2.get(4).addActionListener(this);
		botones2.get(5).setText("M");  // Equivalente al Ans de la calculadora
		botones2.get(5).setActionCommand("M");
		botones2.get(5).addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 10; i++) {
			if (e.getSource().equals(botones.get(i))) {
				if(res) {
					mostrar="";
					res = false;
					lblNewLabel.setText(mostrar);
				}
				mostrar+= String.valueOf((i-9)*-1);
				lblNewLabel.setText(mostrar);
			}
		}
		if (e.getActionCommand().equals("borrar")) {
			mostrar=" ";
			lblNewLabel.setText(mostrar);
			operacion = ' ';
		}
		if (e.getActionCommand().equals("igual")) {
			if (!lblNewLabel.getText().isBlank() && !lblNewLabel.getText().isEmpty()) {
				num2 = Double.parseDouble(lblNewLabel.getText());
				res = true;
				switch (operacion) {
				case '+':
					mostrar = String.valueOf(num1 + num2);
					lblNewLabel.setText(mostrar);
					break;
				case '-':
					mostrar = String.valueOf(num1 - num2);
					lblNewLabel.setText(mostrar);
					break;
				case '/':
					if (num2 != 0) {
						mostrar = String.valueOf(num1 / num2);
						lblNewLabel.setText(mostrar);
					} else {
						mostrar = "Syntax error";
						lblNewLabel.setText(mostrar);
					}
					break;
				case '*':
					mostrar = String.valueOf(num1 * num2);
					lblNewLabel.setText(mostrar);
					break;
				case ' ':
					mostrar = "";
					break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + operacion);
				}
			}
			ans = mostrar;
			num1 =0;
			num2= 0;
			operacion = ' ';
		}
		if (e.getActionCommand().equals("sumar")) {
			if(!lblNewLabel.getText().isEmpty() && !lblNewLabel.getText().equals("Syntax error")) {
				num1 = Double.parseDouble(lblNewLabel.getText());
			operacion = '+';
			mostrar= "";
			lblNewLabel.setText(mostrar);
			}
		}
		if (e.getActionCommand().equals("restar")) {
			if(!lblNewLabel.getText().isEmpty() && !lblNewLabel.getText().equals("Syntax error"))
				num1 = Double.parseDouble(lblNewLabel.getText());
			operacion = '-';
			mostrar= "";
			lblNewLabel.setText(mostrar);
		}
		if (e.getActionCommand().equals("multiplicar")) {
			if(!lblNewLabel.getText().isEmpty() && !lblNewLabel.getText().equals("Syntax error"))
				num1 = Double.parseDouble(lblNewLabel.getText());
			operacion = '*';
			mostrar= "";
			lblNewLabel.setText(mostrar);
		}
		if (e.getActionCommand().equals("dividir")) {
			if(!lblNewLabel.getText().isEmpty() && !lblNewLabel.getText().equals("Syntax error"))
				num1 = Double.parseDouble(lblNewLabel.getText());
			operacion = '/';
			mostrar= "";
			lblNewLabel.setText(mostrar);
		}
		if(e.getActionCommand().equals("¬")) {
			try {
			mostrar = mostrar.substring(0, mostrar.length()-1);
			lblNewLabel.setText(mostrar);
			}catch(Exception ex) {
				
			}
		}
		if(e.getActionCommand().equals("M")) {
			mostrar= ans;
			lblNewLabel.setText(mostrar);
		}
	}
}
