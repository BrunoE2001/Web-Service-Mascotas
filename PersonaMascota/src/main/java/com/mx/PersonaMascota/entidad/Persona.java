package com.mx.PersonaMascota.entidad;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PERSONAS")
@Data // genera set, get y tostring con lombok
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
	// Atributos
	@Id
	@Column
	String curp;
	@Column
	String nombre;
	@Column
	String apellido;
	@Column
	int edad;
	@Column
	double peso;
	@Column
	String ciudad;

	@OneToMany(mappedBy = "persona", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonIgnore
	List<Mascota> mascotas = new ArrayList<Mascota>();
}