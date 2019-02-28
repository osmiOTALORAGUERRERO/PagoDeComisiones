package main;

import controller.Simulator;
import model.Company;
/**
 * 
 * @author Osmi Santiago Otálora Guerrero
 *
 */
public class Main {
	
	public static void main (String[] args) {
		
		Company salesCompany = new Company();
		Simulator simulator = new Simulator(salesCompany);
		simulator.payComissionsSimulator();
		
	}

}
