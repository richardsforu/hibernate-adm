package com.cts.product.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Department {
	

	
	
	@Id
	@GeneratedValue
	private int deptId;
	private String deptName;
	private String loc;
	
	// maping for one to many
	
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name="deptDetails",
	joinColumns = @JoinColumn(name="deptId"),
	inverseJoinColumns = @JoinColumn(name="empId"))
	List<Employee> emps=new ArrayList<Employee>();
	
	
	public List<Employee> getEmps() {
		return emps;
	}

	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}

	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(String deptName, String loc) {
		this.deptName = deptName;
		this.loc = loc;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
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

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", loc=" + loc + "]";
	}

}
