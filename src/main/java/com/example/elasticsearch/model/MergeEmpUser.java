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
}
