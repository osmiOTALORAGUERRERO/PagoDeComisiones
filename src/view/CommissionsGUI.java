package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CommissionsGUI extends JFrame{
	
	public JButton jbSellers;
	public JButton jbMonth;
	public JButton jbRegistry;
	public JButton jbMakeMoth;
	public JTextField jtfMakeMonth;
	public JTextArea jtaAnswers;
	public JOptionPane alert;
	
	public CommissionsGUI() {
		
		setTitle("Company commissions");
		setSize(800, 390);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		jbSellers = new JButton("Ver vendedores de la compañia");
		jbSellers.setBounds(10, 20, 250, 50);
		
		jbMonth = new JButton("Ver temporadas de los meses");
		jbMonth.setBounds(10, 100, 250, 50);
		
		jbRegistry = new JButton("Ver registros");
		jbRegistry.setBounds(10, 180, 250, 50);
		
		jbMakeMoth = new JButton("Realizar mes");
		jbMakeMoth.setBounds(10, 260, 150, 50);
		
		jtfMakeMonth = new JTextField();
		jtfMakeMonth.setBounds(160, 260,100, 50);
		jtfMakeMonth.replaceSelection("1 a 12");
		
		jtaAnswers = new JTextArea();
		jtaAnswers.setFont(new Font("TimesNewRoman", 2, 15));
		jtaAnswers.setEditable(false);
		JScrollPane jsc = new JScrollPane(jtaAnswers);
		jsc.setBounds(270, 20, 500, 300);
		
		add(jbSellers);
		add(jbMonth);
		add(jbRegistry);
		add(jbMakeMoth);
		add(jtfMakeMonth);
		add(jsc);
		
	}
	
	public void alertOption(String strAlert) {
		alert.showMessageDialog(null, strAlert, "Alerta", JOptionPane.WARNING_MESSAGE);
	}
}
