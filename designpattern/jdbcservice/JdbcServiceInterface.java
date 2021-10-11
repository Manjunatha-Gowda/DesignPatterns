package com.te.designpattern.jdbcservice;

import java.util.List;

import com.te.designpattern.dto.Employee;

public interface JdbcServiceInterface {

	void add(Employee employee);

	void update(int id);

	Employee findById(int id);

	List findAll();

	void delete(int id);

}
