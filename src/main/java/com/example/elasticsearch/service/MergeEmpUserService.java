package com.example.elasticsearch.service;

import java.util.List;

import com.example.elasticsearch.model.MergeEmpUser;

public interface MergeEmpUserService {

	public void saveMergeEmpUser(List<MergeEmpUser> mergeEmpUserList);

	public List<MergeEmpUser> findAllMergeEmpUser();

	public List<MergeEmpUser> findByDesignation(String designation);

}
