package com.example.rule;

import com.example.rule.domain.RuleData;
import com.example.rule.domain.external.Product;
import com.example.rule.handler.RuleHandler;
import com.example.rule.service.RuleService;
import com.example.rule.strategy.impl.RuleStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RuleServiceTest {

    @Mock
    private RuleStrategy ruleStrategy;

    @Mock
    private RuleHandler ruleHandler;

    @InjectMocks
    private RuleService ruleService;

    @Test
    void fireAllRules_WhenNameNotTest_ShouldNotChangePrice() {
        final int expectedPrice = 10;
        final Product product = Product.builder().price(expectedPrice).build();
        final RuleData<Product> productRuleData = new RuleData<>(product);

        when(ruleStrategy.findHandler(productRuleData)).thenReturn(Optional.of(ruleHandler));
        when(ruleHandler.fireAllRules(product)).thenReturn(product);

        final RuleData<Product> actual = ruleService.fireAllRules(productRuleData);

        assertEquals(expectedPrice, actual.getContext().getPrice());
    }

    @Test
    void fireAllRules_WhenNameIsTest_ShouldChangePrice() {
        final Product product = Product.builder().name("test").build();
        final RuleData<Product> productRuleData = new RuleData<>(product);

        final int expectedPrice = 20;
        final Product expectedProduct = Product.builder().name("test").price(expectedPrice).build();

        when(ruleStrategy.findHandler(productRuleData)).thenReturn(Optional.of(ruleHandler));
        when(ruleHandler.fireAllRules(product)).thenReturn(expectedProduct);

        final RuleData<Product> actual = ruleService.fireAllRules(productRuleData);

        assertEquals(expectedPrice, actual.getContext().getPrice());
    }

}