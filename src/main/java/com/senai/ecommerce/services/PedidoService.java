package com.senai.ecommerce.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.ecommerce.dto.PedidoDTO;
import com.senai.ecommerce.entities.ItemDoPedido;
import com.senai.ecommerce.entities.Pedido;
import com.senai.ecommerce.entities.Produto;
import com.senai.ecommerce.entities.StatusDoPedido;
import com.senai.ecommerce.entities.Usuario;

import com.senai.ecommerce.repositories.PedidoRepository;
import com.senai.ecommerce.repositories.ProdutoRepository;
import com.senai.ecommerce.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	ProdutoRepository produtoRepository;


	@Transactional
	public PedidoDTO inserir(PedidoDTO dto) {
		Pedido pedido = new Pedido();
		pedido.setMomento(Instant.now());
		pedido.setStatus(StatusDoPedido.AGUARDANDO_PAGAMENTO);
		pedido = pedidoRepository.save(pedido);
		return new PedidoDTO(pedido);
	}

	@Transactional
	public PedidoDTO findById(Long id) {
		Pedido pedido = pedidoRepository.getById(id);
		return new PedidoDTO(pedido);
	}

}
