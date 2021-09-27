package com.example.rule.handler;

public interface RuleHandler {
    <T> T fireAllRules(T context);
}
