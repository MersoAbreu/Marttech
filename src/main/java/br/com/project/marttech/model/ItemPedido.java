package br.com.project.marttech.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ItemPedido implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ItemPedidoPk id = new ItemPedidoPk();

	private double total;
	private int quantidade;

	public ItemPedido() {

	}

	public ItemPedido(ItemPedidoPk id, Produto produto, Pedido pedido, double total, int quantidade) {
		super();
		id.setPedido(pedido);
		id.setProduto(produto);
		this.id = id;
		this.total = total;
		this.quantidade = quantidade;
	}

	public Pedido getPedido() {
		return id.getPedido();
	}

	public Produto getProduto() {
		return id.getProduto();
	}

	public ItemPedidoPk getId() {
		return id;
	}

	public void setId(ItemPedidoPk id) {
		this.id = id;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
