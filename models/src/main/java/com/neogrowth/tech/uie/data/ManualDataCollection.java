package com.neogrowth.tech.uie.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ManualDataCollection {
	private int id;
	private String merchantName;
	private String contactPerson;
	private String telephone;
	private String email;
	private Category category;
	private String photographUrl;
	private String appointmentTime;
	private String address;
	private String addressLocality;
	private String city;
	private String state;
	private String country;
	private int pincode;
	private double latittude;
	private double longitute;
	private int categoryIdCategory;

	// private boolean isOldLead;

	public ManualDataCollection() {

	}

	public ManualDataCollection(String merchantName, String contactPerson,
			Category category) {
		this.merchantName = merchantName;
		this.contactPerson = contactPerson;
		this.category = category;
	}
}
