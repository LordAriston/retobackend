package com.retobackend.restClient;

import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.retobackend.model.Comment;

@Component
public class RestClient {

	private static final Logger log = LoggerFactory.getLogger(RestClient.class);

	@Autowired
	private RestTemplate restTemplate;
	
	public Comment[] getData() throws Exception {
		
		ResponseEntity<Comment[]> response = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/comments",
																		Comment[].class);
		Comment[] comments = response.getBody();

		Stream.of(comments).forEach(s -> log.info(s.toString()));

		return comments;
	}

}
