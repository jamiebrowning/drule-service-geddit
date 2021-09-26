package com.example.rule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RuleStrategy {

    @Autowired
    RuleHandler ruleHandler;

    <T> Optional<RuleHandler> findHandler(RuleData<T> ruleData) {
        Optional<RuleHandler> result = Optional.empty();
        if (ruleData.getContext().getClass().getName().equals("com.example.rule.Product")) {
            result = Optional.of(ruleHandler);
        }
        return result;
    }
}
