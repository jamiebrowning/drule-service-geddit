package com.example.rule;

import com.example.rule.domain.RuleData;
import com.example.rule.domain.external.Product;
import com.example.rule.handler.RuleHandler;
import com.example.rule.handler.impl.PriceRuleHandler;
import com.example.rule.service.RuleService;
import com.example.rule.strategy.impl.RuleStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RuleServiceTest {

    @Mock
    private RuleStrategy ruleStrategy;

    @Mock
    private PriceRuleHandler ruleHandler;

    private RuleService ruleService;

    @BeforeEach
    public void setUp() {
        ruleService = new RuleService(ruleStrategy);
    }

    @Test
    void fireAllRules_WhenNameIsTest_ShouldChangePrice() {
        final Product product = Product.builder().build();
        final RuleData<Product> productRuleData = new RuleData<>(product);

        when(ruleStrategy.findHandler(productRuleData)).thenReturn(Optional.of(ruleHandler));
        when(ruleHandler.fireAllRules(product)).thenReturn(product);

        final RuleData<Product> data = ruleService.fireAllRules(productRuleData);

        assertNotNull(data);

        verify(ruleStrategy, times(1)).findHandler(any());
        verify(ruleHandler, times(1)).fireAllRules(any());
    }

}