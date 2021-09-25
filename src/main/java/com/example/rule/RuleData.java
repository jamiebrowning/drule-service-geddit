package com.example.rule;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

import java.beans.ConstructorProperties;

@Data
public class RuleData<T> {

    @ConstructorProperties({"context"})
    public RuleData(T context) {
        this.context = context;
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS,  property = "@class")
    final T context;
}
