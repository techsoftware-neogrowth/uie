package com.neogrowth.tech.uie.core.api;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.skife.jdbi.v2.DBI;

import com.google.inject.Inject;
import com.neogrowth.tech.uie.core.jdbi.dao.CategoryDao;
import com.neogrowth.tech.uie.data.Category;

@Slf4j
public class CategoryApiImpl implements CategoryApi {
	private DBI dbi;

	@Inject
	public CategoryApiImpl(DBI dbi) {
		this.dbi = dbi;
	}

	public long createCategory(String categoryName, String categoryDescription) {
		log.info("Creating category :" + categoryName);
		Category category = new Category(categoryName, categoryDescription);
		CategoryDao dao = dbi.onDemand(CategoryDao.class);
		long id = dao
				.addCategory(category.getName(), category.getDescription());
		log.info("category :" + categoryName + " created successfully");
		return id;
	}

	public List<Category> getAll() {
		CategoryDao dao = dbi.onDemand(CategoryDao.class);
		return dao.getAll();
	}

	public Category get(long id) {
		CategoryDao dao = dbi.onDemand(CategoryDao.class);
		return dao.get(id);
	}

}
