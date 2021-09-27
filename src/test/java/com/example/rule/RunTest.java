package com.example.rule;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestPropertySource(locations = {"classpath:application.properties"})
class RunTest {

	@Autowired
	private RuleController ruleController;

	@Autowired
	private RuleService ruleService;

	@Test
	void contextLoads() {
		assertNotNull(ruleController);
		assertNotNull(ruleService);
	}

}
