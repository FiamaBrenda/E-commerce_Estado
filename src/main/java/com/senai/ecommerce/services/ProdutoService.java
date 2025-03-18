package com.senai.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.senai.ecommerce.dto.CategoriaDTO;
import com.senai.ecommerce.dto.ProdutoDTO;
import com.senai.ecommerce.entities.Categoria;
import com.senai.ecommerce.entities.Produto;
import com.senai.ecommerce.repositories.CategoriaRepository;
import com.senai.ecommerce.repositories.ProdutoRepository;

import jakarta.transaction.Transactional;
@Service
public class ProdutoService {

	@Autowired 
	ProdutoRepository repo;
	
	@Autowired 
	CategoriaRepository categoriaRepository;
	
	public List<ProdutoDTO> buscarTodos() {
	List<Produto> list = repo.findAll();
		return list.stream().map(x -> new ProdutoDTO(x)).toList() ; 
	}
	
	public Page<ProdutoDTO> buscarPagina(Pageable pagina ){
		Page<Produto> result = repo.findAll(pagina);
		return result.map(x -> new ProdutoDTO(x));
	}
	
@Transactional
	public ProdutoDTO inserir(ProdutoDTO dto) {
		Produto prod = new Produto();
		prod.setNome(dto.getNome());
		prod.setDescricao(dto.getDescricao());
		prod.setPreco(dto.getPreco());
		prod.setImgUrl(dto.getImgUrl());
		for(CategoriaDTO cat : dto.getCategorias()) {
			
			Categoria entity = categoriaRepository.getReferenceById(cat.getId());
			prod.getCategorias().add(entity);
		}
		prod = repo.save(prod);
		return new ProdutoDTO(prod);
	}
}

