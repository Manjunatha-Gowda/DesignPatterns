package com.te.designpattern.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.te.designpattern.dto.Employee;
import com.te.designpattern.service.EmployeeServiceImpl;

public class EmployeeDaoImplementation implements DaoInterface {

	Scanner scanner = new Scanner(System.in);
	private EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("design");

	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();


	public void add(Employee employee) {
		transaction.begin();
		manager.persist(employee);
		transaction.commit();
	}

	@Override
	public List<Employee> findAll() {
		Query query = manager.createQuery("from Employee");
		List<Employee> resultList = query.getResultList();
		return resultList;
	}

	@Override
	public Employee findById(int id) {
		Employee find = manager.find(Employee.class, id);
		return find;
	}

	@Override
	public void update(Employee employee) {
		transaction.begin();
		manager.persist(employee);
		transaction.commit();

	}

	@Override
	public void delete(Employee employee) {
		transaction.begin();
		manager.remove(employee);
		transaction.commit();

	}

}
