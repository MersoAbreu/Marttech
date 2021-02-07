package br.com.project.marttech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.project.marttech.exception.BadRequestException;
import br.com.project.marttech.model.Produto;
import br.com.project.marttech.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto addProduto(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public List<Produto> listaProdutos() {
		return produtoRepository.findAll();
	}
	

	public Produto findByIdOrThrowBadRequestException(Long id){
		return produtoRepository.findById(id)
			.orElseThrow(()-> new BadRequestException("Produto não encontrado"));
	}
	
	public Produto find(Long id) {
		Optional<Produto> prod = produtoRepository.findById(id);
		return prod.orElseThrow(()-> new BadRequestException("Não encontrado "+Produto.class.getName()));
	}
}
