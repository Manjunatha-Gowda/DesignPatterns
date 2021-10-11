package com.te.designpattern.Jdbcdao;

import java.util.List;

import com.te.designpattern.dto.Employee;

public interface JdbcDaoInterface {
	void add(Employee employee);

	void update(Employee id);

	Employee findById(int id);

	List findAll();


	void delete(Employee employee);


}
