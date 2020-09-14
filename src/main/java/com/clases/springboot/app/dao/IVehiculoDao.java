package com.clases.springboot.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.clases.springboot.app.models.entity.Vehiculo;

public interface IVehiculoDao extends CrudRepository<Vehiculo, Long>{

}
