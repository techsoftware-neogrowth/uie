package com.neogrowth.tech.uie.core.api;

import java.util.List;

import com.google.inject.ImplementedBy;
import com.neogrowth.tech.uie.data.Category;

@ImplementedBy(CategoryApiImpl.class)
public interface CategoryApi {

	public long createCategory(String categoryName, String categoryDescription);

	public List<Category> getAll();

	public Category get(long id);

}
