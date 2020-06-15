package com.example.elasticsearch.service;

import java.util.List;

import com.example.elasticsearch.model.User;

public interface UserService {

	public void saveUser(List<User> employees);

	public List<User> findAllUsers();

	public List<User> findByDesignation(String designation);
}
