package model;

import java.util.ArrayList;

public class Seller {
	private String name;
	private int id;
	private String email;
	private String cellphone;
	private ArrayList<Sale> sales;
	private ArrayList<Product> products;
	private double comission = 0;
	
	public Seller(String name, int id, String email, String cellphone, ArrayList<Product> products) {
		this.name = name;
		this.id = id;
		this.email = email;
		this.cellphone = cellphone;
		this.products = products;
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
		
	}
	
	public double salesAmount() {
		return 0.0;
	}
	
}
