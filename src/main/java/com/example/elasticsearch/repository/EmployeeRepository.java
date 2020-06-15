package com.example.elasticsearch.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.elasticsearch.model.Employee;

@Repository
public interface EmployeeRepository extends ElasticsearchRepository<Employee, String>{
    public List<Employee> findByDesignation(String designation);
}
