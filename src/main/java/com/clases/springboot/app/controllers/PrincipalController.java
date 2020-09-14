package com.clases.springboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.clases.springboot.app.models.entity.Vehiculo;
import com.clases.springboot.app.services.IVehiculoService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PrincipalController {
	
	@Autowired
	IVehiculoService vehiculoService;

	@PostMapping("/vehiculos")
	@ResponseStatus(HttpStatus.CREATED)
	public Vehiculo create (@RequestBody Vehiculo vehiculo) {
		return vehiculoService.save(vehiculo);
	}
	
	@GetMapping("/vehiculos")
	public List<Vehiculo> index(){
		return vehiculoService.findAll();
	}
	
	

	
}
