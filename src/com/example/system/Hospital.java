package com.example.system;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.example.personnel.*;
import com.example.person.*;

public class Hospital {
	private Stock stockGros;
	private Stock stockUrgence;
	private Stock stockPharmacie;
	private Finance hospitalFinance;
	private List<Personnel> employees;
	private Admin admin;
	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	private static final String ADMIN_INFO_REGISTRAT = "admin_info.txt";
	
	
	// a constructor to initialize first the admin of system
	public Hospital(String adminFirstname, String adminLastname) {
		this.stockGros =  new Gros();
		this.stockUrgence = new MedocUrgence();
		this.stockPharmacie = new Pharmacie();
		this.hospitalFinance = new Finance();
		this.admin = new Admin(adminFirstname, adminLastname); // the creation of the admin is here
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
	
	// verify whether the name and the code of the user is the same with the one registered in the file
	public void adminAuthenticate(String adminUsername, String adminPassword) {
		try(BufferedReader reader = new BufferedReader(new FileReader(ADMIN_INFO_REGISTRAT))) {
			String line = "";
			
			String searchString1 = "Firstname: "; // considering it as the username for now
			String searchString2 = "Code: "; 
		
			while((line = reader.readLine()) != null) {
				//System.out.println(line);
				int index1 = line.indexOf(searchString1);
				if(index1 != -1) {
					int usernameIndex = index1 + searchString1.length();
					String resultUsername = line.substring(usernameIndex);
					if(resultUsername.equals(adminUsername)) {
						line = reader.readLine(); // getting Lastname
						line = reader.readLine(); // getting password
						int index2 = line.indexOf(searchString2);
						if(index2 != -1) {
							int passwordIndex = index2+ searchString2.length();
							String resultPassword = line.substring(passwordIndex);
							if(resultPassword.equals(adminPassword)) {
								System.out.println("Authentication success!");
							}
							else {
								System.out.println("Password is incorrect");
							}
							
						}
						
					}
					else {
						System.out.println("Username incorrect");
					}
				}
				else {
					System.out.println("Incorrect naming in files, please follow the pattern");
				}
			}
		} catch(IOException e) {
			System.err.println("Error reading file: "+ e.getMessage());
		}
		
	}
	
	// here we initialize the code of the admin
	public String initializeAdminCode() {
		admin.setCode(generateRandomString(8));
		return admin.getCode();
		
	}
	
	public void registerAdminInfo() {
		try(PrintWriter writer = new PrintWriter(new FileWriter(ADMIN_INFO_REGISTRAT))) {
			writer.println("Firstname: "+ admin.getFirstname());
			writer.println("Lastname: "+ admin.getLastname());
			writer.println("Code: "+ admin.getCode());
			System.out.println("Registration of admin done!");
		} catch (IOException e) {
			System.err.println("Error writhing with PrintWriter: "+ e.getMessage());
		}
	}
	
	
	public static String generateRandomString(int length) {
        Random random = new Random(); 
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(randomIndex));
        }
        return sb.toString();
    } 
}
