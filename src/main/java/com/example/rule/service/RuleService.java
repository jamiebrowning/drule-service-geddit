package com.example.rule.service;

import com.example.rule.strategy.impl.RuleStrategy;
import com.example.rule.domain.RuleData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RuleService {

    @Autowired
    RuleStrategy ruleStrategy;

    /**
     * Executes all known rules for a given context.
     *
     * @param ruleData data upon which rules will execute
     * @param <T> the context
     * @return the modified ruleData
     */
    public <T> RuleData<T> fireAllRules(RuleData<T> ruleData) {
        if(ruleStrategy.findHandler(ruleData).isPresent()) {
            ruleStrategy.findHandler(ruleData).get().fireAllRules(ruleData.getContext());
        }
        return ruleData;
    }

}
