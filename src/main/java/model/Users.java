package model;

public class Users {

	private String ctid, name, company, address, country;

	private double salary;

	public Users(String name, String company, String address, String country, double salary) {

		this.name = name;
		this.company = company;
		this.address = address;
		this.country = country;
		this.salary = salary;

	}

	public Users(String ctid, String name, String company, String address, String country, double salary) {

		this.ctid = ctid;
		this.name = name;
		this.company = company;
		this.address = address;
		this.country = country;
		this.salary = salary;
	}

	public String getCtid() {
		return ctid;
	}

	public void setCtid(String ctid) {
		this.ctid = ctid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String toString() {
		return "Users [ctid=" + ctid + ", name=" + name + ", company=" + company + ", address=" + address + ", country="
				+ country + ", salary=" + salary + "]"; 
	}

}
