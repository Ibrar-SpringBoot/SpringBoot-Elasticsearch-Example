package com.example.elasticsearch.service;

import java.util.List;

import com.example.elasticsearch.model.Employee;

public interface EmployeeService {

	public String checkServer();

	public void saveEmployee(List<Employee> employees);

	public List<Employee> findAllEmployees();

	public List<Employee> findByDesignation(String designation);
}
