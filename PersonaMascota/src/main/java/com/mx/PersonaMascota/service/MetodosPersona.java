package com.mx.PersonaMascota.service;

import com.mx.PersonaMascota.entidad.Persona;
import com.mx.PersonaMascota.respuesta.Respuesta;

public interface MetodosPersona {
	public Respuesta guardar(Persona persona);

	public Respuesta editar(Persona persona);

	public Respuesta eliminar(Persona persona);

	public Respuesta buscar(Persona persona);
	
	public Respuesta mostrar();
}
