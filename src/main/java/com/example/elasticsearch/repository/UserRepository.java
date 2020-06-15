package com.example.elasticsearch.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.elasticsearch.model.User;

@Repository
public interface UserRepository extends ElasticsearchRepository<User,String>{
	public List<User> findByDesignation(String designation);
}
