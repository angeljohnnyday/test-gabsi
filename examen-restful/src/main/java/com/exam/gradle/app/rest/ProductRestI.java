package com.exam.gradle.app.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.exam.gradle.app.dto.ProductDTO;

@Path("/product")
public interface ProductRestI {
	final String ERROR = "Ocurrio un error interno en el sistema";

	@GET
	@Path("/get/{id}")
	public ResponseEntity<Object> get(@PathParam("id") String id);
	
	@GET
	@Path("/lst")
	public ResponseEntity<Object> lst();

	@POST
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/create")
	public ResponseEntity<Object> create(@RequestBody ProductDTO productoDTO);

	@PUT
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/update/{id}")
	public ResponseEntity<Object> update(@PathParam("id") String id, @RequestBody ProductDTO productoDTO);
	
	@DELETE
	@Path("/get/{id}")
	public ResponseEntity<Object> delete(@PathParam("id") String id);
}
