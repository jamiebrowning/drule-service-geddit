package com.example.rule;

import org.kie.api.runtime.KieContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RuleHandler {

    private static final String K_SESSION_NAME = "priceRuleKS";

    @Autowired
    KieContainer kContainer;

    <T> T fireAllRules(T context) {
        kContainer.newStatelessKieSession(K_SESSION_NAME).execute(context);
        return context;
    }
}