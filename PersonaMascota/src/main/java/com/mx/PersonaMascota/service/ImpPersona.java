package com.mx.PersonaMascota.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.PersonaMascota.dao.PersonaDao;
import com.mx.PersonaMascota.entidad.Persona;
import com.mx.PersonaMascota.respuesta.Respuesta;

@Service
public class ImpPersona implements MetodosPersona {

	@Autowired
	PersonaDao personaDao;

	@Override
	public Respuesta guardar(Persona persona) {
		Respuesta rs = new Respuesta();
		if (personaDao.findAll().isEmpty()) {
			personaDao.save(persona);
			rs.setMensaje("Se registro correctamente");
			rs.setSuccess(true);
			rs.setObj(persona);
			return rs;
		} else {
			if (personaDao.existsById(persona.getCurp())) {
				rs.setMensaje("Este curp ya existe en la base de datos");
				rs.setSuccess(false);
				rs.setObj(personaDao.existsById(persona.getCurp()));
				return rs;
			} else {
				for (Persona p : personaDao.findAll()) {
					if (persona.getNombre().equals(p.getNombre()) && persona.getApellido().equals(p.getApellido())) {
						rs.setMensaje("Este usuario ya esta registrado en la base de datos");
						rs.setSuccess(false);
						rs.setObj(p);
						return rs;
					}
				}

				personaDao.save(persona);
				rs.setMensaje("Se registro correctamente");
				rs.setSuccess(true);
				rs.setObj(persona);
				return rs;
			}
		}
	}

	@Override
	public Respuesta editar(Persona persona) {
		Respuesta rs = new Respuesta();
		Persona person = personaDao.findById(persona.getCurp()).orElse(null);
		if (person == null) {
			rs.setMensaje("No se encontro este registro");
			rs.setSuccess(false);
			rs.setObj(null);
			return rs;
		} else {
			person.setNombre(persona.getNombre());
			person.setApellido(persona.getApellido());
			person.setEdad(persona.getEdad());
			person.setPeso(persona.getPeso());
			person.setCiudad(persona.getCiudad());
			personaDao.save(person);

			rs.setMensaje("Se edito correctamente");
			rs.setSuccess(true);
			rs.setObj(person);

			return rs;
		}
	}

	@Override
	public Respuesta eliminar(Persona persona) {
		Respuesta rs = new Respuesta();
		persona = personaDao.findById(persona.getCurp()).orElse(null);
		if (persona != null) {
			if (persona.getMascotas().isEmpty()) {
				rs.setObj(new Persona(persona.getCurp(), persona.getNombre(), persona.getApellido(), persona.getEdad(),
						persona.getPeso(), persona.getCiudad(), persona.getMascotas()));
				personaDao.delete(persona);
				rs.setSuccess(true);
				rs.setMensaje("Se elimino correctamente");
				rs.setObj(persona);
				return rs;
			}else {
				rs.setMensaje("Esta persona no se puede eliminar porque tiene una mascota");
				rs.setSuccess(false);
				rs.setObj(persona.getMascotas());
				return rs;
			}			
		} else {
			rs.setMensaje("No se encuntro este registro");
			rs.setSuccess(false);
			rs.setObj(persona);
			return rs;
		}
	}

	@Override
	public Respuesta buscar(Persona persona) {
		Respuesta rs = new Respuesta();
		persona = personaDao.findById(persona.getCurp()).orElse(null);
		if (persona != null) {
			rs.setMensaje("Se encontro una coincidencia");
			rs.setSuccess(true);
			rs.setObj(persona);
			return rs;
		}else {
			rs.setMensaje("No se encontro este registro");
			rs.setSuccess(false);
			rs.setObj(null);
			return rs;
		}
	}

	@Override
	public Respuesta mostrar() {
		Respuesta rs = new Respuesta();
		if (personaDao.findAll().isEmpty()) {
			rs.setMensaje("No hay registros");
			rs.setSuccess(false);
			rs.setObj(null);
			return rs;
		} else {
			rs.setMensaje("Se muestran los registros");
			rs.setObj(personaDao.findAll());
			rs.setSuccess(true);
			return rs;
		}
	}

	public Respuesta mascotasPersona(Persona person) {
		Respuesta rs = new Respuesta();
		Persona persona = personaDao.findById(person.getCurp()).orElse(null);
	    
	    if (persona != null) {
	        if (persona.getMascotas().isEmpty()) {
	            rs.setMensaje("La persona no tiene mascotas registradas.");
	            rs.setSuccess(false);
	            rs.setObj(null);
	        } else {
	            rs.setMensaje("Mascotas de la persona encontradas.");
	            rs.setSuccess(true);
	            rs.setObj(persona.getMascotas());
	        }
	    } else {
	        rs.setMensaje("No se encontró la persona en la base de datos.");
	        rs.setSuccess(false);
	        rs.setObj(null);
	    }
	    
	    return rs;
	}
}
