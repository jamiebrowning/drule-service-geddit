package com.example.rule.handler;

import com.example.rule.Product;
import com.example.rule.RuleData;
import com.example.rule.RuleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = {"classpath:application.properties"})
class PriceRuleHandlerTest {

    @Autowired
    private PriceRuleHandler priceRuleHandler;

    @Test
   void fireAllRules_WhenNameIsTest_ShouldSetPrice() {
        final Product product = Product.builder().name("test").price(10).build();

        final Product result = priceRuleHandler.fireAllRules(product);

        final int expectedPrice = 20;

        assertEquals(expectedPrice, result.getPrice());
    }

    @Test
    void fireAllRules_WhenNameIsNotTest_ShouldNotChangePrice() {
        final int expectedPrice = 10;
        final Product product = Product.builder().price(expectedPrice).build();

        final Product result = priceRuleHandler.fireAllRules(product);

        assertEquals(expectedPrice, result.getPrice());
    }
}