package com.neogrowth.tech.uie.data;

import com.github.rkmk.annotations.ColumnName;
import com.github.rkmk.annotations.PrimaryKey;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Category {

	@PrimaryKey
	@ColumnName("id_category")
	private int id;
	private String name;
	private String description;

	public Category() {

	}

	public Category(String name, String description) {
		this.name = name;
		this.description = description;
	}

}
