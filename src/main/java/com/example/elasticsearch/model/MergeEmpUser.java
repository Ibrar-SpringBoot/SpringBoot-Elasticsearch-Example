package com.example.elasticsearch.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Component
@Document(indexName = "mergeIndex", type = "details")
@AllArgsConstructor
@NoArgsConstructor
public class MergeEmpUser {
	
	@Id
	private String id;
	private String name;
	private String designation;
	
	public MergeEmpUser() {}
	
	public MergeEmpUser(String id, String name, String designation) {
		this.id = id;
		this.name = name;
		this.designation = designation;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	@Override
	public String toString() {
		return "MergeEmpUser [id=" + id + ", name=" + name + ", designation=" + designation + "]";
	}
}
