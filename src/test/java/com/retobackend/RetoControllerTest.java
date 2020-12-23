package com.retobackend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.retobackend.service.RetoService;

@WebMvcTest
public class RetoControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private RetoService retoService;
	
	@Mock
    private RestTemplate restTemplate;
	
	private static ObjectMapper mapper = new ObjectMapper();

	@Test
	public void testGetData() throws Exception {

		List<String> data = new ArrayList<>();
		data.add("1|1|Eliseo@gardner.biz");

		Mockito.when(retoService.getData()).thenReturn(data);

		mockMvc.perform(post("/data")).andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(1)))
				.andExpect(jsonPath("$[0]", Matchers.equalTo("1|1|Eliseo@gardner.biz")));
	}
	
}
