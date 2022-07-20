package com.idat.hospital.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.idat.hospital.dto.ClienteDTOResponse;
import com.idat.hospital.model.Cliente;
import com.idat.hospital.repository.ClienteRepository;

public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	ClienteRepository repository;

	@Override
	public List<ClienteDTOResponse> listarClientes() {
		List<ClienteDTOResponse> listar = new ArrayList<>();
		
		ClienteDTOResponse dto = null;
		
		List<Cliente> c = repository.findAll();
		
		for(Cliente cliente: c) {
			
			dto = new ClienteDTOResponse();
			
			dto.setIdCliente(cliente.getIdCliente());
			dto.setNombre(cliente.getNombre());
			dto.setCelular(cliente.getCelular());
			
			listar.add(dto);
		}
		
		return listar;
	}

	@Override
	public ClienteDTOResponse obtenerClienteId(Integer id) {
		Cliente cliente = repository.findById(id).orElse(null);
		ClienteDTOResponse dto = new ClienteDTOResponse();
		
		dto.setIdCliente(cliente.getIdCliente());
		dto.setNombre(cliente.getNombre());
		dto.setCelular(cliente.getCelular());
		
		return dto;
	}
	
}
