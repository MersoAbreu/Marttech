package br.com.project.marttech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.marttech.model.Cliente;
import br.com.project.marttech.service.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
		Cliente cli = clienteService.create(cliente);
		return ResponseEntity.ok().body(cli);

	}

	@GetMapping(path = "/{id}")
	ResponseEntity<Cliente> getId(@PathVariable Long id) {
	
		return ResponseEntity.ok(clienteService.findByIdOrThrowBadRequestException(id));
	}
	
	@GetMapping(path = "/find")
	ResponseEntity<List<Cliente>> getName(@RequestParam(required = false) String nome) {
	
		return ResponseEntity.ok(clienteService.getName(nome));

	}
}
