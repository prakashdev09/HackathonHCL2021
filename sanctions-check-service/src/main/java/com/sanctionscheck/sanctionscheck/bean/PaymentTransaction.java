package com.sanctionscheck.sanctionscheck.bean;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentTransaction {

	private Long transactionId;
	private String messageID;
	private String debtorAccount;
	private String debtorName;
	private String debtorAddress;
	private String creditorAccount;
	private String creditorName;
	private String creditorAddress; 
	private String debtorAgentIdentifier;
	private String creditorAgentIdentifier;
	private String paymentCurrency;
	private Double paymentAmountO;
	private Date valueDate;
	private String remittanceInfo;
	
}
