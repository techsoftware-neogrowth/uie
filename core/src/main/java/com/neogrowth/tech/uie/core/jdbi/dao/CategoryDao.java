package com.neogrowth.tech.uie.core.jdbi.dao;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import com.neogrowth.tech.uie.core.mappers.CategoryMapper;
import com.neogrowth.tech.uie.data.Category;

@RegisterMapper(CategoryMapper.class)
public interface CategoryDao {

	@SqlUpdate("CREATE TABLE IF NOT EXISTS `UIE`.`category` "
			+ "(`id_category` INT NOT NULL AUTO_INCREMENT, `name` VARCHAR(250) NULL, `description` VARCHAR(1000) NULL,"
			+ " PRIMARY KEY (`id_category`), UNIQUE INDEX `name_UNIQUE` (`name` ASC)) "
			+ "ENGINE = InnoDB;")
	public void createTable();

	@SqlQuery("select * from category where id_category = :id")
	public Category get(@Bind("id") long id);

	@SqlUpdate("INSERT INTO category (name, description) "
			+ "values (:name, :description)")
	@GetGeneratedKeys
	public long addCategory(@Bind("name") String name,
			@Bind("description") String categoryDescription);

	@SqlQuery("select * from category")
	public List<Category> getAll();

}
