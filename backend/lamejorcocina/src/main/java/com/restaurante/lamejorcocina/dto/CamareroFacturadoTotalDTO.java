package com.restaurante.lamejorcocina.dto;

public class CamareroFacturadoTotalDTO {

	private int id;
	
	private String nombre;
	
	private String apellido1;
	
	private String apellido2;
	
	private double facturado;
	
	private double enero;
	
	private double febrero;
	
	private double marzo;
	
	private double abril;
	
	private double mayo;
	
	private double junio;
	
	private double julio;
	
	private double agosto;
	
	private double septiembre;
	
	private double octubre;
	
	private double noviembre;
	
	private double diciembre;
	
	

	public CamareroFacturadoTotalDTO() {
		super();
	}

	public CamareroFacturadoTotalDTO(int id, String nombre, String apellido1, String apellido2, double facturado,
			double enero, double febrero, double marzo, double abril, double mayo, double junio, double julio,
			double agosto, double septiembre, double octubre, double noviembre, double diciembre) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.facturado = facturado;
		this.enero = enero;
		this.febrero = febrero;
		this.marzo = marzo;
		this.abril = abril;
		this.mayo = mayo;
		this.junio = junio;
		this.julio = julio;
		this.agosto = agosto;
		this.septiembre = septiembre;
		this.octubre = octubre;
		this.noviembre = noviembre;
		this.diciembre = diciembre;
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


	public double getFacturado() {
		return facturado;
	}


	public void setFacturado(double facturado) {
		this.facturado = facturado;
	}


	public double getEnero() {
		return enero;
	}


	public void setEnero(double enero) {
		this.enero = enero;
	}


	public double getFebrero() {
		return febrero;
	}


	public void setFebrero(double febrero) {
		this.febrero = febrero;
	}


	public double getMarzo() {
		return marzo;
	}


	public void setMarzo(double marzo) {
		this.marzo = marzo;
	}


	public double getAbril() {
		return abril;
	}


	public void setAbril(double abril) {
		this.abril = abril;
	}


	public double getMayo() {
		return mayo;
	}


	public void setMayo(double mayo) {
		this.mayo = mayo;
	}


	public double getJunio() {
		return junio;
	}


	public void setJunio(double junio) {
		this.junio = junio;
	}


	public double getJulio() {
		return julio;
	}


	public void setJulio(double julio) {
		this.julio = julio;
	}


	public double getAgosto() {
		return agosto;
	}


	public void setAgosto(double agosto) {
		this.agosto = agosto;
	}


	public double getSeptiembre() {
		return septiembre;
	}


	public void setSeptiembre(double septiembre) {
		this.septiembre = septiembre;
	}


	public double getOctubre() {
		return octubre;
	}


	public void setOctubre(double octubre) {
		this.octubre = octubre;
	}


	public double getNoviembre() {
		return noviembre;
	}


	public void setNoviembre(double noviembre) {
		this.noviembre = noviembre;
	}


	public double getDiciembre() {
		return diciembre;
	}


	public void setDiciembre(double diciembre) {
		this.diciembre = diciembre;
	}
		
}
