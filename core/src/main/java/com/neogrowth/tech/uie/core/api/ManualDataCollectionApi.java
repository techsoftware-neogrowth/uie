package com.neogrowth.tech.uie.core.api;

import java.util.List;

import com.google.inject.ImplementedBy;
import com.neogrowth.tech.uie.data.ManualDataCollection;

@ImplementedBy(ManualDataCollectionApiImpl.class)
public interface ManualDataCollectionApi {

	public ManualDataCollection get(int id);

	public List<ManualDataCollection> getAll(int startIndex, int limit);

	public int create(ManualDataCollection collection);

	public int update(ManualDataCollection collection);

}
