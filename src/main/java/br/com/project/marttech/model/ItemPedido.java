package br.com.project.marttech.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemPedido implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private ItemPedidoPk id = new ItemPedidoPk();

	private double preco;
	private int quantidade;

	public ItemPedido() {

	}

	public ItemPedido(ItemPedidoPk id, Produto produto, Pedido pedido, double preco, int quantidade) {
		super();
		id.setPedido(pedido);
		id.setProduto(produto);
		this.id = id;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public double getSubTotal() {
		return preco * quantidade;
	}

	public void setPedido(Pedido pedido) {
		id.setPedido(pedido);
	}
	
	public Pedido getPedido() {
		return id.getPedido();
	}

	public void setProduto(Produto produto) {
		id.setProduto(produto);
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

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
