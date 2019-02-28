package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Forms {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public int companyOptions(){
		int op = 0;
		System.out.println("Bienvenido");
		System.out.println("1. Ver Vendedores");
		System.out.println("2. Ver meses");
		System.out.println("3. Ver registro de comisiones");
		System.out.println("4. Realizar mes");
		System.out.println("0. cerrar compañia");
		try {
			op = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
			System.out.println("Error caracter ingresado: "+e);
			return companyOptions();
		}
		return op;
	}
	
	public int formChooseMonth() {
		int month=0;
		System.out.println("Cual mes desea ejecutar");
		System.out.println("Escoje un numero del mes 1-12, numero del mes repectivamente con el nombre: ");
		try {
			month = Integer.parseInt(br.readLine());
			if(month < 1 || month > 12)
				return formChooseMonth();
		} catch (NumberFormatException | IOException e) {
			System.out.println("Error caracter ingresado: "+e);
			return formChooseMonth();
		}
		return month;
	}
	
	public int formMonthStats() {
		int stats = 0;
		System.out.println("Desea ver las estadisticas de los vendedores en el mes: ");
		System.out.println("1. Si \n2. No");
		try {
			stats = Integer.parseInt(br.readLine());
			if(stats != 1 && stats != 2)
				return formMonthStats();
		} catch (NumberFormatException | IOException e) {
			System.out.println("Error caracter ingresado: "+e);
			return formMonthStats();
		}
		return stats;
	}
}
