package com.restaurante.lamejorcocina.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.lamejorcocina.dto.ClienteImporteTotalDTO;
import com.restaurante.lamejorcocina.entity.Cliente;
import com.restaurante.lamejorcocina.entity.Mesa;
import com.restaurante.lamejorcocina.service.ClienteService;
import com.restaurante.lamejorcocina.service.ServiceResponse;

@RestController
@RequestMapping("/clientes/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ClienteRestController {
	
	private ClienteService clienteService;
	
	@Autowired
	public ClienteRestController(ClienteService theClienteService) {
		clienteService = theClienteService;
	}
	
	@GetMapping("/list") 
	public List<Cliente> findAll() {
		return clienteService.findAll();
	}
	
	@GetMapping("/cliente/{clienteId}")
	public Cliente getCliente(@PathVariable int clienteId) {
		
		Cliente theCliente = clienteService.findById(clienteId);
		
		if(theCliente == null) {
			throw new RuntimeException("Cliente id not found - " + clienteId);
		}
		
		return theCliente;
	}
	
	@PostMapping("/save")
	public ResponseEntity<Object> addCliente(@RequestBody Cliente theCliente) {
		
		theCliente.setId(0);
		clienteService.save(theCliente);
		ServiceResponse<Object> response = new ServiceResponse<Object>("200", theCliente);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public Cliente updateCliente(@RequestBody Cliente theCliente) {
		
		clienteService.save(theCliente);
		
		return theCliente;
	}
	
	@DeleteMapping("/delete/{clienteId}") 
	public String deleteCliente(@PathVariable int clienteId) {
		
		Cliente tempCliente = clienteService.findById(clienteId);
		
		if(tempCliente == null) {
			throw new RuntimeException("Cliente id not found - " + clienteId);
		}
		
		clienteService.deleteById(clienteId);
		
		return "Deleted cliente id - " + clienteId;
	}
	
	
	@GetMapping("/listaImporteTotal_rest")
	public List<ClienteImporteTotalDTO> listaImporteTotal2() {
		return clienteService.findByImporteTotal2();
	}
	
	
	
}
