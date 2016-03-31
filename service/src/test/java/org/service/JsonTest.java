package org.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.neogrowth.tech.uie.data.Category;
import com.neogrowth.tech.uie.data.ContactUs;
import com.neogrowth.tech.uie.data.ManualDataCollection;

public class JsonTest {

	public static void main(String[] args) {
		Gson gson = new GsonBuilder().create();
		// Manual Data Collection
		Category category = new Category("Apparel", null);
		category.setId(1);
		ManualDataCollection person = new ManualDataCollection(1,
				"test_merchantName", "test_contactPerson", "test_telephone",
				"test_email", category, "test_photographUrl",
				"test_appointmentTime", "test_address",
				"test_address_locality", "test_city", "test_state",
				"test_country", 445001, 345.2345533, 231.234432233, 1);
		String payloadStr = gson.toJson(person);
		System.out.println("ManualDataCollection: " + payloadStr);

		// Contact Us
		ContactUs contactUs = new ContactUs(1, "online", "test_name",
				"test_eamil", "test_telephone", "test_loanAmount",
				"test_avg_sales", "test_city", 2, "test_trackingId");
		String contactUsStr = gson.toJson(contactUs);
		System.out.println("ContactUs: " + contactUsStr);
	}
}
