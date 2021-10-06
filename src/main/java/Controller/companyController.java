package Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.companyModel;


@RestController
@RequestMapping("/proyecto")


public class companyController {

	
	@DeleteMapping("/companies/{id}")
		public ResponseEntity<String> deleteCompany(@PathVariable String id) {
		System.out.println("deleteCompany");
		System.out.println("La id de la compañía a borrar es " + id);
	
		boolean deletedCompany = this.companyService.deleteCompany(id);
	
		return new ResponseEntity<>(
		deletedCompany == true ? "Compañía borrada" : "Compañía no encontrada",
		deletedCompany == true ? HttpStatus.OK : HttpStatus.NOT_FOUND
		);
	}
	
	@PutMapping("/companies/{id}")
		public ResponseEntity<companyModel> updateCompany(@RequestBody companyModel company, @PathVariable String id) {
		System.out.println("updateCompany");
		System.out.println("La id de la compañía a actualizar en parámetro es " + id);
		System.out.println("La id de la compañía a actualizar es " + company.getId());
		System.out.println("El nombre de la compañía a actualizar es " + company.getName());
		System.out.println("La cantidad de empleados de la compañía a actualizar es " + company.getEmployeeNumber());

		boolean updatedCompany = this.companyService.updateCompany(company);
		return new ResponseEntity<>(company,
		updatedCompany == true ? HttpStatus.OK : HttpStatus.NOT_FOUND
		);
	}
	
	@PostMapping("/companies")
		public ResponseEntity<companyModel> createCompany(@RequestBody companyModel company) {
		System.out.println("createCompany");
		System.out.println("La id de la nueva compañía es " + company.getId());
		System.out.println("El nombre de la nueva compañía es " + company.getName());
		System.out.println("El número de empleados de la nueva compañía es " + company.getEmployeeNumber());

		return new ResponseEntity<>(
		this.companyService.addCompany(company),
		HttpStatus.CREATED
		);
	}
	
	
	@GetMapping("/companies/{id}")
		public ResponseEntity<Object> getCompanyById(@PathVariable String id) {
		System.out.println("getCompanyById");
		System.out.println("id es " + id);
		Optional<companyModel> result = this.companyService.getCompanyById(id);
		return new ResponseEntity<>(
		result.isPresent() ? result.get() : "Compañía no encontrada",
		result.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND
		);
	}
	
	@Autowired
	companyService companyService;
	@GetMapping("/companies")
		public List<companyModel> getAllCompanies() {
		System.out.println("getCompanies");
		return this.getAllCompanies();
		}
	
	
	
}
