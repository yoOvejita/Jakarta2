package com.pepe.Jakarta2;

import com.pepe.Jakarta2.Modelos.Cliente;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.CacheControl;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Request;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;

@Path("cliente")
public class ClienteResource {
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Cliente getCliente() {
		Cliente c = new Cliente();
		c.setNombre("Pepe");
		c.setEdad(18);
		return c;
	}
	
	@POST
	@Path("/enviar")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String recibirCliente(Cliente cliente) {
		return cliente.getNombre() + ": " + cliente.getEdad();
	}
	
	@GET
	@Path("/{num}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response verificaPrimo(@PathParam("num") int numero) {
		int c = 0;
		for(int i = 1; i<= numero; i++) {
			if(numero%i==0)
				c++;
		}
		if(c==2) {
			return Response.ok("El numero es primo").build();
		}else
			return Response.notAcceptable(null).build();
	}
	
	@GET
	@Path("/cacheo/{id}")
	public Response pruebaCache(@PathParam("id") String id) {
		Cliente c = new Cliente();
		c.setNombre("Ana");
		c.setEdad(18);
		ResponseBuilder builder = Response.ok(c);
		
		CacheControl cc = new CacheControl();
		cc.setMaxAge(3600);
		cc.setPrivate(true);
		builder.cacheControl(cc);
		return builder.build();
	}
}
