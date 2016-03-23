package com.neogrowth.tech.uie.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Category {

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
