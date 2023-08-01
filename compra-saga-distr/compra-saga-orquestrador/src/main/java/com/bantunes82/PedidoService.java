package com.bantunes82;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.apache.camel.Header;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;


@ApplicationScoped
@RegisterRestClient(baseUri = "http://compra-saga-pedido-bantunes82-dev.apps.sandbox-m3.1530.p1.openshiftapps.com/pedido")
public interface PedidoService {


	@GET
	@Path("newPedido")
	@Produces(MediaType.TEXT_PLAIN)
	void newPedido(@QueryParam("id") @Header("id") Long id);

	@GET
	@Path("cancelPedido")
	@Produces(MediaType.TEXT_PLAIN)
	void cancelPedido(@QueryParam("id") @Header("id") Long id);
}
