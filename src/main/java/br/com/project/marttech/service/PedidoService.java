package br.com.project.marttech.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.project.marttech.exception.BadRequestException;
import br.com.project.marttech.model.ItemPedido;
import br.com.project.marttech.model.Pedido;
import br.com.project.marttech.repository.ItemPedidoRepository;
import br.com.project.marttech.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private ClienteService clienteService;

	public Pedido insertPedido(Pedido pedido) {
		pedido.setId(null);
		pedido.setInstante(new Date());
		pedido.setCliente(clienteService.find(pedido.getCliente().getId()));
		pedido = pedidoRepository.save(pedido);
		for (ItemPedido iped : pedido.getItens()) {
			iped.setProduto(produtoService.find(iped.getProduto().getId()));
			iped.setPreco(iped.getProduto().getPreco());
			iped.setPedido(pedido);

		}
		
		itemPedidoRepository.saveAll(pedido.getItens());
		return pedido;
	}

	public Pedido findByIdOrThrowBadRequestException(Long id) {
		return pedidoRepository.findById(id).orElseThrow(() -> new BadRequestException("Cliente não encontrado"));
	}

	public void delete(Long id) {
		pedidoRepository.deleteById(id);
		
	}
}
