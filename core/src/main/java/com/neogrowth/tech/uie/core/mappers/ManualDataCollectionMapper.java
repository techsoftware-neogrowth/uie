package com.neogrowth.tech.uie.core.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.neogrowth.tech.uie.data.Category;
import com.neogrowth.tech.uie.data.ManualDataCollection;

public class ManualDataCollectionMapper implements
		ResultSetMapper<ManualDataCollection> {

	@Override
	public ManualDataCollection map(int index, ResultSet r, StatementContext ctx)
			throws SQLException {
		Category category = new Category(r.getInt("cat$id_category"),
				r.getString("cat$name"), r.getString("cat$description"));
		
		ManualDataCollection manualDataCollection = new ManualDataCollection(
				r.getInt("id_manual_data_collection"),
				r.getString("merchant_name"), r.getString("contact_person"),
				r.getString("telephone"), r.getString("email"), category,
				r.getString("photograph_url"), r.getString("appointment_time"),
				r.getString("address"), r.getString("address_locality"),
				r.getString("city"), r.getString("state"),
				r.getString("country"), r.getInt("pincode"),
				r.getDouble("latitude"), r.getDouble("longitude"),
				r.getInt("fk_id_category"));

		return manualDataCollection;
	}
}
