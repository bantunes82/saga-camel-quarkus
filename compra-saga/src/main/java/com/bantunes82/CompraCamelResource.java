package com.bantunes82;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.apache.camel.CamelContext;

@Path("compra-camel")
public class CompraCamelResource {

	@Inject
	CamelContext context;

	@Path("teste")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response saga(){

		try{//credito = 100
			Long id = 0l;

			comprar(++id, 20);
			comprar(++id, 30);
			comprar(++id, 30);
			comprar(++id, 25);

			return Response.ok().build();
		} catch (Exception e){
			return Response.status(500).build();
		}
	}

	private void comprar (Long id, int valor){
		System.out.println("Peido: " + id + " valor: " + valor );

		try{
			context.createFluentProducerTemplate()
					.to("direct:saga")
					.withHeader("id", id)
					.withHeader("pedidoId", id)
					.withHeader("valor", valor)
					.request();
		}catch (Exception e){
			throw new RuntimeException(e.getMessage());
		}
	}

}
