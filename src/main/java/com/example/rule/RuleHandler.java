package com.example.rule;

import org.kie.api.runtime.KieContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RuleHandler {

    @Autowired
    KieContainer kContainer;

    <T> T fireAllRules(T context) {
        kContainer.newStatelessKieSession().execute(context);
        return context;
    }
}