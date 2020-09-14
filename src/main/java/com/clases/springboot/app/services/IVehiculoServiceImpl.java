package com.clases.springboot.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clases.springboot.app.dao.IVehiculoDao;
import com.clases.springboot.app.models.entity.Vehiculo;

@Service
public class IVehiculoServiceImpl implements IVehiculoService {

	@Autowired
	IVehiculoDao vehiculoDao;
	
	@Override
	public Vehiculo save(Vehiculo vehiculo) {
		return vehiculoDao.save(vehiculo);
	}

	@Override
	public List<Vehiculo> findAll() {
		return (List<Vehiculo>) vehiculoDao.findAll();
	}

}
