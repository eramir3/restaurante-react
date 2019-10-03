package com.restaurante.lamejorcocina.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="mesa")
public class Mesa {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="num_max_comensales")
	private int numMaxComensales;
	
	@Column(name="ubicacion")
	private String ubicacion;
	
	@OneToMany(mappedBy="mesa", cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JsonIgnore
	private List<Factura> facturas;
	
	public Mesa() {
		
	}

	public Mesa(int numMaxComensales, String ubicacion) {
		this.numMaxComensales = numMaxComensales;
		this.ubicacion = ubicacion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumMaxComensales() {
		return numMaxComensales;
	}

	public void setNumMaxComensales(int numMaxComensales) {
		this.numMaxComensales = numMaxComensales;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public void add(Factura tempFactura) {
		
		if(facturas == null) {
			facturas = new ArrayList<>();
		}
		
		facturas.add(tempFactura);
		
		tempFactura.setMesa(this);
	}
	
}
