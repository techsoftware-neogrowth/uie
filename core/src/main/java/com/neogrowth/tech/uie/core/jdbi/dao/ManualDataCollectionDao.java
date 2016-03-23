package com.neogrowth.tech.uie.core.jdbi.dao;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import com.neogrowth.tech.uie.core.mappers.ManualDataCollectionMapper;
import com.neogrowth.tech.uie.data.ManualDataCollection;

@RegisterMapper(ManualDataCollectionMapper.class)
public interface ManualDataCollectionDao {

	@SqlQuery("select * from manual_data_collection")
	public List<ManualDataCollection> getAll();

	@SqlQuery("select * from manual_data_collection where idmanual_data_collection > :startIndex limit :limit")
	public List<ManualDataCollection> getSome(
			@Bind("startIndex") int startIndex, @Bind("limit") int limit);

	@SqlQuery("select * from manual_data_collection where idmanual_data_collection = :id")
	public ManualDataCollection get(@Bind("id") long id);

	@SqlUpdate("INSERT INTO manual_data_collection (merchant_name, contact_person, telephone, "
			+ "email, fk_idcategory, photograph, appointment_time, address, address_locality, "
			+ "city, state, country, pin_code, lat, lng, category_id_category) "
			+ "values (:mdc.merchantName, :mdc.contactPerson, :mdc.telephone, :mdc.email, null, "
			+ ":mdc.photographUrl, :mdc.appointmentTime, :mdc.address, :mdc.addressLocality, "
			+ ":mdc.city, :mdc.state, :mdc.country, :mdc.pincode, :mdc.latittude, :mdc.longitute,"
			+ ":mdc.categoryIdCategory)")
	@GetGeneratedKeys
	public int add(@BindBean("mdc") ManualDataCollection manualDataCollection);

	@SqlUpdate("update manual_data_collection set merchant_name = :mdc.merchantName, "
			+ "contact_person = :mdc.contactPerson, telephone=:mdc.telephone, email=:mdc.email,"
			+ "photograph=:mdc.photographUrl, appointment_time= :mdc.appointmentTime, address=:mdc.address,"
			+ "address_locality=:mdc.addressLocality, city=:mdc.city, state=:mdc.state, country=:mdc.country,"
			+ "pin_code=:mdc.pincode, lat=:mdc.latittude, lng=:mdc.longitute, category_id_category=:mdc.categoryIdCategory "
			+ "where idmanual_data_collection = :mdc.id")
	public int update(@BindBean("mdc") ManualDataCollection manualDataCollection);

}
