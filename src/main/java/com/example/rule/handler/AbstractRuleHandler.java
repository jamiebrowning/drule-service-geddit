package com.example.rule.handler;

import org.kie.api.runtime.KieContainer;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractRuleHandler implements RuleHandler{

    @Autowired
    KieContainer kContainer;

    @Override
    public <T> T fireAllRules(T context) {
        kContainer.newStatelessKieSession(getKSessionName()).execute(context);
        return context;
    }
}
