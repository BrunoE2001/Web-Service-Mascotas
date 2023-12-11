package com.mx.PersonaMascota.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.PersonaMascota.dao.MascotaDao;
import com.mx.PersonaMascota.entidad.Mascota;
import com.mx.PersonaMascota.respuesta.Respuesta;

@Service
public class ImpMascota implements MetodosMascota {

	@Autowired
	MascotaDao mascotaDao;

	@Override
	public Respuesta guardar(Mascota mascota) {
		Respuesta rs = new Respuesta();
		if (mascotaDao.findAll().isEmpty()) {
			mascotaDao.save(mascota);
			rs.setSuccess(true);
			rs.setMensaje("Se registro correctamente");
			rs.setObj(mascota);
			return rs;
		} else {
			if (mascotaDao.existsById(mascota.getNumero_registro())) {
				rs.setMensaje("Este registro ya existe");
				rs.setSuccess(false);
				rs.setObj(mascotaDao.findById(mascota.getNumero_registro()));
				return rs;
			} else {
				mascotaDao.save(mascota);
				rs.setSuccess(true);
				rs.setMensaje("Se registro correctamente");
				rs.setObj(mascota);
				return rs;
			}
		}
	}

	@Override
	public Respuesta editar(Mascota mascota) {
		Respuesta rs = new Respuesta();
		if (mascotaDao.existsById(mascota.getNumero_registro())) {
			mascotaDao.save(mascota);
			rs.setMensaje("Se edito correctamente");
			rs.setSuccess(true);
			rs.setObj(mascota);
			return rs;
		} else {
			rs.setMensaje("No se encontro este registro a editar");
			rs.setSuccess(false);
			rs.setObj(null);
			return rs;
		}
	}

	@Override
	public Respuesta eliminar(Mascota mascota) {
		Respuesta rs = new Respuesta();
		mascota = mascotaDao.findById(mascota.getNumero_registro()).orElse(null);
		if (mascota != null) {
			if (mascota.getPersona() == null) {
				rs.setObj(new Mascota(mascota.getNumero_registro(), 
						mascota.getNombre_mascota(), 
						mascota.getEspecie(), 
						mascota.getRaza(), 
						mascota.getEdad(), 
						mascota.getPeso(), 
						mascota.getPersona()));
				
				mascotaDao.delete(mascota);
				rs.setMensaje("Se elimino correctamente");
				rs.setSuccess(true);
				return rs;
			}
			rs.setObj(new Mascota(mascota.getNumero_registro(), 
					mascota.getNombre_mascota(), 
					mascota.getEspecie(), 
					mascota.getRaza(), 
					mascota.getEdad(), 
					mascota.getPeso(), 
					mascota.getPersona()));
			mascota.getPersona().getMascotas().remove(mascota);
			mascota.setPersona(null);
			mascotaDao.delete(mascota);
			rs.setMensaje("Se elimino correctamente");
			rs.setSuccess(true);
			return rs;
		} else {
			rs.setMensaje("No se encontro este registro a eliminar");
			rs.setSuccess(false);
			rs.setObj(null);
			return rs;
		}
	}

	@Override
	public Respuesta buscar(Mascota mascota) {
		Respuesta rs = new Respuesta();
		mascota = mascotaDao.findById(mascota.getNumero_registro()).orElse(null);
		if (mascota != null) {
			rs.setMensaje("Se encontro la siguiente coincidencia");
			rs.setSuccess(true);
			rs.setObj(mascota);
			return rs;
		} else {
			rs.setMensaje("No se encontraron coincidencias");
			rs.setSuccess(false);
			rs.setObj(null);
			return rs;
		}
	}

	@Override
	public Respuesta mostrar() {
		Respuesta rs = new Respuesta();
		if (mascotaDao.findAll().isEmpty()) {
			rs.setMensaje("Aun no hay registros");
			rs.setSuccess(false);
			rs.setObj(null);
			return rs;
		} else {
			rs.setMensaje("Se muestran los registros");
			rs.setSuccess(true);
			rs.setObj(mascotaDao.findAll());
			return rs;
		}
	}
}
