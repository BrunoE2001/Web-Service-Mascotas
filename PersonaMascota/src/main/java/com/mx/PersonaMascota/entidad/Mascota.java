package com.mx.PersonaMascota.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MASCOTAS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mascota {
	// Atributos
	@Id
	@Column
	int numero_registro;
	@Column(name = "nombre")
	String nombre_mascota;
	@Column
	String especie;
	@Column
	String raza;
	@Column
	int edad;
	@Column
	double peso;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "curp_persona")
	Persona persona;
}
