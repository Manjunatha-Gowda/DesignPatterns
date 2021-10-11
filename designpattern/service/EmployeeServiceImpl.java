package com.te.designpattern.service;

import java.util.List;
import java.util.Scanner;

import com.te.designpattern.dao.EmployeeDaoImplementation;
import com.te.designpattern.dto.Employee;

public class EmployeeServiceImpl implements ServiceInterface {

	Scanner scanner = new Scanner(System.in);
	int inputId;

	private static EmployeeDaoImplementation employeeDaoImplementation = new EmployeeDaoImplementation();
	Scanner sc = new Scanner(System.in);

	@Override
	public void add(Employee employee) {
		if (employee != null) {
			employeeDaoImplementation.add(employee);
		}

	}

	@Override
	public void update(int id) {
		Employee employee = findById(id);
		if (id > 0 && employee != null) {
			System.out.println("Do you want update name y/n");
			String str = sc.next();
			if (str.equalsIgnoreCase("y")) {
				System.out.println("Enter the Name");
				employee.setName(sc.next());
			}
			System.out.println("Do you want update Designation y/n");
			String str1 = sc.next();
			if (str1.equalsIgnoreCase("y")) {
				System.out.println("Enter the Designation");
				employee.setDesignation(sc.next());
			}
			System.out.println("Do you want update Salary y/n");
			String str2 = sc.next();
			if (str1.equalsIgnoreCase("y")) {
				System.out.println("Enter the Salary");
				employee.setSalary(sc.nextDouble());
			}
			employeeDaoImplementation.update(employee);
		}
	}

	@Override
	public void delete(int id) {
		Employee employee = findById(id);
		if (id > 0 && employee != null) {
			employeeDaoImplementation.delete(employee);
		}
	}

	@Override
	public List<Employee> findAll() {
		return employeeDaoImplementation.findAll();
	}

	@Override
	public Employee findById(int id) {
		if (id > 0) {
			return employeeDaoImplementation.findById(id);
		}
		return null;
	}

}
