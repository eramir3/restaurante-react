package com.restaurante.lamejorcocina.dto;

public class ClienteImporteTotalDTO {
	
	private int id;
	
	private String nombre;
	
	private String apellido1;
	
	private String apellido2;
	
	private double importe;

	public ClienteImporteTotalDTO() {
		super();
	}
	
	

	public ClienteImporteTotalDTO(int id, String nombre, String apellido1, String apellido2, double importe) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.importe = importe;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe2) {
		this.importe = importe2;
	}



	@Override
	public String toString() {
		return "ClienteImporteTotalDTO [id=" + id + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2="
				+ apellido2 + ", importe=" + importe + "]";
	}
	
	

}
