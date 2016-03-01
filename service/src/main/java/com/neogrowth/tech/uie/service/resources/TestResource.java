package com.neogrowth.tech.uie.service.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.skife.jdbi.v2.DBI;

import com.codahale.metrics.annotation.Timed;

@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
public class TestResource {

	private DBI dataSourceFactory;

	public TestResource(DBI dataSourceFactory) {
		this.dataSourceFactory = dataSourceFactory;
	}

	@GET
	@Timed
	public String sayHello() {
		if (dataSourceFactory != null) {
			return "Hello, It's working perfectly fine";
		} else {
			return "Hello, It's working, but not able to read from config file";
		}
	}
}
