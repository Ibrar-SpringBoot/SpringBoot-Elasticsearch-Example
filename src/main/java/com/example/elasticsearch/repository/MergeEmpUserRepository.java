package com.example.elasticsearch.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.elasticsearch.model.MergeEmpUser;

@Repository
public interface MergeEmpUserRepository extends ElasticsearchRepository<MergeEmpUser, String>{

	public List<MergeEmpUser> findByDesignation(String designation);
}
