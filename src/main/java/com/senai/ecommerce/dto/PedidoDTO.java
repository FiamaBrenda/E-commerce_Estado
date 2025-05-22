package com.senai.ecommerce.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.senai.ecommerce.entities.ItemDoPedido;
import com.senai.ecommerce.entities.Pedido;
import com.senai.ecommerce.entities.StatusDoPedido;

public class PedidoDTO {
	
	
	private Long id;
	private Instant momento;
	private StatusDoPedido status;
	@JsonProperty("clienteId")
	private Long clienteId;
	
	private List<ItemPedidoDTO> items = new ArrayList<>();

	public PedidoDTO() {

	}

	public PedidoDTO(Long id, Instant momento, StatusDoPedido status, Long clienteId) {
		this.id = id;
		this.momento = momento;
		this.status = status;
		this.clienteId = clienteId;
	}

	public PedidoDTO(Pedido entity) {
		id = entity.getId();
		momento = entity.getMomento();
		status = entity.getStatus();
		clienteId = entity.getCliente().getId();	
		
		for (ItemDoPedido item : entity.getItems()) {
			ItemPedidoDTO itemDto = new ItemPedidoDTO(item);
			items.add(itemDto);
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
	}

	public StatusDoPedido getStatus() {
		return status;
	}

	public void setStatus(StatusDoPedido status) {
		this.status = status;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public List<ItemPedidoDTO> getItems() {
		return items;
	}

	public void setItems(List<ItemPedidoDTO> items) {
		this.items = items;
	}
}
