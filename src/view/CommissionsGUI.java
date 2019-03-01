package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CommissionsGUI extends JFrame{
	
	JButton jbSellers;
	JButton jbMonth;
	JButton jbRegistry;
	JButton jbMakeMoth;
	JTextField jtfMakeMonth;
	JTextArea jtaAnswers;
	
	public CommissionsGUI() {
		
		setTitle("Company commissions");
		setSize(600, 390);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		jbSellers = new JButton("Ver vendedores de la compañia");
		jbSellers.setBounds(10, 20, 250, 50);
		
		jbMonth = new JButton("Ver temporadas de los meses");
		jbMonth.setBounds(10, 100, 250, 50);
		
		jbRegistry = new JButton("Ver registros");
		jbRegistry.setBounds(10, 180, 250, 50);
		
		jbMakeMoth = new JButton("Realizar un mes");
		jbMakeMoth.setBounds(10, 260, 150, 50);
		
		jtfMakeMonth = new JTextField();
		jtfMakeMonth.setBounds(160, 260,100, 50);
		
		jtaAnswers = new JTextArea();
		jtaAnswers.setBounds(270, 20, 310, 300);
		jtaAnswers.setEditable(false);
		
		add(jbSellers);
		add(jbMonth);
		add(jbRegistry);
		add(jbMakeMoth);
		add(jtfMakeMonth);
		add(jtaAnswers);
		
	}
}
