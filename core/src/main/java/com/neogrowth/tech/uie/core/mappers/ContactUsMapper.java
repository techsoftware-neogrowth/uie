package com.neogrowth.tech.uie.core.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.neogrowth.tech.uie.data.ContactUs;

public class ContactUsMapper implements ResultSetMapper<ContactUs> {

	public ContactUs map(int index, ResultSet r, StatementContext ctx)
			throws SQLException {
		ContactUs contactUs = new ContactUs(r.getInt("id_contact_us"),
				r.getString("seller_type"), r.getString("name"),
				r.getString("email"), r.getString("telephone"),
				r.getString("loan_amount"), r.getString("avg_sales"),
				r.getString("city"), r.getInt("num_yrs_in_business"),
				r.getString("tracking_id"));
		return contactUs;
	}
}
