package main;

import controller.Simulator;
import model.Company;
import view.CommissionsGUI;
/**
 * 
 * @author Osmi Santiago Otálora Guerrero
 *
 */
public class Main {
	
	public static void main (String[] args) {
		
		CommissionsGUI comGUI = new CommissionsGUI();
		Company salesCompany = new Company();
		Simulator simulator = new Simulator(salesCompany, comGUI);
		simulator.payComissionsSimulator();
		comGUI.setVisible(true);
	}

}
