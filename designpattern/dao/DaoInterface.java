package com.te.designpattern.dao;

import java.util.List;

import com.te.designpattern.dto.Employee;

public interface DaoInterface {
	
	

	void add(Employee employee);

	void update(Employee id);

	Employee findById(int id);

	List findAll();


	void delete(Employee employee);

	
	

}
