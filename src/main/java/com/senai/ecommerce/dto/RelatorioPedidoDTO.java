package com.senai.ecommerce.dto;

import java.time.format.DateTimeFormatter;

import com.senai.ecommerce.entities.Pedido;

public class RelatorioPedidoDTO {

	private Long pedido;
	private String cliente;
	private String status;
	private String momento;
	
	public RelatorioPedidoDTO(Pedido entity) {
		this.pedido = entity.getId();
		this.cliente = entity.getCliente().getNome();
		
		// convertendo o ENUM status para String com o toString
		this.status = entity.getStatus().toString();
		this.momento = entity.getMomento().atZone(java.time.ZoneId.systemDefault())
				.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
	}

	public Long getPedido() {
		return pedido;
	}

	public String getCliente() {
		return cliente;
	}

	public String getStatus() {
		return status;
	}

	public String getMomento() {
		return momento;
	}
	
}
