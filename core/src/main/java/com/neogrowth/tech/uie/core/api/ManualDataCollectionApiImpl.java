package com.neogrowth.tech.uie.core.api;

import java.util.List;

import org.skife.jdbi.v2.DBI;

import com.google.inject.Inject;
import com.neogrowth.tech.uie.core.jdbi.dao.ManualDataCollectionDao;
import com.neogrowth.tech.uie.data.ManualDataCollection;

public class ManualDataCollectionApiImpl implements ManualDataCollectionApi {

	private DBI dbi;

	@Inject
	public ManualDataCollectionApiImpl(DBI dbi) {
		this.dbi = dbi;
	}

	@Override
	public List<ManualDataCollection> getAll(int startIndex, int limit) {
		ManualDataCollectionDao manualDataCollectionDao = dbi
				.onDemand(ManualDataCollectionDao.class);
		List<ManualDataCollection> collection = null;
		if (startIndex == 0 && limit == 0) {
			collection = manualDataCollectionDao.getAll();
		} else {
			collection = manualDataCollectionDao.getSome(startIndex, limit);
		}
		return collection;
	}

	@Override
	public ManualDataCollection get(int id) {
		ManualDataCollectionDao manualDataCollectionDao = dbi
				.onDemand(ManualDataCollectionDao.class);
		ManualDataCollection collection = manualDataCollectionDao.get(id);
		return collection;
	}

	@Override
	public int create(ManualDataCollection collection) {
		ManualDataCollectionDao manualDataCollectionDao = dbi
				.onDemand(ManualDataCollectionDao.class);
		int id = manualDataCollectionDao.add(collection);
		return id;
	}

	@Override
	public int update(ManualDataCollection collection) {
		ManualDataCollectionDao manualDataCollectionDao = dbi
				.onDemand(ManualDataCollectionDao.class);
		System.out.println(collection);
		int numberOfRowsChanged = manualDataCollectionDao.update(collection);
		return numberOfRowsChanged;
	}

}
