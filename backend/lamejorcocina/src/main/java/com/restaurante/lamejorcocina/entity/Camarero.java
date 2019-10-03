package com.restaurante.lamejorcocina.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.restaurante.lamejorcocina.dto.CamareroFacturadoTotalDTO;

@Entity
@Table(name="camarero")

@NamedNativeQuery(
	    name = "CamareroFacturadoTotalDTO",
	    query ="SELECT camarero.id, camarero.nombre, camarero.apellido1, camarero.apellido2, COALESCE(SUM(detalle_factura.importe), 0) AS total_facturado,\n" + 
				"	SUM(CASE WHEN fecha_factura >= '2019-01-01' AND fecha_factura <= '2019-01-31' \n" + 
				"		THEN detalle_factura.importe ELSE 0 END) AS enero,\n" + 
				"	SUM(CASE WHEN fecha_factura >= '2019-02-01' AND fecha_factura <= '2019-02-28' \n" + 
				"		THEN detalle_factura.importe ELSE 0 END) AS febrero,\n" + 
				"	SUM(CASE WHEN fecha_factura >= '2019-03-01' AND fecha_factura <= '2019-03-31' \n" + 
				"		THEN detalle_factura.importe ELSE 0 END) AS marzo,\n" + 
				"	SUM(CASE WHEN fecha_factura >= '2019-04-01' AND fecha_factura <= '2019-04-30' \n" + 
				"		THEN detalle_factura.importe ELSE 0 END) AS abril,\n" + 
				"	SUM(CASE WHEN fecha_factura >= '2019-05-01' AND fecha_factura <= '2019-05-31' \n" + 
				"		THEN detalle_factura.importe ELSE 0 END) AS mayo,\n" + 
				"	SUM(CASE WHEN fecha_factura >= '2019-06-01' AND fecha_factura <= '2019-06-30' \n" + 
				"		THEN detalle_factura.importe ELSE 0 END) AS junio,\n" + 
				"	SUM(CASE WHEN fecha_factura >= '2019-07-01' AND fecha_factura <= '2019-07-31' \n" + 
				"		THEN detalle_factura.importe ELSE 0 END) AS julio,\n" + 
				"	SUM(CASE WHEN fecha_factura >= '2019-08-01' AND fecha_factura <= '2019-08-31' \n" + 
				"		THEN detalle_factura.importe ELSE 0 END) AS agosto,\n" + 
				"	SUM(CASE WHEN fecha_factura >= '2019-09-01' AND fecha_factura <= '2019-09-30' \n" + 
				"		THEN detalle_factura.importe ELSE 0 END) AS septiembre,\n" + 
				"	SUM(CASE WHEN fecha_factura >= '2019-10-01' AND fecha_factura <= '2019-10-31' \n" + 
				"		THEN detalle_factura.importe ELSE 0 END) AS octubre,\n" + 
				"	SUM(CASE WHEN fecha_factura >= '2019-11-01' AND fecha_factura <= '2019-11-30' \n" + 
				"		THEN detalle_factura.importe ELSE 0 END) AS noviembre,\n" + 
				"	SUM(CASE WHEN fecha_factura >= '2019-12-01' AND fecha_factura <= '2019-12-31' \n" + 
				"		THEN detalle_factura.importe ELSE 0 END) AS diciembre\n" + 
				"FROM camarero \n" + 
				"LEFT JOIN factura ON factura.camarero_id = camarero.id \n" + 
				"LEFT JOIN detalle_factura ON detalle_factura.factura_id = factura.id \n" + 
				"GROUP BY camarero.id",
	    resultSetMapping = "CamareroFacturadoTotalDTO"
	)
	
	@SqlResultSetMapping(
        name = "CamareroFacturadoTotalDTO",
        classes = @ConstructorResult(
                targetClass = CamareroFacturadoTotalDTO.class,
                columns = {
                	@ColumnResult(name = "id"),
                    @ColumnResult(name = "nombre"),
                    @ColumnResult(name = "apellido1"),
                    @ColumnResult(name = "apellido2"),
                    @ColumnResult(name = "total_facturado", type = Double.class),
                	@ColumnResult(name = "enero", type = Double.class),
                	@ColumnResult(name = "febrero", type = Double.class),
                	@ColumnResult(name = "marzo", type = Double.class),
                	@ColumnResult(name = "abril", type = Double.class),
                	@ColumnResult(name = "mayo", type = Double.class),
                	@ColumnResult(name = "junio", type = Double.class),
                	@ColumnResult(name = "julio", type = Double.class),
                	@ColumnResult(name = "agosto", type = Double.class),
                	@ColumnResult(name = "septiembre", type = Double.class),
                	@ColumnResult(name = "octubre", type = Double.class),
                	@ColumnResult(name = "noviembre", type = Double.class),
                	@ColumnResult(name = "diciembre", type = Double.class)
                }))

public class Camarero {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido1")
	private String apellido1;
	
	@Column(name="apellido2")
	private String apellido2;
	
	@OneToMany(mappedBy="camarero", cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JsonIgnore
	private List<Factura> facturas;
	
	

	public Camarero() {
		
	}

	public Camarero(String nombre, String apellido1, String apellido2) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
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
		
		tempFactura.setCamarero(this);
	}
	
}
