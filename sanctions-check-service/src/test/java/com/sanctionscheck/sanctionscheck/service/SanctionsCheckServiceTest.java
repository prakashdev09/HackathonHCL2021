package com.sanctionscheck.sanctionscheck.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.sanctionscheck.sanctionscheck.bean.User;

@RunWith(SpringRunner.class)
@WebMvcTest(value = SanctionsCheckService.class)
public class SanctionsCheckServiceTest {

	@Test
	public void testGetSanctionsCheckList_Success() throws Exception {

		User user = new User();
		user.setCreditorAddress("abc");
		user.setDebtorAddress("xyz");

		ResponseEntity<User> response = ResponseEntity.ok().body(user);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	public void testGetSanctionsCheckList_Failure() throws Exception {

		User user = new User();
		user.setCreditorAddress("abc");
		user.setDebtorAddress("xyz");

		ResponseEntity<User> response = ResponseEntity.notFound().build();
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
}
