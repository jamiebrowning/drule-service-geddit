package com.example.price;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class RuleServiceTest {

    @Autowired
    private RuleService ruleService;

    @Test
    void getPrice_ReturnsBasePriceWhenNoRule() {
        Product context = new Product.ProductBuilder().price(10).build();

        Product actual = ruleService.fireAllRules(context);

        assertEquals(context.getPrice(), actual.getPrice());

    }

    @Test
    void getPrice_ReturnsRulePriceWhenRuleMatches() {
        final Product context = new Product.ProductBuilder().name("test").build();
        final int expectedPrice = 20;

        final Product actual = ruleService.fireAllRules(context);

        assertEquals(expectedPrice, actual.getPrice());

    }

}