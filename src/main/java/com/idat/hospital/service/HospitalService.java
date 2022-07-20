package com.idat.hospital.service;

import java.util.List;

import com.idat.hospital.dto.HospitalDTOResponse;


public interface HospitalService {

	List<HospitalDTOResponse> listarHospitales();
	HospitalDTOResponse obtenerHospitalId(Integer id);
}
