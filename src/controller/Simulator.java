package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import model.Company;
import model.Month;
import view.Forms;

public class Simulator {
	
	Company salesCompany;
	Forms forms = new Forms();
	
	public Simulator(Company salesCompany) {
		System.out.println("Compañia de ventas SalesCompany");
		this.salesCompany = salesCompany;
	}
	
	public void payComissionsSimulator() {
		generateSellers();
		showMonthsCompany();
		int option = 0;
		do {
			option = forms.companyOptions();
			executeOption(option);
		}while(option != 0);
	}
	
	private void generateSellers() {
		System.out.println("Generando vendedores...");
		salesCompany.addSeller("Santiago", 1);
		salesCompany.addSeller("Manuela", 2);
		salesCompany.addSeller("Andres", 3);
		salesCompany.addSeller("Mariana", 4);
		salesCompany.addSeller("Vladimir", 5);
		salesCompany.addSeller("Oscar", 6);
		salesCompany.addSeller("Jaime", 7);
		salesCompany.addSeller("Camila", 8);
		salesCompany.addSeller("Heidy", 9);
		salesCompany.addSeller("Stiven", 10);
	}
	
	private void showMonthsCompany() {
		System.out.println(" Organizacion de los Meses de la compañia");
		Month[] months = salesCompany.getMonths(); 
		for(int i=0; i<months.length; i++) {
			System.out.println("Mes "+(i+1)+": temporada "+months[i].getSeason()+", vendedores: "+months[i].getNumberSellers());
		}
	}
	
	
	
	private void executeOption(int option) {
		switch (option) {
		case 0:
			System.out.println("bye");
			break;			
		case 1://ver vendedores
			showSellers();
			break;
		case 2://Ver meses
			showMonthsCompany();
			break;
		case 3://Ver registro de comisiones
			showRegistry();
			break;
		case 4://realizar mes
			chooseMonth(forms.formChooseMonth());
			monthStats(forms.formMonthStats());
			salesCompany.comissionsPaymet();
			salesCompany.endMonth();
			break;
		default:
			System.out.println("Opcion invalida");
			break;
		}
	}
	
	private void showSellers() {
		System.out.println("Vendedores de la compañia");
		for(int i=0; i<salesCompany.getSellers().size(); i++) {
			System.out.println("id: "+salesCompany.getSellers().get(i).getId()+" nombre: "+salesCompany.getSellers().get(i).getName());
		}
	}
	
	private void chooseMonth(int month) {
		salesCompany.addSellersMonth(month);
		for(int i=0; i<salesCompany.getSellersMonth().size(); i++) {
			int salesNum = (int)Math.floor(Math.random()*12);
			for(int j=0; j<salesNum; j++) {
				salesCompany.getSellersMonth().get(i).makeSale();
			}
		}
	}
	
	private void monthStats(int stats) {
		if(stats == 1) {
			for(int i=0; i<salesCompany.getSellersMonth().size(); i++) { 
				System.out.println("name: "+salesCompany.getSellersMonth().get(i).getName()+
						", numero de ventas: "+salesCompany.getSellersMonth().get(i).getSales().size()+
						", monto total de las ventas: $"+salesCompany.getSellersMonth().get(i).salesAmount());
			}
		}
	}
	
	private void showRegistry() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(salesCompany.getRegiFile()));
			while(br.readLine() != null) {
				System.out.println(br.readLine());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
