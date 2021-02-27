package com.sanctionscheck.sanctionscheck.contoller;

import static com.sanctionscheck.sanctionscheck.util.ServiceConstants.ENTERED_METHOD_LOG;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanctionscheck.sanctionscheck.bean.User;
import com.sanctionscheck.sanctionscheck.service.SanctionsCheckService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/sanctions-check-service")
@Slf4j
public class SanctionsCheckController {
	
	@Autowired
	private SanctionsCheckService sanctionsCheckService;
		
	@GetMapping("/getSanctionsCheck")
	public ResponseEntity<User> getSanctionsCheck(@RequestBody User user) {
		log.info("SanctionsCheckController: getSanctionsCheck ::"+ENTERED_METHOD_LOG);
		return sanctionsCheckService.getSanctionsCheckList(user);
	}

}
