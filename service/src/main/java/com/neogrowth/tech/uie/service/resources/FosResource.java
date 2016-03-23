package com.neogrowth.tech.uie.service.resources;

import static com.neogrowth.tech.uie.service.ServiceConstants.FOS_PATH;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.inject.Inject;
import com.neogrowth.tech.uie.core.api.CategoryApi;
import com.neogrowth.tech.uie.core.api.ManualDataCollectionApi;
import com.neogrowth.tech.uie.data.ManualDataCollection;

@Path(FOS_PATH)
@Produces(MediaType.APPLICATION_JSON)
public class FosResource {

	private CategoryApi categoryApi;
	private ManualDataCollectionApi manualDataCollectionApi;

	@Inject
	public FosResource(CategoryApi categoryApi,
			ManualDataCollectionApi manualDataCollectionApi) {
		this.categoryApi = categoryApi;
		this.manualDataCollectionApi = manualDataCollectionApi;

	}

	@GET
	@Path("/get")
	public List<ManualDataCollection> getAll(
			@QueryParam("start_index") int startIndex,
			@QueryParam("limit") int limit) {
		System.out.println("start index:" + startIndex);
		System.out.println("limit:" + limit);
		return manualDataCollectionApi.getAll(startIndex, limit);
	}

	@GET
	@Path("/get/{id}")
	public ManualDataCollection get(@PathParam("id") int id) {
		return manualDataCollectionApi.get(id);
	}

	@POST
	@Path("/add")
	public Response addLead(ManualDataCollection collection) {
		int id = manualDataCollectionApi.create(collection);
		ManualDataCollection newcollection = get(id);
		return Response.status(Response.Status.CREATED).entity(newcollection)
				.build();
	}

	@PUT
	@Path("/update")
	public Response update(ManualDataCollection collection) {
		int numberOfRowsChanged = manualDataCollectionApi.update(collection);
		return Response.status(Response.Status.OK).entity(numberOfRowsChanged)
				.build();
	}
}
