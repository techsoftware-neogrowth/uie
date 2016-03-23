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

	@SqlQuery("select * from manual_data_collection where id_manual_data_collection > :startIndex limit :limit")
	public List<ManualDataCollection> getSome(
			@Bind("startIndex") int startIndex, @Bind("limit") int limit);

	@SqlQuery("select mdc.*,cat.id_category as cat$id_category, cat.name as cat$name, "
			+ "cat.description as cat$description from manual_data_collection mdc "
			+ "left join category cat on mdc.fk_id_category = cat.id_category "
			+ "where mdc.id_manual_data_collection=:id")
	public ManualDataCollection get(@Bind("id") long id);

	@SqlUpdate("INSERT INTO manual_data_collection (merchant_name, contact_person, telephone, "
			+ "email, photograph_url, appointment_time, address, address_locality, "
			+ "city, state, country, pincode, latitude, longitude, fk_id_category) "
			+ "values (:mdc.merchantName, :mdc.contactPerson, :mdc.telephone, :mdc.email, "
			+ ":mdc.photographUrl, :mdc.appointmentTime, :mdc.address, :mdc.addressLocality, "
			+ ":mdc.city, :mdc.state, :mdc.country, :mdc.pincode, :mdc.latitude, :mdc.longitude,"
			+ ":mdc.fkIdCategory)")
	@GetGeneratedKeys
	public int add(@BindBean("mdc") ManualDataCollection manualDataCollection);

	@SqlUpdate("update manual_data_collection set merchant_name = :mdc.merchantName, "
			+ "contact_person = :mdc.contactPerson, telephone=:mdc.telephone, email=:mdc.email,"
			+ "photograph_url=:mdc.photographUrl, appointment_time= :mdc.appointmentTime, address=:mdc.address,"
			+ "address_locality=:mdc.addressLocality, city=:mdc.city, state=:mdc.state, country=:mdc.country,"
			+ "pincode=:mdc.pincode, latitude=:mdc.latitude, longitude=:mdc.longitude, "
			+ "fk_id_category=:mdc.fkIdCategory where id_manual_data_collection = :mdc.id")
	public int update(@BindBean("mdc") ManualDataCollection manualDataCollection);

}
