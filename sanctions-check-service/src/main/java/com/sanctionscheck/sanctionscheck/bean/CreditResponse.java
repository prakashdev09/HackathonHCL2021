package com.sanctionscheck.sanctionscheck.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditResponse {
	
	private long transactionId;
    private String transactionStatus;

}
