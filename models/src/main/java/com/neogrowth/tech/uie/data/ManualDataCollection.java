package com.neogrowth.tech.uie.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import com.github.rkmk.annotations.ColumnName;
import com.github.rkmk.annotations.OneToOne;
import com.github.rkmk.annotations.PrimaryKey;

@Data
@AllArgsConstructor
public class ManualDataCollection {

	@PrimaryKey
	@ColumnName("id_manual_data_collection")
	private int id;
	private String merchantName;
	private String contactPerson;
	private String telephone;
	private String email;
	@OneToOne("cat")
	private Category category;
	private String photographUrl;
	private String appointmentTime;
	private String address;
	private String addressLocality;
	private String city;
	private String state;
	private String country;
	private int pincode;
	private double latitude;
	private double longitude;
	private transient int fkIdCategory;

	public ManualDataCollection() {

	}

	public ManualDataCollection(String merchantName, String contactPerson,
			Category category) {
		this.merchantName = merchantName;
		this.contactPerson = contactPerson;
		this.category = category;
	}
}
