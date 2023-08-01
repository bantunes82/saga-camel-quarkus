package com.bantunes82;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.apache.camel.Header;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;



@ApplicationScoped
@RegisterRestClient(baseUri = "http://compra-saga-credito-bantunes82-dev.apps.sandbox-m3.1530.p1.openshiftapps.com/credito")
public interface CreditoService {

	@GET
	@Path("newPedidoValor")
	@Produces(MediaType.TEXT_PLAIN)
	void newPedidoValor(@QueryParam("pedidoId") @Header("pedidoId") Long pedidoId,@QueryParam("valor") @Header("valor") int valor);

	@GET
	@Path("cancelPedidoValor")
	@Produces(MediaType.TEXT_PLAIN)
	void cancelPedidoValor(@QueryParam("id") @Header("id") Long id);

	@GET
	@Path("getCreditoTotal")
	@Produces(MediaType.TEXT_PLAIN)
	int getCreditoTotal();




}
