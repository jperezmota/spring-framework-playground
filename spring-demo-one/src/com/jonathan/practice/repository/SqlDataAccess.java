package com.jonathan.practice.repository;

public class SqlDataAccess implements DataAccess {

	@Override
	public String getEmployees() {
		return "Listing employees from SQL";
	}

	@Override
	public String deleteEmployee(long id) {
		return "Deleting employee from SQL" + id;
	}

}
