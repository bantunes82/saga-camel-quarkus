package com.bantunes82;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashSet;
import java.util.Set;

@ApplicationScoped
public class PedidoService {

	private Set<Long> pedidos = new HashSet<>();

	public void newPedido(Long id){
		pedidos.add(id);
	}

	public void cancelPedido(Long id){
		pedidos.remove(id);
	}
}
