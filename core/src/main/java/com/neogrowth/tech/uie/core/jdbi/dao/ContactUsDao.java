package com.neogrowth.tech.uie.core.jdbi.dao;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import com.neogrowth.tech.uie.core.mappers.ContactUsMapper;
import com.neogrowth.tech.uie.data.ContactUs;

@RegisterMapper(ContactUsMapper.class)
public interface ContactUsDao {

	@SqlQuery("select * from contact_us where id_contact_us = :id")
	public ContactUs select(@Bind("id") int id);

	@SqlQuery("select * from contact_us")
	public List<ContactUs> selectAll();

	@SqlUpdate("INSERT INTO contact_us (seller_type, name, email, telephone, loan_amount, avg_sales, "
			+ "city, num_yrs_in_business, tracking_id) "
			+ "values (:sellerType, :name, :email, :telephone, :loanAmount, :avgSales, "
			+ ":city, :numYrsInBusiness, :trackingId)")
	@GetGeneratedKeys
	public int insert(@BindBean ContactUs contactUs);
}
