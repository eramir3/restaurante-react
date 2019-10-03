package com.restaurante.lamejorcocina.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.lamejorcocina.entity.Mesa;
import com.restaurante.lamejorcocina.service.MesaService;

@RestController
@RequestMapping("/mesas/api")
@CrossOrigin(origins = "http://localhost:3000")
public class MesaRestController {

	private MesaService mesaService;
	
	@Autowired
	public MesaRestController(MesaService theMesaService) {
		mesaService = theMesaService;
	}
	
	@GetMapping("/list") 
	public List<Mesa> findAll() {
		return mesaService.findAll();
	}
}
