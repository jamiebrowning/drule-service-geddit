package com.example.rule.strategy.impl;

import com.example.rule.domain.RuleData;
import com.example.rule.handler.impl.ConsumerRuleHandler;
import com.example.rule.handler.impl.PriceRuleHandler;
import com.example.rule.handler.RuleHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RuleStrategy {

    final PriceRuleHandler priceRuleHandler;

    final ConsumerRuleHandler consumerRuleHandler;

    public <T> Optional<RuleHandler> findHandler(RuleData<T> ruleData) {
        Optional<RuleHandler> result = Optional.empty();
        switch (ruleData.getContext().getClass().getName()) {
            case "com.example.rule.domain.external.Product" :
                result = Optional.of(priceRuleHandler);
                break;
            case "com.example.rule.Delivery" :
                result = Optional.of(consumerRuleHandler);
                break;
            default:
                break;
        }
        return result;
    }
}
