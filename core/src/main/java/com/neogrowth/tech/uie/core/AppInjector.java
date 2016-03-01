package com.neogrowth.tech.uie.core;

import io.dropwizard.db.DataSourceFactory;

import javax.sql.DataSource;

import io.dropwizard.setup.Environment;

import org.skife.jdbi.v2.DBI;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.neogrowth.tech.uie.core.api.CategoryApi;
import com.neogrowth.tech.uie.core.api.CategoryApiImpl;
import com.neogrowth.tech.uie.core.config.UieConfiguration;

public class AppInjector extends AbstractModule {

	private UieConfiguration configuration;
	private Environment environment;
	private DBI dbi;

	public AppInjector(UieConfiguration configuration, Environment environment) {
		this.configuration = configuration;
		this.environment = environment;
		initializeDbi();
	}

	@Override
	protected void configure() {
		// any bindings here
		// bind(CategoryApi.class).to(CategoryApiImpl.class);
	}

	private void initializeDbi() {
		DataSourceFactory factory = configuration.getDataSourceFactory();
		DataSource dataSource = factory.build(environment.metrics(),
				"testingDB");
		dbi = new DBI(dataSource);
	}

	@Provides
	public DBI dbiProvider() {
		return dbi;
	}

}