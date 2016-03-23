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
		// int categoryId = Integer.parseInt(categoryidString);
		Category category = new Category("Apparel", null);
		category.setId(1);
		ManualDataCollection manualDataCollection = new ManualDataCollection(
				r.getInt("idmanual_data_collection"),
				r.getString("merchant_name"), r.getString("contact_person"),
				r.getString("telephone"), r.getString("email"), category,
				r.getString("photograph"), r.getString("appointment_time"),
				r.getString("address"), r.getString("address_locality"),
				r.getString("city"), r.getString("state"),
				r.getString("country"), r.getInt("pin_code"),
				r.getDouble("lat"), r.getDouble("lng"),
				r.getInt("category_id_category"));

		return manualDataCollection;
	}
}
