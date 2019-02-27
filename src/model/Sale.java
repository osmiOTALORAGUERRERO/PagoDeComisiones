package model;

import java.util.ArrayList;

public class Sale {
	private ArrayList<Product> products;
	
	public void addProduct(Product product) {
		products.add(product);
	}
	
	public double saleValue() {
		double total = 0;
		for(int i=0; i<products.size(); i++) {
			total += products.get(i).getPrice();
		}
		return total;
	}
}
