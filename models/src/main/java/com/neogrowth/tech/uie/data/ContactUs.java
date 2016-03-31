package com.neogrowth.tech.uie.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class ContactUs {
	private int idContactUs;
	// enum
	private String sellerType;
	private String name;
	// put validation
	private String email;
	// put validation
	private String telephone;
	private String loanAmount;
	private String avgSales;
	private String city;
	private int numYrsInBusiness;
	private String trackingId;

	public ContactUs() {

	}
}

enum SellerType {
	ONLINE("online"), OFFLINE("offline");

	@Getter
	private final String stringValue;

	SellerType(String stringValue) {
		this.stringValue = stringValue;
	}
}