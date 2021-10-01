package com.example.rule.handler.impl;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class ConsumerRuleHandler extends AbstractDroolsRuleHandler {

    @Value("${kie.session.consumer-rules.name}")
    private String kSessionName;

    @Override
    String getKSessionName() {
        return kSessionName;
    }
}