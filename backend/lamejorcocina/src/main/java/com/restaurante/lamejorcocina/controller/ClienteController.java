package com.restaurante.lamejorcocina.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.restaurante.lamejorcocina.entity.Cliente;
import com.restaurante.lamejorcocina.entity.DetalleFactura;
import com.restaurante.lamejorcocina.service.ClienteService;
import com.restaurante.lamejorcocina.service.DetalleFacturaService;


@Controller
@RequestMapping("/clientes")
public class ClienteController {

	private ClienteService clienteService;
		
	public ClienteController(ClienteService theClienteService) {
		clienteService = theClienteService;
	}
	
	@GetMapping("/list")
	public String listClientes(Model theModel) {
		
		List<Cliente> theClientes = clienteService.findAll();
		
		theModel.addAttribute("clientes", theClientes);
		
		return "clientes/list-clientes";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Cliente theCliente = new Cliente();
		
		theModel.addAttribute("cliente", theCliente);
		
		return "clientes/cliente-form";
	}
	
	
	@GetMapping("/listaImporteTotal")
	public String listaImporteTotal(Model theModel) {
		
		List<Object> theClientes = clienteService.findByImporteTotal();
		
		theModel.addAttribute("clientes", theClientes);
		
		return "clientes/importe-clientes";
	}
	
}
