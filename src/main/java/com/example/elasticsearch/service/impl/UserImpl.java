package com.example.elasticsearch.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.elasticsearch.model.User;
import com.example.elasticsearch.repository.UserRepository;
import com.example.elasticsearch.service.UserService;

@Service
public class UserImpl implements UserService {
	private static final Logger LOG = LoggerFactory.getLogger(UserImpl.class);
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public void saveUser(List<User> userlist) {
		// TODO Auto-generated method stub
		userRepo.saveAll(userlist);	
	}

	@Override
	public List<User> findAllUsers() {
		List<User> allRecordList = new ArrayList<User>();
		try {
		Iterable<User> allRecord = userRepo.findAll();
		
		for(User user : allRecord) {
			allRecordList.add(user);
		}
		} catch (Exception e) {
			LOG.error("Exception Error : " + e.getMessage());
		}
		return allRecordList;
	}

	@Override
	public List<User> findByDesignation(String designation) {
		// TODO Auto-generated method stub
		return userRepo.findByDesignation(designation);
	}

}
