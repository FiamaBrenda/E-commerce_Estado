package com.senai.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.ecommerce.entities.ItemDoPedido;
import com.senai.ecommerce.entities.ItemDoPedidoPK;

@Repository
public interface ItemDoPedidoRepository extends JpaRepository<ItemDoPedido, ItemDoPedidoPK> {

}
