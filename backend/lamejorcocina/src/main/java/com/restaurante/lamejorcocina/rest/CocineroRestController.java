package com.restaurante.lamejorcocina.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.lamejorcocina.entity.Cocinero;
import com.restaurante.lamejorcocina.service.CocineroService;

@RestController
@RequestMapping("/cocineros/api")
@CrossOrigin(origins = "http://localhost:3000")
public class CocineroRestController {

	private CocineroService cocineroService;
	
	@Autowired
	public CocineroRestController(CocineroService theCocineroService) {
		cocineroService = theCocineroService;
	}
	
	@GetMapping("/list") 
	public List<Cocinero> findAll() {
		return cocineroService.findAll();
	}
}
