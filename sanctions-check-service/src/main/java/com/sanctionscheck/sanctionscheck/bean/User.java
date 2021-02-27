package com.sanctionscheck.sanctionscheck.bean;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	private String messageID;
	private String debtorAccount;
	private String debtorName;
	private String debtorAddress;
	private String creditorAccount;
	private String creditorAddress; 
	private String debtorAgentIdentifier;
	private String creditorAgentIdentifier;
	private String paymentCurrency;
	private String paymentAmount;
	private String valueDate;
	private String remittanceInfo;
	
}
