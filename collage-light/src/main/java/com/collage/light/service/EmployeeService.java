package com.collage.light.service;

import java.util.List;

import com.collage.light.model.Employee;

public interface EmployeeService {
	Employee findById(int id);

	void saveEmployee(Employee employee);

	void updateEmployee(Employee employee);

	void deleteEmployeeBySsn(String ssn);

	List<Employee> findAllEmployees();

	Employee findEmployeeBySsn(String ssn);

	boolean isEmployeeSsnUnique(Integer id, String ssn);

	Long getNext();

}
