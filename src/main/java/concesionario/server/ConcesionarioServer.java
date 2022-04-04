package concesionario.server;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import concesionario.clases.Compra;


@Path("/collector")
@Produces(MediaType.APPLICATION_JSON)
public class ConcesionarioServer {

	private CompraCollector compraCollector;

	public ConcesionarioServer() {
		compraCollector = new CompraCollector();
	}

	@POST
	@Path("/compra")
	public Response comprarCoche(Compra compra) {
		compraCollector.comprarCoche(compra);
		return Response.ok().build();
	}
	
	@GET
	@Path("/compra")
	public Response getCompras() {
		
		return Response.ok(compraCollector.getCompras()).build();
	}
}