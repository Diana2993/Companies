package model;


public class companyModel {
		private String id;
		private String name;
		private int employeeNumber;

			public companyModel() {
			}
			public companyModel(String id, String name, int employeeNumber) {
			this.id = id;
			this.name = name;
			this.employeeNumber = employeeNumber;
			}
			
		public String getId() {
		return this.id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getEmployeeNumber() {
			return employeeNumber;
		}
		public void setEmployeeNumber(int employeeNumber) {
			this.employeeNumber = employeeNumber;
		}
		public void setId(String id) {
			this.id = id;
		}

}
