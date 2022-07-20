package com.idat.hospital.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.idat.hospital.dto.ClienteDTOResponse;
import com.idat.hospital.dto.HospitalDTOResponse;
import com.idat.hospital.model.Cliente;
import com.idat.hospital.model.Hospital;
import com.idat.hospital.repository.ClienteRepository;
import com.idat.hospital.repository.HospitalRepository;

public class HospitalServiceImpl implements HospitalService{

	@Autowired
	HospitalRepository repository;

	@Override
	public List<HospitalDTOResponse> listarHospitales() {
		List<HospitalDTOResponse> listar = new ArrayList<>();
		
		HospitalDTOResponse dto = null;
		
		List<Hospital> h = repository.findAll();
		
		for(Hospital hospital: h) {
			
			dto = new HospitalDTOResponse();
			
			dto.setIdHospital(hospital.getIdHospital());
			dto.setNombre(hospital.getNombre());
			dto.setDescripcion(hospital.getDescripcion());
			dto.setDistrito(hospital.getDistrito());
			
			listar.add(dto);
		}
		
		return listar;
	}

	@Override
	public HospitalDTOResponse obtenerHospitalId(Integer id) {
		Hospital hospital = repository.findById(id).orElse(null);
		HospitalDTOResponse dto = new HospitalDTOResponse();
		
		dto.setIdHospital(hospital.getIdHospital());
		dto.setNombre(hospital.getNombre());
		dto.setDistrito(hospital.getDistrito());
		dto.setDescripcion(hospital.getDescripcion());
		
		return dto;
	}
}
