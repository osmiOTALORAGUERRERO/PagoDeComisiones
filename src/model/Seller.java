package model;

import java.util.ArrayList;

public class Seller {
	
	private String name;
	private int id;
	private String email;
	private String cellphone;
	private ArrayList<Sale> sales = new ArrayList<Sale>();
	private ArrayList<Product> products;
	private double comission = 0;
	private double porcentage;
	

	public Seller(String name, int id, ArrayList<Product> products) {
		this.name = name;
		this.id = id;
		this.products = products;
	}
	
	public Seller(String name, int id, String email, String cellphone, ArrayList<Product> products) {
		this.name = name;
		this.id = id;
		this.email = email;
		this.cellphone = cellphone;
		this.products = products;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPorcentage() {
		return porcentage;
	}
	
	public void setPorcentage(double porcentage) {
		this.porcentage = porcentage;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Sale> getSales() {
		return sales;
	}

	public void setSales(ArrayList<Sale> sales) {
		this.sales = sales;
	}
	
	public void setProdcuts(ArrayList<Product> products) {
		this.products = products;
	}

	public double getComission() {
		return comission;
	}

	public void setComission(double comission) {
		this.comission = comission;
	}
	
	public void makeSale() {
		Sale sale = new Sale();
		for(int i=0; i<Math.random()*10+1; i++) {
			sale.addProduct(products.get((int)Math.random()*products.size()));
		}
		sales.add(sale);
	}
	
	public double salesAmount() {
		double amount = 0;
		for(int i=0; i<sales.size(); i++) {
			amount += sales.get(i).saleValue();
		}
		return amount;
	}
	
}
