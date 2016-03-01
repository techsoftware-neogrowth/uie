package com.neogrowth.tech.uie.service;

import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIHealthCheck;
import io.dropwizard.lifecycle.Managed;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.skife.jdbi.v2.DBI;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.neogrowth.tech.uie.core.AppInjector;
import com.neogrowth.tech.uie.core.api.CategoryApi;
import com.neogrowth.tech.uie.core.config.UieConfiguration;
import com.neogrowth.tech.uie.service.resources.CategoryResource;
import com.neogrowth.tech.uie.service.resources.TestResource;

public class UieApplication extends Application<UieConfiguration> {

	public static void main(String[] args) throws Exception {
		new UieApplication().run(args);
	}

	@Override
	public String getName() {
		return "User Insights Engine";
	}

	@Override
	public void initialize(Bootstrap<UieConfiguration> bootstrap) {
		// nothing to do yet
	}

	@Override
	public void run(UieConfiguration configuration, Environment environment) {

		// register service for shutdown events
		// environment.lifecycle().manage(this);

		// final UserDAO dao = jdbi.onDemand(UserDAO.class);
		// environment.jersey().register(new UserResource(dao));

		Injector ingestor = Guice.createInjector(new AppInjector(configuration,
				environment));

		DBI dbi = ingestor.getInstance(DBI.class);

		// Resources
		TestResource testResource = new TestResource(dbi);
		environment.jersey().register(testResource);

		CategoryResource categoryResource = new CategoryResource(
				ingestor.getInstance(CategoryApi.class));
		environment.jersey().register(categoryResource);

		// Health check
		DBIHealthCheck dbiHealthCheck = new DBIHealthCheck(dbi,
				configuration.getValidationQuery());
		environment.healthChecks().register("databaseHealthCheck",
				dbiHealthCheck);
	}

	public void start() throws Exception {
		// TODO Auto-generated method stub

	}

	public void stop() throws Exception {
		// TODO Auto-generated method stub

	}
}