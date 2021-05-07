package com.cts.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;

@Entity(name = "employee")
//@SecondaryTable(name = "dept")
//@SecondaryTable(name = "project")
@SecondaryTables(value = {@SecondaryTable(name="dept"),@SecondaryTable(name="project")})
public class Employee {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private double salary;

	@Column(name = "dept_name", table = "dept", length = 30)
	private String deptName;
	@Column(table = "dept", length = 40)
	private String loc;

	@Column(name = "project_name", table = "project", length = 30)
	private String projName;
	@Column(name = "client_name", table = "project", length = 40)
	private String clientName;

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

}
