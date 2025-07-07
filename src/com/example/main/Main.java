package com.example.main;

import com.example.system.*;

public class Main {
	public static void main(String[] args) {
		Hospital csbAmbato = new Hospital("admin", "john");
		
		String codeAdmin = csbAmbato.initializeAdminCode();
		csbAmbato.registerAdminInfo();
		csbAmbato.adminAuthenticate("admin", codeAdmin);
		
	}	
}

