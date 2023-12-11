package com.mx.PersonaMascota.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.PersonaMascota.entidad.Persona;
import com.mx.PersonaMascota.respuesta.Respuesta;
import com.mx.PersonaMascota.service.ImpPersona;

@RestController
@RequestMapping("personas")
@CrossOrigin
public class PersonasWs {

	@Autowired
	ImpPersona imp;

	// lister
	@GetMapping("mostrar")
	public Respuesta mostrar() {
		return imp.mostrar();
	}

	// guerder
	@PostMapping("guardar")
	public Respuesta guardar(@RequestBody Persona persona) {
		return imp.guardar(persona);
	}

	// editar
	@PostMapping("editar")
	public Respuesta editar(@RequestBody Persona persona) {
		return imp.editar(persona);
	}

	// eliminar
	@PostMapping("eliminar")
	public Respuesta eliminar(@RequestBody Persona persona) {
		return imp.eliminar(persona);
	}

	// buscar
	@PostMapping("buscar")
	public Respuesta buscar(@RequestBody Persona persona) {
		return imp.buscar(persona);
	}

	// buscar
	@PostMapping("mascotasDePersona")
	public Respuesta mascotasDePersona(@RequestBody Persona persona) {
		return imp.mascotasPersona(persona);
	}
}