package br.com.project.marttech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.project.marttech.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
