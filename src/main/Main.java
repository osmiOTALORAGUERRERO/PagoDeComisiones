package main;

import java.io.File;
import java.io.IOException;

import controller.Simulator;
import model.Company;

public class Main {
	
	public static void main (String[] args) {
		
		Company salesCompany = new Company();
		Simulator simulator = new Simulator(salesCompany);
		simulator.payComissionsSimulator();
		
	}

}
