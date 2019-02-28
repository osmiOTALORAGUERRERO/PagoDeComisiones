package model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Company {
	protected String name = "The good sale company";
	protected ArrayList<Product> products = new ArrayList<Product>();
	protected ArrayList<Seller> sellers = new ArrayList<Seller>();
	protected Month[] months = new Month[12];
	protected ArrayList<Seller> sellersMonth = new ArrayList<Seller>();
	private DecimalFormat df = new DecimalFormat("#.##");
	private int currentMonth = 0;
	private File registerCommissions;
	private BufferedWriter br;
	
	public Company() {
		registerCommissions = new File("src/documents/registerCommissions.txt");
		generateProducts();
		defineMonths();
		try {
			if (!registerCommissions.exists()) {   
					registerCommissions.createNewFile();				
	        }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	public ArrayList<Seller> getSellersMonth() {
		return sellersMonth;
	}

	public void setSellers(ArrayList<Seller> sellers) {
		this.sellers = sellers;
	}

	public ArrayList<Seller> getSellers() {
		return sellers;
	}

	public Month[] getMonths() {
		return months;
	}
	
	public void addSeller(Seller seller) {
		sellers.add(seller);
	}
	public void addSeller(String name, int id) {
		sellers.add(new Seller(name, id, products));
	}
	
	public void comissionsPaymet() {
		System.out.println("Definiendo comisiones de empleados...");
		System.out.print(sellersMonth);
		for(int i=0; i<sellersMonth.size(); i++) {
			sellersMonth.get(i).setPorcentage(commissionPorcentage(sellersMonth.get(i).salesAmount()));
			sellersMonth.get(i).setComission(calculateComission(sellersMonth.get(i).getPorcentage(), sellersMonth.get(i).salesAmount()));
			generateRegister(sellersMonth.get(i));
		}
	}
	
	private void generateRegister(Seller sellerMonth) {
		try {
			br = new BufferedWriter(new FileWriter(registerCommissions));
			br.write("Mes: "+currentMonth+"\n");
			br.write("Vendedor n°: "+sellerMonth.getId()+", Nombre: "+sellerMonth.getName()+
					", Numero de ventas: "+sellerMonth.getSales().size()+", Monto ventas: $"+sellerMonth.salesAmount()+
					", Porcentage de comision: %"+sellerMonth.getPorcentage()+", Comsion pagada: $"+sellerMonth.getComission());
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void defineMonths() {
		System.out.println("Definiendo meses...");
		String[] season = {"Low","mid","High"};
		int[] numSallers = {1,2,4};
		int seasonChose;
		for(int i=0; i<12; i++) {
			seasonChose = (int)Math.floor(Math.random()*3);	
			months[i] = new Month(i+1+"", season[seasonChose], numSallers[seasonChose]);
		}
	}
	
	private int i = 0;
	public void addSellersMonth(int month) {
		currentMonth = month;
		do {
			if(i < sellers.size()) {
				sellersMonth.add(sellers.get(i));
				i++;
			}else {
				i = 0;
				sellersMonth.add(sellers.get(i));
			}			
		}while(sellersMonth.size() != months[month-1].getNumberSellers());
	}
	
	private void generateProducts() {
		System.out.println("Generando productos...");
		for(int i=0; i<20; i++) {
			products.add(new Product("product"+i, Double.parseDouble(df.format(Math.random()*300+50))));
		}
	}
	
	private double calculateComission(double commissionPorcentage,double salesAmmount) {
		return salesAmmount*commissionPorcentage/100;
	}
	
	private double commissionPorcentage(double ammount) {
		double porcentage = 2;
		porcentage = ammount*porcentage/5000;
		return porcentage;
	}
}
