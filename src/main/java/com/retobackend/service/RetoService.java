package com.retobackend.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retobackend.restClient.RestClient;

@Service
public class RetoService {
	
	@Autowired
	private RestClient restClient;
	
	public List<String> getData() {
		
		try {
			List<String> data = Stream.of(restClient.getData()).map(comment -> comment.getPostId()+"|"+comment.getId()+"|"+comment.getEmail()).collect(Collectors.toList());
			
			return data;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			return null;
		}
		
	}

}
