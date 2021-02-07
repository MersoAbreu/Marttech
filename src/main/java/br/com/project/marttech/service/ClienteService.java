package br.com.project.marttech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.project.marttech.exception.BadRequestException;
import br.com.project.marttech.model.Cliente;
import br.com.project.marttech.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	
	public Cliente create(Cliente cliente) {
		Cliente cli = clienteRepository.save(cliente);
		return cli;
	}
	
	
	public Cliente findByIdOrThrowBadRequestException(Long id){
		return clienteRepository.findById(id)
			.orElseThrow(()-> new BadRequestException("Cliente não encontrado"));
	}
	
	public List<Cliente>getName(String nome){
		List<Cliente> cli = clienteRepository.findByNome(nome);		
		
		return cli;
		
	}

	public Cliente find(Long id){
		return clienteRepository.findById(id)
			.orElseThrow(()-> new BadRequestException("Cliente não encontrado"));
	}
	
	

}
