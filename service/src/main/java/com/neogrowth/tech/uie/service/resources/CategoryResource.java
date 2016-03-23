package com.neogrowth.tech.uie.service.resources;

import static com.neogrowth.tech.uie.service.ServiceConstants.CATEGORY_PATH;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.inject.Inject;
import com.neogrowth.tech.uie.core.api.CategoryApi;
import com.neogrowth.tech.uie.data.Category;

@Path(CATEGORY_PATH)
@Produces(MediaType.APPLICATION_JSON)
public class CategoryResource {

	private CategoryApi api;

	@Inject
	public CategoryResource(CategoryApi api) {
		this.api = api;
	}

	@POST
	@Path("/{category}")
	public long addCategory(@PathParam("category") String categoryName,
			@QueryParam("desc") String categoryDescription) {
		long category = api.create(categoryName, categoryDescription);
		return category;
	}

	@GET
	public List<Category> getAll() {
		return api.getAll();
	}

	@GET
	@Path("/{id}")
	public Category get(@PathParam("id") long id) {
		return api.get(id);
	}

}
