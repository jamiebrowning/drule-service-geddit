package com.example.rule;

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
    <T> RuleData<T> fireAllRules(RuleData<T> ruleData) {
        if(ruleStrategy.findHandler(ruleData).isPresent()) {
            ruleStrategy.findHandler(ruleData).get().fireAllRules(ruleData.getContext());
        }
        return ruleData;
    }

}
