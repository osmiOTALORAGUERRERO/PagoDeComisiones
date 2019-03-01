package controller;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import model.Company;
import model.Month;
import view.CommissionsGUI;

public class Simulator implements ActionListener{
	
	Company salesCompany;
	CommissionsGUI comGUI;
	
	public Simulator(Company salesCompany, CommissionsGUI comGUI) {	
		this.comGUI= comGUI;
		System.out.println("Compañia de ventas SalesCompany");
		this.salesCompany = salesCompany;
		addActionsBottons();
	}
	
	public void addActionsBottons() {
		comGUI.jbSellers.addActionListener(this);
		comGUI.jbMonth.addActionListener(this);
		comGUI.jbRegistry.addActionListener(this);
		comGUI.jbMakeMoth.addActionListener(this);
	}
	
	public void payComissionsSimulator() {
		generateSellers();
		comGUI.jtaAnswers.setText(showMonthsCompany());
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
	
	private String showMonthsCompany() {
		String strMonths = "Organizacion de los Meses de la compañia\n";
		Month[] months = salesCompany.getMonths(); 
		for(int i=0; i<months.length; i++) {
			strMonths += "Mes "+(i+1)+": temporada "+months[i].getSeason()+", vendedores: "+months[i].getNumberSellers()+"\n";
		}
		return strMonths;
	}
	
	private String showSellers() {
		String sellers = "";
		sellers = "Vendedores de la compañia\n";
		for(int i=0; i<salesCompany.getSellers().size(); i++) {
			sellers += "id: "+salesCompany.getSellers().get(i).getId()+" nombre: "+salesCompany.getSellers().get(i).getName()+"\n";
		}
		return sellers;
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
	
	private String monthStats() {
		String statsSellers = "Estado de los vendedores del mes\n";
		for(int i=0; i<salesCompany.getSellersMonth().size(); i++) { 
			statsSellers += "Vendedor n°: "+salesCompany.getSellersMonth().get(i).getId()+", Nombre: "+salesCompany.getSellersMonth().get(i).getName()+
					", Numero de ventas: "+salesCompany.getSellersMonth().get(i).getSales().size()+", Monto ventas: $"+salesCompany.getSellersMonth().get(i).salesAmount()+
					", Porcentage de comision: %"+salesCompany.getSellersMonth().get(i).getPorcentage()+", Comsion pagada: $"+salesCompany.getSellersMonth().get(i).getComission()+"\n";
		}
		return statsSellers;
	}
	
	private void showRegistry() {
		try {
            Desktop.getDesktop().open(salesCompany.getRegiFile());
		}catch (IOException ex) {
            System.out.println(ex);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == comGUI.jbSellers) {
			comGUI.jtaAnswers.setText(showSellers());
		}else if(e.getSource() == comGUI.jbMonth) {
			comGUI.jtaAnswers.setText(showMonthsCompany());
		}else if(e.getSource() == comGUI.jbRegistry) {
			comGUI.jtaAnswers.setText("Abriendo registro...");
			showRegistry();
		}else if(e.getSource() == comGUI.jbMakeMoth){
			String alert = "";
			try {				
				int month = Integer.parseInt(comGUI.jtfMakeMonth.getText());
				if(month >= 1 && month <= 12) {
					chooseMonth(month);
					salesCompany.comissionsPaymet();
					comGUI.jtaAnswers.setText(monthStats());
					salesCompany.endMonth();
				}else {
					alert = "El mes "+month+" no entra en el rango logico de meses";
					comGUI.alertOption(alert);
				}
			} catch (NumberFormatException ex) {
				alert = "No es un numero";
				comGUI.alertOption(alert);
			}			
		}
		
	}
}
