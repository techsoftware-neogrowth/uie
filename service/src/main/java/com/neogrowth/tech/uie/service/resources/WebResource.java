package com.neogrowth.tech.uie.service.resources;

import static com.neogrowth.tech.uie.service.ServiceConstants.WEB_PATH;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.inject.Inject;
import com.neogrowth.tech.uie.core.api.ContactUsApi;
import com.neogrowth.tech.uie.data.ContactUs;

@Path(WEB_PATH)
@Produces(MediaType.APPLICATION_JSON)
public class WebResource {

	private ContactUsApi contactUsApi;

	@Inject
	public WebResource(ContactUsApi contactUsApi) {
		this.contactUsApi = contactUsApi;
	}

	@GET
	@Path("/contactUs")
	public List<ContactUs> getAllContactUs() {
		return contactUsApi.selectAll();
	}

	@GET
	@Path("/contactUs/{id}")
	public ContactUs selectContactUs(@PathParam("id") int id) {
		return contactUsApi.select(id);
	}

	@POST
	@Path("/contactUs")
	public Response insertContactUs(ContactUs contactUs) {
		int id = contactUsApi.insert(contactUs);
		contactUs = contactUsApi.select(id);
		return Response.status(Response.Status.CREATED).entity(contactUs)
				.build();
	}

}
