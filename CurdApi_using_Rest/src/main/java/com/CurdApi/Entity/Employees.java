package com.CurdApi.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Employees {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String emp_name;
	private String  emp_salary;
	private String  emp_age;
	private String  emp_city;
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_salary() {
		return emp_salary;
	}
	public void setEmp_salary(String emp_salary) {
		this.emp_salary = emp_salary;
	}
	public String getEmp_age() {
		return emp_age;
	}
	public void setEmp_age(String emp_age) {
		this.emp_age = emp_age;
	}
	public String getEmp_city() {
		return emp_city;
	}
	public void setEmp_city(String emp_city) {
		this.emp_city = emp_city;
	}
	@Override
	public String toString() {
		return "Employees [id=" + id + ", emp_name=" + emp_name + ", emp_salary=" + emp_salary + ", emp_age=" + emp_age
				+ ", emp_city=" + emp_city + "]";
	}

}
