package com.clases.springboot.app.services;

import java.util.List;

import com.clases.springboot.app.models.entity.Vehiculo;

public interface IVehiculoService {
	public Vehiculo save (Vehiculo vehiculo);
	public List<Vehiculo> findAll();
}
