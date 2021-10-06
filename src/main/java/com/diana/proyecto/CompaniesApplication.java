package com.diana.proyecto;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import model.companyModel;

@SpringBootApplication
public class CompaniesApplication {

	public static ArrayList<companyModel> companyModels;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CompaniesApplication.class, args);
		
		CompaniesApplication.companyModels = CompaniesApplication.getModels();
	}
	
	private static ArrayList<companyModel> getModels() {
		System.out.println("getModels");
		
		ArrayList<companyModel> companyModels = new ArrayList<>();
		companyModels.add(
				new companyModel(
						"1"
						,"Compañía 1"
						, 100
						)
				);
		
		companyModels.add(
				new companyModel(
						"2"
						,"Compañía 2"
						, 200
						)
				);
		
		return companyModels;
	}

}
