package com.collage.light.dao;

import java.util.List;

import com.collage.light.model.Employee;

public interface EmployeeDao {
	Employee findById(int id);

	void saveEmployee(Employee employee);

	void deleteEmployeeBySsn(String ssn);

	List<Employee> findAllEmployees();

	Employee findEmployeeBySsn(String ssn);

	Long getNext();
}
