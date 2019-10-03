package com.restaurante.lamejorcocina.dto;

import java.util.Date;


public class FacturaClienteDTO {

	private int facturaId;
	
	private Date fechaFactura;
	
	private int clienteId;
	
	private String nombre;
	
	private String apellido1;
	
	private String apellido2;
	
	private String observaciones;
	

	public FacturaClienteDTO() {
		super();
	}

	public FacturaClienteDTO(int facturaId, Date fechaFactura, int clienteId, String nombre, String apellido1,
			String apellido2, String observaciones) {
		super();
		this.facturaId = facturaId;
		this.fechaFactura = fechaFactura;
		this.clienteId = clienteId;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.observaciones = observaciones;
	}



	public int getFacturaId() {
		return facturaId;
	}

	public void setFacturaId(int facturaId) {
		this.facturaId = facturaId;
	}

	public Date getFechaFactura() {
		return fechaFactura;
	}

	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}

	public int getClienteId() {
		return clienteId;
	}

	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
}
