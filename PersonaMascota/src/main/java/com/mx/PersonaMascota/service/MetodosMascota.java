package com.mx.PersonaMascota.service;

import com.mx.PersonaMascota.entidad.Mascota;
import com.mx.PersonaMascota.respuesta.Respuesta;

public interface MetodosMascota {
	public Respuesta guardar(Mascota mascota);

	public Respuesta editar(Mascota mascota);

	public Respuesta eliminar(Mascota mascota);

	public Respuesta buscar(Mascota mascota);
	
	public Respuesta mostrar();
}
