package com.retobackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retobackend.model.ResponseVO;
import com.retobackend.service.RetoService;

@RestController
@RequestMapping("/api")
public class RetoController {

	@Autowired
	private RetoService retoService;
	
	@PostMapping("/data")
	public ResponseEntity<ResponseVO> getData() {

		ResponseVO responseVO = new ResponseVO();
		responseVO.setData(retoService.getData());
		
		return new ResponseEntity<>(responseVO, HttpStatus.OK);
	}

//	@GetMapping("/data2")
//	public ResponseEntity<ResponseVO> getDataAll() {
//		
//		ResponseVO responseVO = new ResponseVO();
//		responseVO.setData(retoService.getData());
//		
//		return new ResponseEntity<ResponseVO>(responseVO, HttpStatus.OK);
//	}
//
//	@GetMapping("/saludo")
//	public ResponseEntity<String> getSaludo() {
//		
//		return new ResponseEntity<>("Ok esta funcionando...", HttpStatus.OK);
//	}

}
