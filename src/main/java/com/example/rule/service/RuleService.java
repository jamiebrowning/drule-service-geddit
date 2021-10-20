package com.example.rule.service;

import com.example.rule.domain.RuleData;
import com.example.rule.handler.RuleHandler;
import com.example.rule.strategy.impl.RuleStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RuleService {

    final RuleStrategy ruleStrategy;

    /**
     * Executes all known rules for a given context.
     *
     * @param ruleData data upon which rules will execute
     * @param <T> the context
     * @return the modified ruleData
     */
    public <T> RuleData<T> fireAllRules(RuleData<T> ruleData) {
        Optional<RuleHandler> ruleHandler = ruleStrategy.findHandler(ruleData);
        ruleHandler.ifPresent(handler -> handler.fireAllRules(ruleData.getContext()));
        return ruleData;
    }

}
