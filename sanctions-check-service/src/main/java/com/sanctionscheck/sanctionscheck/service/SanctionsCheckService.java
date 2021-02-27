package com.sanctionscheck.sanctionscheck.service;

import static com.sanctionscheck.sanctionscheck.util.ServiceConstants.ENTERED_METHOD_LOG;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sanctionscheck.sanctionscheck.bean.CreditorAccount;
import com.sanctionscheck.sanctionscheck.bean.DebtorAccount;
import com.sanctionscheck.sanctionscheck.bean.User;
import com.sanctionscheck.sanctionscheck.util.CommonUtil;
import com.sanctionscheck.sanctionscheck.util.Status;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SanctionsCheckService {

	@Autowired
	private RestTemplate restTemplate;

	private final static String[] EUCOUNTRIES = { "GERMANY", "FRANCE", "ITALY", "SPAIN", "PORTUGAL", "NETHERLANDS",
			"GREECE", "AUSTRIA" };

	public ResponseEntity<User> getSanctionsCheckList(User user) {
		log.info("SanctionsCheckService -> validateSactionsCheck::" + ENTERED_METHOD_LOG);
		ResponseEntity<User> res = null;
		if (null != user) {
			if (Arrays.stream(EUCOUNTRIES).anyMatch(user.getCreditorAddress()::equalsIgnoreCase)
					&& Arrays.stream(EUCOUNTRIES).anyMatch(user.getDebtorAddress()::equalsIgnoreCase)) {
				res = CommonUtil.getFinalResponse(HttpStatus.OK, user, Status.SUCCESS, "Payment Sanctions Success");
			} else {
				res = CommonUtil.getFinalResponse(HttpStatus.NOT_ACCEPTABLE, user, Status.FAILED,
						"Payment Sanctions Failed");
			}
		}
		return res;
	}

}
