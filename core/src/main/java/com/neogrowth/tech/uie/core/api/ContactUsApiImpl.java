package com.neogrowth.tech.uie.core.api;

import java.util.List;

import org.skife.jdbi.v2.DBI;

import com.google.inject.Inject;
import com.neogrowth.tech.uie.core.jdbi.dao.ContactUsDao;
import com.neogrowth.tech.uie.data.ContactUs;

public class ContactUsApiImpl implements ContactUsApi {

	private DBI dbi;

	@Inject
	public ContactUsApiImpl(DBI dbi) {
		this.dbi = dbi;
	}

	@Override
	public ContactUs select(int id) {
		ContactUsDao dao = dbi.onDemand(ContactUsDao.class);
		return dao.select(id);
	}

	@Override
	public List<ContactUs> selectAll() {
		ContactUsDao dao = dbi.onDemand(ContactUsDao.class);
		return dao.selectAll();
	}

	@Override
	public int insert(ContactUs contactUs) {
		ContactUsDao dao = dbi.onDemand(ContactUsDao.class);
		return dao.insert(contactUs);
	}

}
