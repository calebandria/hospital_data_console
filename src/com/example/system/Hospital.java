package com.example.system;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.personnel.*;
import com.example.person.*;

public class Hospital {
	private Stock stockGros;
	private Stock stockUrgence;
	private Stock stockPharmacie;
	private Finance hospitalFinance;
	private List<Personnel> employees;
	private Admin admin;
	
	public Hospital() {
		this.stockGros =  new Gros();
		this.stockUrgence = new MedocUrgence();
		this.stockPharmacie = new Pharmacie();
		this.hospitalFinance = new Finance();
		this.admin = new Admin("admin", "john");
		
	}
	
	public void setStockGros(Stock stockGros) {
		this.stockGros = stockGros;
	}
	
	public void setStockUrgence(Stock stockUrgence) {
		this.stockUrgence = stockUrgence;
	}
	
	public void setStockPharmacie(Stock stockPharmacie) {
		this.stockPharmacie = stockPharmacie;
	}
	
	public void setEmployees(List<Personnel> employees) {
		this.employees = employees;
	}
	
	public void setFinance(Finance hospitalFinance) {
		this.hospitalFinance = hospitalFinance;
	}
	
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	
	public Stock getStockGros() {
		return stockGros;
	}
	
	public Stock getStockPharmacie() {
		return stockPharmacie;
	}
	
	public Stock getStockMedocUrgence() {
		return stockUrgence;
	}
	
	public List<Personnel> getEmployees(){
		return employees;
	}
	
	public Admin getAdmin(){
		return admin;
	}
	
	public Finance getFinance() {
		return hospitalFinance;
	}
	
//	public void authenticationEmployee() {
//		Scanner scanner = new Scanner(System.in);
//		Personnel authenticatingPerson = null;
//		int attempt = 3;
//		
//		System.out.println("Bonjour, bienvenu au sein du système!");
//		String code = null;
//
//		
//		while(attempt != 0) {
//			System.out.println("Veuillez entrer votre code");
//			code = scanner.nextLine();
//			attempt --;
//			for(Personnel employee: employees) {
//				if(employee.getCode() == (code)) {
//				authenticatingPerson = employee;
//				break;
//				}
//			}
//		
//			if(authenticatingPerson != null) {
//				System.out.println("Bienvenu "+ authenticatingPerson.getFirstname() + " " + authenticatingPerson.getLastname());
//			}
//			else {
//				System.out.println("Mot de passe erroné!");
//				System.out.println("Plus que " + attempt +"!");
//			}
//		}
//		scanner.close();
//		
//	}
	
	public void adminAuthenticate(String adminUsername) {
		if(admin.getFirstname() == adminUsername) {
			System.out.println("Bienvenu "+ adminUsername);
			System.out.println("Votre code est "+ admin.getCode());
		}
	}
}
