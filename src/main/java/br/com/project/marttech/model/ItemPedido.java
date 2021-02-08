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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
