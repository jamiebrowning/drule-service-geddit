package com.example.rule.handler.impl;

import com.example.rule.handler.RuleHandler;
import org.kie.api.runtime.KieContainer;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDroolsRuleHandler implements RuleHandler {

    @Autowired
    KieContainer kContainer;

    @Override
    public <T> T fireAllRules(T context) {
        kContainer.newStatelessKieSession(getKSessionName()).execute(context);
        return context;
    }

    abstract String getKSessionName();
}
