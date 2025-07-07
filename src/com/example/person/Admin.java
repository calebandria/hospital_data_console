package com.example.person;

import java.util.Random;

public class Admin extends Person {
	
	private String code; 
	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	
	public static String generateRandomString(int length) {
        Random random = new Random(); 
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(randomIndex));
        }
        return sb.toString();
    }
	
	public Admin(String firstname, String lastname){
		super(firstname, lastname);
		this.code = generateRandomString(8);
	}
	public void setCode(String code) {
		this.code = code;
	}
		
	public String getCode() {
		return code;
	
	}
}
