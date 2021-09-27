package com.example.rule;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

// TODO - test the handler instead
@SpringBootTest
@TestPropertySource(locations = {"classpath:application.properties"})
class RuleServiceTest {

    @Autowired
    private RuleService ruleService;

    @Test
    void fireAllRules_WhenNameNotTest_ShouldNotChangePrice() {
        final int expectedPrice = 10;
        final Product product = new Product.ProductBuilder().price(expectedPrice).build();
        final RuleData<Product> productRuleData = new RuleData<>(product);

        final RuleData<Product> actual = ruleService.fireAllRules(productRuleData);

        assertEquals(expectedPrice, actual.getContext().getPrice());
    }

    @Test
    void fireAllRules_WhenNameIsTest_ShouldChangePrice() {
        final int expectedPrice = 20;
        final Product product = new Product.ProductBuilder().name("test").build();
        final RuleData<Product> productRuleData = new RuleData<>(product);

        final RuleData<Product> actual = ruleService.fireAllRules(productRuleData);

        assertEquals(expectedPrice, actual.getContext().getPrice());
    }

}