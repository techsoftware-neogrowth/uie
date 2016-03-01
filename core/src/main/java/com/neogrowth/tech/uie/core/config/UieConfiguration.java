package com.neogrowth.tech.uie.core.config;

import io.dropwizard.Configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import io.dropwizard.db.DataSourceFactory;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UieConfiguration extends Configuration {
	@Valid
	@NotNull
	@JsonProperty
	private DataSourceFactory database = new DataSourceFactory();

	@NotNull
	private String validationQuery = "/* Health Check */ SELECT 1";

	@JsonProperty("database")
	public DataSourceFactory getDataSourceFactory() {
		return database;
	}

	@JsonProperty("database")
	public void setDataSourceFactory(DataSourceFactory dataSourceFactory) {
		this.database = dataSourceFactory;
	}

	@JsonProperty
	public String getValidationQuery() {
		return validationQuery;
	}

	@JsonProperty
	public void setValidationQuery(String validationQuery) {
		this.validationQuery = validationQuery;
	}
}