package com.example.elasticsearch.controller;

import java.util.List;

import org.elasticsearch.action.ActionFuture;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.ActionRequest;
import org.elasticsearch.action.ActionResponse;
import org.elasticsearch.action.ActionType;
import org.elasticsearch.client.ElasticsearchClient;
import org.elasticsearch.index.reindex.ReindexAction;
import org.elasticsearch.index.reindex.ReindexRequestBuilder;
import org.elasticsearch.threadpool.ThreadPool;
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

import com.example.elasticsearch.model.Employee;
import com.example.elasticsearch.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService emplService;

	@RequestMapping(value = "/checkserver", method = RequestMethod.GET)
	public String checkServer() {

//		ReindexRequestBuilder reindexRequest = new ReindexRequestBuilder(null, ReindexAction.INSTANCE).source("source_index").destination("destination_index").refresh(true);
//
//		reindexRequest.execute();
//
//		if (copy.execute().isDone()) {
//			System.out.println("Request is executed");
//		}
		
		ReindexRequestBuilder reIndexBuilder = new ReindexRequestBuilder(new ElasticsearchClient() {
					
					@Override
					public ThreadPool threadPool() {
						// TODO Auto-generated method stub
						return null;
					}
					
					@Override
					public <Request extends ActionRequest, Response extends ActionResponse> void execute(ActionType<Response> action,
							Request request, ActionListener<Response> listener) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public <Request extends ActionRequest, Response extends ActionResponse> ActionFuture<Response> execute(
							ActionType<Response> action, Request request) {
						// TODO Auto-generated method stub
						return null;
					}
				}, ReindexAction.INSTANCE);
		
		reIndexBuilder.source("source_index");
		reIndexBuilder.destination("target_index");
		
		reIndexBuilder.execute();
		
		
		
		//Response response  = reIndexBuilder.get();
		//BulkByScrollResponse response  = reIndexBuilder.get();
		
		LOG.info("ReIndex : "+reIndexBuilder);
		
		return emplService.checkServer();
	}

	@PostMapping(value = "/saveemployees")
	public String saveEmployee(@RequestBody List<Employee> myemployees) {
		emplService.saveEmployee(myemployees);
		return "Records saved in the ES.";
	}

	@GetMapping(value = "/getall")
	public List<Employee> getAllEmployees() {
		return emplService.findAllEmployees();
	}

	@GetMapping(value = "/findbydesignation/{employee-designation}")
	public List<Employee> getByDesignation(@PathVariable(name = "employee-designation") String designation) {
		return emplService.findByDesignation(designation);
	}
}
