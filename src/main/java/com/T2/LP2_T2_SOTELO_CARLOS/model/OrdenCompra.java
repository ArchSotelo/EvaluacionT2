package com.T2.LP2_T2_SOTELO_CARLOS.model;

import java.time.LocalDate;

import org.hibernate.annotations.DynamicInsert;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbl_orden_compra")
@Getter @Setter
@DynamicInsert
public class OrdenCompra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="nro_orden")
	private Integer nroOrden;
	
	@ManyToOne
	@JoinColumn(name="id_proveedor")
	private Proveedor prove;
	
	@Column(name="monto")
	private Double monto;
	
	@Column(name="direccion_entrega")
	private String direccion;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="fecha_entrega")
	private LocalDate fechaEntrega;
	
	@Column(name="estado")
	private String estado;
	
	
	public String textoEstado() {
		switch (estado) {
		case "C": {
			return "Completado";
		}
		case "P": {
			return "Pendiente";
		}
		case "A": {
			return "Aprobado";
		}
		default:
			return "Ninguno";
		}
	}
}
