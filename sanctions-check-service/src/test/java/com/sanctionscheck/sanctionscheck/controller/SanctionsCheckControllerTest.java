package com.sanctionscheck.sanctionscheck.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sanctionscheck.sanctionscheck.bean.Address;
import com.sanctionscheck.sanctionscheck.bean.CreditorAccount;
import com.sanctionscheck.sanctionscheck.bean.DebtorAccount;
import com.sanctionscheck.sanctionscheck.bean.PaymentTransaction;
import com.sanctionscheck.sanctionscheck.contoller.SanctionsCheckController;
import com.sanctionscheck.sanctionscheck.service.SanctionsCheckService;


@RunWith(SpringRunner.class)
@WebMvcTest(value = SanctionsCheckController.class)
public class SanctionsCheckControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private SanctionsCheckService sanctionsCheckService;

	private static ObjectMapper mapper = new ObjectMapper();

	@Test
	public void testGetSanctionsCheck_Success() throws Exception {

		PaymentTransaction user = new PaymentTransaction();
		user.setCreditorAddress("abc");
		user.setDebtorAddress("xyz");
		
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(user);
		
		RequestBuilder builder = MockMvcRequestBuilders.post("/getSanctionsCheck")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(requestJson);
		MvcResult mvcResult = mockMvc.perform(builder).andReturn();
		MockHttpServletResponse httpServletResponse = mvcResult.getResponse();
		assertEquals(HttpStatus.OK.value(), httpServletResponse.getStatus());
	}
}
