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
	public List<ManualDataCollection> getAll(
			@QueryParam("current_position") int currentPosition,
			@QueryParam("limit") int limit,
			@QueryParam("skip_entries") int skipEntries) {
		return manualDataCollectionApi.getAll(currentPosition, limit,
				skipEntries);
	}

	@GET
	@Path("/{id}")
	public ManualDataCollection get(@PathParam("id") int id) {
		return manualDataCollectionApi.get(id);
	}

	@POST
	public Response addLead(ManualDataCollection collection) {
		int id = manualDataCollectionApi.create(collection);
		ManualDataCollection newcollection = get(id);
		return Response.status(Response.Status.CREATED).entity(newcollection)
				.build();
	}

	@PUT
	@Path("/{id}")
	public Response update(@PathParam("id") int id,
			ManualDataCollection collection) {
		if (collection.getId() == 0 || collection.getId() == id) {
			collection.setId(id);
		} else {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		int numberOfRowsChanged = manualDataCollectionApi.update(collection);
		return Response.status(Response.Status.OK).entity(numberOfRowsChanged)
				.build();
	}
}
