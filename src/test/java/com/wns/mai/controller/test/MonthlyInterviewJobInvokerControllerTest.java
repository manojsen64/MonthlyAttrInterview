package com.wns.mai.controller.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(scripts = "classpath:sample_data.sql")
public class MonthlyInterviewJobInvokerControllerTest {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	public void testinvoke() throws Exception {
		String response = restTemplate.getForObject(createURLWithPort("/invokejob"), String.class);
		assertEquals("Batch job has been invoked with status : COMPLETED", response);
		List<Map<String, Object>> list = jdbcTemplate.queryForList(
				"select VALID_DATA from MONTHLY_MASTER_BK_CHANGED_ATTR_INTERVIEW where NVIC in(?,?)", "33TST1",
				"33TST2");
		assertEquals(0, list.get(0).get("VALID_DATA"));
		assertEquals(0, list.get(1).get("VALID_DATA"));
	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

	@AfterEach
	public void after() {
		jdbcTemplate.update("delete from MONTHLY_MASTER_BK_CHANGED_ATTR_INTERVIEW  where nvic in('33TST1','33TST2')");
	}
}
