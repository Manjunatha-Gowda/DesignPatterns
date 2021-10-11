package com.te.designpattern.service;

import java.util.List;

import com.te.designpattern.dto.Employee;

public interface ServiceInterface {

	void add(Employee employee);

	void update(int id);

	Employee findById(int id);

	List findAll();

	void delete(int id);


}
