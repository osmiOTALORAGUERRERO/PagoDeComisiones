package main;

import java.text.DecimalFormat;

import controller.Simulator;
import model.Company;

public class Main {
	
	public static void main (String[] args) {
		
		Company salesCompany = new Company();
		Simulator simulator = new Simulator(salesCompany);
		simulator.payComissionsSimulator();
	}

}
