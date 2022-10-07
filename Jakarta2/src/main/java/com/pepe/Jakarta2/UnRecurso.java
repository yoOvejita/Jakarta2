package com.pepe.Jakarta2;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("mensaje")
public class UnRecurso {

	@GET
	@Path("/saludar")
	public String saludo() {
		return "Hola a todos, soy un recurso";
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{usuario}")
	public String saludoConParametro(@PathParam("usuario") String nom, @QueryParam("edad") int edad) {
		
		return "Hola " + nom + ", tienes la edad: " + edad;
	}
}
