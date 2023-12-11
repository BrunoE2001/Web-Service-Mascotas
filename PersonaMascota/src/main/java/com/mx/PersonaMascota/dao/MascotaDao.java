package com.mx.PersonaMascota.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.PersonaMascota.entidad.Mascota;

@Repository
public interface MascotaDao extends JpaRepository<Mascota, Integer>{

}
