package com.bantunes82;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class CreditoService {

	private int creditoTotal;
	private Map<Long, Integer> pedido_valor = new HashMap<>();

	public CreditoService() {
		this.creditoTotal = 100;
	}

	public void newPedidoValor(Long pedidoId, int valor){
		if (valor > creditoTotal){
			this.creditoTotal = 100; //apenas para que possamos testar vez apos ves
			throw new IllegalStateException("saldo insuficiente");
		}

		creditoTotal = creditoTotal - valor;
		pedido_valor.put(pedidoId, valor);
	}

	public void cancelPedidoValor(Long id){
		System.out.println("PedidoValor falhou. Iniciando cancelamento de pedido");
	}

	public int getCreditoTotal() {
		return creditoTotal;
	}




}
