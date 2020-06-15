package com.example.elasticsearch.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.elasticsearch.model.Employee;
import com.example.elasticsearch.repository.EmployeeRepository;
import com.example.elasticsearch.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeImpl implements EmployeeService {

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeImpl.class);

	@Autowired
	private EmployeeRepository emplRepo;

	@Override
	public String checkServer() {
		// TODO Auto-generated method stub
		return "Server is up Now";
	}

	@Override
	public void saveEmployee(List<Employee> employees) {
		emplRepo.saveAll(employees);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.springboot.elasticsearch.service.Employeeserv#findAllEmployees()
	 */
	@Override
	public List<Employee> findAllEmployees() {
		List<Employee> empRecordList = new ArrayList<Employee>();

		try {
			Iterable<Employee> allRecord = emplRepo.findAll();
			for (Employee emp : allRecord) {

				LOG.info(">>>Emp : " + emp.toString());

				empRecordList.add(emp);
			}
		} catch (Exception e) {
			LOG.error("Exception Error : " + e.getMessage());
		}
		return empRecordList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.springboot.elasticsearch.service.Employeeserv#findByDesignation(java.lang
	 * .String)
	 */
	@Override
	public List<Employee> findByDesignation(String designation) {
		return emplRepo.findByDesignation(designation);
	}

}
