package com.restaurante.lamejorcocina.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.restaurante.lamejorcocina.entity.Camarero;
import com.restaurante.lamejorcocina.entity.Cocinero;
import com.restaurante.lamejorcocina.entity.Factura;
import com.restaurante.lamejorcocina.entity.Mesa;
import com.restaurante.lamejorcocina.service.CamareroService;
import com.restaurante.lamejorcocina.service.CocineroService;
import com.restaurante.lamejorcocina.service.MesaService;

@Controller
@RequestMapping("/facturas")
public class FacturaController {
	
	private CamareroService camareroService;
	
	private CocineroService cocineroService;
	
	private MesaService mesaService;
	
	
	public FacturaController(CamareroService camareroService, CocineroService cocineroService,
							 MesaService mesaService) {
		this.camareroService = camareroService;
		this.cocineroService = cocineroService;
		this.mesaService = mesaService;
	}


	@GetMapping("/showForm")
	public String showForm(Model theModel) {
		
		Factura laFactura = new Factura();
		theModel.addAttribute("factura", laFactura);
		
		List<Camarero> theCamareros = camareroService.findAll();
		theModel.addAttribute("camareros", theCamareros);
		
		List<Cocinero> theCocineros = cocineroService.findAll();
		theModel.addAttribute("cocineros", theCocineros);
		
		List<Mesa> theMesas = mesaService.findAll();
		theModel.addAttribute("mesas", theMesas);
		
		return "facturas/factura-form";
	}
}
