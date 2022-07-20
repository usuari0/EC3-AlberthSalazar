package com.idat.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idat.hospital.dto.ClienteDTOResponse;
import com.idat.hospital.service.ClienteService;

@Controller
@RequestMapping( path = "/cliente/v1")
public class ClienteController {
	@Autowired
	ClienteService service;

	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<ClienteDTOResponse>>  listar() {
		return new ResponseEntity<List<ClienteDTOResponse>>(service.listarClientes(), HttpStatus.OK) ;
	}
	
	@RequestMapping( path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<ClienteDTOResponse> obtenerId(@PathVariable Integer id) {
		ClienteDTOResponse e =service.obtenerClienteId(id);
		if(e != null) {
			return  new ResponseEntity<ClienteDTOResponse>(service.obtenerClienteId(id),HttpStatus.OK);
		}
		return  new ResponseEntity<ClienteDTOResponse>(HttpStatus.NOT_FOUND);
	}
}
