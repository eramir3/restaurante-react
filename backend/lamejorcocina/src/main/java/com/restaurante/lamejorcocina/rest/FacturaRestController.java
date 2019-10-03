package com.restaurante.lamejorcocina.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.restaurante.lamejorcocina.entity.Camarero;
import com.restaurante.lamejorcocina.entity.Cliente;
import com.restaurante.lamejorcocina.entity.Cocinero;
import com.restaurante.lamejorcocina.entity.DetalleFactura;
import com.restaurante.lamejorcocina.entity.Factura;
import com.restaurante.lamejorcocina.entity.Mesa;
import com.restaurante.lamejorcocina.service.CamareroService;
import com.restaurante.lamejorcocina.service.CocineroService;
import com.restaurante.lamejorcocina.service.DetalleFacturaService;
import com.restaurante.lamejorcocina.service.FacturaService;
import com.restaurante.lamejorcocina.service.MesaService;
import com.restaurante.lamejorcocina.service.ServiceResponse;

@RestController
@RequestMapping("/facturas/api")
@CrossOrigin(origins = "http://localhost:3000")
public class FacturaRestController {

	private FacturaService facturaService;
	
	private DetalleFacturaService detalleFacturaService;
	
	private CamareroService camareroService;
	
	private CocineroService cocineroService;
	
	private MesaService mesaService;
	
	
	
	@Autowired
	public FacturaRestController(FacturaService theFacturaService, CamareroService theCamareroService,
								CocineroService theCocineroService, MesaService theMesaService,
								DetalleFacturaService theDetalleFacturaService) {
		facturaService = theFacturaService;
		camareroService = theCamareroService;
		cocineroService = theCocineroService;
		mesaService = theMesaService;
		detalleFacturaService = theDetalleFacturaService;
	}
	
	@PostMapping("/save")
	public ResponseEntity<Object> addFactura(@RequestBody String request) {
		
		JsonObject jsonObject = new JsonParser().parse(request).getAsJsonObject();
		String fechaFactura = jsonObject.get("fechaFactura").getAsString();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = null;
		try {
			date1 = format.parse ( fechaFactura );
		} 
		catch (ParseException e) {
			e.printStackTrace();
		}    
		
		
		int camareroId = jsonObject.get("camareroId").getAsInt();
		int cocineroId = jsonObject.get("cocineroId").getAsInt();
		int mesaId = jsonObject.get("mesaId").getAsInt();
		
		String nombreCliente = jsonObject.get("nombreCliente").getAsString();
		String apellido1Cliente = jsonObject.get("apellido1Cliente").getAsString();
		String apellido2Cliente = jsonObject.get("apellido2Cliente").getAsString();
		String observacionesCliente = jsonObject.get("observacionesCliente").getAsString();
		
		Cliente cliente = new Cliente(nombreCliente, apellido1Cliente, apellido2Cliente, observacionesCliente);
		Camarero camarero = camareroService.findById(camareroId);
		Mesa mesa = mesaService.findById(mesaId);
		
		Factura factura = new Factura(cliente, camarero, mesa, date1);
		facturaService.save(factura);
		
		Cocinero cocinero = cocineroService.findById(cocineroId);
		
		if(jsonObject.get("importePlato[]").isJsonArray()) {
			
			JsonArray platos = jsonObject.getAsJsonArray("nombrePlato[]");
			JsonArray importes = jsonObject.getAsJsonArray("importePlato[]");
			
			for (int i = 0; i < platos.size(); i++) {
				String plato = platos.get(i).getAsString();
		        double importe = importes.get(i).getAsDouble();
		         
		        try {
		        	DetalleFactura detalleFactura = new DetalleFactura(factura, cocinero, plato, importe);
			        detalleFacturaService.save(detalleFactura);
		        }
		        catch (Exception e) {
					e.printStackTrace();
				}    
		        
			 }
		}
		else {
			String plato = jsonObject.get("nombrePlato[]").getAsString();
			double importe = jsonObject.get("importePlato[]").getAsDouble();
			DetalleFactura detalleFactura = new DetalleFactura(factura, cocinero, plato, importe);
			detalleFacturaService.save(detalleFactura);
		}
		
		ServiceResponse<Object> response = new ServiceResponse<Object>("200", "factura");
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	
	
	@PostMapping("/save_react")
	public ResponseEntity<Object> addFacturaReact(@RequestBody String request) {
		
		JsonObject jsonObject = new JsonParser().parse(request).getAsJsonObject();
		JsonObject orderData = (JsonObject) jsonObject.get("orderData");
		
		String fechaFactura = orderData.get("date").getAsString();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = null;
		try {
			date1 = format.parse ( fechaFactura );
		} 
		catch (ParseException e) {
			e.printStackTrace();
		}  
		
		int camareroId = orderData.get("waiter").getAsInt();
		int cocineroId = orderData.get("chef").getAsInt();
		int mesaId = orderData.get("table").getAsInt();
		
		String nombreCliente = orderData.get("name").getAsString();
		String apellido1Cliente = orderData.get("lastname").getAsString();
		String apellido2Cliente = orderData.get("secondLastname").getAsString();
		String observacionesCliente = orderData.get("description").getAsString();
		
		Cliente cliente = new Cliente(nombreCliente, apellido1Cliente, apellido2Cliente, observacionesCliente);
		Camarero camarero = camareroService.findById(camareroId);
		Mesa mesa = mesaService.findById(mesaId);
		
		Factura factura = new Factura(cliente, camarero, mesa, date1);
		facturaService.save(factura);
		
		Cocinero cocinero = cocineroService.findById(cocineroId);
		
		
		String plato = orderData.get("dish").getAsString();
		double importe = orderData.get("import").getAsDouble();
		DetalleFactura detalleFactura = new DetalleFactura(factura, cocinero, plato, importe);
		detalleFacturaService.save(detalleFactura);
		
		if(orderData.get("additionalDishes").isJsonArray()) {
			
			JsonArray additionalDishes = orderData.getAsJsonArray("additionalDishes");
			
			for (int i = 0; i < additionalDishes.size(); i++) {
				
				JsonObject additional = additionalDishes.get(i).getAsJsonObject();
				
				String additionalDish = additional.get("dish").getAsString();
		        double additionalImport = additional.get("import").getAsDouble();
		         
		        try {
		        	DetalleFactura additionalDetalleFactura = new DetalleFactura(factura, cocinero, additionalDish, additionalImport);
			        detalleFacturaService.save(additionalDetalleFactura);
		        }
		        catch (Exception e) {
					e.printStackTrace();
				}    
		        
			 }
			 
		}
		
		ServiceResponse<Object> response = new ServiceResponse<Object>("200", "factura");
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
}
