package Controller;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.diana.proyecto.CompaniesApplication;

import model.companyModel;


@Service

public class companyService {

	
	public boolean deleteCompany(String id) {
		System.out.println("deleteCompany");
		boolean result = false;
		Optional<companyModel> companyToDelete = this.getCompanyById(id);
		if (companyToDelete.isPresent() == true) {
		System.out.println("Compañía para borrar encontrada, borrando");
		CompaniesApplication.companyModels.remove(companyToDelete.get());
		result = true;
		}
		return result;
		}
	
	public boolean updateCompany(companyModel company) {
		System.out.println("updateCompany");
		boolean result = false;
		Optional<companyModel> companyToUpdate = this.getCompanyById(company.getId());
		if (companyToUpdate.isPresent() == true) {
		System.out.println("Compañía para actualizar encontrada, actualizando");
		companyToUpdate.get().setName(company.getName());
		companyToUpdate.get().setEmployeeNumber(company.getEmployeeNumber());
		result = true;
		}
		return result;
		}
	

	public companyModel addCompany(companyModel company) {
	System.out.println("addCompany");
	CompaniesApplication.companyModels.add(company);
	return company;
	}
	
	public Optional<companyModel> getCompanyById(String id) {
		System.out.println("getCompanyById");
		Optional<companyModel> result = Optional.empty();
		for (companyModel company : CompaniesApplication.companyModels) {
		if (company.getId().equals(id)) {
		System.out.println("Compañía encontrada");
		result = Optional.of(company);
		}
		}
		return result;
		}
	
	public List<companyModel> getAllCompanies() {
	System.out.println("getAllCompanies");
	return CompaniesApplication.companyModels;
	}
	
	


	
}
