package com.neogrowth.tech.uie.core.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.neogrowth.tech.uie.data.Category;

public class CategoryMapper implements ResultSetMapper<Category> {

	public Category map(int index, ResultSet r, StatementContext ctx)
			throws SQLException {
		Category cat = new Category(r.getInt("id_category"),
				r.getString("name"), r.getString("description"));
		return cat;
	}
}
