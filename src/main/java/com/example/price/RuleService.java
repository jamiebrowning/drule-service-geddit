package com.example.price;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RuleService {

    @Autowired
    KieContainer kContainer;

    Product fireAllRules(Product product) {
        StatelessKieSession session = kContainer.newStatelessKieSession();
        session.execute(product);
        return product;
    }
}
