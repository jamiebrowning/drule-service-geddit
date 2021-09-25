package com.example.rule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RuleController {

    @Autowired
    RuleService ruleService;

    @PostMapping("/fireAllRules")
    public Product fireAllRules(@RequestBody Product context) {
        return ruleService.fireAllRules(context);
    }
}
