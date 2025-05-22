package com.senai.ecommerce.dto;

import com.senai.ecommerce.entities.ItemDoPedido;

public class ItemPedidoDTO {
	
	private Long idProduto;
	private String nome;
	private Double preco;
	private Integer quantidade;
	private String imgUrl;
	
	public ItemPedidoDTO() {
		
	}
	
	public ItemPedidoDTO(Long idProduto, String nome, Double preco, Integer quantidade, String imgUrl) {
		this.idProduto = idProduto;
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
		this.imgUrl = imgUrl;
	}
	
	public ItemPedidoDTO(ItemDoPedido entity) {
		this.idProduto = entity.getProduto().getId() ;
		this.nome = entity.getProduto().getNome();
		this.preco = entity.getPreco();
		this.quantidade = entity.getQuantidade();
		this.imgUrl = entity.getProduto().getImgUrl();
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	public Double getSubTotal() {
		return preco * quantidade;
	}

}
