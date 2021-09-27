package com.example.rule.handler;

import org.kie.api.runtime.KieContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsumerRuleHandler implements RuleHandler {

    // TODO - inject via @Value
    private static final String K_SESSION_NAME = "consumerRuleKS";

    @Autowired
    KieContainer kContainer;

    public <T> T fireAllRules(T context) {
        kContainer.newStatelessKieSession(K_SESSION_NAME).execute(context);
        return context;
    }
}