package com.example.elasticsearch.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.elasticsearch.model.MergeEmpUser;
import com.example.elasticsearch.repository.MergeEmpUserRepository;
import com.example.elasticsearch.service.MergeEmpUserService;

@Service
public class MergeEmpUserImpl implements MergeEmpUserService {

	private static final Logger LOG = LoggerFactory.getLogger(MergeEmpUserImpl.class);
			
	@Autowired
	private MergeEmpUserRepository mergeEmpUserRepo;

	@Override
	public void saveMergeEmpUser(List<MergeEmpUser> mergeEmpUserList) {
		// TODO Auto-generated method stub
		mergeEmpUserRepo.saveAll(mergeEmpUserList);
	}

	@Override
	public List<MergeEmpUser> findAllMergeEmpUser() {
		List<MergeEmpUser> allRecordList = new ArrayList<MergeEmpUser>();
		try {
			Iterable<MergeEmpUser> allRecords = mergeEmpUserRepo.findAll();

			for (MergeEmpUser megerObj : allRecords) {
				allRecordList.add(megerObj);
			}

		} catch (Exception e) {
			LOG.error("Exception Error : " + e.getMessage());
		}
		return allRecordList;
	}

	@Override
	public List<MergeEmpUser> findByDesignation(String designation) {
		// TODO Auto-generated method stub
		return mergeEmpUserRepo.findByDesignation(designation);
	}

}
