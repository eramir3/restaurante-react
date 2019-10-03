package com.restaurante.lamejorcocina.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.ConstructorResult;
import javax.persistence.FieldResult;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.restaurante.lamejorcocina.dto.ClienteImporteTotalDTO;
import com.restaurante.lamejorcocina.dto.FacturaClienteDTO;

@Entity
@Table(name="cliente")

/* Native query con mapping sencillo a la entidad
@SqlResultSetMapping(
        name = "ClienteMapping",
        entities = 
        	@EntityResult(
                entityClass = Cliente.class,
                fields = {
                    @FieldResult(name = "id", column = "clienteId"),
                    @FieldResult(name = "nombre", column = "nombre"),
                    @FieldResult(name = "apellido1", column = "apellido1"),
                    @FieldResult(name = "apellido2", column = "apellido1"),
                    @FieldResult(name = "observaciones", column = "observaciones")}))
          			*/



// Native query con mapping a dto
@NamedNativeQuery(
	    name = "FacturaClienteDTO",
	    query ="SELECT f.id as facturaId, f.fecha_factura, c.id as clienteId, c.nombre, c.apellido1, c.apellido2, c.observaciones FROM Factura f JOIN Cliente c ON f.cliente_id = c.id",
	    resultSetMapping = "FacturaClienteDTO"
	)

@SqlResultSetMapping(
        name = "FacturaClienteDTO",
        classes = @ConstructorResult(
                targetClass = FacturaClienteDTO.class,
                columns = {
                    @ColumnResult(name = "facturaId"),
                    @ColumnResult(name = "fecha_factura"),
                    @ColumnResult(name = "clienteId"),
                    @ColumnResult(name = "nombre"),
                    @ColumnResult(name = "apellido1"),
                    @ColumnResult(name = "apellido2"),
                    @ColumnResult(name = "observaciones")
                }))


@NamedNativeQuery(
	    name = "ClienteImporteTotalDTO",
	    query ="SELECT * FROM \n" + 
				"	(SELECT cliente.id, cliente.nombre as nombre, cliente.apellido1 as apellido1, cliente.apellido2 as apellido2, SUM(importe) as importe_total FROM detalle_factura\n" + 
				"	JOIN factura ON factura.id = detalle_factura.factura_id\n" + 
				"	JOIN cliente ON cliente.id = factura.cliente_id\n" + 
				"	GROUP BY cliente.id ) AS result\n" + 
				"	WHERE importe_total >= 100000",
	    resultSetMapping = "ClienteImporteTotalDTO"
	)

@SqlResultSetMapping(
        name = "ClienteImporteTotalDTO",
        classes = @ConstructorResult(
                targetClass = ClienteImporteTotalDTO.class,
                columns = {
                	@ColumnResult(name = "id"),
                    @ColumnResult(name = "nombre"),
                    @ColumnResult(name = "apellido1"),
                    @ColumnResult(name = "apellido2"),
                    @ColumnResult(name = "importe_total", type = Double.class)
                }))

public class Cliente {

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
	
	@Column(name="observaciones")
	private String observaciones;
	
	@OneToMany(mappedBy="cliente", cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JsonIgnore
	private List<Factura> facturas;

	
	
	public Cliente() {
		
	}

	public Cliente(String nombre, String apellido1, String apellido2, String observaciones) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.observaciones = observaciones;
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

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
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
		
		tempFactura.setCliente(this);
	}
	
}
