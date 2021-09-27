package com.example.rule;

import com.example.rule.handler.ConsumerRuleHandler;
import com.example.rule.handler.PriceRuleHandler;
import com.example.rule.handler.RuleHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RuleStrategy {

    @Autowired
    PriceRuleHandler priceRuleHandler;

    @Autowired
    ConsumerRuleHandler consumerRuleHandler;

    <T> Optional<RuleHandler> findHandler(RuleData<T> ruleData) {
        Optional<RuleHandler> result = Optional.empty();
        switch (ruleData.getContext().getClass().getName()) {
            case "com.example.rule.Product" :
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
