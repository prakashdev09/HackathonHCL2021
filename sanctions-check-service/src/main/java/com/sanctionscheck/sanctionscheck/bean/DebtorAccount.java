package com.sanctionscheck.sanctionscheck.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DebtorAccount {
	
	private String name;
	private Address address;

}
