package com.example.elasticsearch.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.elasticsearch.model.MergeEmpUser;
import com.example.elasticsearch.service.MergeEmpUserService;

@RestController
@RequestMapping("/merge")
public class MergeEmpUserController {
	
	@Autowired
	private MergeEmpUserService mergeEmpUserService;
	
	@RequestMapping(value = "/checkserver", method = RequestMethod.GET)
	public String checkServer() {
		return "Server is up";
	}
	
	@PostMapping(value = "/saveempuser")
	public String saveEmployee(@RequestBody List<MergeEmpUser> mergeEmpUserList) {
		mergeEmpUserService.saveMergeEmpUser(mergeEmpUserList);
		return "Records saved in the ES.";
	}

	@GetMapping(value = "/getall")
	public List<MergeEmpUser> getAllMergeEmpUser() {
		return mergeEmpUserService.findAllMergeEmpUser();
	}

	@GetMapping(value = "/findbydesignation/{empuser-designation}")
	public List<MergeEmpUser> getByDesignation(@PathVariable(name = "empuser-designation") String designation) {
		return mergeEmpUserService.findByDesignation(designation);
	}
}
