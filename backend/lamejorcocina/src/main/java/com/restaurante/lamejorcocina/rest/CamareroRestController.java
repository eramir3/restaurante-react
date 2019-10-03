package com.restaurante.lamejorcocina.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.lamejorcocina.dto.CamareroFacturadoTotalDTO;
import com.restaurante.lamejorcocina.dto.ClienteImporteTotalDTO;
import com.restaurante.lamejorcocina.entity.Camarero;
import com.restaurante.lamejorcocina.service.CamareroService;

@RestController
@RequestMapping("/camareros/api")
@CrossOrigin(origins = "http://localhost:3000")
public class CamareroRestController {

	private CamareroService camareroService;
	
	@Autowired
	public CamareroRestController(CamareroService theCamareroService) {
		camareroService = theCamareroService;
	}
	
	@GetMapping("/list") 
	public List<Camarero> findAll() {
		return camareroService.findAll();
	}
	
	@GetMapping("/listaFacturadoTotal_rest")
	public List<CamareroFacturadoTotalDTO> listaImporteTotal2() {
		return camareroService.findByTotalFacturado2();
	}
}
