package br.com.project.marttech.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.project.marttech.model.Pedido;
import br.com.project.marttech.service.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Pedido pedido) {
		pedido = pedidoService.insertPedido(pedido);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(pedido.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping(path = "/{id}")
	ResponseEntity<Pedido> getId(@PathVariable Long id) {
	
		return ResponseEntity.ok(pedidoService.findByIdOrThrowBadRequestException(id));
	}
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Void>delete(@PathVariable Long id){
		pedidoService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
