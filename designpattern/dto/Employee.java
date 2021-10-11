package com.te.designpattern.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Employee implements Serializable {

	@Id
	private Integer id;
	private String name;
	private Double salary;
	private String designation;

	public Employee(Integer id, String name, String designation, Double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.designation = designation;
	}
	public Employee() {
		
	}


}
