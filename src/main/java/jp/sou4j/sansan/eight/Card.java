package jp.sou4j.sansan.eight;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Card {

	private String companyName;
	private String department;
	private String title;
	private String fullName;
	private String lastName;
	private String firstName;
	private String email;
	private String postalCode;
	private String address;
	private String companyPhoneNumber;
	private String departmentPhoneNumber;
	private String directPhoneNumber;
	private String companyFaxNumber;
	private String mobilePhoneNumber;
	private String url;
	private Date tradingDate;
	private boolean linked;

}
