package com.clases.springboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.clases.springboot.app.models.entity.AuthenticationRequest;
import com.clases.springboot.app.models.entity.AuthenticationResponse;
import com.clases.springboot.app.services.JpaUserDetailsService;
import com.clases.springboot.app.util.JwtUtil;

@RestController
@RequestMapping("/api")
public class LoginController {
	
	@Autowired
	private JpaUserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@PostMapping("/authenticate")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> createAuthtenticationToken (@RequestBody AuthenticationRequest authenticationRequest)
	throws Exception{
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword())
			);
		}catch (BadCredentialsException e) {
			throw new Exception("Usuario o contraseña incorrecta", e);
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
		
	}
}
