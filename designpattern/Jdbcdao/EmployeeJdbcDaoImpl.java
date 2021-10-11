package com.te.designpattern.Jdbcdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.te.designpattern.dto.Employee;

public class EmployeeJdbcDaoImpl implements JdbcDaoInterface {
	private static Connection connection;
	private static java.sql.PreparedStatement preparedStatement;
	static {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/designpattern", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void add(Employee employee) {
		try {
			preparedStatement = connection.prepareStatement("insert into employee values(?,?,?,?)");
			preparedStatement.setInt(1, employee.getId());
			preparedStatement.setString(2, employee.getName());
			preparedStatement.setString(3, employee.getDesignation());
			preparedStatement.setDouble(4, employee.getSalary());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Employee employee) {
		try {
			preparedStatement = connection
					.prepareStatement(("update employee set name=?,designation=?,salary=? where id=?"));
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getDesignation());
			preparedStatement.setDouble(3, employee.getSalary());
			preparedStatement.setInt(4, employee.getId());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Employee employee) {
		try {
			preparedStatement = connection.prepareStatement("delete from employee where id=?");
			preparedStatement.setInt(1, employee.getId());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Employee> findAll() {
		List<Employee> rs = new ArrayList<Employee>();
		try {
			preparedStatement = connection.prepareStatement("select * from employee");
			rs = (List<Employee>) preparedStatement.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public Employee findById(int id) {
		Employee employee = null;
		try {
			preparedStatement = connection.prepareStatement("select * from employee where id=?");
			preparedStatement.setInt(1, id);
			employee = (Employee) preparedStatement.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}

}
