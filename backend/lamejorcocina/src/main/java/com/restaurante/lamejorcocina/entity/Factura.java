package com.restaurante.lamejorcocina.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="factura")
public class Factura {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="camarero_id")
	private Camarero camarero;
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="mesa_id")
	private Mesa mesa;
	
	@Column(name="fecha_factura")
	private Date fechaFactura;
	
	@OneToMany(mappedBy="factura", cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private List<DetalleFactura> detalleFactura;

	public Factura() {
	
	}

	public Factura(Cliente cliente, Camarero camarero, Mesa mesa, Date fechaFactura) {
		this.cliente = cliente;
		this.camarero = camarero;
		this.mesa = mesa;
		this.fechaFactura = fechaFactura;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Camarero getCamarero() {
		return camarero;
	}

	public void setCamarero(Camarero camarero) {
		this.camarero = camarero;
	}

	public Mesa getMesa() {
		return this.mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public Date getFechaFactura() {
		return fechaFactura;
	}

	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}

	public List<DetalleFactura> getDetalleFactura() {
		return detalleFactura;
	}

	public void setDetalleFactura(List<DetalleFactura> detalleFactura) {
		this.detalleFactura = detalleFactura;
	}

	public void add(DetalleFactura tempDetalleFactura) {
		
		if(detalleFactura == null) {
			detalleFactura = new ArrayList<>();
		}
		
		detalleFactura.add(tempDetalleFactura);
		
		tempDetalleFactura.setFactura(this);
	}

	@Override
	public String toString() {
		return "Factura [id=" + id + ", cliente=" + cliente + ", camarero=" + camarero + ", mesa=" + mesa
				+ ", fechaFactura=" + fechaFactura + ", detalleFactura=" + detalleFactura + "]";
	}
	
}
