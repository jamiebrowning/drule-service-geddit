package com.example.rule.controller;

import com.example.rule.domain.RuleData;
import com.example.rule.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RuleController {

    @Autowired
    RuleService ruleService;

    @PostMapping("/fireAllRules")
    public <T> RuleData<T> fireAllRules(@RequestBody RuleData<T> ruleData) {
        return ruleService.fireAllRules(ruleData);
    }
}
