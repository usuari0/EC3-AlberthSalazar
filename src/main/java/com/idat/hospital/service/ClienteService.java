package com.idat.hospital.service;

import java.util.List;
import com.idat.hospital.dto.ClienteDTOResponse;

public interface ClienteService {
	List<ClienteDTOResponse> listarClientes();
	ClienteDTOResponse obtenerClienteId(Integer id);
	
}
