package com.jonathan.practice.repository;

public class XmlDataAccess implements DataAccess {

	@Override
	public String getEmployees() {
		return "Listing employees from XML";
	}

	@Override
	public String deleteEmployee(long id) {
		return "Deleting employee from XML" + id;
	}

}
