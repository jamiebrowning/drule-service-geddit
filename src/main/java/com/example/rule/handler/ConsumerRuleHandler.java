package com.example.rule.handler;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class ConsumerRuleHandler extends AbstractRuleHandler {

    @Value("${kie.session.consumer-rules.name}")
    private String kSessionName;

    @Override
    String getKSessionName() {
        return kSessionName;
    }
}