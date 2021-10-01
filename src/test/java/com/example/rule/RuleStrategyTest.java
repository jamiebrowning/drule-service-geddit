package com.example.rule;

import com.example.rule.domain.external.Product;
import com.example.rule.domain.RuleData;
import com.example.rule.handler.impl.ConsumerRuleHandler;
import com.example.rule.handler.impl.PriceRuleHandler;
import com.example.rule.strategy.impl.RuleStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RuleStrategyTest {

    @Mock
    private PriceRuleHandler priceRuleHandler;

    @Mock
    private ConsumerRuleHandler consumerRuleHandler;

    @InjectMocks
    private RuleStrategy ruleStrategy;

    @Test
    public void findHandler_WhenProduct_ShouldReturnPriceRuleHandler() {
        final RuleData<Product> ruleData = new RuleData<>(Product.builder().build());
        assertTrue(ruleStrategy.findHandler(ruleData).isPresent());
        assertTrue(ruleStrategy.findHandler(ruleData).get() instanceof PriceRuleHandler);
    }

}