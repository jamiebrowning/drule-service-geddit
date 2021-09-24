package com.example.price;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RuleService {

    @Autowired
    KieContainer kContainer;

    <T> T fireAllRules(T context) {
        StatelessKieSession session = kContainer.newStatelessKieSession();
        session.execute(context);
        return context;
    }
}
