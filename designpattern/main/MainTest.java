package com.te.designpattern.main;

import java.util.List;
import java.util.Scanner;

import com.te.designpattern.dto.Employee;
import com.te.designpattern.jdbcservice.EmployeeJdbcServiceImpl;
import com.te.designpattern.service.EmployeeServiceImpl;

public class MainTest {

	private static int id;
	private static String name;
	private static String desig;
	private static double sal;

	public static void main(String[] args) {

		EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Choose which Implemention Do You Want Run\n1.Hibernate Code\n2.JDBC Code");
		String option = scanner.next();

		if (option.equals("1")) {

			while (true) {
				System.out.println(
						"Choose The Options To Perform operations \n1.Add The Data Into To Employee Database\n2.Delete Employee Record By Id\n3.Display The Employee Data By Id\n4.Update Employee Data By Id\n5.Display The All Employee Data\n6.Exit If You Don't Want To Perform Operations");

				String ch = scanner.next();
				switch (ch) {
				case "1":
					System.out.println("Enter the ID For the Employee");
					id = scanner.nextInt();
					System.out.println("Enter the Name Of the Employee");
					name = scanner.next();
					System.out.println("Enter the Designation Of the Employee");
					desig = scanner.next();
					System.out.println("Enter the Salary Of the Employee");
					sal = scanner.nextDouble();

					employeeServiceImpl.add(new Employee(id, name, desig, sal));
					break;
				case "2":
					System.out.println("Enter the id");
					id = scanner.nextInt();
					employeeServiceImpl.delete(id);
					break;
				case "3":
					System.out.println("Enter the id");
					id = scanner.nextInt();
					System.out.println(employeeServiceImpl.findById(id));
					break;
				case "4":
					System.out.println("Enter the id");
					id = scanner.nextInt();
					employeeServiceImpl.update(id);
					break;
				case "5":
					List<Employee> all = employeeServiceImpl.findAll();
				all.forEach(i -> System.out.println(i));
					break;

				case "n":
					System.out.println("Exiting...!!!!");
					System.exit(0);

					break;
				case "6":
					System.err.println("Exiting...!!!");
					System.exit(0);
					break;

				default:
					System.out.println("Enter the Correct option");
					break;
				}
			}
		}

		else if (option.equals("2")) {
			System.out.println("Hi From JDBC");
			EmployeeJdbcServiceImpl employeeJdbcServiceImpl=new EmployeeJdbcServiceImpl();
			while (true) {
				System.out.println(
						"Choose The Options To Perform operations \n1.Add The Data Into To Employee Database\n2.Delete Employee Record By Id\n3.Display The Employee Data By Id\n4.Update Employee Data By Id\n5.Display The All Employee Data\n6.Exit If You Don't Want To Perform Operations");

				String ch = scanner.next();
				switch (ch) {
				case "1":
					System.out.println("Enter the ID For the Employee");
					id = scanner.nextInt();
					System.out.println("Enter the Name Of the Employee");
					name = scanner.next();
					System.out.println("Enter the Designation Of the Employee");
					desig = scanner.next();
					System.out.println("Enter the Salary Of the Employee");
					sal = scanner.nextDouble();

					employeeJdbcServiceImpl.add(new Employee(id, name, desig, sal));
					break;
				case "2":
					System.out.println("Enter the id");
					id = scanner.nextInt();
					employeeJdbcServiceImpl.delete(id);
					break;
				case "3":
					System.out.println("Enter the id");
					id = scanner.nextInt();
					System.out.println(employeeJdbcServiceImpl.findById(id));
					break;
				case "4":
					System.out.println("Enter the id");
					id = scanner.nextInt();
					employeeJdbcServiceImpl.update(id);
					break;
				case "5":
					List<Employee> all = employeeJdbcServiceImpl.findAll();
					all.forEach(i -> System.out.println(i));
					break;

				case "n":
					System.out.println("Exiting...!!!!");
					System.exit(0);

					break;
				case "6":
					System.err.println("Exiting...!!!");
					System.exit(0);
					break;

				default:
					System.out.println("Enter the Correct option");
					break;
				}
			}
		}
	}
}
