import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;

public class Binaria extends JFrame implements ActionListener {

	private JPanel contentPane;
	private String op1="";
	private String op2="";
	private Calculadora_bin a = new Calculadora_bin();
	char operacion=' ';
	private String Ans =" ";
	JLabel lblNewLabel = new JLabel("");
	String mostrar="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Binaria frame = new Binaria();
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
	public Binaria() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 334, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 298, 69);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel.setBounds(10, 11, 278, 47);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 91, 298, 202);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("0");
		btnNewButton.setBounds(10, 11, 70, 40);
		btnNewButton.setActionCommand("0");
		btnNewButton.addActionListener(this);
		panel_1.add(btnNewButton);
		
		JButton btnC = new JButton("C");
		btnC.setBounds(10, 68, 70, 40);
		btnC.setActionCommand("C");
		btnC.addActionListener(this);
		panel_1.add(btnC);
		
		JButton btnNewButton_2 = new JButton("1");
		btnNewButton_2.setBounds(118, 11, 70, 40);
		btnNewButton_2.setActionCommand("1");
		btnNewButton_2.addActionListener(this);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("=");
		btnNewButton_3.setBounds(118, 68, 70, 40);
		btnNewButton_3.setActionCommand("=");
		btnNewButton_3.addActionListener(this);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("+");
		btnNewButton_4.setBounds(219, 11, 70, 40);
		btnNewButton_4.setActionCommand("+");
		btnNewButton_4.addActionListener(this);
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("-");
		btnNewButton_5.setBounds(219, 68, 70, 40);
		btnNewButton_5.setActionCommand("-");
		btnNewButton_5.addActionListener(this);
		panel_1.add(btnNewButton_5);
		
		JButton btnNewButton_1 = new JButton("*");
		btnNewButton_1.setBounds(10, 124, 70, 40);
		btnNewButton_1.setActionCommand("*");
		btnNewButton_1.addActionListener(this);
		panel_1.add(btnNewButton_1);
		
		JButton btnM = new JButton("M");
		btnM.setBounds(118, 124, 70, 40);
		btnM.setActionCommand("M");
		btnM.addActionListener(this);
		panel_1.add(btnM);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("0")) {
			mostrar += "0";
			lblNewLabel.setText(mostrar);
		}
		if(e.getActionCommand().equals("1")) {
			mostrar += "1";
			lblNewLabel.setText(mostrar);
		}
		if(e.getActionCommand().equals("+")) {
			if (!lblNewLabel.getText().isEmpty()) {
				op1 = lblNewLabel.getText();
				operacion = '+';
			}
			mostrar ="";
			lblNewLabel.setText(mostrar);
		}
		if(e.getActionCommand().equals("-")) {
			if (!lblNewLabel.getText().isEmpty()) {
				op1 = lblNewLabel.getText();
				operacion = '-';
			}
			mostrar ="";
			lblNewLabel.setText(mostrar);
		}
		if(e.getActionCommand().equals("*")) {
			if (!lblNewLabel.getText().isEmpty()) {
				op1 = lblNewLabel.getText();
				operacion = '*';
			}
			mostrar ="";
			lblNewLabel.setText(mostrar);
		}
		if(e.getActionCommand().equals("C")) {
			mostrar ="";
			lblNewLabel.setText(mostrar);
			operacion = ' ';
		}
		if(e.getActionCommand().equals("M")) {
			mostrar =Ans;
			lblNewLabel.setText(mostrar);
			operacion = ' ';
		}
		if(e.getActionCommand().equals("=")) {
			op2 = lblNewLabel.getText();
			switch (operacion) {
			case '+':  
				mostrar =a.sumar(op1, op2);
				lblNewLabel.setText(mostrar);
				operacion = ' ';
				Ans = mostrar;
				break;
			case '-':
				mostrar =a.restar(op1, op2);
				lblNewLabel.setText(mostrar);
				operacion = ' ';
				Ans = mostrar;
				break;
			case '*':
				mostrar =a.multiplicar(op1, op2);
				lblNewLabel.setText(mostrar);
				operacion = ' ';
				Ans = mostrar;
			case ' ':
				break;
				
			default:
				throw new IllegalArgumentException("Unexpected value: " + operacion);
			}
			
		}
		
	}
}
