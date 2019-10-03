package com.restaurante.lamejorcocina.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.restaurante.lamejorcocina.entity.Camarero;
import com.restaurante.lamejorcocina.service.CamareroService;


@Controller
@RequestMapping("/camareros")
public class CamareroController {

	private CamareroService camareroService;
	
	public CamareroController(CamareroService theCamareroService) {
		camareroService = theCamareroService;
	}
	
	@GetMapping("/list")
	public String listCamareros(Model theModel) {
		
		List<Camarero> theCamareros = camareroService.findAll();
		
		theModel.addAttribute("Camareros", theCamareros);
		
		return "camareros/list-Camareros";
	}
	
	@GetMapping("/listaFacturadoTotal")
	public String listaFacturadoTotal(Model theModel) {
		
		List<Object> theCamareros = camareroService.findByTotalFacturado();
		
		theModel.addAttribute("camareros", theCamareros);
		
		return "camareros/facturado-camareros";
	}
	
}
