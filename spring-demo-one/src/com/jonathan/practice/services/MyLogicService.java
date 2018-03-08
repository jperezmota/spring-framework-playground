package com.jonathan.practice.services;

import com.jonathan.practice.repository.DataAccess;

public class MyLogicService implements LogicService {
	
	private DataAccess dataAccess;
	
	public MyLogicService(DataAccess dataAccess) {
		this.dataAccess = dataAccess;
	}

	@Override
	public String listEmployees() {
		return dataAccess.getEmployees();
	}

}
