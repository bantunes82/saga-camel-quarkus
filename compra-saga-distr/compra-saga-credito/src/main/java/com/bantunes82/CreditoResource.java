package com.bantunes82;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("credito")
public class CreditoResource {


	@Inject
	CreditoService creditoService;

	@GET
	@Path("newPedidoValor")
	@Produces(MediaType.TEXT_PLAIN)
	public Response newPedidoValor(@QueryParam("pedidoId") Long pedidoId, @QueryParam("valor")  int valor){
		try{
			creditoService.newPedidoValor(pedidoId, valor);
			return Response.ok().build();
		}catch (IllegalStateException e){
			return Response.status(Response.Status.NOT_ACCEPTABLE).entity(e.getMessage()).build();
		}
	}


	@GET
	@Path("cancelPedidoValor")
	@Produces(MediaType.TEXT_PLAIN)
	public void cancelPedidoValor(@QueryParam("id") Long id){
		creditoService.cancelPedidoValor(id);
	}

	@GET
	@Path("getCreditoTotal")
	@Produces(MediaType.TEXT_PLAIN)
	public int getCreditoTotal(){
		return creditoService.getCreditoTotal();
	}

}
