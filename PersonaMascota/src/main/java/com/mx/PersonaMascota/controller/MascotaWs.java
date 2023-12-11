package com.mx.PersonaMascota.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.PersonaMascota.entidad.Mascota;
import com.mx.PersonaMascota.respuesta.Respuesta;
import com.mx.PersonaMascota.service.ImpMascota;

@RestController
@RequestMapping("mascotas")
@CrossOrigin
public class MascotaWs {
	@Autowired
	ImpMascota imp;
	
	@GetMapping("mostrar")
	public Respuesta mostrar() {
		return imp.mostrar();
	}
	
	@PostMapping("guardar")
	public Respuesta guardar(@RequestBody Mascota mascota) {
		return imp.guardar(mascota);
	}
	
	@PostMapping("editar")
	public Respuesta editar(@RequestBody Mascota mascota) {
		return imp.editar(mascota);
	}
	
	@PostMapping("eliminar")
	public Respuesta eliminar(@RequestBody Mascota mascota) {
		return imp.eliminar(mascota);
	}
	
	@PostMapping("buscar")
	public Respuesta buscar(@RequestBody Mascota mascota) {
		return imp.buscar(mascota);
	}
}
