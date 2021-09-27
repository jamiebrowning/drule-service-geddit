package com.example.rule.handler;

public interface RuleHandler {
    String getKSessionName();
    <T> T fireAllRules(T context);
}
