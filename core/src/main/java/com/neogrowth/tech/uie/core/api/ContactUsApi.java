package com.neogrowth.tech.uie.core.api;

import java.util.List;

import com.google.inject.ImplementedBy;
import com.neogrowth.tech.uie.data.ContactUs;

@ImplementedBy(ContactUsApiImpl.class)
public interface ContactUsApi {

	public ContactUs select(int id);

	public List<ContactUs> selectAll();

	public int insert(ContactUs contactUs);
}
