package com.mx.PersonaMascota.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.PersonaMascota.entidad.Persona;

@Repository
public interface PersonaDao extends JpaRepository<Persona, String>{

}
