package com.example.personnel;

import com.example.person.Person;

public class MedecinChef extends Person implements Personnel{

	private String code; 
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	
}
