package com.importexcel;

/**
 * 
 * @author Efraim Gentil
 * @email efraim.gentil@gmail.com
 * @date Dec 14, 2013
 */
public class ContactPOJO {
	
	private String name;
	
	private String email;
	
	private String phone;
	
	private String cellphone;
	
	public ContactPOJO() { }
	
	@Override
	public String toString() {
		return "ContactPOJO [name=" + name + ", email=" + email + ", phone="
				+ phone + ", cellphone=" + cellphone + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	
}
