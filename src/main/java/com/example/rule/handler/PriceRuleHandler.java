package com.example.rule.handler;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class PriceRuleHandler extends AbstractRuleHandler {

    @Value("{kie.session.price-rules.name}")
    private String kSessionName;

    @Override
    public String getKSessionName() {
        return kSessionName;
    }
}