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
import com.idat.hospital.dto.HospitalDTOResponse;
import com.idat.hospital.service.ClienteService;
import com.idat.hospital.service.HospitalService;

@Controller
@RequestMapping( path = "/hospital/v1")
public class HospitalController {
	@Autowired
	HospitalService service;

	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<HospitalDTOResponse>>  listar() {
		return new ResponseEntity<List<HospitalDTOResponse>>(service.listarHospitales(), HttpStatus.OK) ;
	}
	
	@RequestMapping( path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<HospitalDTOResponse> obtenerId(@PathVariable Integer id) {
		HospitalDTOResponse e =service.obtenerHospitalId(id);
		if(e != null) {
			return  new ResponseEntity<HospitalDTOResponse>(service.obtenerHospitalId(id),HttpStatus.OK);
		}
		return  new ResponseEntity<HospitalDTOResponse>(HttpStatus.NOT_FOUND);
	}
}
