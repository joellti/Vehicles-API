package com.udacity.pricing;

import com.udacity.pricing.entity.Price;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PricingServiceApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	TestRestTemplate testRestTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	public void getPrice() {
		ResponseEntity<Price> resp = testRestTemplate.getForEntity("http://localhost:" + port + "/prices/5", Price.class);
		BigDecimal expected = new BigDecimal(17800);
		assertEquals(0, expected.compareTo(resp.getBody().getPrice()));
	}

}
